package com.codes.abhimangalms.retrofitlearning;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    ListView mListView;
    String[] heroNames;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = (ListView) findViewById(R.id.listview);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL_GET)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class); //building api

        Call<List<Hero>> call = api.getHeroes(); // creating object for Call

        call.enqueue(new Callback<List<Hero>>() { //calling api

            @Override
            public void onResponse(Call<List<Hero>> call, Response<List<Hero>> response) {

                List<Hero> heroes = response.body();

                heroNames = new String[heroes.size()];

                for (int i =0; i<heroes.size(); i++){

                    heroNames[i] = heroes.get(i).getName();
                }

                mListView.setAdapter( //creating listview
                        new ArrayAdapter<String>(
                                getApplicationContext(),
                                android.R.layout.simple_list_item_1,
                                heroNames));

            }

            @Override
            public void onFailure(Call<List<Hero>> call, Throwable t) {

                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


//        Call<Hero> heroCall = api.putdata("tgrfdhfd", "khgjhf"); //creating object for call

//        heroCall.enqueue(new Callback<Hero>() { //calling api

//            @Override
//            public void onResponse(Call<Hero> call, Response<Hero> response) {

//            }

//            @Override
//            public void onFailure(Call<Hero> call, Throwable t) {

//            }
//        });





    }

}
