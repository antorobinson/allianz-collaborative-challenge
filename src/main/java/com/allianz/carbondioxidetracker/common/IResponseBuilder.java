package com.allianz.carbondioxidetracker.common;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

public class IResponseBuilder<T> {

    private T body ;
    private HttpStatus status ;

    private HttpHeaders headers = null;

    private IResponseBuilder() {
    }

    public static <T> IResponseBuilder<T> builder() {

        return new IResponseBuilder<T>() ;
    }

    public static <T> IResponseBuilder<T> builder(T body) {

        final IResponseBuilder<T> builder = builder() ;
        builder.setBody(body) ;

        return builder ;
    }

    public static Error error(Object obj) {
        return new Error(obj) ;
    }


    public IResponse<T> build() {
        return new IResponse<>(body, headers, status);
    }


    public IResponseBuilder<T> setBody(T body) {

        this.body = body;
        return this ;
    }

    public IResponseBuilder<T> setStatus(HttpStatus status) {

        this.status = status;
        return this ;
    }

    public IResponseBuilder<T> addHeader(String key, String value) {

        if (headers == null) {
            headers = new HttpHeaders() ;
        }

        headers.add(key, value);

        return this ;
    }

    public static class Error {

        private final Object errorCode;

        Error(Object error) {
            this.errorCode = error;
        }

        public Object getErrorCode() {
            return errorCode;
        }
    }
}

