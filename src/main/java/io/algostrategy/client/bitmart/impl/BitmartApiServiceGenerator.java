package io.algostrategy.client.bitmart.impl;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.algostrategy.client.bitmart.BitmartApiError;
import io.algostrategy.client.bitmart.exception.BitmartApiException;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;
import java.lang.annotation.Annotation;

import static io.algostrategy.client.bitmart.constant.BitmartApiConstants.API_BASE_URL;

/**
 * Generates a Bitmart API implementation based on @see {@link BitmartApiService}.
 */
public class BitmartApiServiceGenerator {

    private static final ObjectMapper mapper = new ObjectMapper();
    private static final Converter.Factory converterFactory = JacksonConverterFactory.create(mapper);
    @SuppressWarnings("unchecked")
    private static final Converter<ResponseBody, BitmartApiError> errorBodyConverter =
            (Converter<ResponseBody, BitmartApiError>) converterFactory.responseBodyConverter(
                    BitmartApiError.class, new Annotation[0], null);

    static {
        mapper.enable(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL);
    }

    private final OkHttpClient client;

    public BitmartApiServiceGenerator(OkHttpClient client) {
        this.client = client;
    }

    public <S> S createService(Class<S> serviceClass) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(converterFactory)
                .client(client)
                .build();

        return retrofit.create(serviceClass);
    }

    /**
     * Execute a REST call and block until the response is received.
     */
    public static <T> T executeSync(Call<T> call) {
        try {
            Response<T> response = call.execute();
            if (response.isSuccessful()) {
                return response.body();
            } else {
                BitmartApiError apiError = getBitmartApiError(response);
                throw new BitmartApiException(apiError);
            }
        } catch (IOException e) {
            throw new BitmartApiException(e);
        }
    }

    /**
     * Extracts and converts the response error body into an object.
     */
    public static BitmartApiError getBitmartApiError(Response<?> response) throws IOException, BitmartApiException {
        return errorBodyConverter.convert(response.errorBody());
    }
}
