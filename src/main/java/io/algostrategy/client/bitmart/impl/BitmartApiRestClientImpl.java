package io.algostrategy.client.bitmart.impl;

import io.algostrategy.client.bitmart.BitmartApiRestClient;
import io.algostrategy.client.bitmart.domain.Response;
import io.algostrategy.client.bitmart.domain.general.AssetResponse;

/**
 * Implementation of Binance's REST API using Retrofit with synchronous/blocking method calls.
 */
public class BitmartApiRestClientImpl implements BitmartApiRestClient {

    private final BitmartApiService bitmartApiService;

    public BitmartApiRestClientImpl(BitmartApiService bitmartApiService) {
        this.bitmartApiService = bitmartApiService;
    }

    // General endpoints

    @Override
    public Response<AssetResponse> getAssets() {
        return BitmartApiServiceGenerator.executeSync(bitmartApiService.getAssets());
    }
}
