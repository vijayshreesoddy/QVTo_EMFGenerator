package org.eclipse.m2m.qvt.oml.examples.blackbox;

import java.time.Instant;

import com.influxdb.client.InfluxDBClient;
import com.influxdb.client.InfluxDBClientFactory;
import com.influxdb.client.WriteApi;
import com.influxdb.client.domain.WritePrecision;
import com.influxdb.client.write.Point;


import kieker.common.record.IMonitoringRecord;
import kieker.common.record.controlflow.OperationExecutionRecord;

public class InfluxDataWriter {

	private static char[] token = "YL-iYGoYXPZzb-U3jaLqKV1RDdRrjFRD1C4QXVWscKMyjw2k8uts5z_GUm8Fb2BMLzKxJqM_O6r-rUO7uzzEoQ=="
			.toCharArray();
	private static String org = "University of Stuttgart";
	private static String bucket = "Monitoring-Data";

	// private volatile InfluxDB influxDB;
	private static InfluxDataWriter WRITER = null;
	private InfluxDBClient influxDBClient = null;

	public static InfluxDataWriter INSTANCE() {
		if (WRITER == null) {
			WRITER = new InfluxDataWriter();
		}
		return WRITER;
	}

	private InfluxDataWriter() {
		influxDBClient = InfluxDBClientFactory.create("http://localhost:9999", token, org, bucket);

	}
	
	public static void main(String[] args) {
		InfluxDBClient influxDBClient1 = InfluxDBClientFactory.create("http://localhost:9999", token, org, bucket);

		final long timestamp = 1L;
		final String hostname = "Me";
		final String operationSignature = "UML2RDB";
		final String sessionId = "1";
		final int eoi = 32;
		final int ess = 100;
		final long tin = 12;
		final long tout = 120;
		final long traceId = 298L;
		final long responseTime = tout - tin;

		Point point = Point.measurement("OperationExecution_Sample").time(Instant.now().toEpochMilli(), WritePrecision.MS)
				.addField("sessionId", sessionId).addField("traceId", traceId).addField("tin", tin)
				.addField("tout", tout).addField("eoi", eoi).addField("ess", ess)
				.addField("responseTime", responseTime).addTag("operationSignature", operationSignature)
				.addTag("hostname", hostname);

		try (WriteApi writeApi = influxDBClient1.getWriteApi()) {

			writeApi.writePoint(point);

		} catch (RuntimeException e) {
			System.out.println(e);
		}
		influxDBClient1.close();

	}
		
	

	public final void inputRecord(final IMonitoringRecord monitoringRecord) {
		if (monitoringRecord instanceof OperationExecutionRecord) {

			final OperationExecutionRecord operationExecutionRecord = (OperationExecutionRecord) monitoringRecord;

			final long timestamp = operationExecutionRecord.getLoggingTimestamp();
			final String hostname = operationExecutionRecord.getHostname();
			final String operationSignature = operationExecutionRecord.getOperationSignature();
			final String sessionId = operationExecutionRecord.getSessionId();
			final int eoi = operationExecutionRecord.getEoi();
			final int ess = operationExecutionRecord.getEss();
			final long tin = operationExecutionRecord.getTin();
			final long tout = operationExecutionRecord.getTout();
			final long traceId = operationExecutionRecord.getTraceId();
			final long responseTime = tout - tin;

			Point point = Point.measurement("OperationExecution").time(timestamp, WritePrecision.NS)
					.addField("sessionId", sessionId).addField("traceId", traceId).addField("tin", tin)
					.addField("tout", tout).addField("eoi", eoi).addField("ess", ess)
					.addField("responseTime", responseTime).addTag("operationSignature", operationSignature)
					.addTag("hostname", hostname);

			try (WriteApi writeApi = influxDBClient.getWriteApi()) {

				writeApi.writePoint(point);

			} catch (RuntimeException e) {
				System.out.println(e);
			}
		}
	}

	public void terminate(boolean error) {
		System.out.println("Closing database");
		influxDBClient.close();
		System.out.println("Closing database done");
	}

}
