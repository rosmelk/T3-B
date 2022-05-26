package com.example.t3examen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.t3examen.factories.Retrofactory;
import com.example.t3examen.services.PokemonService;
import com.example.t3examen.entities.Pokemon;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class RegistrarPokemon extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_pokemon);

        EditText txtNumero = findViewById(R.id.txtNumero);
        EditText txtNombre = findViewById(R.id.txtNombre);
        Spinner  spTipo = findViewById(R.id.spTipo);
        EditText txtRegion = findViewById(R.id.txtRegion);
        Button btnCrear = findViewById(R.id.btnGuardar);

        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer numero = txtNumero.getInputType();
                String  nombre = txtNombre.getText().toString();
                String  region = txtRegion.getText().toString();

                Retrofit retrofit = Retrofactory.build();
                PokemonService service = retrofit.create(PokemonService.class);
                Pokemon pokemon =new Pokemon();

                pokemon.setNumero(numero);
                pokemon.setNombre(nombre);
                pokemon.setRegion(region);

                Call<Pokemon> call = service.create(pokemon);
                call.enqueue(new Callback<Pokemon>() {
                    @Override
                    public void onResponse(Call<Pokemon> call, Response<Pokemon> response) {
                        Log.e("APP", new Gson().toJson(response.body()));
                    }

                    @Override
                    public void onFailure(Call<Pokemon> call, Throwable t) {
                        Log.e("APP","Error");
                    }
                });


            }
        });




    }
}