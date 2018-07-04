package com.example.tretiakoff.sifg2.api.client;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by tretiakoff on 04/07/2018.
 */

public class Client {

    public static Sifg2 getClient() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Sifg2.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(Sifg2.class);
    }
}
