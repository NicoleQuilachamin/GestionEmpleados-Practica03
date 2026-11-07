package vista;

import java.awt.Color;
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

// DIS-08: ventana para registrar administrativos
// RF-01: registro de administrativos
public class VentanaAdministrativo extends JFrame {

    private ControladorEmpleado controlador;

    private JTextField txtNombre = new JTextField();
    private JTextField txtCedula = new JTextField();
    private JTextField txtCargo = new JTextField();

    private JButton btnRegistrar = new JButton("Registrar");
    private JButton btnLimpiar = new JButton("Limpiar");

    // RF-01, DIS-08: recibe el controlador
    public VentanaAdministrativo(ControladorEmpleado controlador) {
        this.controlador = controlador;
        initComponents();
    }

    // RF-01, DIS-08: configura el formulario de registro
    private void initComponents() {
        setTitle("Registrar Administrativo");
        setSize(420, 260);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 12));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 25, 20, 25));
        panel.setBackground(new Color(255, 200, 220));

        panel.add(new JLabel("Nombre:"));
        panel.add(txtNombre);
        panel.add(new JLabel("Cédula:"));
        panel.add(txtCedula);
        panel.add(new JLabel("Cargo:"));
        panel.add(txtCargo);
        panel.add(btnRegistrar);
        panel.add(btnLimpiar);

        add(panel);

        // RF-01, DIS-08: boton para registrar
        btnRegistrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                registrar();
            }
        });

        // DIS-08: boton para limpiar los campos
        btnLimpiar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                limpiar();
            }
        });
    }

    // DIS-08: muestra la ventana
    public void mostrar() {
        setVisible(true);
    }

    // RF-01, RF-06, DIS-08: registra y muestra el resultado
    public void registrar() {
        boolean registrado = controlador.registrarAdministrativo(
                txtNombre.getText(),
                txtCedula.getText(),
                txtCargo.getText()
        );

        if (registrado) {
            JOptionPane.showMessageDialog(this, controlador.getMensaje());
            limpiar();
        } else {
            JOptionPane.showMessageDialog(this, controlador.getMensaje());
        }
    }

    // DIS-08: limpia los campos del formulario
    private void limpiar() {
        txtNombre.setText("");
        txtCedula.setText("");
        txtCargo.setText("");
    }
}
