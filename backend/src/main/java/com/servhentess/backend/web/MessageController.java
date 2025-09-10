package com.servhentess.backend.web;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

  private final List<String> messages = new ArrayList<>(List.of("Hello from Spring"));

  @GetMapping
  public List<String> list() { return messages; }

  @PostMapping
  public String add(@RequestBody String msg) {
    messages.add(msg);
    return msg;
  }
}
