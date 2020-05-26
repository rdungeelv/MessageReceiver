package com.tspi.beans;

import org.influxdb.InfluxDB;
import org.influxdb.InfluxDBFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseConfiguration {

    @Bean
    public InfluxDB dbConnection(@Value("${spring.influxdb.url}") String url) {
        return InfluxDBFactory.connect(url);
    }
}
