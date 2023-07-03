package com.myrealtrip.skeleton.infrastructure.http;

import org.jetbrains.annotations.NotNull;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * HttpClientFactory
 *
 * @author sarasu
 * @since 2021.10.26
 */
public class HttpClientFactory {
    public static <T> T build(String baseUrl, Class<T> type) {
        return build(baseUrl, type, JacksonConverterFactory.create());
    }

    @NotNull
    public static <T> T build(String baseUrl, Class<T> type, Converter.Factory converterFactory) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(converterFactory)
                .build();

        return retrofit.create(type);
    }
}