package com.losdistribuidos.turestaurante;

import com.losdistribuidos.turestaurante.models.ServerRequest;
import com.losdistribuidos.turestaurante.models.ServerResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RequestInterface {

    @POST("Restaurant/")
    Call<ServerResponse> operation(@Body ServerRequest request);

}
