package io.algostrategy.client.bitmart.impl;

import io.algostrategy.client.bitmart.BitmartApiAsyncRestClient;
import io.algostrategy.client.bitmart.domain.Response;
import io.algostrategy.client.bitmart.domain.general.AssetResponse;

import java.util.concurrent.CompletableFuture;

/**
 * Implementation of Bitmart's REST API using Retrofit with asynchronous/non-blocking method calls.
 */
public class BitmartApiAsyncRestClientImpl implements BitmartApiAsyncRestClient {

    private final BitmartApiService bitmartApiService;

    public BitmartApiAsyncRestClientImpl(BitmartApiService bitmartApiService) {
        this.bitmartApiService = bitmartApiService;
    }

    // General endpoints

    @Override
    public CompletableFuture<Response<AssetResponse>> getAssets() {
        CompletableFuture<Response<AssetResponse>> future = new CompletableFuture<>();
        bitmartApiService.getAssets().enqueue(new RetrofitCallbackAdapter<>(future));
        return future;
    }
}
