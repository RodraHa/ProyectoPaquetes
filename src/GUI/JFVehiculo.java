/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import com.toedter.calendar.JDateChooser;

import javax.swing.JFrame;
import javax.swing.JRootPane;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import mod_administracion.Conductor;
import mod_administracion.Recepcionista;
import mod_paquetes.Paquete;
import mod_transporte.Provincia;
import mod_transporte.AsignacionConductor;
import mod_transporte.FlotaVehiculo;
import mod_transporte.Vehiculo;
import validaciones.*;

/**
 *
 * @author USUARIO
 */
public class JFVehiculo extends javax.swing.JFrame {

    private Recepcionista recepcionista;

    DefaultTableModel modelo;
    // Mouse
    int xMouse, yMouse;

    public JFVehiculo(Recepcionista recepcionista) {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/iconos/icons8_Monitor_32px.png")).getImage());
        JFrame frame = new JFrame();
        frame.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        setLocationRelativeTo(null);
        cargarProvincias();
        this.recepcionista = recepcionista;
        refrescarVehiculos();

        // Opcional: Deshabilita la edición manual del campo de texto
        modelo = new DefaultTableModel();
        jInventarioVehiculo.setModel(modelo);
        String[] columnNames = {
                "Codigo", "Contenido", "Destinatario", "Provincia Destino"
        };
        modelo.setColumnIdentifiers(columnNames);

    }

    public boolean fechaVacia(JDateChooser dateChooser, JLabel label) {
        if (dateChooser.getDate() == null) {
            label.setVisible(true);
            return false;
        } else {
            label.setVisible(false);
            return true;
        }
    }

    private void refrescarVehiculos() {
        DefaultTableModel model = new DefaultTableModel();
        jTablaVehiculos.setModel(model);
        String[] columnNames = {
                "Placa", "Capacidad", "Nombre Conductor", "Identificacion", "Telefono"
        };
        model.setColumnIdentifiers(columnNames);
        
        model.setRowCount(0);
        for (Vehiculo vehiculo : recepcionista.obtenerVehiculos()) {
            Conductor conductor = recepcionista.obtenerConductorDeVehiculo(vehiculo);
            if (conductor != null) {
                model.addRow(new Object[] {
                        vehiculo.getNumeroPlaca(),
                        vehiculo.getCapacidad(),
                        conductor.getNombres() + " " + conductor.getApellidos(),
                        conductor.getCedula(),
                        conductor.getTelefono()
                });
            } else {
                model.addRow(new Object[] {
                        vehiculo.getNumeroPlaca(),
                        vehiculo.getCapacidad(),
                        "NAN",
                        "NAN",
                        "NAN"
                });
            }
        }
    }

    private void refrescarAsignacion() {

        Vehiculo vehiculo = recepcionista.obtenerVehiculo(jTPlacaVehiculo3.getText());
        ArrayList<Paquete> paquetes = recepcionista.obtenerRelacionPaqueteVehiculo().get(vehiculo);
        
        modelo.setRowCount(0);
        for (Paquete paquete : paquetes) {
            modelo.addRow(new Object[] {
                    paquete.obtenerCodigo(),
                    paquete.getContenido(),
                    paquete.getNombreDestinatario(),
                    paquete.getProvinciaDestino().name()
            });
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSlider1 = new javax.swing.JSlider();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPEmpleadosTab = new javax.swing.JPanel();
        jTPEmpleados = new javax.swing.JTabbedPane();
        jPRE = new javax.swing.JPanel();
        jPDatosEmpleados = new javax.swing.JPanel();
        jTCapacidadVehiculo = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        bRegistrarVehiculo = new javax.swing.JButton();
        jTPlacaVehiculo = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jPAE = new javax.swing.JPanel();
        jPDatosRecuperadosEmpleados = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        jTPlacaVehiculo2 = new javax.swing.JTextField();
        jPanel46 = new javax.swing.JPanel();
        jTNombreDespachador3 = new javax.swing.JTextField();
        jTTelefono1 = new javax.swing.JTextField();
        jTCorreo1 = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jTCedula2 = new javax.swing.JTextField();
        BActualizar = new javax.swing.JButton();
        jPEE = new javax.swing.JPanel();
        jScrollPane25 = new javax.swing.JScrollPane();
        jInventarioVehiculo = new javax.swing.JTable();
        JComboDestino1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jTPlacaVehiculo3 = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        jPCE = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTablaVehiculos = new javax.swing.JTable();
        jTPlacaVehiculo1 = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jTCapacidad = new javax.swing.JTextField();
        jPanel45 = new javax.swing.JPanel();
        jTNombreDespachador1 = new javax.swing.JTextField();
        jTTelefono = new javax.swing.JTextField();
        jTCorreo = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jTCedula3 = new javax.swing.JTextField();
        bSeleccionarConductor = new javax.swing.JButton();
        jLabel62 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel69 = new javax.swing.JLabel();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setTitle("Registro de Empleados");
        setMinimumSize(new java.awt.Dimension(1180, 680));
        setUndecorated(true);
        getContentPane().setLayout(new java.awt.CardLayout());

        jPEmpleadosTab.setMinimumSize(new java.awt.Dimension(1180, 609));
        jPEmpleadosTab.setPreferredSize(new java.awt.Dimension(1180, 609));
        jPEmpleadosTab.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTPEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTPEmpleadosMouseClicked(evt);
            }
        });

        jPRE.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPDatosEmpleados.setBorder(javax.swing.BorderFactory.createTitledBorder("Ingresar datos de un empleado"));
        jPDatosEmpleados.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTCapacidadVehiculo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTCapacidadVehiculoFocusLost(evt);
            }
        });
        jTCapacidadVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTCapacidadVehiculoActionPerformed(evt);
            }
        });
        jTCapacidadVehiculo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTCapacidadVehiculoKeyReleased(evt);
            }
        });
        jPDatosEmpleados.add(jTCapacidadVehiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 120, 201, -1));

        jLabel32.setText("Placa");
        jPDatosEmpleados.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 60, 34, 22));

        bRegistrarVehiculo.setText("Registrar Vehículo");
        bRegistrarVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRegistrarVehiculoActionPerformed(evt);
            }
        });
        jPDatosEmpleados.add(bRegistrarVehiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 190, -1, 36));

        jTPlacaVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTPlacaVehiculoActionPerformed(evt);
            }
        });
        jPDatosEmpleados.add(jTPlacaVehiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 60, 201, -1));

        jLabel29.setText("Capacidad");
        jPDatosEmpleados.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 125, -1, -1));
        jLabel29.getAccessibleContext().setAccessibleDescription("");

        jLabel61.setText("m3");
        jLabel61.setRequestFocusEnabled(false);
        jPDatosEmpleados.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(685, 125, -1, -1));

        jPRE.add(jPDatosEmpleados, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 1110, 530));

        jTPEmpleados.addTab("Registrar Vehiculo", jPRE);

        jPAE.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPDatosRecuperadosEmpleados.setBorder(javax.swing.BorderFactory.createTitledBorder("Asignar Conductor"));
        jPDatosRecuperadosEmpleados.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel38.setText("Placa");
        jPDatosRecuperadosEmpleados.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 70, 34, 22));

        jTPlacaVehiculo2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTPlacaVehiculo2FocusLost(evt);
            }
        });
        jTPlacaVehiculo2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTPlacaVehiculo2ActionPerformed(evt);
            }
        });
        jTPlacaVehiculo2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTPlacaVehiculo2KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTPlacaVehiculo2KeyTyped(evt);
            }
        });
        jPDatosRecuperadosEmpleados.add(jTPlacaVehiculo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 70, 210, -1));

        jPanel46.setBorder(javax.swing.BorderFactory.createTitledBorder("Conductor Asignado"));
        jPanel46.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTNombreDespachador3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTNombreDespachador3.setEnabled(false);
        jTNombreDespachador3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTNombreDespachador3ActionPerformed(evt);
            }
        });
        jPanel46.add(jTNombreDespachador3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 206, -1));

        jTTelefono1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTTelefono1.setEnabled(false);
        jPanel46.add(jTTelefono1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 206, -1));

        jTCorreo1.setEnabled(false);
        jTCorreo1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTCorreo1FocusLost(evt);
            }
        });
        jTCorreo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTCorreo1ActionPerformed(evt);
            }
        });
        jTCorreo1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTCorreo1KeyReleased(evt);
            }
        });
        jPanel46.add(jTCorreo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, 206, -1));

        jLabel39.setText("Cédula");
        jPanel46.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 55, -1));

        jLabel40.setText("Nombres");
        jPanel46.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 55, -1));

        jLabel41.setText("Teléfono");
        jPanel46.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 55, -1));

        jLabel42.setText("Correo");
        jPanel46.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 55, -1));

        jTCedula2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTCedula2FocusLost(evt);
            }
        });
        jTCedula2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTCedula2ActionPerformed(evt);
            }
        });
        jTCedula2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTCedula2KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTCedula2KeyTyped(evt);
            }
        });
        jPanel46.add(jTCedula2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, 206, -1));

        jPDatosRecuperadosEmpleados.add(jPanel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 360, 190));

        jPAE.add(jPDatosRecuperadosEmpleados, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 810, 250));

        BActualizar.setText("Asignar");
        BActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BActualizarActionPerformed(evt);
            }
        });
        jPAE.add(BActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 310, 110, 40));

        jTPEmpleados.addTab("Asignar Vehiculo", jPAE);

        jPEE.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jInventarioVehiculo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane25.setViewportView(jInventarioVehiculo);

        jPEE.add(jScrollPane25, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 235, 1130, 253));

        JComboDestino1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        JComboDestino1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JComboDestino1ActionPerformed(evt);
            }
        });
        jPEE.add(JComboDestino1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 204, -1));

        jButton1.setText("Asignar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPEE.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 83, 31));

        jTPlacaVehiculo3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTPlacaVehiculo3FocusLost(evt);
            }
        });
        jTPlacaVehiculo3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTPlacaVehiculo3ActionPerformed(evt);
            }
        });
        jTPlacaVehiculo3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTPlacaVehiculo3KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTPlacaVehiculo3KeyTyped(evt);
            }
        });
        jPEE.add(jTPlacaVehiculo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 204, 30));

        jLabel37.setText("Placa");
        jPEE.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 40, 30));

        jTPEmpleados.addTab("Asignar Paquetes", jPEE);

        jPCE.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTablaVehiculos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane6.setViewportView(jTablaVehiculos);

        jPCE.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 1070, 185));

        jTPlacaVehiculo1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTPlacaVehiculo1FocusLost(evt);
            }
        });
        jTPlacaVehiculo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTPlacaVehiculo1ActionPerformed(evt);
            }
        });
        jTPlacaVehiculo1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTPlacaVehiculo1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTPlacaVehiculo1KeyTyped(evt);
            }
        });
        jPCE.add(jTPlacaVehiculo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 201, -1));

        jLabel33.setText("Placa");
        jPCE.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 34, 22));

        jLabel28.setText("Capacidad");
        jPCE.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 75, -1, -1));

        jTCapacidad.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTCapacidad.setEnabled(false);
        jPCE.add(jTCapacidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 200, -1));

        jPanel45.setBorder(javax.swing.BorderFactory.createTitledBorder("Conductor Asignado"));
        jPanel45.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTNombreDespachador1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTNombreDespachador1.setEnabled(false);
        jTNombreDespachador1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTNombreDespachador1ActionPerformed(evt);
            }
        });
        jPanel45.add(jTNombreDespachador1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 206, -1));

        jTTelefono.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTTelefono.setEnabled(false);
        jPanel45.add(jTTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, 206, -1));

        jTCorreo.setEnabled(false);
        jTCorreo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTCorreoFocusLost(evt);
            }
        });
        jTCorreo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTCorreoKeyReleased(evt);
            }
        });
        jPanel45.add(jTCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, 206, -1));

        jLabel31.setText("Cédula");
        jPanel45.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 66, -1));

        jLabel34.setText("Nombres");
        jPanel45.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 66, -1));

        jLabel35.setText("Teléfono");
        jPanel45.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 66, -1));

        jLabel36.setText("Correo");
        jPanel45.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 66, -1));

        jTCedula3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTCedula3.setEnabled(false);
        jPanel45.add(jTCedula3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 206, -1));

        jPCE.add(jPanel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 330, 180));

        bSeleccionarConductor.setText("Buscar Vehiculo");
        bSeleccionarConductor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSeleccionarConductorActionPerformed(evt);
            }
        });
        jPCE.add(bSeleccionarConductor, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 20, -1, 36));

        jLabel62.setText("m3");
        jLabel62.setRequestFocusEnabled(false);
        jPCE.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(305, 75, -1, -1));

        jTPEmpleados.addTab("Consultar", jPCE);

        jPEmpleadosTab.add(jTPEmpleados, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 41, 1150, 600));

        jPanel3.setBackground(new java.awt.Color(146, 10, 48));
        jPanel3.setMinimumSize(new java.awt.Dimension(1180, 35));
        jPanel3.setPreferredSize(new java.awt.Dimension(1180, 35));
        jPanel3.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel3MouseDragged(evt);
            }
        });
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel3MousePressed(evt);
            }
        });
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel69.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel69.setForeground(new java.awt.Color(255, 255, 255));
        jLabel69.setText("Vehiculos");
        jPanel3.add(jLabel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 0, -1, 20));

        jPEmpleadosTab.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(jPEmpleadosTab, "card2");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel3MouseDragged(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jPanel3MouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }// GEN-LAST:event_jPanel3MouseDragged

    private void jPanel3MousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jPanel3MousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }// GEN-LAST:event_jPanel3MousePressed

    private void jTPEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jTPEmpleadosMouseClicked

    }// GEN-LAST:event_jTPEmpleadosMouseClicked

    private void BActualizarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_BActualizarActionPerformed
        String placa = jTPlacaVehiculo2.getText();
        String cedula = jTCedula2.getText();
        if (placa.isEmpty() || cedula.isEmpty()) {
            JOptionPane.showMessageDialog(this, "El campo está vacío.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!ValidadorDeRegistros.validarPlaca(placa)) {
            JOptionPane.showMessageDialog(this, "La placa no es válida.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (!ValidadorDeRegistros.validarCedula(cedula)) {
            JOptionPane.showMessageDialog(this, "La cedula no es válida.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        } else {
            Vehiculo vehiculo = recepcionista.obtenerVehiculo(placa);
            if (vehiculo == null) {
                JOptionPane.showMessageDialog(this, "No existe un vehículo con la placa " + placa, "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            Conductor conductor = recepcionista.obtenerConductorPorCedula(cedula);
            if (conductor == null) {
                JOptionPane.showMessageDialog(this, "No existe un conductor con la cedula " + cedula, "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            jTNombreDespachador3.setText(conductor.getNombres() + " " + conductor.getApellidos());
            jTTelefono1.setText(conductor.getTelefono());
            jTCorreo1.setText(conductor.getEmail());
            recepcionista.asignarConductorAVehiculo(conductor, vehiculo);
            refrescarVehiculos();
        }
    }// GEN-LAST:event_BActualizarActionPerformed

    private void jTCedula2KeyTyped(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_jTCedula2KeyTyped
        // TODO add your handling code here:
    }// GEN-LAST:event_jTCedula2KeyTyped

    private void jTCedula2KeyReleased(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_jTCedula2KeyReleased
        // TODO add your handling code here:
    }// GEN-LAST:event_jTCedula2KeyReleased

    private void jTCedula2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jTCedula2ActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_jTCedula2ActionPerformed

    private void jTCedula2FocusLost(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_jTCedula2FocusLost
        // TODO add your handling code here:
    }// GEN-LAST:event_jTCedula2FocusLost

    private void jTCorreo1KeyReleased(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_jTCorreo1KeyReleased
        // TODO add your handling code here:
    }// GEN-LAST:event_jTCorreo1KeyReleased

    private void jTCorreo1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jTCorreo1ActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_jTCorreo1ActionPerformed

    private void jTCorreo1FocusLost(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_jTCorreo1FocusLost
        // TODO add your handling code here:
    }// GEN-LAST:event_jTCorreo1FocusLost

    private void jTNombreDespachador3ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jTNombreDespachador3ActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_jTNombreDespachador3ActionPerformed

    private void jTPlacaVehiculo2KeyTyped(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_jTPlacaVehiculo2KeyTyped
        // TODO add your handling code here:
    }// GEN-LAST:event_jTPlacaVehiculo2KeyTyped

    private void jTPlacaVehiculo2KeyReleased(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_jTPlacaVehiculo2KeyReleased
        // TODO add your handling code here:
    }// GEN-LAST:event_jTPlacaVehiculo2KeyReleased

    private void jTPlacaVehiculo2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jTPlacaVehiculo2ActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_jTPlacaVehiculo2ActionPerformed

    private void jTPlacaVehiculo2FocusLost(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_jTPlacaVehiculo2FocusLost
        // TODO add your handling code here:
    }// GEN-LAST:event_jTPlacaVehiculo2FocusLost

    private void bSeleccionarConductorActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_bSeleccionarConductorActionPerformed
        String placa = jTPlacaVehiculo1.getText();
        if (placa.isEmpty()) {
            JOptionPane.showMessageDialog(this, "El campo de la placa está vacío.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!ValidadorDeRegistros.validarPlaca(placa)) {
            JOptionPane.showMessageDialog(this, "La placa no es válida.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            Vehiculo vehiculo = recepcionista.obtenerVehiculo(placa);
            if (vehiculo == null) {
                JOptionPane.showMessageDialog(this, "No existe un vehículo con la placa " + placa, "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            Conductor conductor = recepcionista.obtenerConductorDeVehiculo(vehiculo);
            jTCapacidad.setText(Double.toString(vehiculo.getCapacidad()));
            if (conductor != null) {
                jTCedula3.setText(conductor.getCedula());
                jTNombreDespachador1.setText(conductor.getNombres() + " " + conductor.getApellidos());
                jTTelefono.setText(conductor.getTelefono());
                jTCorreo.setText(conductor.getEmail());
                return;
            }
            jTCedula3.setText("No existe conductor asignado");
            jTNombreDespachador1.setText("No existe conductor asignado");
            jTTelefono.setText("No existe conductor asignado");
            jTCorreo.setText("No existe conductor asignado");
        }
    }// GEN-LAST:event_bSeleccionarConductorActionPerformed

    private void cargarProvincias() {
        JComboDestino1.removeAllItems();
        for (Provincia provincia : Provincia.values()) {
            JComboDestino1.addItem(provincia.name());
        }
    }

    private void jTCorreoKeyReleased(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_jTCorreoKeyReleased

    }// GEN-LAST:event_jTCorreoKeyReleased

    private void jTCorreoFocusLost(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_jTCorreoFocusLost

    }// GEN-LAST:event_jTCorreoFocusLost

    private void jTNombreDespachador1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jTNombreDespachador1ActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_jTNombreDespachador1ActionPerformed

    private void jTPlacaVehiculo1KeyTyped(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_jTPlacaVehiculo1KeyTyped
        // TODO add your handling code here:
    }// GEN-LAST:event_jTPlacaVehiculo1KeyTyped

    private void jTPlacaVehiculo1KeyReleased(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_jTPlacaVehiculo1KeyReleased
        // TODO add your handling code here:
    }// GEN-LAST:event_jTPlacaVehiculo1KeyReleased

    private void jTPlacaVehiculo1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jTPlacaVehiculo1ActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_jTPlacaVehiculo1ActionPerformed

    private void jTPlacaVehiculo1FocusLost(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_jTPlacaVehiculo1FocusLost
        // TODO add your handling code here:
    }// GEN-LAST:event_jTPlacaVehiculo1FocusLost

    private void jTPlacaVehiculoActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jTPlacaVehiculoActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_jTPlacaVehiculoActionPerformed

    private void bRegistrarVehiculoActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_bRegistrarVehiculoActionPerformed
        double capacidad = Double.parseDouble(jTCapacidadVehiculo.getText());
        String placa = jTPlacaVehiculo.getText();
        
        if (!ValidadorDeRegistros.validarPlaca(placa)) {
            JOptionPane.showMessageDialog(this, "La placa no es válida", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(recepcionista.verificarPlacaRegistrada(placa)){
            JOptionPane.showMessageDialog(this, "La placa ya está registrada en el sistema.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Vehiculo vehiculo = new Vehiculo(placa, capacidad, this.recepcionista.obtenerSucursal());
        recepcionista.agregarVehiculo(vehiculo);
        JOptionPane.showMessageDialog(this, "El vehículo se registró con éxito", "Registro Exitoso", JOptionPane.INFORMATION_MESSAGE);
        refrescarVehiculos();
    }// GEN-LAST:event_bRegistrarVehiculoActionPerformed

    private void jTCapacidadVehiculoKeyReleased(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_jTCapacidadVehiculoKeyReleased

    }// GEN-LAST:event_jTCapacidadVehiculoKeyReleased

    private void jTCapacidadVehiculoActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jTCapacidadVehiculoActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_jTCapacidadVehiculoActionPerformed

    private void jTCapacidadVehiculoFocusLost(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_jTCapacidadVehiculoFocusLost

    }// GEN-LAST:event_jTCapacidadVehiculoFocusLost

    private void JComboDestino1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_JComboDestino1ActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_JComboDestino1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed
        Provincia destino = null;
        Class<?> enumClass;
        try {
            enumClass = Class.forName("mod_transporte.Provincia");
            destino = (Provincia) Enum.valueOf((Class<Enum>) enumClass, JComboDestino1.getSelectedItem().toString());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JFPaquetes.class.getName()).log(Level.SEVERE, null, ex);
        }
        String placa = jTPlacaVehiculo3.getText();
        if (placa.isEmpty()) {
            JOptionPane.showMessageDialog(this, "El campo de la placa está vacío.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!ValidadorDeRegistros.validarPlaca(placa)) {
            JOptionPane.showMessageDialog(this, "La placa no es válida.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        } else {
            Vehiculo vehiculo = recepcionista.obtenerVehiculo(placa);
            if (!recepcionista.asignarPaquetesAVehiculo(vehiculo, destino)) {
                JOptionPane.showMessageDialog(this, "No existen paquetes", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        refrescarAsignacion();
    }// GEN-LAST:event_jButton1ActionPerformed

    private void jTPlacaVehiculo3FocusLost(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_jTPlacaVehiculo3FocusLost
        // TODO add your handling code here:
    }// GEN-LAST:event_jTPlacaVehiculo3FocusLost

    private void jTPlacaVehiculo3ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jTPlacaVehiculo3ActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_jTPlacaVehiculo3ActionPerformed

    private void jTPlacaVehiculo3KeyReleased(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_jTPlacaVehiculo3KeyReleased
        // TODO add your handling code here:
    }// GEN-LAST:event_jTPlacaVehiculo3KeyReleased

    private void jTPlacaVehiculo3KeyTyped(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_jTPlacaVehiculo3KeyTyped
        // TODO add your handling code here:
    }// GEN-LAST:event_jTPlacaVehiculo3KeyTyped

    private void jTCapacidad1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jTCapacidad1ActionPerformed

    }// GEN-LAST:event_jTCapacidad1ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BActualizar;
    private javax.swing.JComboBox<String> JComboDestino1;
    private javax.swing.JButton bRegistrarVehiculo;
    private javax.swing.JButton bSeleccionarConductor;
    private javax.swing.JButton jButton1;
    private javax.swing.JTable jInventarioVehiculo;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JPanel jPAE;
    private javax.swing.JPanel jPCE;
    private javax.swing.JPanel jPDatosEmpleados;
    private javax.swing.JPanel jPDatosRecuperadosEmpleados;
    private javax.swing.JPanel jPEE;
    private javax.swing.JPanel jPEmpleadosTab;
    private javax.swing.JPanel jPRE;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel45;
    private javax.swing.JPanel jPanel46;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane25;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JTextField jTCapacidad;
    private javax.swing.JTextField jTCapacidadVehiculo;
    private javax.swing.JTextField jTCedula2;
    private javax.swing.JTextField jTCedula3;
    private javax.swing.JTextField jTCorreo;
    private javax.swing.JTextField jTCorreo1;
    private javax.swing.JTextField jTNombreDespachador1;
    private javax.swing.JTextField jTNombreDespachador3;
    private javax.swing.JTabbedPane jTPEmpleados;
    private javax.swing.JTextField jTPlacaVehiculo;
    private javax.swing.JTextField jTPlacaVehiculo1;
    private javax.swing.JTextField jTPlacaVehiculo2;
    private javax.swing.JTextField jTPlacaVehiculo3;
    private javax.swing.JTextField jTTelefono;
    private javax.swing.JTextField jTTelefono1;
    private javax.swing.JTable jTablaVehiculos;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
