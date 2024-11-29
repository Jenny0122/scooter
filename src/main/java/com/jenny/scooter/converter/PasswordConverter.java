package com.jenny.scooter.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


@Converter
public class PasswordConverter implements AttributeConverter<String, String> {

    @Override
    public String convertToDatabaseColumn(String raw) {

        return encode(raw);
    }

    @Override
    public String convertToEntityAttribute(String encoded) {

        return "";      // * 개인정보보호법에 따라서 복호화는 사용하지 않음
    }

    private String encode(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(password.getBytes());

            return String.format("%0128x", new BigInteger(1, md.digest()));

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
