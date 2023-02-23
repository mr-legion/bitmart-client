package io.algostrategy.client.bitmart;

import io.algostrategy.client.bitmart.domain.Response;
import io.algostrategy.client.bitmart.domain.general.Asset;
import io.algostrategy.client.bitmart.domain.general.AssetResponse;

import java.util.List;
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

}