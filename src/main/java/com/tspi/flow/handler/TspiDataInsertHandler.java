package com.tspi.flow.handler;

import com.tspi.to.TspiData;
import org.influxdb.InfluxDB;
import org.influxdb.annotation.Column;
import org.influxdb.dto.Point;
import org.springframework.integration.handler.GenericHandler;
import org.springframework.messaging.MessageHeaders;

import java.util.Map;
import java.util.concurrent.TimeUnit;

public class TspiDataInsertHandler implements GenericHandler<TspiData> {

    private boolean created = false;
    private InfluxDB influxDB;

    public TspiDataInsertHandler(InfluxDB influxDB) {
        this.influxDB = influxDB;
    }

    @Override
    public Object handle(TspiData payload, MessageHeaders headers) {
        if(!created) {
            influxDB.createDatabase("tspi_data");
            influxDB.createRetentionPolicy(
                    "defaultPolicy",
                    "tspi_data",
                    "3d",
                    1,
                    true);
            influxDB.setLogLevel(InfluxDB.LogLevel.BASIC);
            created = true;
        }

        Point newPoint = Point.measurement("tspidata")
                .time(payload.getNanoseconds(), TimeUnit.NANOSECONDS)
                .addField("trackE", payload.getTrackE())
                .addField("trackF", payload.getTrackF())
                .addField("trackG", payload.getTrackG())
                .addField("range", payload.getRg())
                .addField("azimuth", payload.getAz())
                .addField("elevation", payload.getEl())
                .addField("mode", payload.getMode())
                .build();
        influxDB.write(newPoint);
        return null;
    }
}
