/*
 * This is only for an interview purpose in Allianz Technology,
 * This code is developed by 4 interview candidates.
 * This is written in free version Java 8 .
 * This is written in spring boot version 2.4.2 .
 * This is an open source .
 * This code meets most of the SOLID principles.
 * No Copyrights or no rights reserved .
 * Any one can use this code for their organization, personal or learning purposes.
 * ANY ONE CAN ALTER THIS CODE OR THIS FILE.
 * @author Team Player-1
 * @author Team Player-2
 * @author Team Player-3
 * @author Team Player-4
 */
package com.allianz.carbondioxidetracker.common;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

public class IResponseBuilder<T> {

    public enum Message {
        SUCCESS ,
        NOT_SUCCESS
    }

    private final ResponseBody<T> responseBody = new ResponseBody<>() ;
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

    public static Error error(ErrorCode errorCode, String errorMessage) {
        return new Error(errorCode, errorMessage) ;
    }


    public IResponse<ResponseBody<T>> build() {
        return new IResponse<>(responseBody, headers, status);
    }

    public IResponseBuilder<T> setBody(T body) {

        responseBody.setData(body);
        return this ;
    }

    public IResponseBuilder<T> setError(Error error) {

        responseBody.setError(error);
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

    public static final class ResponseBody<T> {

        private T data;
        private Error error;
        private Message message ;

        public T getData() {
            return data;
        }

        public Error getError() {
            return error;
        }

        public Message getMessage() {
            return message;
        }

        void setData(T data) {

            this.error = null;
            message = Message.SUCCESS ;
            this.data = data;
        }

        void setError(Error error) {

            this.data = null;
            message = Message.NOT_SUCCESS;
            this.error = error;
        }
    }

    public static final class Error {

        private final ErrorCode errorCode;
        private final String errorMessage;

        Error(ErrorCode errorCode, String errorMessage) {
            this.errorCode = errorCode;
            this.errorMessage = errorMessage;
        }

        public Object getErrorCode() {
            return errorCode;
        }

        public String getErrorMessage() {
            return errorMessage;
        }
    }
}

