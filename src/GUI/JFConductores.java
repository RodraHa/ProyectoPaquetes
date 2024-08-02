/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import javax.swing.JFrame;
import javax.swing.JRootPane;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.util.List;
import javax.swing.JLabel;
import mod_administracion.Recepcionista;
import validaciones.*;


/**
 *
 * @author USUARIO
 */
public class JFConductores extends javax.swing.JFrame {
//Validadores

    ValidadorDeRegistros validarRegistroF = new ValidadorDeRegistros();
    ValidadorDeSwings validadorCheck = new ValidadorDeSwings();
    private Recepcionista recepcionista;
//Conductores
    private boolean cIConductor = false;
    private boolean nombreConductor = false;
    private boolean cedulaConductorValidar = false;
    private boolean nombreConductorValidar = false;
    private boolean apellidoConductorValidar = false;
    private boolean telefonoConductorValidar = false;
    private boolean rucConductorValidar=false;
    private boolean nomb=false;
//ConductoresActualizar
    private boolean cIConductor1 = false;
    private boolean nombreEmpresaProve1 = false;
    private boolean cedulaProve1 = false;
    private boolean nombreProve1 = false;
    private boolean apellidoProve1 = false;
    private boolean telefonoProve1 = false;
//Mouse
    int xMouse, yMouse;

    public JFConductores(Recepcionista recepcionista) {
        initComponents();
        this.recepcionista = recepcionista;
        setIconImage(new ImageIcon(getClass().getResource("/iconos/exclamacion.png")).getImage());
        JFrame frame = new JFrame();
        frame.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        setLocationRelativeTo(null);
     }

    private String getValueAtSelectedRow(DefaultTableModel model, int selectedRow, String columnName) {
        int colIndex = model.findColumn(columnName);
        return colIndex != -1 ? model.getValueAt(selectedRow, colIndex).toString() : "";
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JPProovedores = new javax.swing.JPanel();
        jPGP = new javax.swing.JTabbedPane();
        jPPR = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        jTConductores = new javax.swing.JTable();
        jPanel15 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jTCedulaConductor = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jTNombreConductor = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jTApellidoConductor = new javax.swing.JTextField();
        jLabel107 = new javax.swing.JLabel();
        jTTelefonoConductor = new javax.swing.JTextField();
        jLabel87 = new javax.swing.JLabel();
        jTCorreoConductor = new javax.swing.JTextField();
        jLabel73 = new javax.swing.JLabel();
        jTDireccionConductor = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jTClaveConductor = new javax.swing.JTextField();
        jTNombreUsuario1 = new javax.swing.JTextField();
        jBRegistrarConductor = new javax.swing.JButton();
        jPPA = new javax.swing.JPanel();
        jPActualizarProovedores = new javax.swing.JPanel();
        jPanel25 = new javax.swing.JPanel();
        jPanel24 = new javax.swing.JPanel();
        jTCedulaDespachadorAct = new javax.swing.JTextField();
        jTNombreDespachadorAct = new javax.swing.JTextField();
        jTApellidoDespachadorAct = new javax.swing.JTextField();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jCheckBox5 = new javax.swing.JCheckBox();
        jCheckBox8 = new javax.swing.JCheckBox();
        jTTelefonoConductorActualizar = new javax.swing.JTextField();
        errorProveedores7 = new javax.swing.JLabel();
        jPPC = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel69 = new javax.swing.JLabel();
        btnExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.CardLayout());

        JPProovedores.setBackground(new java.awt.Color(245, 245, 245));
        JPProovedores.setMinimumSize(new java.awt.Dimension(810, 540));
        JPProovedores.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPPR.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTConductores.setModel(new javax.swing.table.DefaultTableModel(
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
        jTConductores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTConductoresMouseClicked(evt);
            }
        });
        jScrollPane11.setViewportView(jTConductores);

        jPPR.add(jScrollPane11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 975, 220));

        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos conductor"));
        jPanel15.setToolTipText("");

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos personales del conductor"));

        jLabel21.setText("Cédula");

        jTCedulaConductor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTCedulaConductorFocusLost(evt);
            }
        });
        jTCedulaConductor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTCedulaConductorKeyReleased(evt);
            }
        });

        jLabel22.setText("Nombres");

        jTNombreConductor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTNombreConductorFocusLost(evt);
            }
        });
        jTNombreConductor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTNombreConductorKeyReleased(evt);
            }
        });

        jLabel23.setText("Apellido");

        jTApellidoConductor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTApellidoConductorFocusLost(evt);
            }
        });
        jTApellidoConductor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTApellidoConductorKeyReleased(evt);
            }
        });

        jLabel107.setText("Teléfono");

        jTTelefonoConductor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTTelefonoConductorFocusLost(evt);
            }
        });
        jTTelefonoConductor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTTelefonoConductorKeyReleased(evt);
            }
        });

        jLabel87.setText("Correo");

        jTCorreoConductor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTCorreoConductorFocusLost(evt);
            }
        });
        jTCorreoConductor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTCorreoConductorKeyReleased(evt);
            }
        });

        jLabel73.setText("Dirección");

        jTDireccionConductor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTDireccionConductorFocusLost(evt);
            }
        });
        jTDireccionConductor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTDireccionConductorKeyReleased(evt);
            }
        });

        jLabel25.setText("Nombre de usuario");

        jLabel26.setText("Clave");

        jTClaveConductor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTClaveConductorFocusLost(evt);
            }
        });
        jTClaveConductor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTClaveConductorKeyReleased(evt);
            }
        });

        jTNombreUsuario1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTNombreUsuario1FocusLost(evt);
            }
        });
        jTNombreUsuario1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTNombreUsuario1KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel73)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTDireccionConductor, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel87, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTCorreoConductor))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22)
                            .addComponent(jLabel21)
                            .addComponent(jLabel23)
                            .addComponent(jLabel107))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTTelefonoConductor)
                            .addComponent(jTApellidoConductor, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTNombreConductor, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTCedulaConductor, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE))))
                .addGap(52, 52, 52)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel25)
                    .addComponent(jTClaveConductor, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26)
                    .addComponent(jTNombreUsuario1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(75, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTCedulaConductor, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25))
                        .addGap(2, 2, 2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel21)))
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jTNombreUsuario1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTClaveConductor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTNombreConductor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22))
                        .addGap(9, 9, 9)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTApellidoConductor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTTelefonoConductor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel107))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel87)
                            .addComponent(jTCorreoConductor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel73)
                            .addComponent(jTDireccionConductor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jBRegistrarConductor.setText("Registrar datos");
        jBRegistrarConductor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBRegistrarConductorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(230, 230, 230)
                .addComponent(jBRegistrarConductor)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jBRegistrarConductor)
                .addContainerGap())
        );

        jPPR.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, 660, 310));

        jPGP.addTab("Registrar Conductor", jPPR);

        jPPA.setPreferredSize(new java.awt.Dimension(790, 459));
        jPPA.setLayout(new java.awt.CardLayout());

        jPActualizarProovedores.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPActualizarProovedores.setToolTipText("");
        jPActualizarProovedores.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel25.setBorder(javax.swing.BorderFactory.createTitledBorder("Actualizar proveedor"));

        jPanel24.setBorder(javax.swing.BorderFactory.createTitledBorder("Despachador"));

        jTCedulaDespachadorAct.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTCedulaDespachadorAct.setEnabled(false);

        jTNombreDespachadorAct.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTNombreDespachadorAct.setEnabled(false);

        jTApellidoDespachadorAct.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTApellidoDespachadorAct.setEnabled(false);

        jCheckBox3.setSelected(true);
        jCheckBox3.setText("Cédula");
        jCheckBox3.setEnabled(false);

        jCheckBox4.setSelected(true);
        jCheckBox4.setText("Nombre");
        jCheckBox4.setEnabled(false);

        jCheckBox5.setSelected(true);
        jCheckBox5.setText("Apellido");
        jCheckBox5.setEnabled(false);

        jCheckBox8.setText("Teléfono");
        jCheckBox8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox8ActionPerformed(evt);
            }
        });

        jTTelefonoConductorActualizar.setEnabled(false);
        jTTelefonoConductorActualizar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTTelefonoConductorActualizarFocusLost(evt);
            }
        });
        jTTelefonoConductorActualizar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTTelefonoConductorActualizarKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox3)
                            .addComponent(jCheckBox4)
                            .addComponent(jCheckBox5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTCedulaDespachadorAct, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                            .addComponent(jTNombreDespachadorAct)
                            .addComponent(jTApellidoDespachadorAct)))
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addComponent(jCheckBox8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTTelefonoConductorActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTCedulaDespachadorAct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTNombreDespachadorAct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTApellidoDespachadorAct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox8)
                    .addComponent(jTTelefonoConductorActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        errorProveedores7.setForeground(new java.awt.Color(255, 0, 51));
        errorProveedores7.setText("Teléfono móvil inválido");

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(errorProveedores7)
                .addContainerGap(238, Short.MAX_VALUE))
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel25Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel25Layout.createSequentialGroup()
                        .addComponent(errorProveedores7)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout jPActualizarProovedoresLayout = new javax.swing.GroupLayout(jPActualizarProovedores);
        jPActualizarProovedores.setLayout(jPActualizarProovedoresLayout);
        jPActualizarProovedoresLayout.setHorizontalGroup(
            jPActualizarProovedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPActualizarProovedoresLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jPanel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(309, 309, 309))
        );
        jPActualizarProovedoresLayout.setVerticalGroup(
            jPActualizarProovedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPActualizarProovedoresLayout.createSequentialGroup()
                .addContainerGap(82, Short.MAX_VALUE)
                .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(234, 234, 234))
        );

        jPPA.add(jPActualizarProovedores, "cardActualizar");

        jPGP.addTab("Asignar Conductor a Vehiculo", jPPA);

        javax.swing.GroupLayout jPPCLayout = new javax.swing.GroupLayout(jPPC);
        jPPC.setLayout(jPPCLayout);
        jPPCLayout.setHorizontalGroup(
            jPPCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1030, Short.MAX_VALUE)
        );
        jPPCLayout.setVerticalGroup(
            jPPCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 565, Short.MAX_VALUE)
        );

        jPGP.addTab("Eliminar Conductor", jPPC);

        JPProovedores.add(jPGP, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 1030, 600));

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
        jLabel69.setText("Gestion de Envios");

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 990, Short.MAX_VALUE)
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

        JPProovedores.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1130, -1));

        getContentPane().add(JPProovedores, "card3");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTConductoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTConductoresMouseClicked

    }//GEN-LAST:event_jTConductoresMouseClicked

    private void jTCedulaConductorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTCedulaConductorFocusLost
        //cedulaConductorValidar = validarRegistroF.camposDeRegistros(jTCedulaConductor, errorProveedores3, "cedula");
    }//GEN-LAST:event_jTCedulaConductorFocusLost

    private void jTCedulaConductorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTCedulaConductorKeyReleased
        //cedulaConductorValidar = validarRegistroF.camposDeRegistros(jTCedulaConductor, errorProveedores3, "cedula");
    }//GEN-LAST:event_jTCedulaConductorKeyReleased

    private void jTNombreConductorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTNombreConductorFocusLost
        //nombreConductorValidar = validarRegistroF.camposDeRegistros(jTNombreConductor, errorProveedores4, "n");
    }//GEN-LAST:event_jTNombreConductorFocusLost

    private void jTNombreConductorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTNombreConductorKeyReleased
        //nombreConductorValidar = validarRegistroF.camposDeRegistros(jTNombreConductor, errorProveedores4, "n");
    }//GEN-LAST:event_jTNombreConductorKeyReleased

    private void jTApellidoConductorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTApellidoConductorFocusLost
        //apellidoConductorValidar = validarRegistroF.camposDeRegistros(jTApellidoConductor, errorProveedores5, "n");
    }//GEN-LAST:event_jTApellidoConductorFocusLost

    private void jTApellidoConductorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTApellidoConductorKeyReleased
        //apellidoConductorValidar = validarRegistroF.camposDeRegistros(jTApellidoConductor, errorProveedores5, "n");
    }//GEN-LAST:event_jTApellidoConductorKeyReleased

    private void jTTelefonoConductorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTTelefonoConductorFocusLost
        //telefonoConductorValidar = validarRegistroF.camposDeRegistros(jTTelefonoConductor, errorProveedores6, "telefono");
    }//GEN-LAST:event_jTTelefonoConductorFocusLost

    private void jTTelefonoConductorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTTelefonoConductorKeyReleased
        //telefonoConductorValidar = validarRegistroF.camposDeRegistros(jTTelefonoConductor, errorProveedores6, "telefono");
    }//GEN-LAST:event_jTTelefonoConductorKeyReleased

    private void jBRegistrarConductorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRegistrarConductorActionPerformed
        
    }//GEN-LAST:event_jBRegistrarConductorActionPerformed

    private void jCheckBox8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox8ActionPerformed
        validadorCheck.actualizarCampo(jCheckBox8, jTTelefonoConductorActualizar, telefonoProve1, errorProveedores7);
    }//GEN-LAST:event_jCheckBox8ActionPerformed

    private void jTTelefonoConductorActualizarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTTelefonoConductorActualizarFocusLost
        telefonoProve1 = validarRegistroF.camposDeRegistros(jTTelefonoConductorActualizar, errorProveedores7, "telefono");
    }//GEN-LAST:event_jTTelefonoConductorActualizarFocusLost

    private void jTTelefonoConductorActualizarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTTelefonoConductorActualizarKeyReleased
        telefonoProve1 = validarRegistroF.camposDeRegistros(jTTelefonoConductorActualizar, errorProveedores7, "telefono");
    }//GEN-LAST:event_jTTelefonoConductorActualizarKeyReleased

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

    private void jTCorreoConductorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTCorreoConductorFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jTCorreoConductorFocusLost

    private void jTCorreoConductorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTCorreoConductorKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTCorreoConductorKeyReleased

    private void jTDireccionConductorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTDireccionConductorFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jTDireccionConductorFocusLost

    private void jTDireccionConductorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTDireccionConductorKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTDireccionConductorKeyReleased

    private void jTClaveConductorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTClaveConductorFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jTClaveConductorFocusLost

    private void jTClaveConductorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTClaveConductorKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTClaveConductorKeyReleased

    private void jTNombreUsuario1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTNombreUsuario1FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jTNombreUsuario1FocusLost

    private void jTNombreUsuario1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTNombreUsuario1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTNombreUsuario1KeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JPProovedores;
    private javax.swing.JButton btnExit;
    private javax.swing.JLabel errorProveedores7;
    private javax.swing.JButton jBRegistrarConductor;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox8;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JPanel jPActualizarProovedores;
    private javax.swing.JTabbedPane jPGP;
    private javax.swing.JPanel jPPA;
    private javax.swing.JPanel jPPC;
    private javax.swing.JPanel jPPR;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JTextField jTApellidoConductor;
    private javax.swing.JTextField jTApellidoDespachadorAct;
    private javax.swing.JTextField jTCedulaConductor;
    private javax.swing.JTextField jTCedulaDespachadorAct;
    private javax.swing.JTextField jTClaveConductor;
    private javax.swing.JTable jTConductores;
    private javax.swing.JTextField jTCorreoConductor;
    private javax.swing.JTextField jTDireccionConductor;
    private javax.swing.JTextField jTNombreConductor;
    private javax.swing.JTextField jTNombreDespachadorAct;
    private javax.swing.JTextField jTNombreUsuario1;
    private javax.swing.JTextField jTTelefonoConductor;
    private javax.swing.JTextField jTTelefonoConductorActualizar;
    // End of variables declaration//GEN-END:variables
}
