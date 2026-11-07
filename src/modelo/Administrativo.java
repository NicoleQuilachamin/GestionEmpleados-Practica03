package modelo;

// DIS-02: clase Administrativo que hereda de Persona
// RF-01: registro de administrativos
// RNF-04: estructura del modelo MVC
public class Administrativo extends Persona {

    private String cargo;

    // RF-01, DIS-02: datos del administrativo
    public Administrativo(String nombre, String cedula, String cargo) {
        super(nombre, cedula);
        this.cargo = cargo;
    }

    // DIS-02
    public String getCargo() {
        return cargo;
    }

    // DIS-02
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    // DIS-02: identifica el tipo de empleado
    @Override
    public String getTipo() {
        return "Administrativo";
    }

    // RF-04, DIS-02: obtiene los datos del administrativo
    @Override
    public String obtenerInformacion() {
        return "NOMBRE: " + getNombre() + "\tCEDULA: " + getCedula() + "\tCARGO: " + cargo;
    }

    // RF-04, DIS-02: muestra la informacion del administrativo
    @Override
    public void informacion() {
        print("NOMBRE \t CARGO \n" + getNombre() + "\t" + getCargo());
    }
}
