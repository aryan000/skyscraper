package com.dataIntegration.Skyscraper;

import java.io.Serializable;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Builder
@Data
@EqualsAndHashCode
public class MyBean implements Serializable {

  Integer id;
  String name;

}
