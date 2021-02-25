package es.studium.filmingapp;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SeriesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    ImageView caratula;
    TextView titulo;
    RatingBar estrellas;
    RecyclerViewOnItemClickListener listener;

    @SuppressLint("ClickableViewAccessibility")
    public SeriesViewHolder(@NonNull View itemView, RecyclerViewOnItemClickListener listener) {
        super(itemView);
        caratula = (ImageView)  itemView.findViewById(R.id.caratula);
        titulo = itemView.findViewById(R.id.titulo);
        estrellas = itemView.findViewById(R.id.estrellas);

        titulo.setOnClickListener(this);
        caratula.setOnClickListener(this);
        estrellas.setOnClickListener(this);

        this.listener = listener;
    }

    public void bindRow(Series serie){
        titulo.setText(serie.getTitulo());
        Double num = serie.getClasificacion()/2;
        estrellas.setRating(Float.parseFloat(num.toString()));
        caratula.setImageResource(serie.getCaratula());
    }

    @Override
    public void onClick(View v) {
        listener.onClick(v, getAdapterPosition());
    }
}