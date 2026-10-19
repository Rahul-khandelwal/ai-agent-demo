package com.rahul.ai.aiagent;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.spring.AiService;

@AiService
public interface SupportAgent {
  @SystemMessage("You are a senior DevOps engineer. " +
      "You have access to tools to check the service status." +
      "Use these tools to give the correct answer.")
  String chat(String userMessage);
}
