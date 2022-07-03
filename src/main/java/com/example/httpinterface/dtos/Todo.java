package com.example.httpinterface.dtos;

public record Todo(Long id, String title, boolean completed, Long userId) {
}
