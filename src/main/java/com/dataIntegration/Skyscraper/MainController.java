package com.dataIntegration.Skyscraper;

import com.dataIntegration.Skyscraper.kafka.KafkaApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Controller
public class MainController {

  @Autowired
  private KafkaApplication kafkaApplication;

  @RequestMapping("/home")
  public String getRequest(){
    System.out.println("i am getting request");

    return "Successfully returned";
  }
}
