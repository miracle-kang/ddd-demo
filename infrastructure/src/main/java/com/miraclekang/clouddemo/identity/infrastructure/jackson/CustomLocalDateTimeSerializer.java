package com.miraclekang.clouddemo.identity.infrastructure.jackson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.ifreecomm.education.infrastructure.factory.ObjectMapperFactory;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * Created by shuzhiqiang on 2017-2-13.
 */

public class CustomLocalDateTimeSerializer extends com.fasterxml.jackson.databind.JsonSerializer<LocalDateTime> {

    @Override
    public void serialize(LocalDateTime dateTime, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        try {
            ZoneId zone = ZoneId.systemDefault();
            Instant instant = dateTime.atZone(zone).toInstant();
            Date date = Date.from(instant);
            jsonGenerator.writeString(ObjectMapperFactory.objectMapper().getDateFormat().format(date));
        } catch (Exception ex) {
            jsonGenerator.writeString("");
        }
    }
}