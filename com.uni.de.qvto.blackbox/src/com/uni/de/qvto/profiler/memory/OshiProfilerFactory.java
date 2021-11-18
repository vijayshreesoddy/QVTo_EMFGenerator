package com.uni.de.qvto.profiler.memory;

import org.hyperic.sigar.SigarException;

import kieker.common.record.system.MemSwapUsageRecord;
import kieker.monitoring.core.controller.IMonitoringController;
import kieker.monitoring.core.signaturePattern.SignatureFactory;
import oshi.SystemInfo;
import oshi.hardware.GlobalMemory;
import oshi.hardware.HardwareAbstractionLayer;

public enum OshiProfilerFactory {
	
	INSTANCE;
	/**
	 * {@link HardwareAbstractionLayer} instance used to retrieve the data to be
	 * logged.
	 */
	private final HardwareAbstractionLayer hardwareAbstractionLayer;

	/**
	 * Used by {@link #getInstance()} to construct the singleton instance.
	 */
	private OshiProfilerFactory() {
		this.hardwareAbstractionLayer = new SystemInfo().getHardware();
	}

	public long record(final IMonitoringController monitoringCtr) throws SigarException {
		if (!monitoringCtr.isMonitoringEnabled() || !monitoringCtr.isProbeActivated(SignatureFactory.createMemSwapSignature())) {
			return 0;
		}
		final GlobalMemory globalMemory = this.hardwareAbstractionLayer.getMemory();

		final long memoryTotal = globalMemory.getTotal();
		final long memoryAvailable = globalMemory.getAvailable();
		final long memoryUsed = memoryTotal - memoryAvailable;
		final long swapTotal = globalMemory.getSwapTotal();
		final long swapUsed = globalMemory.getSwapUsed();
		final long swapFree = swapTotal - swapUsed;

		final MemSwapUsageRecord r = new MemSwapUsageRecord(monitoringCtr.getTimeSource().getTime(),
				monitoringCtr.getHostname(), memoryTotal, memoryUsed, memoryAvailable, swapTotal, swapUsed, swapFree);
		monitoringCtr.newMonitoringRecord(r);
		return memoryUsed;
	}

}
