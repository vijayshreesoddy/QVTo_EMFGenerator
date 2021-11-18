package com.uni.de.qvto.influxdb;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;


import kieker.common.record.IMonitoringRecord;
import kieker.common.record.controlflow.OperationExecutionRecord;

public class InfluxDataWriter_1_1 {/*
	public static final String CONFIG_PROPERTY_DB_URL = "databaseURL";
	public static final String CONFIG_PROPERTY_DB_PORT = "databasePort";
	public static final String CONFIG_PROPERTY_DB_USERNAME = "databaseUsername";
	public static final String CONFIG_PROPERTY_DB_PASSWORD = "databasePAssword";
	public static final String CONFIG_PROPERTY_DB_NAME = "databaseName";

	private final String dbURL;
	private final int dbPort;
	private final String dbUsername;
	private final String dbPassword;
	private final String dbName;
	//private volatile InfluxDB influxDB;
	private volatile boolean isConnected = false;
	private static InfluxDataWriter_1_1 WRITER = null;
	

	public static InfluxDataWriter_1_1 INSTANCE() {
		if (WRITER==null) {
			WRITER = new InfluxDataWriter_1_1();
		}
		return WRITER;
	}
	
	private InfluxDataWriter_1_1() { 
		Configuration configuration = getCurrentConfiguration();
		this.dbURL = configuration.getStringProperty(CONFIG_PROPERTY_DB_URL);
		this.dbPort = configuration.getIntProperty(CONFIG_PROPERTY_DB_PORT);
		this.dbUsername = configuration.getStringProperty(CONFIG_PROPERTY_DB_USERNAME);
		this.dbPassword = configuration.getStringProperty(CONFIG_PROPERTY_DB_PASSWORD);
		this.dbName = configuration.getStringProperty(CONFIG_PROPERTY_DB_NAME);

		String influxDBEnabled = System.getenv("KLS_INFLUXDB_ENABLED");
		if (influxDBEnabled != null && influxDBEnabled.toLowerCase().equals("true")) {
			try {
				this.connect();
			} catch (IOException e) {
				System.out.println("Cannot connect to influxdb");
			}
		}

	}
	

	private void connect() throws IOException {
		System.out.println("Connecting to database");
		System.out.println("dbURL = " + dbURL);
		System.out.println("dbPort = " + dbPort);
		System.out.println("dbUsername = " + dbUsername);
		System.out.println("dbPassword = " + dbPassword);
		System.out.println("dbName = " + dbName);

	/*	this.influxDB = InfluxDBFactory.connect(this.dbURL + ":" + this.dbPort, this.dbUsername, this.dbPassword);
		if (!this.influxDB.isBatchEnabled()) {
			this.influxDB.enableBatch(2000, 500, TimeUnit.MILLISECONDS);
		}

		// Test connection
		final Pong pong;
		try {
			pong = this.influxDB.ping();
			System.out.println("Connected to InfluxDB");
		} catch (final RuntimeException e) { // NOCS NOPMD (thrown by InfluxDB library)
			throw new IOException("Cannot connect to InfluxDB with the following parameters:" + "URL = " + this.dbURL
					+ "; Port = " + this.dbPort + "; Username = " + this.dbUsername + "; Password = " + this.dbPassword,
					e);
		}
		final String influxDBVersion = pong.getVersion();
		final String[] splitVersion = influxDBVersion.split("\\.");
		System.out.println("Version: " + influxDBVersion);
		System.out.println("Response time: " + pong.getResponseTime());

		// Create database if it does not exist
		final List<String> dbList = this.influxDB.describeDatabases();
		if (!dbList.contains(this.dbName)) {
			System.out.println("Database " + this.dbName + " does not exist. Creating ...");
			this.influxDB.createDatabase(this.dbName);
			System.out.println("Done");
		}
		this.isConnected = true;
	}

	public final void inputRecord(final IMonitoringRecord monitoringRecord) {
		if (monitoringRecord instanceof OperationExecutionRecord) {
			// Check connection to InfluxDB
			if (!this.isConnected) {
				try {
					this.connect();
				} catch (final IOException e) {
					System.out.println("Cannot connect to InfluxDB. Dropping record.");
					return;
				}
			}

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

			Point point = Point.measurement("OperationExecution").time(timestamp, TimeUnit.NANOSECONDS)
					.addField("sessionId", sessionId).addField("traceId", traceId).addField("tin", tin)
					.addField("tout", tout).addField("eoi", eoi).addField("ess", ess)
					.addField("responseTime", responseTime).tag("operationSignature", operationSignature)
					.tag("hostname", hostname).build();
			try {
				influxDB.write(dbName, "autogen", point);
			} catch (RuntimeException e) {
				System.out.println(e);
				this.isConnected = false;
			}
		}
	}

	public void terminate(boolean error) {
		System.out.println("Closing database");
		this.influxDB.close();
		System.out.println("Closing database done");
	}

	 public final Configuration getCurrentConfiguration() {
		final Configuration configuration = new Configuration();
		configuration.setProperty(CONFIG_PROPERTY_DB_URL, "http://localhost");
		configuration.setProperty(CONFIG_PROPERTY_DB_PORT, Integer.toString(9999));
		configuration.setProperty(CONFIG_PROPERTY_DB_USERNAME, "vijayshree");
		configuration.setProperty(CONFIG_PROPERTY_DB_PASSWORD, "11Anand-Pinky?");
		configuration.setProperty(CONFIG_PROPERTY_DB_NAME, "Monitoring-Data");
		return configuration;
	}*/

}
