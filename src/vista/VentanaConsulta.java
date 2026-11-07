package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controlador.ControladorEmpleado;

// DIS-11: ventana para consultar empleados
// RF-04: consulta de empleados por cedula
public class VentanaConsulta extends JFrame {

    private ControladorEmpleado controlador;

    private JTextField txtCedula = new JTextField(14);
    private JButton btnBuscar = new JButton("Buscar");

    private JLabel lblNombre = new JLabel("-");
    private JLabel lblCedula = new JLabel("-");
    private JLabel lblTipo = new JLabel("-");
    private JLabel lblCargo = new JLabel("-");
    private JLabel lblCodigo = new JLabel("-");
    private JLabel lblClave = new JLabel("-");

    // RF-04, DIS-11: recibe el controlador
    public VentanaConsulta(ControladorEmpleado controlador) {
        this.controlador = controlador;
        initComponents();
    }

    // RF-04, DIS-11: configura la ventana de consulta
    private void initComponents() {
        setTitle("Consultar Empleado");
        setSize(440, 340);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel arriba = new JPanel(new FlowLayout());
        arriba.add(new JLabel("Cédula:"));
        arriba.add(txtCedula);
        arriba.add(btnBuscar);

        JPanel info = new JPanel(new GridLayout(6, 2, 5, 8));
        info.setBorder(BorderFactory.createTitledBorder("Información del Empleado"));

        info.add(new JLabel("Nombre:"));
        info.add(lblNombre);
        info.add(new JLabel("Cédula:"));
        info.add(lblCedula);
        info.add(new JLabel("Tipo:"));
        info.add(lblTipo);
        info.add(new JLabel("Cargo:"));
        info.add(lblCargo);
        info.add(new JLabel("Código:"));
        info.add(lblCodigo);
        info.add(new JLabel("Clave de acceso:"));
        info.add(lblClave);

        JPanel centro = new JPanel(new BorderLayout());
        centro.add(info, BorderLayout.CENTER);

        add(arriba, BorderLayout.NORTH);
        add(centro, BorderLayout.CENTER);

        // RF-04, DIS-11: boton para buscar empleados
        btnBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buscar();
            }
        });
    }

    // DIS-11: muestra la ventana de consulta
    public void mostrar() {
        setVisible(true);
    }

    // RF-04, RF-06, DIS-11: consulta y muestra los datos del empleado
    public void buscar() {

        String[] datos = controlador.consultarPorCedula(txtCedula.getText());

        if (datos == null) {
            limpiarEtiquetas();
            JOptionPane.showMessageDialog(this, controlador.getMensaje());
            return;
        }

        lblNombre.setText(datos[0]);
        lblCedula.setText(datos[1]);
        lblTipo.setText(datos[2]);
        lblCargo.setText(datos[3]);
        lblCodigo.setText(datos[4]);
        lblClave.setText(datos[5]);
    }

    // RF-04, DIS-11: limpia los datos de una consulta anterior
    private void limpiarEtiquetas() {
        lblNombre.setText("-");
        lblCedula.setText("-");
        lblTipo.setText("-");
        lblCargo.setText("-");
        lblCodigo.setText("-");
        lblClave.setText("-");
    }
}
