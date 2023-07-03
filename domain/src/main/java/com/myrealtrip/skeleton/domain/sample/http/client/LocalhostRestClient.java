package com.myrealtrip.skeleton.domain.sample.http.client;

import com.myrealtrip.skeleton.core.sample.http.dto.TestResponseSample;
import retrofit2.Call;
import retrofit2.http.GET;

public interface LocalhostRestClient {
    @GET("/test-response")
    Call<TestResponseSample> ping();
}
