package es.studium.filmingapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Zoom extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_zoom);

        ImageView caratula = findViewById(R.id.imagenZoom);
        caratula.setOnClickListener(this);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if(bundle != null){
            caratula.setImageResource(bundle.getInt("Caratula"));
        }
    }

    @Override
    public void onClick(View v) {
        finish();
    }
}