package com.myrealtrip.skeleton.api.handler;

import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Request Logging
 *
 * @author sarasu
 * @since 2021.09.27
 */
@Slf4j
@Component
public class RestApiLoggingInterceptor implements HandlerInterceptor {
    /**
     * This implementation always returns {@code true}.
     *
     * @author sarasu
     * @since 2021.09.27
     */
    @Override
    public boolean preHandle(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response, @Nullable Object handler) {
        log.debug("Before handle, request={}", request);
        return true;
    }

    /**
     * This implementation always returns {@code true}
     *
     * @author sarasu
     * @since 2021.09.27
     */
    @Override
    public void postHandle(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response, @Nullable Object handler, @Nullable ModelAndView modelAndView) {
        log.debug("After handle, request={}, response={}", request, response);
    }
}
