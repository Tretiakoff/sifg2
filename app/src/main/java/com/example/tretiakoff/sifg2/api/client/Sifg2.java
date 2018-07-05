package com.example.tretiakoff.sifg2.api.client;

import com.example.tretiakoff.sifg2.api.model.chat.ChatResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by tretiakoff on 04/07/2018.
 */
public interface Sifg2 {

    String BASE_URL = "https://www.sifg2.ml/api/";

    @GET("questions/{id}")
    Call<ChatResult> getQuestions(@Path(value = "id") Integer id);

    @GET("questions/start")
    Call<ChatResult> getFirstQuestion();
}