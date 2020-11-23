package com.dataIntegration.Skyscraper;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Controller
public class ErrorController {

  @RequestMapping("/404")
  public String error() {
    return "Error, Controller not found";
  }
}
