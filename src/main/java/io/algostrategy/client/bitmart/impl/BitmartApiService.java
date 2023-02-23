package io.algostrategy.client.bitmart.impl;

import io.algostrategy.client.bitmart.domain.Response;
import io.algostrategy.client.bitmart.domain.general.Asset;
import io.algostrategy.client.bitmart.domain.general.AssetResponse;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

/**
 * Bitmart's REST API URL mappings.
 */
public interface BitmartApiService {

    // General endpoints

    @GET("/spot/v1/currencies")
    Call<Response<AssetResponse>> getAssets();
}
