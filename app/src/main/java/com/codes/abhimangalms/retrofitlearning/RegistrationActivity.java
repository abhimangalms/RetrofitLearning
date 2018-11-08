package com.codes.abhimangalms.retrofitlearning;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegistrationActivity extends AppCompatActivity implements View.OnClickListener {

    EditText mEditTextName;
    EditText mEditTextUsername;
    EditText mEditTextPassword;
    EditText mEditTextEmail;

    Button mButonRegister;

    public static final String ROOT_URL = "http://192.168.1.15";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        mEditTextName = (EditText) findViewById(R.id.editTextName);
        mEditTextUsername = (EditText) findViewById(R.id.editTextUsername);
        mEditTextPassword = (EditText) findViewById(R.id.editTextPassword);
        mEditTextEmail = (EditText) findViewById(R.id.editTextEmail);

        mButonRegister = findViewById(R.id.buttonRegister);

    }

    private void insertUser(){

        //code to insert data into the database

        //creating Retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);

        api.insertUser(

                mEditTextName.getText().toString(),
                mEditTextUsername.getText().toString(),
                mEditTextPassword.getText().toString(),
                mEditTextEmail.getText().toString(),

                //creating a callback
                new Callback<Response>() {
                    @Override
                    public void onResponse(Call<Response> call, Response<Response> response) {
                        
                    }

                    @Override
                    public void onFailure(Call<Response> call, Throwable t) {

                    }
                }
        );



    }

    @Override
    public void onClick(View v) {

    }
}
