package io.algostrategy.client.bitmart.domain.market;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Market orderbook.
 */
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderBook {

    @JsonProperty("sells")
    private List<Order> asks;
    @JsonProperty("buys")
    private List<Order> bids;

    private Long timestamp;
}
