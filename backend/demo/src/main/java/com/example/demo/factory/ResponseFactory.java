package com.example.demo.factory;

import com.example.demo.model.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ResponseFactory{
    public ResponseEntity<Response> createResponse(Object data, HttpStatus httpStatus) {
        return new ResponseEntity<>(new Response(data), httpStatus);
    }
    public ResponseEntity<Response> createResponse(String message, HttpStatus httpStatus) {
        return new ResponseEntity<>(new Response(message), httpStatus);
    }

    public ResponseEntity<Response> createResponse(HttpStatus httpStatus) {
        return new ResponseEntity<>(new Response(), httpStatus);
    }
}
