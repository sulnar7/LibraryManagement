package com.example.librarymanagement.exception;

import com.example.librarymanagement.exception.errors.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Handle Custom Exception
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFound(RuntimeException ex) {
        ErrorResponse errorResponse = new ErrorResponse(
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND.value(),
                ex.getMessage()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

//        // Handle Validation Errors
//        @ExceptionHandler(MethodArgumentNotValidException.class)
//        public ResponseEntity<Map<String, String>> handleValidationErrors(MethodArgumentNotValidException ex) {
//            Map<String, String> errors = new HashMap<>();
//            ex.getBindingResult().getFieldErrors().forEach(error ->
//                    errors.put(error.getField(), error.getDefaultMessage())
//            );
//            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
//        }
//
//        // Handle Generic Exception
//        @ExceptionHandler(Exception.class)
//        public ResponseEntity<ErrorResponse> handleGlobalException(Exception ex) {
//            ErrorResponse errorResponse = new ErrorResponse(
//                    LocalDateTime.now(),
//                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
//                    "An unexpected error occurred: " + ex.getMessage()
//            );
//            return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }


}
