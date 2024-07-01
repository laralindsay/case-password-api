package com.example.passwordvalidatorapi.utils.enums;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ErrorMapper {

    public Map<String, String> createErrorMap(Throwable e) {
        Map<String, String> errorMsg = new HashMap<>();
        errorMsg.put("message", e.getMessage());

        return errorMsg;
    }

    public Map<String, String> createErrorMap(String message) {
        Map<String, String> errorMsg = new HashMap<>();
        errorMsg.put("message", message);

        return errorMsg;
    }
}
