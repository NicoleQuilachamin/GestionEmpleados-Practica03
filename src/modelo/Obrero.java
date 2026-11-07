package modelo;

// DIS-03: clase Obrero que hereda de Persona
// RF-02: registro de obreros
// RNF-04: estructura del modelo MVC
public class Obrero extends Persona {

    protected String codigo;

    // RF-02, DIS-03: datos del obrero
    public Obrero(String nombre, String cedula, String codigo) {
        super(nombre, cedula);
        this.codigo = codigo;
    }

    // DIS-03
    public String getCodigo() {
        return codigo;
    }

    // DIS-03
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    // DIS-03: identifica el tipo de empleado
    @Override
    public String getTipo() {
        return "Obrero";
    }

    // RF-04, DIS-03: obtiene los datos del obrero
    @Override
    public String obtenerInformacion() {
        return "NOMBRE: " + getNombre() + "\tCEDULA: " + getCedula() + "\tCODIGO: " + codigo;
    }

    // RF-04, DIS-03: muestra la informacion del obrero
    @Override
    public void informacion() {
        print("NOMBRES \t CEDULA \t CODIGO \n" + getNombre() + "\t" + getCedula() + "\t" + codigo);
    }
}
