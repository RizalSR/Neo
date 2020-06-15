package com.example.neo.Retrofit;


import com.example.neo.Model.LoginRequest;
import com.example.neo.Model.LoginResponse;
import com.example.neo.Model.UserDetailsResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

/**
 * Created by Thio Van on 12/12/2017.
 */

public interface APIService {

    @POST("login")
    Call<LoginResponse> loginRequest (
            @Header("Accept") String accept,
            @Header("Content-Type") String contentType,
            @Body LoginRequest login);

    @GET("user")
    Call<UserDetailsResponse> userDetailsRequest(
            @Header("Accept") String accept,
            @Header("Content-Type") String content_Type,
            @QueryMap HashMap<String,String> accestoken
    );
}

