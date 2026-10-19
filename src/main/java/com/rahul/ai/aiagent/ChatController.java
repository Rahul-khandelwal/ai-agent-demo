package com.rahul.ai.aiagent;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/chat")
public class ChatController {

  private final SupportAgent agent;

  public ChatController(SupportAgent agent) {
    this.agent = agent;
  }

  @PostMapping
  public String chat(@RequestBody String message) {
    return agent.chat(message);
  }
}