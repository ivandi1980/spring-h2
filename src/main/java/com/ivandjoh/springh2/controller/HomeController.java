package com.ivandjoh.springh2.controller;

import com.ivandjoh.springh2.dto.ApiMessages;
import com.ivandjoh.springh2.dto.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class HomeController {

  @GetMapping("/")
  public ResponseEntity<ApiResponse<Map<String, Object>>> home() {
    Map<String, Object> response = new LinkedHashMap<>();
    response.put("data", Collections.emptyList());

    return ResponseEntity.ok(ApiResponse.success(response, ApiMessages.RESOURCES_FETCHED));
  }

  @GetMapping("/success")
  public ResponseEntity<ApiResponse<List<String>>> successResponse() {
    List<String> data = List.of("Item1", "Item2");
    return ResponseEntity.ok(ApiResponse.success(data, ApiMessages.RESOURCES_FETCHED));
  }

  @GetMapping("/dashboard")
  public ResponseEntity<ApiResponse<String>> getDashboard() {
    String message = "Welcome to My Home...";
    return ResponseEntity.ok(ApiResponse.success(message, ApiMessages.RESOURCE_FETCHED));
  }

  @GetMapping("/not-found")
  public ResponseEntity<ApiResponse<Void>> notFoundResponse() {
    return ResponseEntity.status(404).body(ApiResponse.notFound(ApiMessages.RESOURCE_NOT_FOUND));
  }

  @GetMapping("/server-error")
  public ResponseEntity<ApiResponse<Void>> serverErrorResponse() {
    return ResponseEntity.status(500).body(ApiResponse.internalServerError(ApiMessages.INTERNAL_SERVER_ERROR));
  }

  @GetMapping("/no-content")
  public ResponseEntity<ApiResponse<Void>> noContentResponse() {
    return ResponseEntity.status(204).body(ApiResponse.noContent());
  }
}