package com.maru.services;


import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AiService {

    private final ChatClient chatClient;

    @Autowired
    public AiService(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    public String generateResponse(String promptText) {
        Prompt prompt = new Prompt(promptText);
        ChatResponse response = chatClient.call(prompt);
        return response.getResult().getOutput().getText();
    }
} 