package com.tspi.beans;

import com.tspi.flow.TspiDataSorter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.PollableChannel;

@Configuration
public class CommonsConfiguration {
    @Bean
    public TspiDataSorter dataSorter(PollableChannel udpTransformedInputChannel) {
        return new TspiDataSorter(udpTransformedInputChannel);
    }
}
