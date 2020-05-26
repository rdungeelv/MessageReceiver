package com.tspi.flow.handler;

import com.tspi.to.TspiData;
import org.influxdb.InfluxDB;
import org.springframework.integration.handler.GenericHandler;
import org.springframework.messaging.MessageHeaders;

import java.util.Map;

public class TspiDataInsertHandler implements GenericHandler<TspiData> {

    private InfluxDB influxDB;

    public TspiDataInsertHandler(InfluxDB influxDB) {
        this.influxDB = influxDB;
    }

    @Override
    public Object handle(TspiData payload, MessageHeaders headers) {
        return null;
    }
}
