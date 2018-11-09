package com.codes.abhimangalms.retrofitlearning;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Api {

    String BASE_URL_GET = "https://simplifiedcoding.net/demos/";

    String BASE_URL_POST = "http://192.168.1.15/";

    @GET("marvel")
    Call<List<Hero>> getHeroes();


    @FormUrlEncoded
    @POST("retrofit_users/insert.php")
    Call<Hero> insertUser(
            @Field("name") String name,
            @Field("username") String username,
            @Field("password") String password,
            @Field("email") String email);

}

