/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;
import basededatos.DataBase;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.Color;
import java.text.SimpleDateFormat;
import javax.swing.JFrame;
import javax.swing.JRootPane;
import java.sql.Connection;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import mod_administracion.Conductor;
import mod_paquetes.Provincia;
import mod_transporte.Asignacion;
import mod_transporte.Vehiculo;
import validaciones.*;

/**
 *
 * @author USUARIO
 */
public class JFRecepcionista extends javax.swing.JFrame {
    
    ValidadorDeRegistros validarRegistroF = new ValidadorDeRegistros();
    ValidadorDeSwings validadorCheck = new ValidadorDeSwings();
    //Recepcionista
    private boolean cedulaEmpleadoValidar = false;
    private boolean nombreEmpleadoValidar = false;
    private boolean apellidoEmpleadoValidar = false;
    private boolean cargoEmpleadoValidar = false;
    private boolean direccionEmpleadoValidar = false;
    private boolean telefonoConvenValidar = false;
    private boolean telefonoEmpleadoValiar = false;
    private boolean correoEmpleadoValidar = false;
    //Actualizar
    private boolean cargoEmpleadoValidar1 = false;
    private boolean direccionEmpleadoValidar1 = false;
    private boolean telefonoConvenValidar1 = false;
    private boolean telefonoEmpleadoValiar1 = false;
    private boolean correoEmpleadoValidar1 = false;
    private Provincia sucursal;
    //Conexion
    Connection cnx;
    //Mouse
    int xMouse, yMouse; 
    public JFRecepcionista(Connection cnx, Provincia sucursal) {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/iconos/icons8_Monitor_32px.png")).getImage());
        this.cnx=cnx;
        //All Files	C:\Users\USUARIO\GitHub\PROYECTO_DELIVERY\PROYECTO_ENCOMIENDA\src\proyecto_encomienda\GESTION_PAQUETES\FRONTEND\imagenes\caja.png
        JFrame frame = new JFrame();
        frame.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        setLocationRelativeTo(null);
        this.sucursal = sucursal;
        // Opcional: Deshabilita la edición manual del campo de texto

    }
    
    public JFRecepcionista() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/proyecto_encomienda/GESTION_PAQUETES/FRONTEND/imagenes/icons8_Monitor_32px.png")).getImage());
        JFrame frame = new JFrame();
        frame.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        setLocationRelativeTo(null);
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
  
   private String getValueAtSelectedRow(DefaultTableModel model, int selectedRow, String columnName) {
        int colIndex = model.findColumn(columnName);
        return colIndex != -1 ? model.getValueAt(selectedRow, colIndex).toString() : "";
    }
   

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSlider1 = new javax.swing.JSlider();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPEmpleadosTab = new javax.swing.JPanel();
        jTPEmpleados = new javax.swing.JTabbedPane();
        jPRE = new javax.swing.JPanel();
        jPDatosEmpleados = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jTCapacidadVehiculo = new javax.swing.JTextField();
        jPanel44 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        bRegistrarVehiculo = new javax.swing.JButton();
        jTPlacaVehiculo = new javax.swing.JTextField();
        jPCE = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTableEmpleadosAcutalizar2 = new javax.swing.JTable();
        jTPlacaVehiculo1 = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jTCapacidad = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
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
        jPEE = new javax.swing.JPanel();
        jScrollPane25 = new javax.swing.JScrollPane();
        jTableEmpleadosAcutalizar3 = new javax.swing.JTable();
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
        jScrollPane24 = new javax.swing.JScrollPane();
        jTableEmpleadosAcutalizar1 = new javax.swing.JTable();
        BActualizar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel69 = new javax.swing.JLabel();
        btnExit = new javax.swing.JButton();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setTitle("Registro de Empleados");
        setUndecorated(true);
        getContentPane().setLayout(new java.awt.CardLayout());

        jTPEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTPEmpleadosMouseClicked(evt);
            }
        });

        jPRE.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPDatosEmpleados.setBorder(javax.swing.BorderFactory.createTitledBorder("Ingresar datos de un empleado"));

        jLabel27.setText("Capacidad");

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

        jPanel44.setBorder(javax.swing.BorderFactory.createTitledBorder("Conductor Asignado"));

        javax.swing.GroupLayout jPanel44Layout = new javax.swing.GroupLayout(jPanel44);
        jPanel44.setLayout(jPanel44Layout);
        jPanel44Layout.setHorizontalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel44Layout.setVerticalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 207, Short.MAX_VALUE)
        );

        jLabel32.setText("Placa");

        bRegistrarVehiculo.setText("Registrar Vehiculo");
        bRegistrarVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRegistrarVehiculoActionPerformed(evt);
            }
        });

        jTPlacaVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTPlacaVehiculoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPDatosEmpleadosLayout = new javax.swing.GroupLayout(jPDatosEmpleados);
        jPDatosEmpleados.setLayout(jPDatosEmpleadosLayout);
        jPDatosEmpleadosLayout.setHorizontalGroup(
            jPDatosEmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPDatosEmpleadosLayout.createSequentialGroup()
                .addGap(839, 839, 839)
                .addComponent(jPanel44, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(578, 578, 578))
            .addGroup(jPDatosEmpleadosLayout.createSequentialGroup()
                .addGroup(jPDatosEmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPDatosEmpleadosLayout.createSequentialGroup()
                        .addGroup(jPDatosEmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPDatosEmpleadosLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPDatosEmpleadosLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel27)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPDatosEmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTCapacidadVehiculo, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                            .addComponent(jTPlacaVehiculo)))
                    .addGroup(jPDatosEmpleadosLayout.createSequentialGroup()
                        .addGap(290, 290, 290)
                        .addComponent(bRegistrarVehiculo)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPDatosEmpleadosLayout.setVerticalGroup(
            jPDatosEmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPDatosEmpleadosLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPDatosEmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTPlacaVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPDatosEmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(jTCapacidadVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(bRegistrarVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel44, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67))
        );

        jPanel44.getAccessibleContext().setAccessibleName("Conductor Asignado\n");

        jPRE.add(jPDatosEmpleados, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 28, 843, -1));

        jTPEmpleados.addTab("Registrar Vehiculo", jPRE);

        jTableEmpleadosAcutalizar2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane6.setViewportView(jTableEmpleadosAcutalizar2);

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

        jLabel33.setText("Placa");

        jLabel28.setText("Capacidad");

        jTCapacidad.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTCapacidad.setEnabled(false);

        jLabel29.setText("Conductor");

        jPanel45.setBorder(javax.swing.BorderFactory.createTitledBorder("Conductor Asignado"));

        jTNombreDespachador1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTNombreDespachador1.setEnabled(false);
        jTNombreDespachador1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTNombreDespachador1ActionPerformed(evt);
            }
        });

        jTTelefono.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTTelefono.setEnabled(false);

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

        jLabel31.setText("Cedula");

        jLabel34.setText("Nombres");

        jLabel35.setText("Telefono");

        jLabel36.setText("Correo");

        jTCedula3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTCedula3.setEnabled(false);

        javax.swing.GroupLayout jPanel45Layout = new javax.swing.GroupLayout(jPanel45);
        jPanel45.setLayout(jPanel45Layout);
        jPanel45Layout.setHorizontalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel45Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel34, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                    .addComponent(jLabel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTCorreo, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                    .addComponent(jTNombreDespachador1)
                    .addComponent(jTTelefono)
                    .addComponent(jTCedula3))
                .addContainerGap())
        );
        jPanel45Layout.setVerticalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel45Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(jTCedula3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTNombreDespachador1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel34))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel35))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        bSeleccionarConductor.setText("Buscar Vehiculo");
        bSeleccionarConductor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSeleccionarConductorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPCELayout = new javax.swing.GroupLayout(jPCE);
        jPCE.setLayout(jPCELayout);
        jPCELayout.setHorizontalGroup(
            jPCELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPCELayout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
                .addGroup(jPCELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel45, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPCELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPCELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPCELayout.createSequentialGroup()
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 892, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24))
                            .addGroup(jPCELayout.createSequentialGroup()
                                .addGroup(jPCELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel28))
                                .addGap(18, 18, 18)
                                .addGroup(jPCELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTPlacaVehiculo1, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                                    .addComponent(jTCapacidad))
                                .addGap(18, 18, 18)
                                .addComponent(bSeleccionarConductor)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPCELayout.createSequentialGroup()
                            .addComponent(jLabel29)
                            .addGap(860, 860, 860)))))
        );
        jPCELayout.setVerticalGroup(
            jPCELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCELayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPCELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTPlacaVehiculo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPCELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(jTCapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bSeleccionarConductor, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel29)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel45, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jTPEmpleados.addTab("Consultar", jPCE);

        jTableEmpleadosAcutalizar3.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane25.setViewportView(jTableEmpleadosAcutalizar3);

        javax.swing.GroupLayout jPEELayout = new javax.swing.GroupLayout(jPEE);
        jPEE.setLayout(jPEELayout);
        jPEELayout.setHorizontalGroup(
            jPEELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPEELayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jScrollPane25, javax.swing.GroupLayout.PREFERRED_SIZE, 920, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPEELayout.setVerticalGroup(
            jPEELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPEELayout.createSequentialGroup()
                .addContainerGap(132, Short.MAX_VALUE)
                .addComponent(jScrollPane25, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(320, 320, 320))
        );

        jTPEmpleados.addTab("Cambiar de estado", jPEE);

        jPAE.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPDatosRecuperadosEmpleados.setBorder(javax.swing.BorderFactory.createTitledBorder("Asignar Conductor"));
        jPDatosRecuperadosEmpleados.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel38.setText("Placa");
        jPDatosRecuperadosEmpleados.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 34, 22));

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
        jPDatosRecuperadosEmpleados.add(jTPlacaVehiculo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, 210, -1));

        jPanel46.setBorder(javax.swing.BorderFactory.createTitledBorder("Conductor Asignado"));
        jPanel46.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTNombreDespachador3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTNombreDespachador3.setEnabled(false);
        jTNombreDespachador3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTNombreDespachador3ActionPerformed(evt);
            }
        });
        jPanel46.add(jTNombreDespachador3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 206, -1));

        jTTelefono1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTTelefono1.setEnabled(false);
        jPanel46.add(jTTelefono1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, 206, -1));

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
        jPanel46.add(jTCorreo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, 206, -1));

        jLabel39.setText("Cedula");
        jPanel46.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 55, -1));

        jLabel40.setText("Nombres");
        jPanel46.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 55, -1));

        jLabel41.setText("Telefono");
        jPanel46.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 55, -1));

        jLabel42.setText("Correo");
        jPanel46.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 55, -1));

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
        jPanel46.add(jTCedula2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 206, -1));

        jPDatosRecuperadosEmpleados.add(jPanel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, -1, 140));

        jPAE.add(jPDatosRecuperadosEmpleados, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 390, 270));

        jTableEmpleadosAcutalizar1.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableEmpleadosAcutalizar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableEmpleadosAcutalizar1MouseClicked(evt);
            }
        });
        jScrollPane24.setViewportView(jTableEmpleadosAcutalizar1);

        jPAE.add(jScrollPane24, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 332, 878, 109));

        BActualizar.setText("Asignar");
        BActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BActualizarActionPerformed(evt);
            }
        });
        jPAE.add(BActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 280, -1, -1));

        jTPEmpleados.addTab("Actualizar", jPAE);

        jPanel3.setBackground(new java.awt.Color(146, 10, 48));
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

        jLabel69.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel69.setForeground(new java.awt.Color(255, 255, 255));
        jLabel69.setText("Reccepcionista");

        btnExit.setForeground(new java.awt.Color(255, 255, 255));
        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/power_24dp.png"))); // NOI18N
        btnExit.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnExit.setContentAreaFilled(false);
        btnExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel69)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel69)
                    .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPEmpleadosTabLayout = new javax.swing.GroupLayout(jPEmpleadosTab);
        jPEmpleadosTab.setLayout(jPEmpleadosTabLayout);
        jPEmpleadosTabLayout.setHorizontalGroup(
            jPEmpleadosTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPEmpleadosTabLayout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(jTPEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, 965, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 61, Short.MAX_VALUE))
        );
        jPEmpleadosTabLayout.setVerticalGroup(
            jPEmpleadosTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPEmpleadosTabLayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jTPEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, 601, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(jPEmpleadosTab, "card2");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTCapacidadVehiculoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTCapacidadVehiculoFocusLost
    }//GEN-LAST:event_jTCapacidadVehiculoFocusLost

    private void jTCapacidadVehiculoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTCapacidadVehiculoKeyReleased
    }//GEN-LAST:event_jTCapacidadVehiculoKeyReleased

    private void jTableEmpleadosAcutalizar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableEmpleadosAcutalizar1MouseClicked
        
    }//GEN-LAST:event_jTableEmpleadosAcutalizar1MouseClicked

    private void BActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BActualizarActionPerformed
        String placa = jTPlacaVehiculo2.getText();
        String cedula = jTCedula2.getText();
        if(placa.isEmpty() || cedula.isEmpty()){
            JOptionPane.showMessageDialog(this, "El campo está vacío.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!ValidadorDeRegistros.validarPlaca(placa)) {
            JOptionPane.showMessageDialog(this, "La placa no es válida.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        } else if(!ValidadorDeRegistros.validarCedula(cedula)){
                JOptionPane.showMessageDialog(this, "La cedula no es válida.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }else {
            Asignacion asignacion = Asignacion.obtenerInstancia();
            Vehiculo vehiculo = asignacion.obtenerVehiculo(placa);
            if (vehiculo == null) {
                JOptionPane.showMessageDialog(this, "No existe un vehículo con la placa " + placa, "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            Conductor conductor = asignacion.obtenerConductorPorCedula(cedula);
            if(conductor == null){
                JOptionPane.showMessageDialog(this, "No existe un conductor con la cedula " + cedula, "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            jTNombreDespachador3.setText(conductor.getNombres() + " " +conductor.getApellidos());
            jTTelefono1.setText(conductor.getTelefono());
            jTCorreo1.setText(conductor.getEmail());
            asignacion.asignarConductorAVehiculo(conductor,vehiculo);
            
        }
    }//GEN-LAST:event_BActualizarActionPerformed

    private void jTPEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTPEmpleadosMouseClicked


    }//GEN-LAST:event_jTPEmpleadosMouseClicked

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        getToolkit().beep();
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(null, "Estas seguro de quieres cerrar la ventana?", "Warning", dialogButton);
        if (dialogResult == JOptionPane.YES_OPTION) {
            this.dispose();
        }
    }//GEN-LAST:event_btnExitActionPerformed

    private void jPanel3MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_jPanel3MouseDragged

    private void jPanel3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_jPanel3MousePressed

    private void jTCapacidadVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTCapacidadVehiculoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTCapacidadVehiculoActionPerformed

    private void bRegistrarVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRegistrarVehiculoActionPerformed
        Asignacion asignacion = Asignacion.obtenerInstancia();
        double capacidad = Double.parseDouble(jTCapacidadVehiculo.getText());
        Vehiculo vehiculo = new Vehiculo(jTPlacaVehiculo.getText(),capacidad, sucursal);
        asignacion.agregarVehiculo(vehiculo);
        JOptionPane.showMessageDialog(this, "El vehiculo se registro con exito");
    }//GEN-LAST:event_bRegistrarVehiculoActionPerformed

    private void jTPlacaVehiculo1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTPlacaVehiculo1FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jTPlacaVehiculo1FocusLost

    private void jTPlacaVehiculo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTPlacaVehiculo1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTPlacaVehiculo1ActionPerformed

    private void jTPlacaVehiculo1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTPlacaVehiculo1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTPlacaVehiculo1KeyReleased

    private void jTPlacaVehiculo1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTPlacaVehiculo1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTPlacaVehiculo1KeyTyped

    private void jTCorreoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTCorreoFocusLost

    }//GEN-LAST:event_jTCorreoFocusLost

    private void jTCorreoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTCorreoKeyReleased

    }//GEN-LAST:event_jTCorreoKeyReleased

    private void bSeleccionarConductorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSeleccionarConductorActionPerformed
        String placa = jTPlacaVehiculo1.getText();
        if(placa.isEmpty()){
            JOptionPane.showMessageDialog(this, "El campo de la placa está vacío.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!ValidadorDeRegistros.validarPlaca(placa)) {
            JOptionPane.showMessageDialog(this, "La placa no es válida.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            Asignacion asignacion = Asignacion.obtenerInstancia();
            Vehiculo vehiculo = asignacion.obtenerVehiculo(placa);
            if (vehiculo == null) {
                JOptionPane.showMessageDialog(this, "No existe un vehículo con la placa " + placa, "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            Conductor conductor = asignacion.obtenerConductorDeVehiculo(vehiculo);
            jTCapacidad.setText(Double.toString(vehiculo.getCapacidad()));
            if(conductor != null){
                jTCedula3.setText(conductor.getCedula());
                jTNombreDespachador1.setText(conductor.getNombres()+" "+ conductor.getApellidos());
                jTTelefono.setText(conductor.getTelefono());
                jTCorreo.setText(conductor.getEmail());
                return;
            }
            jTCedula3.setText("No existe conductor asignado");
            jTNombreDespachador1.setText("No existe conductor asignado");
            jTTelefono.setText("No existe conductor asignado");
            jTCorreo.setText("No existe conductor asignado");
        }
    }//GEN-LAST:event_bSeleccionarConductorActionPerformed

    private void jTNombreDespachador1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTNombreDespachador1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTNombreDespachador1ActionPerformed

    private void jTCedula2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTCedula2FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jTCedula2FocusLost

    private void jTCedula2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTCedula2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTCedula2ActionPerformed

    private void jTCedula2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTCedula2KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTCedula2KeyReleased

    private void jTCedula2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTCedula2KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTCedula2KeyTyped

    private void jTNombreDespachador3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTNombreDespachador3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTNombreDespachador3ActionPerformed

    private void jTCorreo1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTCorreo1FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jTCorreo1FocusLost

    private void jTCorreo1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTCorreo1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTCorreo1KeyReleased

    private void jTCorreo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTCorreo1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTCorreo1ActionPerformed

    private void jTPlacaVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTPlacaVehiculoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTPlacaVehiculoActionPerformed

    private void jTPlacaVehiculo2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTPlacaVehiculo2KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTPlacaVehiculo2KeyTyped

    private void jTPlacaVehiculo2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTPlacaVehiculo2KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTPlacaVehiculo2KeyReleased

    private void jTPlacaVehiculo2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTPlacaVehiculo2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTPlacaVehiculo2ActionPerformed

    private void jTPlacaVehiculo2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTPlacaVehiculo2FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jTPlacaVehiculo2FocusLost

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFRecepcionista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFRecepcionista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFRecepcionista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFRecepcionista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFRecepcionista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BActualizar;
    private javax.swing.JButton bRegistrarVehiculo;
    private javax.swing.JButton bSeleccionarConductor;
    private javax.swing.JButton btnExit;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JPanel jPAE;
    private javax.swing.JPanel jPCE;
    private javax.swing.JPanel jPDatosEmpleados;
    private javax.swing.JPanel jPDatosRecuperadosEmpleados;
    private javax.swing.JPanel jPEE;
    private javax.swing.JPanel jPEmpleadosTab;
    private javax.swing.JPanel jPRE;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel44;
    private javax.swing.JPanel jPanel45;
    private javax.swing.JPanel jPanel46;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane24;
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
    private javax.swing.JTextField jTTelefono;
    private javax.swing.JTextField jTTelefono1;
    private javax.swing.JTable jTableEmpleadosAcutalizar1;
    private javax.swing.JTable jTableEmpleadosAcutalizar2;
    private javax.swing.JTable jTableEmpleadosAcutalizar3;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
