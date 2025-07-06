package com.tourneyofthereliquary.tourneyrestendpoint.services;

import org.springframework.http.codec.json.Jackson2JsonEncoder;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.lettuce.core.json.JsonValue;

@Service
public class SerializationService {
    ObjectMapper mapper;

    public SerializationService(){
        mapper = new ObjectMapper();
    }

    // public JsonValue serializePojo(Object pojo) {
    //     return DelegateJsonValue.wrap(mapper.valueToTree(pojo));
    // }

    // public <T> deserializeJsonAsPojo(JsonValue value, T clazz) {

    // }
}
