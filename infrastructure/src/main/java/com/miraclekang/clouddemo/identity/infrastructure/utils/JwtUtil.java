package com.miraclekang.clouddemo.identity.infrastructure.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.miraclekang.clouddemo.identity.infrastructure.exception.InvalidTokenException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.security.Key;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Map;

/**
 * Specified here
 *
 * @author kangliqi
 * @date 2019/1/28
 */
public class JwtUtil {

    private static ObjectMapper DEFAULT_OBJECT_MAPPER;

    static {
        DEFAULT_OBJECT_MAPPER = new ObjectMapper();
        DEFAULT_OBJECT_MAPPER.setDefaultPropertyInclusion(JsonInclude.Include.NON_NULL);
        DEFAULT_OBJECT_MAPPER.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    }

    private static final int DEFAULT_EXPIRES_IN_DAYS = 7;
    private final String issuer;
    private final Key key;

    private final ObjectMapper objectMapper;

    public JwtUtil(String issuer, ObjectMapper objectMapper, String key) {
        this.issuer = issuer;
        this.objectMapper = objectMapper;
        if (key == null || key.isBlank()) {
            this.key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        } else {
            byte[] keyData = Base64.decodeBase64(key);
            this.key = new SecretKeySpec(keyData, SignatureAlgorithm.HS256.getJcaName());
        }
    }

    public JwtUtil(ObjectMapper objectMapper, String key) {
        this(null, objectMapper, key);
    }

    public JwtUtil(String issuer, String key) {
        this(issuer, DEFAULT_OBJECT_MAPPER, key);
    }

    public JwtUtil() {
        this(DEFAULT_OBJECT_MAPPER, null);
    }


    public String encode(Map<String, Object> content) {
        return Jwts.builder()
                .signWith(key)
                .setClaims(content)
                .compact();
    }

    public String encode(Object content) {
        try {
            return Jwts.builder()
                    .signWith(key)
                    .setPayload(objectMapper.writeValueAsString(content))
                    .compact();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public String encode(String id, String subject, String audience, Object content) {
        try {
            String jsonContent = objectMapper.writeValueAsString(content);
            Map<String, Object> contentMap = objectMapper.readValue(jsonContent,
                    new TypeReference<Map<String, Object>>() {
                    }
            );
            return this.encode(id, subject, audience, contentMap, LocalDateTime.now().plusDays(DEFAULT_EXPIRES_IN_DAYS));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String encode(String id, String subject, String audience, Map<String, Object> content) {
        return this.encode(id, subject, audience, content, LocalDateTime.now().plusDays(DEFAULT_EXPIRES_IN_DAYS));
    }

    public String encode(String id, String subject, String audience, Object content, int expiresHours) {
        try {
            String jsonContent = objectMapper.writeValueAsString(content);
            Map<String, Object> contentMap = objectMapper.readValue(jsonContent,
                    new TypeReference<Map<String, Object>>() {
                    }
            );
            return this.encode(id, subject, audience, contentMap, LocalDateTime.now().plusHours(expiresHours));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String encode(String id, String subject, String audience, Map<String, Object> content, LocalDateTime expiresIn) {
        Claims jwtClaims = Jwts.claims()
                .setId(id)
                .setIssuer(issuer)
                .setSubject(subject)
                .setAudience(audience)
                .setIssuedAt(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
                .setExpiration(Date.from(expiresIn.atZone(ZoneId.systemDefault()).toInstant()));
        jwtClaims.putAll(content);

        return Jwts.builder()
                .signWith(key)
                .setClaims(jwtClaims)
                .compact();
    }

    public <T> T decode(String encodedJws, Class<T> type) throws InvalidTokenException {
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(key)
                    .parseClaimsJws(encodedJws)
                    .getBody();
            return objectMapper.readValue(objectMapper.writeValueAsBytes(claims), type);
        } catch (JwtException e) {
            throw new InvalidTokenException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Claims decode(String encodedJws) throws InvalidTokenException {
        try {
            return Jwts.parser()
                    .setSigningKey(key)
                    .parseClaimsJws(encodedJws)
                    .getBody();
        } catch (JwtException e) {
            throw new InvalidTokenException(e);
        }
    }
}
