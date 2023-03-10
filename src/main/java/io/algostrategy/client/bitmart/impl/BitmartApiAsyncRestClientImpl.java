package io.algostrategy.client.bitmart.impl;

import io.algostrategy.client.bitmart.BitmartApiAsyncRestClient;
import io.algostrategy.client.bitmart.domain.Response;
import io.algostrategy.client.bitmart.domain.general.AssetResponse;
import io.algostrategy.client.bitmart.domain.market.MarketInfoResponse;
import io.algostrategy.client.bitmart.domain.market.MarketTickerResponse;
import io.algostrategy.client.bitmart.domain.market.OrderBook;

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

    // Market endpoints

    @Override
    public CompletableFuture<Response<MarketInfoResponse>> getMarketInfo() {
        CompletableFuture<Response<MarketInfoResponse>> future = new CompletableFuture<>();
        bitmartApiService.getMarketInfo().enqueue(new RetrofitCallbackAdapter<>(future));
        return future;
    }

    @Override
    public CompletableFuture<Response<MarketTickerResponse>> getMarketTickers() {
        CompletableFuture<Response<MarketTickerResponse>> future = new CompletableFuture<>();
        bitmartApiService.getMarketTickers().enqueue(new RetrofitCallbackAdapter<>(future));
        return future;
    }

    @Override
    public CompletableFuture<Response<OrderBook>> getOrderBook(String market, Integer limit, Integer precision) {
        CompletableFuture<Response<OrderBook>> future = new CompletableFuture<>();
        bitmartApiService.getOrderBook(market, limit, precision).enqueue(new RetrofitCallbackAdapter<>(future));
        return future;
    }
}
