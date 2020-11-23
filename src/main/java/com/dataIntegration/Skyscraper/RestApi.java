package com.dataIntegration.Skyscraper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.model.rest.RestBindingMode;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
class RestApi extends RouteBuilder {

  @Value("${baeldung.api.path}")
  String contextPath;

  @Value("${server.port}")
  String serverPort;

  @Override
  public void configure() {
    CamelContext context = new DefaultCamelContext();

    restConfiguration()
        .contextPath(contextPath)
        .port(serverPort)
        .enableCORS(true)
        .apiContextPath("/api-doc")
        .apiProperty("api.title", "Test REST API")
        .apiProperty("api.version", "v1")
        .apiContextRouteId("doc-api")
        .component("servlet")
        .bindingMode(RestBindingMode.json);

    rest("/api/")
        .id("api-route")
        .consumes("application/json")
        .post("/bean")
        .bindingMode(RestBindingMode.json_xml)
        .type(MyBean.class)
        .to("direct:remoteService");

    from("direct:remoteService")
        .routeId("direct-route")
        .tracing()
        .log(">>> ${body.id}")
        .log(">>> ${body.name}")
        .process(
            new Processor() {
              @Override
              public void process(Exchange exchange) throws Exception {
                MyBean bodyIn = (MyBean) exchange.getIn().getBody();
                System.out.println("bodyIn"+bodyIn);
                ExampleServices.example(bodyIn);
                exchange.getIn().setBody(bodyIn);
                try (Socket socket = new Socket("localhost", 6868)) {

                  InputStream input = socket.getInputStream();
                  BufferedReader reader = new BufferedReader(new InputStreamReader(input));

                  String time = reader.readLine();

                  System.out.println(time);


                } catch (UnknownHostException ex) {

                  System.out.println("Server not found: " + ex.getMessage());

                } catch (IOException ex) {

                  System.out.println("I/O error: " + ex.getMessage());
                }
              }
            })
        .setHeader(Exchange.HTTP_RESPONSE_CODE, constant(200));
  }
}
