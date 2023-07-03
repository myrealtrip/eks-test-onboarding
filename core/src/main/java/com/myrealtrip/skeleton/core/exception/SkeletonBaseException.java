package com.myrealtrip.skeleton.core.exception;

/**
 * SkeletonBaseException
 *
 * @author sarasu
 * @since 2021.10.21
 */
public class SkeletonBaseException extends RuntimeException {
    public SkeletonBaseException() {
        super();
    }
    public SkeletonBaseException(Throwable ex) {
        super(ex);
    }
}
