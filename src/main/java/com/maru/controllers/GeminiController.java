package com.maru.controllers;

import com.maru.models.GeminiRequest;
import com.maru.models.GeminiResponse;
import com.maru.services.GeminiService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/gemini")
@Tag(name = "Gemini", description = "Google Gemini API 관련 기능")
public class GeminiController {

    private final GeminiService geminiService;

    public GeminiController(GeminiService geminiService) {
        this.geminiService = geminiService;
    }

    @Operation(
        summary = "Gemini 텍스트 생성",
        description = "Gemini API를 통해 한국어로 텍스트를 생성합니다.",
        responses = {
            @ApiResponse(
                responseCode = "200",
                description = "요청 성공",
                content = @Content(mediaType = "application/json", 
                schema = @Schema(implementation = GeminiResponse.class))
            )
        }
    )
    @PostMapping("/generate")
    public GeminiResponse generateContent(@RequestBody GeminiRequest request) {
        String prompt = request.getPrompt();
        String response = geminiService.generateContent(prompt);
        return new GeminiResponse(response);
    }
    
    @Operation(
        summary = "PDF 분석 및 응답 생성",
        description = "PDF 파일을 분석하고 Gemini API를 통해 한국어로 텍스트를 생성합니다.",
        responses = {
            @ApiResponse(
                responseCode = "200",
                description = "요청 성공",
                content = @Content(mediaType = "application/json", 
                schema = @Schema(implementation = GeminiResponse.class))
            )
        }
    )
    @PostMapping(value = "/generate-with-pdf", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public GeminiResponse generateContentWithPdf(
            @RequestParam("prompt") String prompt,
            @RequestParam("pdfFile") MultipartFile pdfFile) {
        
        String response = geminiService.generateContentWithPdf(prompt, pdfFile);
        return new GeminiResponse(response);
    }
} 