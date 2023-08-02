package com.nikiko.timemanager.errorhandling;

//import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import com.nikiko.timemanager.exception.ApiException;
import com.nikiko.timemanager.exception.InvalidDataException;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.reactive.error.DefaultErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class AppErrorAttributes extends DefaultErrorAttributes {

    public AppErrorAttributes(){
        super();
    }
    private HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

    @Override
    public Map<String, Object> getErrorAttributes(ServerRequest request, ErrorAttributeOptions options){
        var errorAttributes = super.getErrorAttributes(request, ErrorAttributeOptions.defaults());
        var errorList = new ArrayList<Map<String, Object>>();
        var error = getError(request);
        if (error instanceof InvalidDataException) {
            status = HttpStatus.BAD_REQUEST;
            var errorMap = new HashMap<String, Object>();
            errorMap.put("code", error.getCause());
            errorMap.put("message", error.getMessage());
            errorList.add(errorMap);
        } else if (error instanceof ApiException) {
            status = HttpStatus.INTERNAL_SERVER_ERROR;
            var errorMap = new HashMap<String, Object>();
            errorMap.put("code", error.getCause());
            errorMap.put("message", error.getMessage());
            errorList.add(errorMap);
        } else {
            status = HttpStatus.INTERNAL_SERVER_ERROR;
            var errorMap = new HashMap<String, Object>();
            errorMap.put("code", error.getCause());
            errorMap.put("message", error.getMessage());
            errorList.add(errorMap);
        }
        var errors = new HashMap<String, Object>();
        errors.put("errors", errorList);
        errorAttributes.put("status", status.value());
        errorAttributes.put("errors", errors);
        return errorAttributes;
    }
}
