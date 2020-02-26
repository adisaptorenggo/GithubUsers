package com.example.githubusers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.githubusers.Adapter.AdapterUsers;
import com.example.githubusers.Model.User;
import com.example.githubusers.Rest.ApiClient;
import com.example.githubusers.Rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ApiInterface mApiInterface;
    private EditText mEditTextSearch;
    private Button mButtonSeach;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    public static MainActivity ma;
    List<User> UsersList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEditTextSearch = findViewById(R.id.etSearch);
        mButtonSeach = findViewById(R.id.btSearch);
        mRecyclerView = findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        ma=this;
        refresh();
        mButtonSeach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditTextSearch.getText();
            }
        });
    }

    public void refresh() {
        Call<List<User>> mCall;
        mCall = mApiInterface.getUsers();
        mCall.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {

                if (response.isSuccessful()) {
                    UsersList = response.body();
                    Log.d("Retrofit Get", response.toString());
                    mAdapter = new AdapterUsers(UsersList);
                    mRecyclerView.setAdapter(mAdapter);
                } else {
                    Toast.makeText(getApplication(), "No conexion", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Log.e("Retrofit Get", t.toString());
            }
        });
    }
}


