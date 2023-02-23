package io.algostrategy.client.bitmart.impl;

import io.algostrategy.client.bitmart.BitmartApiAsyncRestClient;
import io.algostrategy.client.bitmart.BitmartApiClientFactory;
import io.algostrategy.client.bitmart.domain.Response;
import io.algostrategy.client.bitmart.domain.general.AssetResponse;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutionException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BitmartApiAsyncRestClientImplTest {

    private final BitmartApiAsyncRestClient bitmartApiAsyncRestClient = BitmartApiClientFactory.newInstance().newAsyncRestClient();

    @Test
    public void getAssets_ShouldReturnAssets() throws ExecutionException, InterruptedException {
        Response<AssetResponse> response = bitmartApiAsyncRestClient.getAssets().get();
        assertNotNull(response);
        assertNotNull(response.getData());
        assertThat(response.getData().getAssets(), is(not(empty())));
    }
}