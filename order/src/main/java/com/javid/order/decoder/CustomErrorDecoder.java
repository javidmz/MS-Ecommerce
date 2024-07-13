package com.javid.order.decoder;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.javid.order.exception.CustomFeignException;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.RequiredArgsConstructor;

import java.io.IOException;

@RequiredArgsConstructor
public class CustomErrorDecoder implements ErrorDecoder {
    private final ObjectMapper MAPPER;

    @Override
    public Exception decode(String s, Response response) {
        int statusCode = response.status();
        String errorMsg = "Some error occurred. PLease try again.";

        if (response.body() != null) {
            try (var body = response.body().asInputStream()) {
                JsonNode jsonNode = MAPPER.readTree(body);
                if (jsonNode.has("message")) {
                    errorMsg = jsonNode.get("message").asText();
                }
            } catch (IOException exception) {
                throw new CustomFeignException(statusCode, errorMsg);
            }
        }

        throw new CustomFeignException(statusCode, errorMsg);
    }
}
