package com.example.demo.model;

import lombok.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response {

    private String message;
    private Object data;
    public Response(Object data) {
        this.data = data;
    }

    public Response(String message) {
        this.message = message;
    }
}