package com.maru.models;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "AI 요청 모델")
public class AiRequest {

    @Schema(description = "사용자 질문/프롬프트", example = "안녕하세요, 오늘 날씨가 어때요?")
    private String prompt;

    public AiRequest() {
    }

    public AiRequest(String prompt) {
        this.prompt = prompt;
    }

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }
} 