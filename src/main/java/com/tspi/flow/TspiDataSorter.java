package com.tspi.flow;

import org.springframework.messaging.Message;
import org.springframework.messaging.PollableChannel;

public class TspiDataSorter {

    private PollableChannel inboundChannel;

    public TspiDataSorter(PollableChannel udpTransformedInputChannel) {
        this.inboundChannel = udpTransformedInputChannel;
    }

    public void sort() {
        while(true) {
            Message<?> message = inboundChannel.receive();

            if (message != null) {
                System.out.println(message.getPayload());
            } else {
                throw new IllegalArgumentException("Received a null message from the channel. Something weird happened.");
            }
        }
    }
}
