package com.kmth.streamingengine.controller;

import com.kmth.streamingengine.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/stream")
public class StreamingController {

    @Autowired
    private KafkaProducerService kafkaProducerService;

    @PostMapping("/audio")
    public ResponseEntity<String> streamAudio(@RequestBody String audioMessage) {
        kafkaProducerService.sendAudio(audioMessage);
        return ResponseEntity.ok("Audio message sent to Kafka");
    }

    @PostMapping("/video")
    public ResponseEntity<String> streamVideo(@RequestBody String videoMessage) {
        kafkaProducerService.sendVideo(videoMessage);
        return ResponseEntity.ok("Video message sent to Kafka");
    }
}

