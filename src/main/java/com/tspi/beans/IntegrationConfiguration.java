package com.tspi.beans;

import com.tspi.flow.handler.TspiDataInsertHandler;
import com.tspi.flow.transform.TspiDataTransformer;
import com.tspi.to.TspiData;
import org.influxdb.InfluxDB;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.handler.GenericHandler;
import org.springframework.integration.ip.udp.UnicastReceivingChannelAdapter;
import org.springframework.integration.transformer.GenericTransformer;
import org.springframework.integration.transformer.ObjectToStringTransformer;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.PollableChannel;

@Configuration
@EnableIntegration
public class IntegrationConfiguration {
    @Bean
    public IntegrationFlow handleUdpMsgFlow(
            @Qualifier("udpInboundAdapter") UnicastReceivingChannelAdapter udpInboundAdapter,
            @Qualifier("udpMsgTransformer") GenericTransformer<?,?> udpMsgTransformer,
            GenericHandler<TspiData> dataHandler) {
        return IntegrationFlows.from(udpInboundAdapter)
                .transform(udpMsgTransformer)
                .transform(tspiDataTransformer())
                .handle(dataHandler)
                .channel(udpTransformedInputChannel())
                .get();
    }

    @Bean
    public GenericTransformer<?,?> udpMsgTransformer() {
        return new ObjectToStringTransformer();
    }

    @Bean
    public GenericTransformer<String, TspiData> tspiDataTransformer() {
        return new TspiDataTransformer();
    }

    @Bean
    public GenericHandler<TspiData> dataHandler(InfluxDB dbConnection) {
        return new TspiDataInsertHandler(dbConnection);
    }

    @Bean
    public MessageChannel udpInputChannel() {
        return new DirectChannel();
    }

    @Bean
    public PollableChannel udpTransformedInputChannel() {
        return new QueueChannel();
    }

    @Bean
    public UnicastReceivingChannelAdapter udpInboundAdapter(@Value("${tspi.receiving.port:59090}") int port) {
        UnicastReceivingChannelAdapter unicastReceivingChannelAdapter = new UnicastReceivingChannelAdapter(port);
        unicastReceivingChannelAdapter.setOutputChannel(udpInputChannel());
        return unicastReceivingChannelAdapter;
    }
}
