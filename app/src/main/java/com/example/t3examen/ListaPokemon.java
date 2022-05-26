package com.example.t3examen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.t3examen.adapters.PokemonAdapters;
import com.example.t3examen.entities.Pokemon;
import com.example.t3examen.factories.Retrofactory;
import com.example.t3examen.services.PokemonService;
import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ListaPokemon extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pokemon);

        Retrofit retrofit = Retrofactory.build();
        PokemonService service = retrofit.create(PokemonService.class);
        Call<List<Pokemon>> call = service.getPokemon ();
        call.enqueue(new Callback<List<Pokemon>>() {
            @Override
            public void onResponse(Call<List<Pokemon>> call, Response<List<Pokemon>> response) {
                List<Pokemon> pokemon = response.body();
                RecyclerView rv = findViewById(R.id.rvList);
                rv.setLayoutManager(new LinearLayoutManager(ListaPokemon.this));
                PokemonAdapters adapters =new PokemonAdapters(pokemon);
                adapters.setOnclickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(v.getContext(),InfoPokemon.class);
                        String pokemons = new Gson().toJson(pokemon.get(rv.getChildAdapterPosition(v)));

                        intent.putExtra("poke", pokemons);
                        startActivity(intent);


                    }
                });

                rv.setAdapter(adapters);

            }

            @Override
            public void onFailure(Call<List<Pokemon>> call, Throwable t) {

            }
        });
    }
}