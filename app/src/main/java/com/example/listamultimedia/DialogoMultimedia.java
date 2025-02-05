package com.example.listamultimedia;

import android.app.Dialog;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebView;
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
            String url = itemSeleccionado.getPath();

            VideoView videoView = view.findViewById(R.id.videoView);
            WebView webView = view.findViewById(R.id.webView);

            if (tipo.equals("V")) {
                videoView.setVisibility(View.VISIBLE);
                videoView.setVideoPath("android.resource.raw://" + url);
                videoView.start();
            } else if (tipo.equals("A")) {
                Uri uri = Uri.parse("android.resource://" + requireContext().getPackageName() + "/raw/" + url);
                mediaPlayer = MediaPlayer.create(getActivity(), uri);
                mediaPlayer.start();
            } else if (tipo.equals("W")) {
                webView.setVisibility(View.VISIBLE);
                webView.loadUrl(url);
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
