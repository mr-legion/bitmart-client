package io.algostrategy.client.bitmart.domain.market;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Market ticker information.
 */
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MarketTicker {

    private String symbol;

    @JsonProperty("open_24h")
    private Double open;
    @JsonProperty("close_24h")
    private Double close;

    @JsonProperty("low_24h")
    private Double low;
    @JsonProperty("high_24h")
    private Double high;

    @JsonProperty("last_price")
    private Double lastPrice;

    @JsonProperty("best_ask")
    private Double ask;
    @JsonProperty("best_ask_size")
    private Double askSize;

    @JsonProperty("best_bid")
    private Double bid;
    @JsonProperty("best_bid_size")
    private Double bidSize;

    @JsonProperty("base_volume_24h")
    private Double baseVolume;
    @JsonProperty("quote_volume_24h")
    private Double quoteVolume;

    private Double fluctuation;

    private String url;

    private Long timestamp;
}
