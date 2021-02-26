package es.studium.filmingapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class SeriesFragment extends Fragment {
    RecyclerView recycler;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager lManager;
    RecyclerViewOnItemClickListener recyclerViewOnItemClickListener;
    public List<Series> items;
    public static int posicion;
    View rootView;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        rootView = inflater.inflate(R.layout.fragment_peliculas, container, false);
        items = new ArrayList<>();
        items.add(new Series(R.drawable.serie_bad, "Breaking Bad", "Vince Gilligan",
                "Bryan Cranston, Aaron Paul, Anna Gunn, Dean Norris, Betsy Brandt...",
                8.8, "Tras cumplir 50 años, Walter White (Bryan Cranston), un profesor de química de un instituto de Albuquerque, Nuevo México, se entera de que tiene un cáncer de pulmón incurable. Casado con Skyler (Anna Gunn) y con un hijo discapacitado (RJ Mitte), la brutal noticia lo impulsa a dar un drástico cambio a su vida: decide, con la ayuda de un antiguo alumno (Aaron Paul), fabricar anfetaminas y ponerlas a la venta. Lo que pretende es liberar a su familia de problemas económicos cuando se produzca el fatal desenlace.", 5));
        items.add(new Series(R.drawable.serie_chernobyl, "Chernobyl", "Craig Mazin",
                "Jared Harris, Stellan Skarsgard, Emily Watson, Paul Ritter, Jessie Buckley...",
                8.4, "El 26 de abril de 1986, la Central Nuclear de Chernóbil, en Ucrania (por entonces perteneciente a la Unión Soviética), sufrió una explosión masiva que liberó material radioactivo en Ucrania, Bielorrusia, Rusia, así como en zonas de Escandinavia y Europa Central. La serie relata, desde múltiples puntos de vista, lo que aconteció en torno a una de las mayores tragedias en la historia reciente, así como los sacrificios realizados para salvar al continente de un desastre sin precedentes.", 1));
        items.add(new Series(R.drawable.serie_mandalorian, "The Mandalorian", "Jon Favreau",
                "Pedro Pascal, Gina Carano, Carl Weathers, Werner Herzog, Nick Nolte...",
                7.7, "Ambientada tras la caída del Imperio y antes de la aparición de la Primera Orden, la serie sigue los pasos de Mando, un cazarrecompensas perteneciente a la legendaria tribu de los mandalorianos, un pistolero solitario que trabaja en los confines de la galaxia, donde no alcanza la autoridad de la Nueva República.", 2));
        items.add(new Series(R.drawable.serie_mirror, "Black Mirror", "Charlie Brooker",
                "Rory Kinnear, Lindsay Duncan, Lydia Wilson, Tom Goodman-Hill, Donald Sumpter...",
                8.2, "Serie antológica creada por Charlie Brooker (\"Dead Set\") que muestra el lado oscuro de la tecnología y cómo esta afecta y puede alterar nuestra vida, a veces con consecuencias tan impredecibles como aterradoras. \"Black Mirror\" comenzó su emisión en 2011 en el canal británico Channel 4, con dos temporadas de tres episodios cada una, y tras producirse un especial de Navidad la serie fue comprada y renovada por Netflix, que ya ha producido tres temporadas más.", 5));
        items.add(new Series(R.drawable.serie_tronos, "Juego de Tronos", "David Benioff, D.B. Weiss ",
                "Lena Headey, Peter Dinklage, Maisie Williams, Emilia Clarke, Kit Harington...",
                8.6, "La historia se desarrolla en un mundo ficticio de carácter medieval donde hay Siete Reinos. Hay tres líneas argumentales principales: la crónica de la guerra civil dinástica por el control de Poniente entre varias familias nobles que aspiran al Trono de Hierro; la creciente amenaza de \"los otros\", seres desconocidos que viven al otro lado de un inmenso muro de hielo que protege el Norte de Poniente; y el viaje de Daenerys Targaryen, la hija exiliada del rey que fue asesinado en una guerra civil anterior, y que pretende regresar a Poniente para reclamar sus derechos dinásticos. Tras un largo verano de varios años, el temible invierno se acerca a los Siete Reinos. Lord Eddard 'Ned' Stark, señor de Invernalia, deja sus dominios para ir a la corte de su amigo, el rey Robert Baratheon, en Desembarco del Rey, la capital de los Siete Reinos. Stark se convierte en la Mano del Rey e intenta desentrañar una maraña de intrigas que pondrá en peligro su vida y la de todos los suyos. Mientras tanto, diversas facciones conspiran con un solo objetivo: apoderarse del trono.", 8));
        recycler = (RecyclerView) rootView.findViewById(R.id.recyclerViewPeliculas);
        recycler.setHasFixedSize(true);
        lManager = new LinearLayoutManager(getContext());
        recycler.setLayoutManager(lManager);
        adapter = new SeriesAdapter(items, recyclerViewOnItemClickListener);
        recycler.setAdapter(adapter);
        setupRecyclerView();
        return rootView;
    }

    private void setupRecyclerView() {
        RecyclerView recyclerView = recycler.findViewById(R.id.recyclerViewPeliculas);
        recyclerView.setAdapter(new SeriesAdapter(items,new RecyclerViewOnItemClickListener()  {
            @Override
            public void onClick(View v, int position) {
                switch(v.getId()) {
                    case R.id.caratula:
                        Intent zoom = new Intent(rootView.getContext(), Zoom.class);
                        zoom.putExtra("Caratula", items.get(position).getCaratula());
                        startActivity(zoom);
                        break;
                    case R.id.titulo:
                        verDetalles(position);
                        break;
                    case R.id.estrellas:
                        verDetalles(position);
                        break;
                }
            }
        }));
        recyclerView.setLayoutManager(new LinearLayoutManager(rootView.getContext()));
    }

    private void verDetalles(int position) {
        Intent detalleSeries = new Intent(rootView.getContext(), SeriesActivity.class);
        detalleSeries.putExtra("Caratula", items.get(position).getCaratula());
        detalleSeries.putExtra("Titulo", items.get(position).getTitulo());
        detalleSeries.putExtra("Director", items.get(position).getDirector());
        detalleSeries.putExtra("Reparto", items.get(position).getReparto());
        detalleSeries.putExtra("Puntos", items.get(position).getClasificacion());
        detalleSeries.putExtra("Sinopsis", items.get(position).getSinopsis());
        detalleSeries.putExtra("Temporadas", items.get(position).getTemporadas());
        startActivity(detalleSeries);
    }
}