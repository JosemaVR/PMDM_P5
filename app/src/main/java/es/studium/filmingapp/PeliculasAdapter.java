package es.studium.filmingapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PeliculasAdapter extends RecyclerView.Adapter<PeliculasViewHolder> {

    private List<Peliculas> peliculas;
    final RecyclerViewOnItemClickListener recyclerViewOnItemClickListener;

    public PeliculasAdapter(List<Peliculas> peliculas, RecyclerViewOnItemClickListener recyclerViewOnItemClickListener){
        this.peliculas = peliculas;
        this.recyclerViewOnItemClickListener = recyclerViewOnItemClickListener;
    }

    @NonNull
    @Override
    public PeliculasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_peliculas, parent, false);
        return new PeliculasViewHolder(row, recyclerViewOnItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull PeliculasViewHolder holder, int position) {
        holder.bindRow(peliculas.get(position));
    }

    @Override
    public int getItemCount() {
        return peliculas.size();
    }
}
