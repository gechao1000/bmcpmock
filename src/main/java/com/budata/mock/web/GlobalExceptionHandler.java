package com.budata.mock.web;

import com.budata.mock.util.R;
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
    public R handleException(Exception e) {
        return R.fail(e.getLocalizedMessage());
    }

}
