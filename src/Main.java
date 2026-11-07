import controlador.ControladorEmpleado;
import vista.VentanaPrincipal;

// DIS-13: clase principal que inicia el sistema
// RF-01, RF-02, RF-03, RF-04, RF-05: acceso a las funciones
public class Main {

    // DIS-13: crea el controlador y muestra la ventana principal
    public static void main(String[] args) {
    	ControladorEmpleado controlador = new ControladorEmpleado();

        VentanaPrincipal ventana = new VentanaPrincipal(controlador);
        ventana.mostrar();

    }
}
