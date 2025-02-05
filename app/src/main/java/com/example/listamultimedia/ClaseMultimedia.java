package com.example.listamultimedia;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.VideoView;

public class ClaseMultimedia implements Parcelable {
    private String titulo;
    private String path;
    private String tipo;

    public ClaseMultimedia(String titulo, String url, String tipo) {
        this.titulo = titulo;
        this.path = url;
        this.tipo = tipo;
    }

    // Parcelable implementation
    protected ClaseMultimedia(Parcel in) {
        titulo = in.readString();
        path = in.readString();
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
        dest.writeString(path);
        dest.writeString(tipo);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
