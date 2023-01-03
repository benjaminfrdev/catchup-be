package com.project.be.api.controller;

import com.project.be.api.exception.BadRequest;
import com.project.be.api.exception.Forbidden;
import com.project.be.api.exception.UnAuthorized;
import com.project.be.api.util.Exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

@RestControllerAdvice
public class ControllerAdvice {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BadRequest.class)
    public Exception badRequest() {
        Exception exception = new Exception();
        exception.setStatus(400);
        exception.setError("Bad request");
        exception.setMessage("Bad request parameter");
        return exception;
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(UnAuthorized.class)
    public Exception unAuthorized() {
        Exception exception = new Exception();
        exception.setStatus(401);
        exception.setError("Unauthorized");
        exception.setMessage("Incorrect authentication info");
        return exception;
    }

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(Forbidden.class)
    public Exception forbidden() {
        Exception exception = new Exception();
        exception.setStatus(403);
        exception.setError("Forbidden");
        exception.setMessage("Not allowed");
        return exception;
    }


}
