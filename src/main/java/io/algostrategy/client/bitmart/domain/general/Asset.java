package io.algostrategy.client.bitmart.domain.general;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Asset information.
 */
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Asset {

    @JsonProperty("id")
    private String symbol;

    private String name;

    @JsonProperty("deposit_enabled")
    private Boolean depositEnabled;

    @JsonProperty("withdraw_enabled")
    private Boolean withdrawEnabled;
}