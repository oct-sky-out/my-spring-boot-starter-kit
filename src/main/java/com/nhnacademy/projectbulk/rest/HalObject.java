package com.nhnacademy.projectbulk.rest;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

/**
 * 설명작성란
 *
 * @author 김민수
 * @since 1.0
 */
public class HalObject<T> {
    private static final String HREF = "href";
    private static final String ROOT_URL = "root";

    @JsonProperty("_links")
    private Map<String, Map<String, String>> links;

    @JsonProperty("_embedded")
    private T resource;

    HalObject() {
        links.put("root", Map.of(HREF, ROOT_URL));
    }

    public void addSelfHref(String url) {
        links.put("self", Map.of(HREF, url));
    }

    public void addNextHref(String url) {
        links.put("next", Map.of(HREF, url));
    }

    public void addPreviousHref(String url) {
        links.put("previous", Map.of(HREF, url));
    }

    public HalObject<T> addAnyHref(String linkFor, String url) {
        links.put(linkFor, Map.of(HREF, url));
        return this;
    }

    public ResponseEntity<HalObject<T>> createResponseEntity(HttpStatus httpStatus) {
        return ResponseEntity.status(httpStatus.value())
            .contentType(MediaType.APPLICATION_JSON)
            .body(this);
    }

    public void setResource(T resource) {
        this.resource = resource;
    }
}
