package com.myrealtrip.skeleton.infrastructure.http;

import com.myrealtrip.skeleton.core.http.exception.HttpCallException;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.io.IOException;

/**
 * HttpBroker
 *
 * @author sarasu
 * @since 2021.10.27
 */
public class HttpBroker {
    public static <T> T execute(Call<T> call) {
        try {
            Response<T> response = call.execute();
            return response.body();
        } catch (IOException ix) {
            throw new HttpCallException(ix);
        }
    }

    public static  <T> void executeAsync(Call<T> call) {
        executeAsync(
                call,
                new Callback<T>() {
                    @Override
                    public void onResponse(Call<T> call, Response<T> response) {
                    }

                    @Override
                    public void onFailure(Call<T> call, Throwable t) {
                        throw new HttpCallException(t);
                    }
                });
    }

    public static <T> void executeAsync(Call<T> call, Callback<T> callback) {
        call.enqueue(callback);
    }
}