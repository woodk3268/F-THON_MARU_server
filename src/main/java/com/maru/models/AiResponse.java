package com.maru.models;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "AI 응답 모델")
public class AiResponse {

    @Schema(description = "AI 모델의 응답")
    private String response;

    @Schema(description = "요청 처리 상태", example = "success")
    private String status;

    @Schema(description = "처리 시간 (밀리초)", example = "1234")
    private long processingTime;

    public AiResponse() {
    }

    public AiResponse(String response, String status, long processingTime) {
        this.response = response;
        this.status = status;
        this.processingTime = processingTime;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getProcessingTime() {
        return processingTime;
    }

    public void setProcessingTime(long processingTime) {
        this.processingTime = processingTime;
    }
} 