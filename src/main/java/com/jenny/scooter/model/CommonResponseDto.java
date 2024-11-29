package com.jenny.scooter.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
@AllArgsConstructor
public class CommonResponseDto <T>{

    T data;

    String resultCode;

    String message;
}
