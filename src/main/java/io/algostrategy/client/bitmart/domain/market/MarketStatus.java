package io.algostrategy.client.bitmart.domain.market;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Market status.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public enum MarketStatus {
    /**
     * Is trading.
     */
    @JsonProperty("trading")
    TRADING,

    /**
     * Pre-open.
     */
    @JsonProperty("pre-trade")
    PRE_TRADE,
}
