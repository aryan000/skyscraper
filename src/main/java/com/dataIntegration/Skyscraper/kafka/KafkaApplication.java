package com.dataIntegration.Skyscraper.kafka;

import java.util.concurrent.ExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Component
/**
 * To publish a message, auto wire the Kafka Template object and produce the message
 */
public class KafkaApplication {

  @Autowired
  private KafkaTemplate<String, String> kafkaTemplate;

  private static final String TOPIC_NAME = "tutorialspoint";

  /**
   * Producer
   * @param message
   * @return
   * @throws ExecutionException
   * @throws InterruptedException
   */
  public String sendMessage(String message) throws ExecutionException, InterruptedException {

    System.out.println("getting message with messge: " + message);
    ListenableFuture<SendResult<String, String>> future =
        kafkaTemplate.send(TOPIC_NAME, message);

    future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {

      @Override
      public void onSuccess(SendResult<String, String> result) {
        System.out.println("Sent message=[" + message +
            "] with offset=[" + result.getRecordMetadata().offset() + "]");
      }
      @Override
      public void onFailure(Throwable ex) {
        System.out.println("Unable to send message=["
            + message + "] due to : " + ex.getMessage());
      }
    });
     future.get();
     return "Processed topic successfully";
  }

  /**
   * Kafka Listener: write a Listener to listen to the messages. This is consumer
   * @param message
   */
  @KafkaListener(topics = TOPIC_NAME, groupId = "group-id")
  public void listen(String message) {
    System.out.println("Received Messasge in group - group-id: " + message);
  }

}
