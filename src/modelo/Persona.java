package modelo;

// DIS-01: clase base para los empleados
// RNF-04: estructura del modelo MVC
public class Persona {

    private String nombre;
    private String cedula;

    // DIS-01: datos principales del empleado
    public Persona(String nombre, String cedula) {
        this.nombre = nombre;
        this.cedula = cedula;
    }

    // DIS-01
    public String getNombre() {
        return nombre;
    }

    // DIS-01
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // DIS-01
    public String getCedula() {
        return cedula;
    }

    // DIS-01
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    // DIS-01
    public void print(String texto) {
        System.out.println(texto);
    }

    // DIS-01: identifica el tipo de empleado
    public String getTipo() {
        return "Persona";
    }

    // RF-04, DIS-01: obtiene los datos del empleado
    public String obtenerInformacion() {
        return "NOMBRE: " + nombre + "\tCEDULA: " + cedula;
    }

    // RF-04, DIS-01: muestra la informacion
    public void informacion() {
        print(obtenerInformacion());
    }
}
