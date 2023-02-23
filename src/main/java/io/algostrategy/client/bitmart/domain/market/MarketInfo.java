package io.algostrategy.client.bitmart.domain.market;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Market information.
 */
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MarketInfo {

    @JsonProperty("symbol_id")
    private Integer id;

    private String symbol;

    @JsonProperty("base_currency")
    private String baseAsset;

    @JsonProperty("quote_currency")
    private String quoteAsset;

    @JsonProperty("quote_increment")
    private Double quoteIncrement;

    @JsonProperty("base_min_size")
    private Double baseMinSize;

    @JsonProperty("price_min_precision")
    private Double priceMinPrecision;

    @JsonProperty("price_max_precision")
    private Double priceMaxPrecision;

    @JsonProperty("expiration")
    private String expiration;

    @JsonProperty("min_buy_amount")
    private Double minBuyAmount;

    @JsonProperty("min_sell_amount")
    private Double minSellAmount;

    @JsonProperty("trade_status")
    private MarketStatus status;
}
