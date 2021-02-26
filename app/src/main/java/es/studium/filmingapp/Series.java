package es.studium.filmingapp;

public class Series {

    String titulo, director, reparto, sinopsis;
    Double clasificacion;
    Integer caratula, temporadas;

    public Series(){
        this.caratula = 0;
        this.titulo = "";
        this.director = "";
        this.reparto = "";
        this.clasificacion = 0.;
        this.sinopsis = "";
        this.temporadas = 0;
    }

    public Series(Integer caratula, String titulo, String director, String reparto,
                     Double clasificacion, String sinopsis, Integer temporadas){
        this.caratula = caratula;
        this.titulo = titulo;
        this.director = director;
        this.reparto = reparto;
        this.clasificacion = clasificacion;
        this.sinopsis= sinopsis;
        this.temporadas = temporadas;
    }

    public Integer getCaratula() {
        return caratula;
    }

    public void setCaratula(Integer caratula) {
        this.caratula = caratula;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getReparto() {
        return reparto;
    }

    public void setReparto(String reparto) {
        this.reparto = reparto;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public Double getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(Double clasificacion) {
        this.clasificacion = clasificacion;
    }

    public Integer getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(Integer temporadas) {
        this.temporadas = temporadas;
    }
}