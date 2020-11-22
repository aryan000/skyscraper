package com.dataIntegration.Skyscraper.kafka;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
  private String name;
  private int age;
}
