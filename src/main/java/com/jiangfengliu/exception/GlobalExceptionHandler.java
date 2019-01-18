package com.jiangfengliu.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
 public class GlobalExceptionHandler {  
     @ExceptionHandler(RuntimeException.class)
     @ResponseBody //在返回自定义相应类的情况下必须有，这是@ControllerAdvice注解的规定
     public HttpServletResponse exceptionHandler(RuntimeException e, HttpServletResponse response) {
         
         return response;
     }  
 } 