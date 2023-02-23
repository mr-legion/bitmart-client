package io.algostrategy.client.bitmart.impl;

import io.algostrategy.client.bitmart.BitmartApiRestClient;
import io.algostrategy.client.bitmart.domain.Response;
import io.algostrategy.client.bitmart.domain.general.AssetResponse;
import io.algostrategy.client.bitmart.domain.market.MarketInfoResponse;
import io.algostrategy.client.bitmart.domain.market.MarketTickerResponse;
import io.algostrategy.client.bitmart.domain.market.OrderBook;

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

    // Market endpoints

    @Override
    public Response<MarketInfoResponse> getMarketInfo() {
        return BitmartApiServiceGenerator.executeSync(bitmartApiService.getMarketInfo());
    }

    @Override
    public Response<MarketTickerResponse> getMarketTickers() {
        return BitmartApiServiceGenerator.executeSync(bitmartApiService.getMarketTickers());
    }

    @Override
    public Response<OrderBook> getOrderBook(String market, Integer limit, Integer precision) {
        return BitmartApiServiceGenerator.executeSync(bitmartApiService.getOrderBook(market, limit, precision));
    }
}
