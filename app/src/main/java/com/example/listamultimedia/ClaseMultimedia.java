package com.example.listamultimedia;

import android.widget.VideoView;

public class ClaseMultimedia {
    private String titulo;
    private String url;
    private String tipo;

    public ClaseMultimedia(String titulo, String url, String tipo) {
        this.titulo = titulo;
        this.url = url;
        this.tipo = tipo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

//    public  abrirRecurso(){
//        if(tipo == "V"){
//            VideoView videoView = findViewById(R.id.videoView);
//
//        } else if (tipo == "A") {
//
//        } else {
//
//        }
//    }


}
