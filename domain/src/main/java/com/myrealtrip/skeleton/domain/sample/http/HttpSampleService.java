package com.myrealtrip.skeleton.domain.sample.http;

import com.myrealtrip.skeleton.domain.sample.http.client.LocalhostRestClient;
import com.myrealtrip.skeleton.core.sample.http.dto.TestResponseSample;
import com.myrealtrip.skeleton.infrastructure.http.HttpBroker;
import com.myrealtrip.skeleton.infrastructure.http.HttpClientFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * HttpSampleService
 *
 * @author sarasu
 * @since 2021.10.27
 */
@Slf4j
@Service
public class HttpSampleService {
    private LocalhostRestClient localhostRestClient;

    public HttpSampleService(@Value("${myrealtrip.test-servers}") String baseUrl) {
        this.localhostRestClient = HttpClientFactory.build(baseUrl, LocalhostRestClient.class);
    }

    public TestResponseSample callLocalhostPingSync() {
        return HttpBroker.execute(localhostRestClient.ping());
    }

    public void callLocalhostPingAsync() {
        HttpBroker.executeAsync(localhostRestClient.ping());
    }

    public void callLocalhostPingAsyncWithCallback() {
        HttpBroker.executeAsync(
                localhostRestClient.ping(),
                new Callback<TestResponseSample>() {
                    @Override
                    public void onResponse(Call<TestResponseSample> call, Response<TestResponseSample> response) {
                        log.debug("=======");
                        log.debug("Success Response : {}", response.body());
                        log.debug("=======");
                    }

                    @Override
                    public void onFailure(Call<TestResponseSample> call, Throwable t) {
                        log.debug("=======");
                        log.debug("Request Failed");
                        log.debug("=======");
                    }
                }
        );
    }
}
