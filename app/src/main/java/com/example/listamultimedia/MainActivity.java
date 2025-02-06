package com.example.listamultimedia;

import android.app.AlertDialog;
import android.os.Bundle;
import android.util.Log;

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
        listaMultimedia.add(new ClaseMultimedia("Video 1", R.raw.oceano1, "V"));
        listaMultimedia.add(new ClaseMultimedia("Video 2", R.raw.oceano2, "V"));
        listaMultimedia.add(new ClaseMultimedia("Audio 1", R.raw.oceano1, "A"));
        listaMultimedia.add(new ClaseMultimedia("Audio 2", R.raw.oceano2, "A"));
        //listaMultimedia.add(new ClaseMultimedia("Web 1", "url", "W"));
        //listaMultimedia.add(new ClaseMultimedia("Web 2", "url", "W"));

        CMAdapter = new CMAdapter(listaMultimedia);
        RVM.setAdapter(CMAdapter);

        CMAdapter.setOnItemClickListener(position -> {
            if(listaMultimedia.get(position).getTipo().equals("V")) {
                ClaseMultimedia item = listaMultimedia.get(position);
                DialogFragment dialogFragment = DialogoMultimedia.newInstance(item);
                dialogFragment.show(getSupportFragmentManager(), "DialogoMultimedia");
            }
        });
    }
}