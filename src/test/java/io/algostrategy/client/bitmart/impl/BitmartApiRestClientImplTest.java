package io.algostrategy.client.bitmart.impl;

import io.algostrategy.client.bitmart.BitmartApiClientFactory;
import io.algostrategy.client.bitmart.BitmartApiRestClient;
import io.algostrategy.client.bitmart.domain.Response;
import io.algostrategy.client.bitmart.domain.general.AssetResponse;
import io.algostrategy.client.bitmart.domain.market.MarketInfoResponse;
import io.algostrategy.client.bitmart.domain.market.MarketTickerResponse;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BitmartApiRestClientImplTest {

    private final BitmartApiRestClient bitmartApiRestClient = BitmartApiClientFactory.newInstance().newRestClient();

    @Test
    public void getAssets_ShouldReturnAssets() {
        Response<AssetResponse> response = bitmartApiRestClient.getAssets();
        assertNotNull(response);
        assertNotNull(response.getData());
        assertThat(response.getData().getAssets(), is(not(empty())));
    }

    @Test
    public void getMarketInfo_ShouldReturnMarketInfo() {
        Response<MarketInfoResponse> response = bitmartApiRestClient.getMarketInfo();
        assertNotNull(response);
        assertNotNull(response.getData());
        assertThat(response.getData().getMarkets(), is(not(empty())));
    }

    @Test
    public void getMarketTickers_ShouldReturnMarketTickers() {
        Response<MarketTickerResponse> response = bitmartApiRestClient.getMarketTickers();
        assertNotNull(response);
        assertNotNull(response.getData());
        assertThat(response.getData().getTickers(), is(not(empty())));
    }
}