package com.myrealtrip.skeleton.api.handler;

import com.myrealtrip.skeleton.core.exception.SkeletonBaseException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * ApiExceptionHandler
 *
 * @author sarasu
 * @since 2021.09.27
 */
@Slf4j
@ControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(SkeletonBaseException.class)
    @ResponseBody
    public ResponseEntity<SkeletonBaseException> handleException(final Exception ex) {
        log.error(ex.toString());

        return ResponseEntity
                .status(HttpStatus.SERVICE_UNAVAILABLE)
                .body(new SkeletonBaseException());
    }
}
