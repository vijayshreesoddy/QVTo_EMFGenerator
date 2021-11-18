package com.uni.de.qvto.influxdb;

import java.time.Instant;
import java.util.List;
import java.io.IOException;
import java.util.concurrent.TimeUnit;





import com.influxdb.annotations.Column;
import com.influxdb.annotations.Measurement;
import com.influxdb.client.InfluxDBClient;
import com.influxdb.client.InfluxDBClientFactory;
import com.influxdb.client.QueryApi;
import com.influxdb.client.WriteApi;
import com.influxdb.client.domain.WritePrecision;
import com.influxdb.client.write.Point;
import com.influxdb.query.FluxRecord;
import com.influxdb.query.FluxTable;


import kieker.common.record.IMonitoringRecord;
import kieker.common.record.controlflow.OperationExecutionRecord;


public class InfluxDataWriter_NEW {

        private static char[] token = "YL-iYGoYXPZzb-U3jaLqKV1RDdRrjFRD1C4QXVWscKMyjw2k8uts5z_GUm8Fb2BMLzKxJqM_O6r-rUO7uzzEoQ==".toCharArray();
	    private static String org = "University of Stuttgart";
	    private static String bucket = "Monitoring-Data";
	    
	    
	   
		



	    public static void main(final String[] args) {
	    	


	        InfluxDBClient influxDBClient = InfluxDBClientFactory.create("http://localhost:9999", token, org, bucket);

	        //
	        // Write data
	        //
	        try (WriteApi writeApi = influxDBClient.getWriteApi()) {

	            //
	            // Write by Data Point
	            //
	        	  Point point = Point.measurement("OperationExecution_Sam")
	                    .addTag("hostname", "hostname")
	                    .addField("value", 55D)
	                    .time(Instant.now().toEpochMilli(), WritePrecision.MS);

	            writeApi.writePoint(point);

	            //
	            // Write by LineProtocol
	            //
	            writeApi.writeRecord(WritePrecision.MS, "temperature,location=north value=60.0");

	            //
	            // Write by POJO
	            //
	            Temperature temperature = new Temperature();
	            temperature.location = "south";
	            temperature.value = 62D;
	            temperature.time = Instant.now();

	            writeApi.writeMeasurement(WritePrecision.MS, temperature);
	        }

	        //
	        // Query data
	        //
	        String flux = "from(bucket:\"Monitoring-Data\") |> range(start: 0)";

	        QueryApi queryApi = influxDBClient.getQueryApi();

	        List<FluxTable> tables = queryApi.query(flux);
	        for (FluxTable fluxTable : tables) {
	            List<FluxRecord> records = fluxTable.getRecords();
	            for (FluxRecord fluxRecord : records) {
	                System.out.println(fluxRecord.getTime() + ": " + fluxRecord.getValueByKey("_value"));
	            }
	        }

	        influxDBClient.close();
	    }

	    @Measurement(name = "OperationExecution")
	    private static class Temperature {

	        @Column(tag = true)
	        String location;

	        @Column
	        Double value;

	        @Column(timestamp = true)
	        Instant time;
	    }
	
}

