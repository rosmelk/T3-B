package com.example.t3examen.services;
import com.example.t3examen.entities.Pokemon;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface PokemonService {

    @GET("pokemon")
    Call<List<Pokemon>> getPokemon();

    @POST("pokemon")
    Call<Pokemon> create(@Body Pokemon pokemon);


}
