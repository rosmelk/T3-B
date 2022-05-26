package com.example.t3examen.factories;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Retrofactory {

    public static Retrofit build(){

        return new Retrofit.Builder()
                .baseUrl("https://628f371bdc478523653bc250.mockapi.io/api/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
