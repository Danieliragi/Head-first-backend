package com.alimentationAkonkwa.HeadFirst.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse<T> {
    private T data;
    private String message;

    public ApiResponse(T data) {
        this.data = data;
        this.message = "success";
    }

    public ApiResponse(String message) {
        this.message = message;
    }

}
