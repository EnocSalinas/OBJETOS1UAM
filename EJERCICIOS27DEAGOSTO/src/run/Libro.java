package run;

public class Libro {
    String titulo;
    String autor;
    int numPaginas;

    public String descripcion() {
        return "Título: " + titulo + ", Autor: " + autor + ", Páginas: " + numPaginas;
    }
}
