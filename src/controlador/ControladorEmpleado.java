package controlador;

import java.util.ArrayList;

import modelo.Administrativo;
import modelo.Obrero;
import modelo.Persona;
import modelo.Repositorio;
import modelo.Tecnico;

// DIS-06: controlador del sistema de empleados
// RF-01, RF-02, RF-03, RF-04, RF-05, RF-06
public class ControladorEmpleado {

    private Repositorio<Administrativo> administrativos = new Repositorio<>();
    private Repositorio<Obrero> obreros = new Repositorio<>();
    private Repositorio<Tecnico> tecnicos = new Repositorio<>();

    private String mensaje = "";

    // DIS-06: obtiene los mensajes del sistema
    public String getMensaje() {
        return mensaje;
    }

    // RF-01, DIS-06: registra un administrativo
    public boolean registrarAdministrativo(String nombre, String cedula, String cargo) {

        if (!validarDatos(nombre, cedula)) {
            return false;
        }

        if (cargo == null || cargo.trim().isEmpty()) {
            mensaje = "Ingrese el cargo";
            return false;
        }

        Administrativo a = new Administrativo(nombre.trim(), cedula.trim(), cargo.trim());

        if (administrativos.registrar(a)) {
            mensaje = "Administrativo registrado";
            return true;
        }

        mensaje = "No se pudo registrar";
        return false;
    }

    // RF-02, DIS-06: registra un obrero
    public boolean registrarObrero(String nombre, String cedula, String codigo) {

        if (!validarDatos(nombre, cedula)) {
            return false;
        }

        if (codigo == null || codigo.trim().isEmpty()) {
            mensaje = "Ingrese el código";
            return false;
        }

        Obrero o = new Obrero(nombre.trim(), cedula.trim(), codigo.trim());

        if (obreros.registrar(o)) {
            mensaje = "Obrero registrado";
            return true;
        }

        mensaje = "No se pudo registrar";
        return false;
    }

    // RF-03, DIS-06: registra un tecnico
    public boolean registrarTecnico(String nombre, String cedula, String codigo, String clave) {

        if (!validarDatos(nombre, cedula)) {
            return false;
        }

        if (codigo == null || codigo.trim().isEmpty()) {
            mensaje = "Ingrese el código";
            return false;
        }

        if (clave == null || clave.trim().isEmpty()) {
            mensaje = "Ingrese la clave";
            return false;
        }

        Tecnico t = new Tecnico(nombre.trim(), cedula.trim(), codigo.trim(), clave.trim());

        if (tecnicos.registrar(t)) {
            mensaje = "Técnico registrado";
            return true;
        }

        mensaje = "No se pudo registrar";
        return false;
    }

    // RF-04, DIS-06: busca empleados en los repositorios
    public Persona buscarPorCedula(String cedula) {

        Persona empleado = administrativos.buscarPorCedula(cedula);

        if (empleado == null) {
            empleado = obreros.buscarPorCedula(cedula);
        }

        if (empleado == null) {
            empleado = tecnicos.buscarPorCedula(cedula);
        }

        return empleado;
    }

    // RF-04, DIS-06: consulta los datos de un empleado
    public String[] consultarPorCedula(String cedula) {

        if (!validarCedula(cedula)) {
            return null;
        }

        String numero = cedula.trim();

        for (Administrativo a : administrativos.listar()) {
            if (a.getCedula().equals(numero)) {
                mensaje = "Empleado encontrado";
                return new String[] {
                        a.getNombre(), "" + a.getCedula(),
                        "Administrativo", a.getCargo(), "-", "-"
                };
            }
        }

        for (Obrero o : obreros.listar()) {
            if (o.getCedula().equals(numero)) {
                mensaje = "Empleado encontrado";
                return new String[] {
                        o.getNombre(), "" + o.getCedula(),
                        "Obrero", "-", o.getCodigo(), "-"
                };
            }
        }

        for (Tecnico t : tecnicos.listar()) {
            if (t.getCedula().equals(numero)) {
                mensaje = "Empleado encontrado";
                return new String[] {
                        t.getNombre(), "" + t.getCedula(),
                        "Técnico", "-", t.getCodigo(), t.getClave_acceso()
                };
            }
        }

        mensaje = "No se encontró el empleado";
        return null;
    }

    // RF-05, DIS-06: lista los empleados segun su tipo
    public ArrayList<String[]> listar(String tipo) {

        ArrayList<String[]> lista = new ArrayList<>();

        if (tipo.equals("Todos") || tipo.equals("Administrativo")) {
            for (Administrativo a : administrativos.listar()) {
                lista.add(new String[] {
                        a.getNombre(), "" + a.getCedula(),
                        "Administrativo", a.getCargo(), "-", "-"
                });
            }
        }

        if (tipo.equals("Todos") || tipo.equals("Obrero")) {
            for (Obrero o : obreros.listar()) {
                lista.add(new String[] {
                        o.getNombre(), "" + o.getCedula(),
                        "Obrero", "-", o.getCodigo(), "-"
                });
            }
        }

        if (tipo.equals("Todos") || tipo.equals("Técnico")) {
            for (Tecnico t : tecnicos.listar()) {
                lista.add(new String[] {
                        t.getNombre(), "" + t.getCedula(),
                        "Técnico", "-", t.getCodigo(), t.getClave_acceso()
                });
            }
        }

        return lista;
    }

    // RF-05, DIS-06: obtiene los administrativos
    public ArrayList<Administrativo> listarAdministrativos() {
        return administrativos.listar();
    }

    // RF-05, DIS-06: obtiene los obreros
    public ArrayList<Obrero> listarObreros() {
        return obreros.listar();
    }

    // RF-05, DIS-06: obtiene los tecnicos
    public ArrayList<Tecnico> listarTecnicos() {
        return tecnicos.listar();
    }

    // RF-05, DIS-06: cuenta los empleados registrados
    public int getTotal(String tipo) {

        if (tipo.equals("Administrativo")) {
            return administrativos.cantidad();
        }

        if (tipo.equals("Obrero")) {
            return obreros.cantidad();
        }

        if (tipo.equals("Técnico")) {
            return tecnicos.cantidad();
        }

        return administrativos.cantidad() + obreros.cantidad() + tecnicos.cantidad();
    }

    // RF-06, DIS-06: valida los datos y evita cedulas repetidas
    private boolean validarDatos(String nombre, String cedula) {

        if (nombre == null || nombre.trim().isEmpty()) {
            mensaje = "Ingrese el nombre";
            return false;
        }

        if (!validarCedula(cedula)) {
            return false;
        }

        String numero = cedula.trim();

        if (buscarPorCedula(numero) != null) {
            mensaje = "La cédula ya está registrada";
            return false;
        }

        return true;
    }

    // RF-06, DIS-06: valida que la cedula tenga 10 digitos numericos
    private boolean validarCedula(String cedula) {

        if (cedula == null || cedula.trim().isEmpty()) {
            mensaje = "Ingrese la cédula";
            return false;
        }

        cedula = cedula.trim();

        if (cedula.length() != 10) {
            mensaje = "La cédula debe tener 10 dígitos";
            return false;
        }

        for (int i = 0; i < 10; i++) {
            char numero = cedula.charAt(i);

            if (numero < '0' || numero > '9') {
                mensaje = "La cédula solo debe tener números";
                return false;
            }
        }

        return true;
    }
}
