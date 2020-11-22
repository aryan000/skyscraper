package com.dataIntegration.Skyscraper.kafka;

import java.util.concurrent.ExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {

  @Autowired
  private KafkaApplication kafkaApplication;

  @RequestMapping("/send")
  public String sendMessage(@RequestParam("message") String message)
      throws ExecutionException, InterruptedException {
    System.out.println("qwerty received send input message");
    return kafkaApplication.sendMessage(message);
  }

  @PostMapping(value = "/publish")
  public String sendMessageToKafkaTopic(@RequestParam("message") String message)
      throws ExecutionException, InterruptedException {
    return this.kafkaApplication.sendMessage(message);
  }
}
