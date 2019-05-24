package com.budata.mock.web;

import com.budata.mock.vo.Json;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * GlobalExceptionHandler class
 *
 * @author gexc
 * @date 2019/05/24
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Json handleException(Exception e) {
        return Json.fail(e.getLocalizedMessage());
    }

}
