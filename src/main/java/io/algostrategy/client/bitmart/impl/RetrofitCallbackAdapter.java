package io.algostrategy.client.bitmart.impl;

import io.algostrategy.client.bitmart.BitmartApiError;
import io.algostrategy.client.bitmart.exception.BitmartApiException;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

/**
 * An adapter/wrapper that transform a response to the {@link CompletableFuture}.
 */
public class RetrofitCallbackAdapter<T> implements Callback<T> {

    private final CompletableFuture<T> future;

    public RetrofitCallbackAdapter(CompletableFuture<T> future) {
        this.future = future;
    }

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        if (response.isSuccessful()) {
            future.complete(response.body());
        } else {
            try {
                BitmartApiError apiError = BitmartApiServiceGenerator.getBitmartApiError(response);
                onFailure(call, new BitmartApiException(apiError));
            } catch (IOException e) {
                onFailure(call, new BitmartApiException(e));
            }
        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        if (t instanceof BitmartApiException) {
            future.completeExceptionally(t);
        } else {
            future.completeExceptionally(new BitmartApiException(t));
        }
    }
}
