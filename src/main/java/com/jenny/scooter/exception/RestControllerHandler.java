package com.jenny.scooter.exception;

import com.jenny.scooter.model.CommonResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class RestControllerHandler {

    @ExceptionHandler(DuplicatedValueException.class)
    public String duplicatedValueHandler(DuplicatedValueException d) {
        return d.getMessage();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Object methodArgumentNotValidException(MethodArgumentNotValidException m) {


        Map<String, String> data = new HashMap<>();

        for (ObjectError oe : m.getBindingResult().getAllErrors()) {
            FieldError fieldError = (FieldError) oe;
            String fieldName = fieldError.getField();
            String errorMessage = fieldError.getDefaultMessage();

            if (data.containsKey(fieldName))
                data.put(fieldName, data.get(fieldName) + " " + errorMessage);
            else
                data.put(fieldName, errorMessage);
        }

        CommonResponseDto<Object> commonResponseDto = CommonResponseDto.builder()
                .data(data)
                .resultCode("BAD_REQUEST")
                .message("요청정보가 잘못되었습니다.")
                .build();


        return ResponseEntity.ok(commonResponseDto);

    }
}