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

// DIS-10: ventana para registrar tecnicos
// RF-03: registro de tecnicos
public class VentanaTecnico extends JFrame {

    private ControladorEmpleado controlador;

    private JTextField txtNombre = new JTextField();
    private JTextField txtCedula = new JTextField();
    private JTextField txtCodigo = new JTextField();
    private JTextField txtClave = new JTextField();

    private JButton btnRegistrar = new JButton("Registrar");
    private JButton btnLimpiar = new JButton("Limpiar");

    // RF-03, DIS-10: recibe el controlador
    public VentanaTecnico(ControladorEmpleado controlador) {
        this.controlador = controlador;
        initComponents();
    }

    // RF-03, DIS-10: configura el formulario de registro
    private void initComponents() {
        setTitle("Registrar Técnico");
        setSize(420, 310);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 12));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 25, 20, 25));
        panel.setBackground(new Color(255, 200, 220));

        panel.add(new JLabel("Nombre:"));
        panel.add(txtNombre);
        panel.add(new JLabel("Cédula:"));
        panel.add(txtCedula);
        panel.add(new JLabel("Código:"));
        panel.add(txtCodigo);
        panel.add(new JLabel("Clave de acceso:"));
        panel.add(txtClave);
        panel.add(btnRegistrar);
        panel.add(btnLimpiar);

        add(panel);

        // RF-03, DIS-10: boton para registrar
        btnRegistrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                registrar();
            }
        });

        // DIS-10: boton para limpiar los campos
        btnLimpiar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                limpiar();
            }
        });
    }

    // DIS-10: muestra la ventana
    public void mostrar() {
        setVisible(true);
    }

    // RF-03, RF-06, DIS-10: registra y muestra el resultado
    public void registrar() {
        boolean registrado = controlador.registrarTecnico(
                txtNombre.getText(),
                txtCedula.getText(),
                txtCodigo.getText(),
                txtClave.getText()
        );

        if (registrado) {
            JOptionPane.showMessageDialog(this, controlador.getMensaje());
            limpiar();
        } else {
            JOptionPane.showMessageDialog(this, controlador.getMensaje());
        }
    }

    // DIS-10: limpia los campos del formulario
    private void limpiar() {
        txtNombre.setText("");
        txtCedula.setText("");
        txtCodigo.setText("");
        txtClave.setText("");
    }
}
