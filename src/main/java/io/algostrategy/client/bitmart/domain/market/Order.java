package io.algostrategy.client.bitmart.domain.market;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * An order.
 */
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Order {

    private Double price;

    @JsonProperty("amount")
    private Double quantity;

    private Double total;

    private Integer count;
}
