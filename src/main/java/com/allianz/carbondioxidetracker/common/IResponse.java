package com.allianz.carbondioxidetracker.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

public class IResponse<T> extends ResponseEntity<T> {

    public IResponse(HttpStatus status) {
        super(status);
    }

    public IResponse(T body, HttpStatus status) {
        super(body, status);
    }

    public IResponse(MultiValueMap<String, String> headers, HttpStatus status) {
        super(headers, status);
    }

    public IResponse(T body, MultiValueMap<String, String> headers, HttpStatus status) {
        super(body, headers, status);
    }

    public IResponse(T body, MultiValueMap<String, String> headers, int rawStatus) {
        super(body, headers, rawStatus);
    }
}
