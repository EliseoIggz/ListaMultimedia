package com.example.listamultimedia;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CMAdapter extends RecyclerView.Adapter<CMAdapter.ClaseMultimediaViewHolder> {

    private ArrayList<ClaseMultimedia> listaMultimedia;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public CMAdapter(ArrayList<ClaseMultimedia> listaDeberes) {
        this.listaMultimedia = listaDeberes;
    }

    @NonNull
    @Override
    public ClaseMultimediaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item, parent, false);
        return new ClaseMultimediaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ClaseMultimediaViewHolder holder, int position) {
        ClaseMultimedia archivoMultimedia = listaMultimedia.get(position);
        holder.tituloTV.setText(archivoMultimedia.getTitulo());
        holder.itemView.setOnClickListener(v -> {
            listener.onItemClick(position);
        });
    }

    @Override
    public int getItemCount() {
        return listaMultimedia.size();
    }

    public class ClaseMultimediaViewHolder extends RecyclerView.ViewHolder {
        TextView tituloTV;

        public ClaseMultimediaViewHolder(@NonNull View itemView) {
            super(itemView);
            tituloTV = itemView.findViewById(R.id.tituloItem);
        }
    }
}
