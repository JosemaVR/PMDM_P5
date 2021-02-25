package es.studium.filmingapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SeriesActivity extends AppCompatActivity {

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

        Bundle bundle = intent.getExtras();
        if(bundle != null){
            titulo.setText(bundle.getString("Titulo"));
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
    }
}