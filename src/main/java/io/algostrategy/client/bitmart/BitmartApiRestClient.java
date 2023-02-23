package io.algostrategy.client.bitmart;

import io.algostrategy.client.bitmart.domain.Response;
import io.algostrategy.client.bitmart.domain.general.AssetResponse;
import io.algostrategy.client.bitmart.domain.market.MarketInfoResponse;
import io.algostrategy.client.bitmart.domain.market.MarketTickerResponse;
import io.algostrategy.client.bitmart.domain.market.OrderBook;

/**
 * Bitmart API facade, supporting synchronous/blocking access Binance's REST API.
 */
public interface BitmartApiRestClient {

    // General endpoints

    /**
     * Get all supported assets.
     *
     * @return assets
     */
    Response<AssetResponse> getAssets();

    // Market endpoints

    /**
     * Get all supported markets.
     *
     * @return market info
     */
    Response<MarketInfoResponse> getMarketInfo();

    /**
     * Get market ticker information.
     *
     * @return market tickers
     */
    Response<MarketTickerResponse> getMarketTickers();

    /**
     * Get orderbook for the market.
     *
     * @param market    market symbol (e.g. BTC_USDT)
     * @param limit     depth of the order book. The value can be transmitted [1-50].
     * @param precision price precision, the range is defined in trading pair details.
     * @return orderbook
     */
    Response<OrderBook> getOrderBook(String market, Integer limit, Integer precision);
}