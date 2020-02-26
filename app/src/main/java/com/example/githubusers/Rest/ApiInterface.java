package com.example.githubusers.Rest;

import com.example.githubusers.Model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("/users")
    Call<List<User>> getUsers();
}
