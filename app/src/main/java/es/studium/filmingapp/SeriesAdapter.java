package es.studium.filmingapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SeriesAdapter extends RecyclerView.Adapter<SeriesViewHolder> {

    private List<Series> series;
    final RecyclerViewOnItemClickListener recyclerViewOnItemClickListener;

    public SeriesAdapter(List<Series> series, RecyclerViewOnItemClickListener recyclerViewOnItemClickListener){
        this.series = series;
        this.recyclerViewOnItemClickListener = recyclerViewOnItemClickListener;
    }

    @NonNull
    @Override
    public SeriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_series, parent, false);
        return new SeriesViewHolder(row, recyclerViewOnItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull SeriesViewHolder holder, int position) {
        holder.bindRow(series.get(position));
    }

    @Override
    public int getItemCount() {
        return series.size();
    }
}
