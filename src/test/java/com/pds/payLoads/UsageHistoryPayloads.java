package com.pds.payLoads;

import io.cucumber.core.internal.com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

public class UsageHistoryPayloads {

    public static Object validPayloadStatic(String title, String body, int userId) throws JsonProcessingException {
        Map<String, Object>  payLoad = new HashMap<String, Object>();
        payLoad.put("title", title);
        payLoad.put("body", body);
        payLoad.put("userId", userId);
//        return payLoad;

        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(payLoad);
    }

    public static Map<String, String> validPayloadDynamic(String job){
        Map<String,String>  payLoad = new HashMap<String, String>();
        payLoad.put("name", "User" + UUID.randomUUID());
        payLoad.put("job", job);
        return payLoad;
    }
    public static Map<String, String> invalidPayloadt() {
        Map<String, String> payload = new HashMap<>();
        payload.put("invalidKey", "value");
        return payload;
    }
}
