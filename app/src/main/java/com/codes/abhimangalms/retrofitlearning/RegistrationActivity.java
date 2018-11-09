package com.codes.abhimangalms.retrofitlearning;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        mEditTextName = (EditText) findViewById(R.id.editTextName);
        mEditTextUsername = (EditText) findViewById(R.id.editTextUsername);
        mEditTextPassword = (EditText) findViewById(R.id.editTextPassword);
        mEditTextEmail = (EditText) findViewById(R.id.editTextEmail);

        mButonRegister = findViewById(R.id.buttonRegister);

        mButonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertUser(); //method to insert data into database
            }
        });

    }

    private void insertUser() {

        String inputName = mEditTextName.getText().toString();
        String inputUsername = mEditTextUsername.getText().toString();
        String inputPassword = mEditTextPassword.getText().toString();
        String inputEmail = mEditTextEmail.getText().toString();

        //code to insert data into the database

        //creating Retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL_POST)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);

        Call<Hero> heroCall = api.insertUser(inputName, inputUsername, inputPassword, inputEmail); //creating object for call

        heroCall.enqueue(new Callback<Hero>() { //calling api

            @Override
            public void onResponse(Call<Hero> call, Response<Hero> response) {

                Toast.makeText(RegistrationActivity.this, "registered", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Hero> call, Throwable t) {

                Toast.makeText(RegistrationActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void onClick(View v) {

        insertUser();

    }
}
