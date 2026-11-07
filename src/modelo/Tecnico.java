package modelo;

// DIS-04: clase Tecnico que hereda de Obrero
// RF-03: registro de tecnicos
// RNF-04: estructura del modelo MVC
public class Tecnico extends Obrero {

    private String clave_acceso;

    // RF-03, DIS-04: datos del tecnico
    public Tecnico(String nombre, String cedula, String codigo, String clave_acceso) {
        super(nombre, cedula, codigo);
        this.clave_acceso = clave_acceso;
    }

    // DIS-04
    public String getClave_acceso() {
        return clave_acceso;
    }

    // DIS-04
    public void setClave_acceso(String clave_acceso) {
        this.clave_acceso = clave_acceso;
    }

    // DIS-04: identifica el tipo de empleado
    @Override
    public String getTipo() {
        return "Técnico";
    }

    // RF-04, DIS-04: obtiene los datos del tecnico
    @Override
    public String obtenerInformacion() {
        return super.obtenerInformacion() + "\tCLAVE: " + clave_acceso;
    }

    // RF-04, DIS-04: muestra la informacion del tecnico
    @Override
    public void informacion() {
        print("NOMBRES \t CEDULA \t CODIGO \t CLAVE \n"
                + getNombre() + "\t" + getCedula()
                + "\t" + codigo + "\t" + clave_acceso);
    }
}
