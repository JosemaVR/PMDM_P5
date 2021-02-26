package es.studium.filmingapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class SeriesActivity extends AppCompatActivity implements View.OnClickListener {

    Integer idImagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_series);
        ImageView caratula = (ImageView) findViewById(R.id.caratulaSerie);
        TextView titulo = (TextView) findViewById(R.id.tituloSerie);
        RatingBar clasificacion = (RatingBar) findViewById(R.id.clasificacionSerie);
        TextView director = (TextView) findViewById(R.id.directorSerie);
        TextView reparto = (TextView) findViewById(R.id.repartoSerie);
        TextView sinopsis = (TextView) findViewById(R.id.sinopsisSerie);
        TextView temporadas = (TextView) findViewById(R.id.temporadasSerie);
        Intent intent = getIntent();
        caratula.setOnClickListener(this);
        Bundle bundle = intent.getExtras();
        if(bundle != null){
            titulo.setText(bundle.getString("Titulo"));
            idImagen = bundle.getInt("Caratula");
            caratula.setImageResource(bundle.getInt("Caratula"));
            Double num = bundle.getDouble("Puntos")/2;
            clasificacion.setRating(Float.parseFloat(num.toString()));
            director.setText("Director: ");
            director.append(bundle.getString("Director"));
            reparto.setText("Reparto: ");
            reparto.append(bundle.getString("Reparto"));
            sinopsis.setText("Sinopsis: ");
            sinopsis.append(bundle.getString("Sinopsis"));
            temporadas.setText("Nº de temporadas: ");
            temporadas.append(bundle.getInt("Temporadas")+"");
        }
        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar_series);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent = new Intent(SeriesActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("Fragment", "series");
                startActivity(intent);
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onClick(View v) {
        Intent zoom = new Intent(SeriesActivity.this, Zoom.class);
        zoom.putExtra("Caratula", idImagen);
        SeriesActivity.this.startActivity(zoom);
    }
}