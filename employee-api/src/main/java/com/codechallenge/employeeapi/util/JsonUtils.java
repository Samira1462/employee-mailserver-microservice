package com.codechallenge.employeeapi.util;

import com.codechallenge.employeeapi.model.EmployeeMessage;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static String convertEmployeeMessageToJson(EmployeeMessage message) {
        try {
            return objectMapper.writeValueAsString(message);
        } catch (Exception e) {
            // Handle exceptions
            return null;
        }
    }

    public static EmployeeMessage convertJsonToEmployeeMessage(String serializedMessage) {
        try {
            return objectMapper.readValue(serializedMessage, EmployeeMessage.class);
        } catch (Exception e) {
            // Handle exceptions
            return null;
        }
    }
}
