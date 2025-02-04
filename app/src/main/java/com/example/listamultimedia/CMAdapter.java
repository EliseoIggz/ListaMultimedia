package com.example.listamultimedia;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
        holder.titulo.setText(deber.getTitulo());
        holder.descripcion.setText(deber.getDescripcion());
        holder.asignatura.setText(deber.getAsignatura());
        holder.fecha.setText(deber.getFecha());
        holder.hora.setText(deber.getHora());
        holder.estado.setText(deber.getEstado());

        holder.itemView.setOnClickListener(v -> {
            listener.onItemClick(position);
        });
    }
}
