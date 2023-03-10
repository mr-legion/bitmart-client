package io.algostrategy.client.bitmart;

import io.algostrategy.client.bitmart.domain.Response;
import io.algostrategy.client.bitmart.domain.general.AssetResponse;
import io.algostrategy.client.bitmart.domain.market.MarketInfoResponse;
import io.algostrategy.client.bitmart.domain.market.MarketTickerResponse;
import io.algostrategy.client.bitmart.domain.market.OrderBook;

import java.util.concurrent.CompletableFuture;

/**
 * Bitmart API facade, supporting asynchronous/non-blocking access Binance's REST API.
 */
public interface BitmartApiAsyncRestClient {

    // General endpoints

    /**
     * Get all supported assets (asynchronous).
     *
     * @return assets
     */
    CompletableFuture<Response<AssetResponse>> getAssets();

    // Market endpoints

    /**
     * Get all supported markets (asynchronous).
     *
     * @return market info
     */
    CompletableFuture<Response<MarketInfoResponse>> getMarketInfo();

    /**
     * Get market ticker information (asynchronous).
     *
     * @return market tickers
     */
    CompletableFuture<Response<MarketTickerResponse>> getMarketTickers();

    /**
     * Get orderbook for the market (asynchronous).
     *
     * @param market    market symbol (e.g. BTC_USDT)
     * @param limit     depth of the order book. The value can be transmitted [1-50].
     * @param precision price precision, the range is defined in trading pair details.
     * @return orderbook
     */
    CompletableFuture<Response<OrderBook>> getOrderBook(String market, Integer limit, Integer precision);
}