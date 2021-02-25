package es.studium.filmingapp;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PeliculasViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    ImageView caratula;
    TextView titulo;
    RatingBar estrellas;
    RecyclerViewOnItemClickListener listener;

    @SuppressLint("ClickableViewAccessibility")
    public PeliculasViewHolder(@NonNull View itemView, RecyclerViewOnItemClickListener listener) {
        super(itemView);
        caratula = (ImageView)  itemView.findViewById(R.id.caratula);
        titulo = itemView.findViewById(R.id.titulo);
        estrellas = itemView.findViewById(R.id.estrellas);

        titulo.setOnClickListener(this);
        caratula.setOnClickListener(this);
        estrellas.setOnClickListener(this);

        this.listener = listener;
    }

    public void bindRow(Peliculas pelicula){
        titulo.setText(pelicula.getTitulo());
        Double num = pelicula.getClasificacion()/2;
        estrellas.setRating(Float.parseFloat(num.toString()));
        caratula.setImageResource(pelicula.getCaratula());
    }

    @Override
    public void onClick(View v) {
        listener.onClick(v, getAdapterPosition());
    }
}