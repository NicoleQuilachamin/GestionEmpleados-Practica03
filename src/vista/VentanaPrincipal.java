package vista;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import controlador.ControladorEmpleado;

// DIS-07: ventana principal del sistema
// RF-01, RF-02, RF-03, RF-04, RF-05: acceso a las funciones
public class VentanaPrincipal extends JFrame {

    private ControladorEmpleado controlador;

    private JButton btnAdministrativo = new JButton("Registrar Administrativo");
    private JButton btnObrero = new JButton("Registrar Obrero");
    private JButton btnTecnico = new JButton("Registrar Técnico");
    private JButton btnConsulta = new JButton("Consultar Empleado");
    private JButton btnListado = new JButton("Listar Empleados");
    private JButton btnSalir = new JButton("Salir");

    // DIS-07: recibe el controlador del sistema
    public VentanaPrincipal(ControladorEmpleado controlador) {
        this.controlador = controlador;
        initComponents();
    }

    // DIS-07: configura la ventana y sus botones
    public void initComponents() {

        setTitle("Sistema de Gestión de Empleados");
        setSize(420, 430);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        Color rosado = new Color(255, 200, 220);

        getContentPane().setBackground(rosado);

        JLabel titulo = new JLabel("Sistema de Gestión de Empleados", SwingConstants.CENTER);
        titulo.setFont(titulo.getFont().deriveFont(18f));
        titulo.setBorder(BorderFactory.createEmptyBorder(15, 10, 5, 10));

        JPanel panel = new JPanel(new GridLayout(6, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 50, 25, 50));
        panel.setBackground(rosado);

        panel.add(btnAdministrativo);
        panel.add(btnObrero);
        panel.add(btnTecnico);
        panel.add(btnConsulta);
        panel.add(btnListado);
        panel.add(btnSalir);

        add(titulo, java.awt.BorderLayout.NORTH);
        add(panel, java.awt.BorderLayout.CENTER);

        // RF-01, DIS-07: abre el registro de administrativos
        btnAdministrativo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirRegistroAdministrativo();
            }
        });

        // RF-02, DIS-07: abre el registro de obreros
        btnObrero.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirRegistroObrero();
            }
        });

        // RF-03, DIS-07: abre el registro de tecnicos
        btnTecnico.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirRegistroTecnico();
            }
        });

        // RF-04, DIS-07: abre la consulta de empleados
        btnConsulta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirConsulta();
            }
        });

        // RF-05, DIS-07: abre el listado de empleados
        btnListado.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirListado();
            }
        });

        // DIS-07: cierra el sistema
        btnSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    // DIS-07: muestra la ventana principal
    public void mostrar() {
        setVisible(true);
    }

    // RF-01, DIS-07: muestra el formulario de administrativos
    public void abrirRegistroAdministrativo() {
        new VentanaAdministrativo(controlador).mostrar();
    }

    // RF-02, DIS-07: muestra el formulario de obreros
    public void abrirRegistroObrero() {
        new VentanaObrero(controlador).mostrar();
    }

    // RF-03, DIS-07: muestra el formulario de tecnicos
    public void abrirRegistroTecnico() {
        new VentanaTecnico(controlador).mostrar();
    }

    // RF-04, DIS-07: muestra la ventana de consulta
    public void abrirConsulta() {
        new VentanaConsulta(controlador).mostrar();
    }

    // RF-05, DIS-07: muestra el listado de empleados
    public void abrirListado() {
        new VentanaListado(controlador).mostrar();
    }
}
