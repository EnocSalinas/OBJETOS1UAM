package run;

public class Estudiante {
    String nombre;
    String matricula;
    double promedio;

    public void verificarAprobacion() {
        if (promedio >= 70) {
            System.out.println(nombre + " aprobó");
        } else {
            System.out.println(nombre + " no aprobó");
        }
    }
}
