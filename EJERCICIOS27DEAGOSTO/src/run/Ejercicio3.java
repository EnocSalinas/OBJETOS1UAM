package run;

public class Ejercicio3 {
    public static void main(String[] args) {
        Libro l = new Libro();
        l.titulo = "Cien años de soledad";
        l.autor = "Gabriel García Márquez";
        l.numPaginas = 471;
        System.out.println(l.descripcion());
    }
}
