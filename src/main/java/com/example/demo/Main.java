package com.example.demo;

import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Base64;

public class Main {
    public static void main(String[] args) {
        String key = Base64.getEncoder().encodeToString(Keys.secretKeyFor(SignatureAlgorithm.HS256).getEncoded());
        System.out.println("Generated Key: " + key);
    }
}
