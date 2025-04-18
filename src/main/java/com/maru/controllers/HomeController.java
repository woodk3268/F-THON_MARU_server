package com.maru.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@Tag(name = "홈", description = "홈 관련 API")
public class HomeController {

    @Operation(
        summary = "홈 정보 조회",
        description = "서버 상태 정보를 제공합니다.",
        responses = {
            @ApiResponse(
                responseCode = "200",
                description = "요청 성공",
                content = @Content(mediaType = "application/json", 
                schema = @Schema(implementation = Map.class))
            )
        }
    )
    @GetMapping("/")
    public Map<String, Object> home() {
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        response.put("message", "MARU API is running");
        return response;
    }
} 