package com.example.t3examen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.t3examen.entities.Pokemon;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

public class InfoPokemon extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_pokemon);

        ImageView imagen = findViewById(R.id.tvIma);
        TextView codigo = findViewById(R.id.txCodigo);
        TextView numero = findViewById(R.id.txNumero);
        TextView nombre = findViewById(R.id.txNombre);
        TextView region = findViewById(R.id.txRegion);


        Intent intent = getIntent();
        String pokemon = intent.getStringExtra("poke");
        Pokemon pokem = new Gson().fromJson(pokemon,Pokemon.class);
        Picasso.get().load(pokem.getImagen()).into(imagen);
        codigo.setText(pokem.getTipo());
        numero.setText(pokem.getNumero());
        nombre.setText(pokem.getNombre());
        region.setText(pokem.getRegion());



    }
}