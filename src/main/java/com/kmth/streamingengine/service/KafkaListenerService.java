package com.kmth.streamingengine.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaListenerService {

    @KafkaListener(topics = "audio-stream", groupId = "streaming-group")
    public void listenAudio(String message) {
        // Process audio message
        System.out.println("Received Audio Message: " + message);
    }

    @KafkaListener(topics = "video-stream", groupId = "streaming-group")
    public void listenVideo(String message) {
        // Process video message
        System.out.println("Received Video Message: " + message);
    }
}
