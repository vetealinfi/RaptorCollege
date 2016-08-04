package com.codebake.raptor.raptorcollege;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.codebake.raptor.raptorcollege.ui.ColegiosFragment;

public class ResultadoColegiosActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_colegios);

        getSupportFragmentManager().beginTransaction().add(R.id.frameLayoutId,new ColegiosFragment()).commit();



    }
}
