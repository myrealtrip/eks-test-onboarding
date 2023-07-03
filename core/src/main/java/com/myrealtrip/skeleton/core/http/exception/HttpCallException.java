package com.myrealtrip.skeleton.core.http.exception;

import com.myrealtrip.skeleton.core.exception.SkeletonBaseException;

/**
 * HttpCallException
 *
 * @author sarasu
 * @since 2021.10.27
 */
public class HttpCallException extends SkeletonBaseException {
    public HttpCallException(Throwable ex) {
        super(ex);
    }
}
