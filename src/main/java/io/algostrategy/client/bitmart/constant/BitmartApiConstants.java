package io.algostrategy.client.bitmart.constant;

import lombok.experimental.UtilityClass;

/**
 * Constants used throughout Bitmart's API.
 */
@UtilityClass
public class BitmartApiConstants {

    /**
     * Base domain.
     */
    public static final String BASE_DOMAIN = "bitmart.com";

    /**
     * REST base URL.
     */
    public static final String BASE_URL = "https://www." + BASE_DOMAIN;

    /**
     * REST API base URL.
     */
    public static final String API_BASE_URL = "https://api-cloud." + BASE_DOMAIN;
}
