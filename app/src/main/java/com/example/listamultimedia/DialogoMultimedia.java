package com.example.listamultimedia;

import android.app.Dialog;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import org.jetbrains.annotations.Nullable;

public class DialogoMultimedia extends DialogFragment {
    private ClaseMultimedia itemSeleccionado;
    private MediaPlayer mediaPlayer;

    public static DialogoMultimedia newInstance(ClaseMultimedia item) {
        DialogoMultimedia fragment = new DialogoMultimedia();
        Bundle args = new Bundle();
        args.putParcelable("itemSeleccionado", item);
        fragment.setArguments(args);
        return fragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        itemSeleccionado = getArguments().getParcelable("itemSeleccionado");

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialogo_multimedia, null);
        builder.setView(view);

        if (itemSeleccionado != null) {
            String tipo = itemSeleccionado.getTipo();
            String recurso = itemSeleccionado.getRecurso();

            VideoView videoView = view.findViewById(R.id.videoView);
            WebView webView = view.findViewById(R.id.webView);
            Button playB = view.findViewById(R.id.playBtn);
            Button pauseB = view.findViewById(R.id.pauseBtn);
            Button stopB = view.findViewById(R.id.stopBtn);

            playB.setVisibility(View.INVISIBLE);
            pauseB.setVisibility(View.INVISIBLE);
            stopB.setVisibility(View.INVISIBLE);
            videoView.setVisibility(View.INVISIBLE);
            webView.setVisibility(View.INVISIBLE);

            //Log.d("DialogoMultimedia", "HOLA BUEBNAS");
            playB.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!mediaPlayer.isPlaying()) {
                        mediaPlayer.start();
                    }
                }
            });

            pauseB.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mediaPlayer.isPlaying()) {
                        mediaPlayer.pause();
                    }
                }
            });

            stopB.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mediaPlayer.isPlaying()) {
                        mediaPlayer.stop();
                        mediaPlayer.prepareAsync(); // Volver a prepararlo
                    }
                }
            });

            if (tipo.equals("V")) {
                videoView.setVisibility(View.VISIBLE);
                //Log.d("DialogoMultimedia","android.resource://" + getContext().getPackageName() + "/" + recurso);
                videoView.setVideoPath("android.resource://" + getContext().getPackageName() + "/" + recurso);
                videoView.start();
            } else if (tipo.equals("A")) {
                playB.setVisibility(View.VISIBLE);
                pauseB.setVisibility(View.VISIBLE);
                stopB.setVisibility(View.VISIBLE);
                Uri uri = Uri.parse("android.resource://" + getContext().getPackageName() + "/" + recurso);
                //Log.d("DialogoMultimedia","android.resource://" + getContext().getPackageName() + "/" + recurso);
                mediaPlayer = MediaPlayer.create(getActivity(), uri);
                mediaPlayer.start();
            } else if (tipo.equals("W")) {
                webView.setVisibility(View.VISIBLE);
                webView.getSettings().setJavaScriptEnabled(true);
                webView.setWebViewClient(new WebViewClient());
                webView.setWebChromeClient(new WebChromeClient());
                webView.loadUrl(recurso);
            }
        }

        builder.setNegativeButton("Cerrar", (dialog, which) -> {
            if (mediaPlayer != null) {
                mediaPlayer.stop();
                mediaPlayer.release();
            }
            dialog.dismiss();
        });

        return builder.create();
    }
}
