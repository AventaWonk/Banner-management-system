package com.splat.bms.dto;

import org.springframework.validation.ObjectError;

import java.util.List;

public abstract class ResponseDto <T> {

    abstract String getStatus();
    abstract T getResult();

    public static ErrorResponse getError(List<ObjectError> objectErrors) {
        String[] errorMessages = new String[objectErrors.size()];
        for (int i = 0; i < errorMessages.length; i++) {
            errorMessages[i] = objectErrors.get(i).getCode();
        }

        return new ResponseDto.ErrorResponse(errorMessages);
    }

    public static SuccessResponse getSuccess(Object object) {
        return new ResponseDto.SuccessResponse(object);
    }

    public static SuccessResponse getSuccess() {
        return new ResponseDto.SuccessResponse();
    }

    private static class ErrorResponse extends ResponseDto {

        private String[] errorMessages;

        ErrorResponse(String[] errorMessages) {
            this.errorMessages = errorMessages;
        }

        @Override
        public String getStatus() {
            return "error";
        }

        @Override
        public String[] getResult() {
            return errorMessages;
        }

    }

    private static class SuccessResponse extends ResponseDto {

        private Object resultObject;

        SuccessResponse(Object resultObject) {
            this.resultObject = resultObject;
        }

        SuccessResponse() {

        }

        @Override
        public String getStatus() {
            return "success";
        }

        @Override
        public Object getResult() {
            return resultObject;
        }

    }

}
