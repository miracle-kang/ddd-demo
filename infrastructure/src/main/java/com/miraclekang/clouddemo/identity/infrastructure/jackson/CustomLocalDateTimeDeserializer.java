package com.miraclekang.clouddemo.identity.infrastructure.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.util.StdDateFormat;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * Created by shuzhiqiang on 2017-2-13.
 */
public class CustomLocalDateTimeDeserializer extends JsonDeserializer<LocalDateTime> {
    @Override
    public LocalDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {

        String txt = jsonParser.getText();

        if (txt == null || txt.trim().isEmpty()) {
            return null;
        }

        try {
            StdDateFormat format = new StdDateFormat();
            Date date = format.parse(txt.trim());
            return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
        } catch (Exception ex) {
            throw new IOException("时间格式错误", ex);
        }
    }
}