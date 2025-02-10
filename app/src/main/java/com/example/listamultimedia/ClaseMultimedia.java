package com.example.listamultimedia;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.VideoView;

public class ClaseMultimedia implements Parcelable {
    private String titulo;
    private String recurso;
    private String tipo;

    public ClaseMultimedia(String titulo, String recurso, String tipo) {
        this.titulo = titulo;
        this.recurso = recurso;
        this.tipo = tipo;
    }

    // Parcelable implementation
    protected ClaseMultimedia(Parcel in) {
        titulo = in.readString();
        recurso = in.readString();
        tipo = in.readString();
    }

    public static final Creator<ClaseMultimedia> CREATOR = new Creator<ClaseMultimedia>() {
        @Override
        public ClaseMultimedia createFromParcel(Parcel in) {
            return new ClaseMultimedia(in);
        }

        @Override
        public ClaseMultimedia[] newArray(int size) {
            return new ClaseMultimedia[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(titulo);
        dest.writeString(recurso);
        dest.writeString(tipo);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getRecurso() {
        return recurso;
    }

    public void setRecurso(String recurso) {
        this.recurso = recurso;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
