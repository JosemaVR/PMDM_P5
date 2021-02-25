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

public class PeliculasFragment extends Fragment {
    RecyclerView recycler;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager lManager;
    RecyclerViewOnItemClickListener recyclerViewOnItemClickListener;
    public List<Peliculas> items;
    public static int posicion;
    View rootView;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        rootView = inflater.inflate(R.layout.fragment_peliculas, container, false);
        items = new ArrayList<>();
        items.add(new Peliculas(R.drawable.pelicula_1917, "1917", "Sam Mendes",
                "George MacKay, Dean-Charles Chapman, Mark Strong, Richard Madden, Benedict Cumberbatch...",
                7.1, "En lo más crudo de la Primera Guerra Mundial, dos jóvenes soldados británicos, " +
                "Schofield (George MacKay) y Blake (Dean-Charles Chapman) reciben una misión aparentemente imposible. " +
                "En una carrera contrarreloj, deberán atravesar el territorio enemigo para entregar un mensaje que evitará " +
                "un mortífero ataque contra cientos de soldados, entre ellos el propio hermano de Blake."));

        items.add(new Peliculas(R.drawable.pelicula_torino, "Gran torino", "Clint Eastwood",
                "Clint Eastwood, Christopher Carley, Bee Vang, Ahney Her, John Carroll Lynch...", 9.2,
                "Walt Kowalski (Clint Eastwood), un veterano de la guerra de Corea (1950-1953), es un obrero jubilado del sector del automóvil que ha enviudado recientemente. Su máxima pasión es cuidar de su más preciado tesoro: un coche Gran Torino de 1972. Es un hombre inflexible y cascarrabias, al que le cuesta trabajo asimilar los cambios que se producen a su alrededor, especialmente la llegada de multitud de inmigrantes asiáticos a su barrio. Sin embargo, las circustancias harán que se vea obligado a replantearse sus ideas."));

        items.add(new Peliculas(R.drawable.pelicula_pianista, "El pianista", "Roman Polanski",
                "Adrien Brody, Thomas Kretschmann, Maureen Lipman, Ed Stoppard, Emilia Fox...",7.6,
                "Wladyslaw Szpilman, un brillante pianista polaco de origen judío, vive con su familia en el ghetto de Varsovia. Cuando, en 1939, los alemanes invaden Polonia, consigue evitar la deportación gracias a la ayuda de algunos amigos. Pero tendrá que vivir escondido y completamente aislado durante mucho tiempo, y para sobrevivir tendrá que afrontar constantes peligros."));

        items.add(new Peliculas(R.drawable.pelicula_lucha, "El club de la lucha", "David Fincher",
                        "Edward Norton, Brad Pitt, Helena Bonham Carter, Meat Loaf, Jared Leto...", 6.1,
                        "Un joven hastiado de su gris y monótona vida lucha contra el insomnio. En un viaje en avión conoce a un carismático vendedor de jabón que sostiene una teoría muy particular: el perfeccionismo es cosa de gentes débiles; sólo la autodestrucción hace que la vida merezca la pena. Ambos deciden entonces fundar un club secreto de lucha, donde poder descargar sus frustaciones y su ira, que tendrá un éxito arrollador."));

        items.add(new Peliculas(R.drawable.pelicula_batman, "El caballero oscuro", "Christopher Nolan",
                "Christian Bale, Heath Ledger, Aaron Eckhart, Michael Caine, Gary Oldman...",6.8,
                "Batman/Bruce Wayne (Christian Bale) regresa para continuar su guerra contra el crimen. Con la ayuda del teniente Jim Gordon (Gary Oldman) y del Fiscal del Distrito Harvey Dent (Aaron Eckhart), Batman se propone destruir el crimen organizado en la ciudad de Gotham. El triunvirato demuestra su eficacia, pero, de repente, aparece Joker (Heath Ledger), un nuevo criminal que desencadena el caos y tiene aterrados a los ciudadanos."));

        recycler = (RecyclerView) rootView.findViewById(R.id.recyclerViewPeliculas);
        recycler.setHasFixedSize(true);

        lManager = new LinearLayoutManager(getContext());
        recycler.setLayoutManager(lManager);

        adapter = new PeliculasAdapter(items, recyclerViewOnItemClickListener);
        recycler.setAdapter(adapter);
        setupRecyclerView();
        return rootView;
    }

    private void setupRecyclerView() {
        RecyclerView recyclerView = recycler.findViewById(R.id.recyclerViewPeliculas);
        recyclerView.setAdapter(new PeliculasAdapter(items,new RecyclerViewOnItemClickListener()  {
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
        Intent detallePeliculas = new Intent(rootView.getContext(), PeliculasActivity.class);
        detallePeliculas.putExtra("Caratula", items.get(position).getCaratula());
        detallePeliculas.putExtra("Titulo", items.get(position).getTitulo());
        detallePeliculas.putExtra("Director", items.get(position).getDirector());
        detallePeliculas.putExtra("Reparto", items.get(position).getReparto());
        detallePeliculas.putExtra("Puntos", items.get(position).getClasificacion());
        detallePeliculas.putExtra("Sinopsis", items.get(position).getSinopsis());
        startActivity(detallePeliculas);
    }
}
