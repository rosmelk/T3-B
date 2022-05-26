package com.example.t3examen.adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.t3examen.InfoPokemon;
import com.example.t3examen.R;
import com.example.t3examen.entities.Pokemon;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PokemonAdapters extends RecyclerView.Adapter<PokemonAdapters.ViewHolderPokemon>   implements View.OnClickListener{

    List<Pokemon> pokemon;
    private  View.OnClickListener listener;
    public PokemonAdapters(List<Pokemon> pokemon) {
        this.pokemon = pokemon;
    }




    @NonNull
    @Override
    public PokemonAdapters.ViewHolderPokemon onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pokemon,parent,false);
        view.setOnClickListener(this.listener);
        return new ViewHolderPokemon(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderPokemon vh, int position) {

        View itemView =vh.itemView;
        Pokemon poke = pokemon.get(position);
        ImageView tvImagen = itemView.findViewById(R.id.tvImagen);
        TextView txtNombre = itemView.findViewById(R.id.tvNombre);
        TextView txtCodigo = itemView.findViewById(R.id.tvCodigo);

        Picasso.get().load(poke.imagen).into(tvImagen);
        txtNombre.setText(poke.nombre);
        txtCodigo.setText(poke.codigo);


    }

    @Override
    public int getItemCount() {
        return pokemon.size();
    }

    public void setOnclickListener(View.OnClickListener listener){
        this.listener = listener;
    }

    @Override
    public void onClick(View v) {

    }

    public class ViewHolderPokemon extends RecyclerView.ViewHolder {
        public ViewHolderPokemon(@NonNull View itemView) {
            super(itemView);
        }
    }
}
