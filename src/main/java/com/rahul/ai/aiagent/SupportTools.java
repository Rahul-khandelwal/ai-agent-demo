package com.rahul.ai.aiagent;

import dev.langchain4j.agent.tool.P;
import dev.langchain4j.agent.tool.Tool;
import java.util.Map;
import java.util.Random;
import org.springframework.stereotype.Service;

@Service
public class SupportTools {

  private Random random = new Random();
  private String[] statuses = {"UP", "DOWN"};
  private Map<String, String[]> serviceDetails =
      Map.of("notification", statuses, "database", statuses);

  @Tool(value = "Returns the current health status of a specific microservice. " +
      "Use this when asked about service status.")
  public String getServiceStatus(@P("the name of the service for which status is required") String serviceName) {
    try {
      System.out.println("Checking the status of " + serviceName);
      if (serviceDetails.containsKey(serviceName)) {
        return serviceName + " is " + statuses[random.nextInt(statuses.length)];
      }
      throw new IllegalArgumentException("Invalid service name " + serviceName);
    } catch (RuntimeException e) {
      return e.getMessage();
    }
  }
}
