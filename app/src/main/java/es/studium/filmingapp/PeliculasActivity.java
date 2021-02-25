package es.studium.filmingapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import static android.widget.Toast.LENGTH_SHORT;

public class PeliculasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peliculas);

        ImageView caratula = (ImageView) findViewById(R.id.caratulaPelicula);
        TextView titulo = (TextView) findViewById(R.id.tituloPelicula);
        RatingBar clasificacion = (RatingBar) findViewById(R.id.clasificacionPelicula);
        TextView director = (TextView) findViewById(R.id.directorPelicula);
        TextView reparto = (TextView) findViewById(R.id.repartoPelicula);
        TextView sinopsis = (TextView) findViewById(R.id.sinopsisPelicula);

        Intent intent = getIntent();

        Bundle bundle = intent.getExtras();
        if (bundle != null) {
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
        }
    }
}