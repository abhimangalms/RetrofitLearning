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

    String BASE_URL = "https://simplifiedcoding.net/demos/";

    @GET("marvel")
    Call<List<Hero>> getHeroes();


//    @FormUrlEncoded
//    @POST("abcc")
//    Call<Hero> putdata(@Field("tid") String tripId,
//                       @Field("bid") String busNId);

    @FormUrlEncoded
    @POST("/retrofit_users/insert.php")
    public void insertUser(
            @Field("name") String name,
            @Field("username") String username,
            @Field("password") String password,
            @Field("email") String email,
            Callback<Response> callback);

}

