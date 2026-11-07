package modelo;

import java.util.ArrayList;

// DIS-05: clase generica para almacenar empleados
// RF-01, RF-02, RF-03: registro de empleados
public class Repositorio<T extends Persona> {

    private ArrayList<T> empleados = new ArrayList<>();
    private ArrayList<String> cedulas = new ArrayList<>();

    // RF-01, RF-02, RF-03, DIS-05: registra empleados sin repetir cedulas
    public boolean registrar(T empleado) {

        if (empleado == null) {
            return false;
        }

        if (existeCedula(empleado.getCedula())) {
            return false;
        }

        empleados.add(empleado);

        cedulas.add(empleado.getCedula());

        return true;
    }

    // RF-04, DIS-05: busca un empleado por su cedula
    public T buscarPorCedula(String cedula) {

        return buscarEnLista(empleados, cedula);

    }

    // RF-05, DIS-05: devuelve la lista de empleados
    public ArrayList<T> listar() {

        return empleados;

    }

    // RF-06, DIS-05: verifica si una cedula ya esta registrada
    public boolean existeCedula(String cedula) {

        for (String numero : cedulas) {

            if (numero.equals(cedula)) {
                return true;
            }

        }

        return false;
    }

    // DIS-05: boxing y unboxing con Integer
    public int cantidad() {

        Integer total = empleados.size();

        return total;

    }

    // RF-04, DIS-05: metodo generico para buscar empleados
    public static <E extends Persona> E buscarEnLista(
            ArrayList<E> lista, String cedula) {

        for (E empleado : lista) {

            if (empleado.getCedula().equals(cedula)) {
                return empleado;
            }

        }

        return null;
    }
}
