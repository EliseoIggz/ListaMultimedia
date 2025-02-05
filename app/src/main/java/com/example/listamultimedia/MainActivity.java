package com.example.listamultimedia;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView RVM;
    private CMAdapter CMAdapter;
    private ArrayList<ClaseMultimedia> listaMultimedia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        RVM = findViewById(R.id.RVMulti);
        RVM.setLayoutManager(new LinearLayoutManager(this));
        RVM.setHasFixedSize(true);

        listaMultimedia = new ArrayList<>();
        listaMultimedia.add(new ClaseMultimedia("Video 1", "oceano1", "V"));
        listaMultimedia.add(new ClaseMultimedia("Video 2", "oceano2", "V"));
        listaMultimedia.add(new ClaseMultimedia("Audio 1", "url", "A"));
        listaMultimedia.add(new ClaseMultimedia("Audio 2", "url", "A"));
        listaMultimedia.add(new ClaseMultimedia("Web 1", "url", "W"));
        listaMultimedia.add(new ClaseMultimedia("Web 2", "url", "W"));

        CMAdapter = new CMAdapter(listaMultimedia);
        RVM.setAdapter(CMAdapter);

        CMAdapter.setOnItemClickListener(position -> {
            DialogFragment dialogFragment = new Dialogo();
            dialogFragment.show(getSupportFragmentManager(), "Dialogo tarea");
        });
    }
}