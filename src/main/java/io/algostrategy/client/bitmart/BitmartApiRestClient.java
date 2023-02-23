package io.algostrategy.client.bitmart;

import io.algostrategy.client.bitmart.domain.Response;
import io.algostrategy.client.bitmart.domain.general.Asset;
import io.algostrategy.client.bitmart.domain.general.AssetResponse;

import java.util.List;

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

}