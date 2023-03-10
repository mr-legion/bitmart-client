package io.algostrategy.client.bitmart.impl;

import io.algostrategy.client.bitmart.domain.Response;
import io.algostrategy.client.bitmart.domain.general.AssetResponse;
import io.algostrategy.client.bitmart.domain.market.MarketInfoResponse;
import io.algostrategy.client.bitmart.domain.market.MarketTickerResponse;
import io.algostrategy.client.bitmart.domain.market.OrderBook;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Bitmart's REST API URL mappings.
 */
public interface BitmartApiService {

    // General endpoints

    @GET("/account/v1/currencies")
    Call<Response<AssetResponse>> getAssets();

    // Market endpoints

    @GET("/spot/v1/symbols/details")
    Call<Response<MarketInfoResponse>> getMarketInfo();

    @GET("/spot/v2/ticker")
    Call<Response<MarketTickerResponse>> getMarketTickers();

    @GET("/spot/v1/symbols/book")
    Call<Response<OrderBook>> getOrderBook(@Query("symbol") String market,
                                           @Query("size") Integer limit,
                                           @Query("precision") Integer precision);
}
