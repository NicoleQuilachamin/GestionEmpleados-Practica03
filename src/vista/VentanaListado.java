package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controlador.ControladorEmpleado;

// DIS-12: ventana para listar empleados
// RF-05: listado y filtrado de empleados
public class VentanaListado extends JFrame {

    private ControladorEmpleado controlador;

    private JComboBox<String> cmbTipo = new JComboBox<>(
            new String[] {"Todos", "Administrativo", "Obrero", "Técnico"}
    );

    private JButton btnListar = new JButton("Listar");
    private JTable tabla = new JTable();

    // RF-05, DIS-12: recibe el controlador
    public VentanaListado(ControladorEmpleado controlador) {
        this.controlador = controlador;
        initComponents();
    }

    // RF-05, DIS-12: configura la tabla y el filtro
    private void initComponents() {

        setTitle("Listado de Empleados");
        setSize(750, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        Color rosado = new Color(255, 200, 220);
        getContentPane().setBackground(rosado);

        JPanel arriba = new JPanel(new FlowLayout());
        arriba.setBackground(rosado);

        arriba.add(new JLabel("Tipo de empleado:"));
        arriba.add(cmbTipo);
        arriba.add(btnListar);

        String[] columnas = {
            "Nombre", "Cédula", "Tipo", "Cargo", "Código", "Clave"
        };

        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);
        tabla.setModel(modelo);

        JScrollPane scroll = new JScrollPane(tabla);

        add(arriba, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);

        // RF-05, DIS-12: boton para actualizar el listado
        btnListar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                listar();
            }
        });

        listar();
    }

    // DIS-12: muestra la ventana de listado
    public void mostrar() {
        setVisible(true);
    }

    // RF-05, DIS-12: muestra los empleados segun el filtro seleccionado
    public void listar() {

        String tipo = (String) cmbTipo.getSelectedItem();

        ArrayList<String[]> empleados = controlador.listar(tipo);

        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();

        modelo.setRowCount(0);

        for (String[] empleado : empleados) {
            modelo.addRow(empleado);
        }
    }
}
