package io.algostrategy.client.bitmart;

import io.algostrategy.client.bitmart.impl.BitmartApiAsyncRestClientImpl;
import io.algostrategy.client.bitmart.impl.BitmartApiRestClientImpl;
import io.algostrategy.client.bitmart.impl.BitmartApiService;
import io.algostrategy.client.bitmart.impl.BitmartApiServiceGenerator;
import okhttp3.OkHttpClient;

/**
 * A factory for creating Bitmart API client objects.
 */
public class BitmartApiClientFactory {

    private final BitmartApiServiceGenerator serviceGenerator;

    public BitmartApiClientFactory() {
        this.serviceGenerator = new BitmartApiServiceGenerator(new OkHttpClient());
    }

    public BitmartApiClientFactory(ApiInteractionConfig apiInteractionConfig) {
        this(new OkHttpClient(), apiInteractionConfig);
    }

    public BitmartApiClientFactory(OkHttpClient client, ApiInteractionConfig apiInteractionConfig) {
        OkHttpClient newClient = client.newBuilder()
                .proxySelector(new CustomProxySelector(apiInteractionConfig.getProxies()))
                .addInterceptor(new RateLimitInterceptor(
                        apiInteractionConfig.getMaxRequestsPerSecond(),
                        apiInteractionConfig.getMaxApiKeyUsagePerSecond()
                )).build();
        this.serviceGenerator = new BitmartApiServiceGenerator(newClient);
    }

    /**
     * New instance without authentication.
     *
     * @return the Bitmart API client factory
     */
    public static BitmartApiClientFactory newInstance() {
        return new BitmartApiClientFactory();
    }

    /**
     * Creates a new synchronous/blocking REST client.
     */
    public BitmartApiRestClient newRestClient() {
        return new BitmartApiRestClientImpl(serviceGenerator.createService(BitmartApiService.class));
    }

    /**
     * Creates a new asynchronous/non-blocking REST client.
     */
    public BitmartApiAsyncRestClient newAsyncRestClient() {
        return new BitmartApiAsyncRestClientImpl(serviceGenerator.createService(BitmartApiService.class));
    }
}
