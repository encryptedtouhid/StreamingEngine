package com.kmth.streamingengine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendAudio(String message) {
        kafkaTemplate.send("audio-stream", message);
    }

    public void sendVideo(String message) {
        kafkaTemplate.send("video-stream", message);
    }
}

