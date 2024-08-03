/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import mod_incidentes.ErrorDireccion;
import mod_incidentes.GestorIncidente;
import mod_incidentes.Incidente;
import mod_incidentes.PaqueteEstropeado;
import mod_incidentes.PaquetePerdido;
import java.sql.Connection;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import mod_administracion.Recepcionista;
import mod_paquetes.Inventario;
import mod_paquetes.Paquete;
import mod_paquetes.Pendiente;
import mod_paquetes.Seguimiento;
import validaciones.*;


/**
 *
 * @author Moises Arequipa
 * @Grupo: Segunda es Todo
 */
public class JFIncidente extends javax.swing.JFrame {

    /**
     * Creates new form JFIncidente
     */
    //Validadores
    ValidadorDeRegistros validarRegistroF = new ValidadorDeRegistros();
    ValidadorDeSwings validadorCheck = new ValidadorDeSwings();
    Recepcionista recepcionista;
    
    //Mouse
    int xMouse, yMouse;

    //Incidentes
    private boolean idIncidenteValidar = false;
    private boolean descriptionValidar = false;
    private boolean seleccionValidar = false;

    public JFIncidente(Recepcionista recepcionista) {
        initComponents();
        this.recepcionista = recepcionista;
        setIconImage(new ImageIcon(getClass().getResource("/iconos/exclamacion.png")).getImage());
        JFrame frame = new JFrame();
        frame.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        setLocationRelativeTo(null);
        placeHolder();
        jBRegistrarIncidente.setVisible(false);
        jTablaPaquete.setVisible(false);
        cargarIncidentes();
    }

    private void placeHolder() {
        TextPrompt texto1 = new TextPrompt("Obligatorio", jTCodigoTracking);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JPIncidentes = new javax.swing.JPanel();
        jPIncidentes = new javax.swing.JPanel();
        jTPEmpleados1 = new javax.swing.JTabbedPane();
        jPRE1 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        seleccionIncidentes = new javax.swing.JComboBox<>();
        jLabel133 = new javax.swing.JLabel();
        jLabel134 = new javax.swing.JLabel();
        jTCodigoTracking = new javax.swing.JTextField();
        jBConsultarPaquete = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTablaPaquete = new javax.swing.JTable();
        jBRegistrarIncidente = new javax.swing.JButton();
        jPAE1 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        seleccionIncidentes1 = new javax.swing.JComboBox<>();
        jLabel136 = new javax.swing.JLabel();
        jLabel137 = new javax.swing.JLabel();
        jTCodigoResolver = new javax.swing.JTextField();
        jBConsultarIncidente = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTIncidente = new javax.swing.JTable();
        jBResolverIncidente = new javax.swing.JButton();
        jLabel138 = new javax.swing.JLabel();
        jTArgumentos = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel69 = new javax.swing.JLabel();
        btnExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Incidentes");
        setUndecorated(true);
        getContentPane().setLayout(new java.awt.CardLayout());

        JPIncidentes.setBackground(new java.awt.Color(245, 245, 245));
        JPIncidentes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        JPIncidentes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPIncidentes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTPEmpleados1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTPEmpleados1MouseClicked(evt);
            }
        });

        jPRE1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        seleccionIncidentes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona", "Daño en el Paquete", "Error de Dirección", "Paquete Perdido", "Rechazo Entrega" }));
        seleccionIncidentes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seleccionIncidentesActionPerformed(evt);
            }
        });
        jPanel10.add(seleccionIncidentes, new org.netbeans.lib.awtextra.AbsoluteConstraints(267, 70, 157, -1));

        jLabel133.setText("Tipo de incidente:");
        jPanel10.add(jLabel133, new org.netbeans.lib.awtextra.AbsoluteConstraints(98, 73, 163, -1));

        jLabel134.setText("Código tracking");
        jPanel10.add(jLabel134, new org.netbeans.lib.awtextra.AbsoluteConstraints(98, 20, 163, -1));

        jTCodigoTracking.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTCodigoTrackingFocusLost(evt);
            }
        });
        jTCodigoTracking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTCodigoTrackingActionPerformed(evt);
            }
        });
        jTCodigoTracking.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTCodigoTrackingKeyReleased(evt);
            }
        });
        jPanel10.add(jTCodigoTracking, new org.netbeans.lib.awtextra.AbsoluteConstraints(267, 17, 157, -1));

        jBConsultarPaquete.setText("Consultar");
        jBConsultarPaquete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBConsultarPaqueteActionPerformed(evt);
            }
        });
        jPanel10.add(jBConsultarPaquete, new org.netbeans.lib.awtextra.AbsoluteConstraints(493, 45, -1, -1));

        jTablaPaquete.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane7.setViewportView(jTablaPaquete);

        jPanel10.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 110, 622, 237));

        jBRegistrarIncidente.setText("Registrar");
        jBRegistrarIncidente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBRegistrarIncidenteActionPerformed(evt);
            }
        });
        jPanel10.add(jBRegistrarIncidente, new org.netbeans.lib.awtextra.AbsoluteConstraints(303, 369, -1, -1));

        jPRE1.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 24, -1, -1));

        jTPEmpleados1.addTab("Registrar Incidente", jPRE1);

        jPanel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        seleccionIncidentes1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona", "Daño en el Paquete", "Error de Dirección", "Paquete Perdido", "Rechazo Entrega" }));
        seleccionIncidentes1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seleccionIncidentes1ActionPerformed(evt);
            }
        });

        jLabel136.setText("Tipo de incidente:");

        jLabel137.setText("Código tracking");

        jTCodigoResolver.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTCodigoResolverFocusLost(evt);
            }
        });
        jTCodigoResolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTCodigoResolverActionPerformed(evt);
            }
        });
        jTCodigoResolver.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTCodigoResolverKeyReleased(evt);
            }
        });

        jBConsultarIncidente.setText("Consultar");
        jBConsultarIncidente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBConsultarIncidenteActionPerformed(evt);
            }
        });

        jTIncidente.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane8.setViewportView(jTIncidente);

        jBResolverIncidente.setText("Resolver");
        jBResolverIncidente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBResolverIncidenteActionPerformed(evt);
            }
        });

        jLabel138.setText("Argumentos");

        jTArgumentos.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTArgumentosFocusLost(evt);
            }
        });
        jTArgumentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTArgumentosActionPerformed(evt);
            }
        });
        jTArgumentos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTArgumentosKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel137, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel136, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTCodigoResolver, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(seleccionIncidentes1, javax.swing.GroupLayout.Alignment.LEADING, 0, 157, Short.MAX_VALUE))
                        .addGap(263, 263, 263))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                        .addComponent(jBConsultarIncidente)
                        .addGap(113, 113, 113))))
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 622, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(176, 176, 176)
                        .addComponent(jLabel138, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTArgumentos, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(34, Short.MAX_VALUE))
            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel11Layout.createSequentialGroup()
                    .addGap(302, 302, 302)
                    .addComponent(jBResolverIncidente)
                    .addContainerGap(307, Short.MAX_VALUE)))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel137)
                    .addComponent(jTCodigoResolver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBConsultarIncidente)
                .addGap(2, 2, 2)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel136)
                    .addComponent(seleccionIncidentes1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel138)
                    .addComponent(jTArgumentos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(74, Short.MAX_VALUE))
            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                    .addContainerGap(435, Short.MAX_VALUE)
                    .addComponent(jBResolverIncidente)
                    .addGap(10, 10, 10)))
        );

        javax.swing.GroupLayout jPAE1Layout = new javax.swing.GroupLayout(jPAE1);
        jPAE1.setLayout(jPAE1Layout);
        jPAE1Layout.setHorizontalGroup(
            jPAE1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPAE1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(231, Short.MAX_VALUE))
        );
        jPAE1Layout.setVerticalGroup(
            jPAE1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPAE1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(68, Short.MAX_VALUE))
        );

        jTPEmpleados1.addTab("Resolver Incidente", jPAE1);

        jPIncidentes.add(jTPEmpleados1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 6, -1, -1));

        JPIncidentes.add(jPIncidentes, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 1080, 640));

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
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel69.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel69.setForeground(new java.awt.Color(255, 255, 255));
        jLabel69.setText("Gestion de Envios");
        jPanel3.add(jLabel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 0, -1, -1));

        btnExit.setForeground(new java.awt.Color(255, 255, 255));
        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_Delete_32px.png"))); // NOI18N
        btnExit.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnExit.setContentAreaFilled(false);
        btnExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        jPanel3.add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(1145, 0, 35, 35));

        JPIncidentes.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1180, -1));

        getContentPane().add(JPIncidentes, "card6");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void seleccionIncidentesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seleccionIncidentesActionPerformed

    }//GEN-LAST:event_seleccionIncidentesActionPerformed

    private void jTCodigoTrackingKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTCodigoTrackingKeyReleased

    }//GEN-LAST:event_jTCodigoTrackingKeyReleased

    private void jBConsultarPaqueteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBConsultarPaqueteActionPerformed
        Inventario inventario = Inventario.obtenerInstancia();
        if (jTCodigoTracking.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Ingrese un código tracking", "Llene el campo", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        if (!inventario.existePaquete(jTCodigoTracking.getText())) {
            JOptionPane.showMessageDialog(null, "El paquete no existe", "Código tracking no existe", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Paquete paquete = inventario.obtenerPaquete(jTCodigoTracking.getText());
        DefaultTableModel model = new DefaultTableModel();
        model.setRowCount(0);
        model.addColumn("Propiedad");
        model.addColumn("Valor");
        model.addRow(new Object[]{"Código de Tracking", paquete.obtenerCodigo()});
        model.addRow(new Object[]{"Volumen", paquete.getVolumen() + " m³"});
        model.addRow(new Object[]{"Peso", paquete.getPeso() + " kg"});
        model.addRow(new Object[]{"Contenido", paquete.getContenido()});
        model.addRow(new Object[]{"Remitente", paquete.getRemitente().toString()});
        model.addRow(new Object[]{"Provincia Origen", paquete.getProvinciaOrigen().name()});
        model.addRow(new Object[]{"Provincia Destino", paquete.getProvinciaDestino().name()});
        model.addRow(new Object[]{"Dirección Destino", paquete.getDireccionDestino()});
        model.addRow(new Object[]{"Estado", paquete.obtenerEstado().toString()});
        model.addRow(new Object[]{"Distancia Estimada", paquete.calcularDistancia() + " Km"});
        jTablaPaquete.setModel(model);
        jBRegistrarIncidente.setVisible(true);
        jTablaPaquete.setVisible(true);
    }//GEN-LAST:event_jBConsultarPaqueteActionPerformed

    private void jTPEmpleados1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTPEmpleados1MouseClicked

    }//GEN-LAST:event_jTPEmpleados1MouseClicked

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

    private void jTCodigoTrackingFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTCodigoTrackingFocusLost
        
    }//GEN-LAST:event_jTCodigoTrackingFocusLost

    private void jTCodigoTrackingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTCodigoTrackingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTCodigoTrackingActionPerformed

    private void jBRegistrarIncidenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRegistrarIncidenteActionPerformed
        String incidente = (String) seleccionIncidentes.getSelectedItem();
        Paquete paquete = Inventario.obtenerInstancia().obtenerPaquete(jTCodigoTracking.getText());
        Incidente incidenteRegistrar = null;
        if (incidente.equals("Error Dirección")) {
            incidenteRegistrar = new ErrorDireccion();
        } else if (incidente.equals("Paquete Estropeado")) {
            incidenteRegistrar = new PaqueteEstropeado();
        } else if (incidente.equals("Paquete Perdido")) {
            incidenteRegistrar = new PaquetePerdido();
        }
        if (!(paquete.obtenerEstado() instanceof Pendiente)) {
            JOptionPane.showMessageDialog(
                null,
                "El paquete se encuentra fuera de su jurisdicción",
                "Registro falló",
                JOptionPane.INFORMATION_MESSAGE
            );
            return;
        }
        int respuesta = JOptionPane.showConfirmDialog(
            null,
            "¿Estás seguro de que deseas registrar este incidente?",
            "Confirmación de registro",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.WARNING_MESSAGE
        );
        if (respuesta == JOptionPane.YES_OPTION) {
            GestorIncidente gi = new GestorIncidente(incidenteRegistrar);
            gi.crearIncidente(paquete);
            JOptionPane.showMessageDialog(
                null,
                "El incidente se ha registrado",
                "Registro Exitoso",
                JOptionPane.INFORMATION_MESSAGE
            );
            DefaultTableModel modeloTabla = (DefaultTableModel) jTablaPaquete.getModel();
            modeloTabla.setRowCount(0);
        } else {
            JOptionPane.showMessageDialog(
                null,
                "El registro del incidente se ha cancelado",
                "Registro Cancelado",
                JOptionPane.INFORMATION_MESSAGE
            );
        }
    }//GEN-LAST:event_jBRegistrarIncidenteActionPerformed

    private void seleccionIncidentes1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seleccionIncidentes1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_seleccionIncidentes1ActionPerformed

    private void jTCodigoResolverFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTCodigoResolverFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jTCodigoResolverFocusLost

    private void jTCodigoResolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTCodigoResolverActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTCodigoResolverActionPerformed

    private void jTCodigoResolverKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTCodigoResolverKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTCodigoResolverKeyReleased

    private void jBConsultarIncidenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBConsultarIncidenteActionPerformed
        Inventario inventario = Inventario.obtenerInstancia();
        if (jTCodigoResolver.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Ingrese un código tracking", "Llene el campo", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        if (!inventario.existePaquete(jTCodigoResolver.getText())) {
            JOptionPane.showMessageDialog(null, "El paquete no existe", "Código tracking no existe", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Seguimiento seguimiento = inventario.obtenerPaquete(jTCodigoResolver.getText()).obtenerSeguimiento();
        DefaultTableModel model = new DefaultTableModel();
        model.setRowCount(0);
        model.addColumn("Propiedad");
        model.addColumn("Valor");
        model.addRow(new Object[]{"Estado del paquete", seguimiento.obtenerEstado()});
        model.addRow(new Object[]{"Incidente", seguimiento.obtenerRegistroIncidente()});
        jTIncidente.setModel(model);
        jBResolverIncidente.setVisible(true);
    }//GEN-LAST:event_jBConsultarIncidenteActionPerformed

    private void jBResolverIncidenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBResolverIncidenteActionPerformed
        String incidente = (String) seleccionIncidentes1.getSelectedItem();
        Paquete paquete = Inventario.obtenerInstancia().obtenerPaquete(jTCodigoResolver.getText());
        Incidente incidenteRegistrar = null;
        if (incidente.equals("Error Dirección")) {
            incidenteRegistrar = new ErrorDireccion();
        } else if (incidente.equals("Paquete Estropeado")) {
            incidenteRegistrar = new PaqueteEstropeado();
        } else if (incidente.equals("Paquete Perdido")) {
            incidenteRegistrar = new PaquetePerdido();
        }
        if (!(paquete.obtenerEstado() instanceof Pendiente)) {
            JOptionPane.showMessageDialog(
                null,
                "El paquete se encuentra fuera de su jurisdicción",
                "Resolución falló",
                JOptionPane.INFORMATION_MESSAGE
            );
            return;
        }
        String argumentos = jTArgumentos.getText();
        if (argumentos.isBlank()) {
            JOptionPane.showMessageDialog(
                null,
                "Ingrese los argumentos",
                "Error",
                JOptionPane.INFORMATION_MESSAGE
            );
            return;
        }
        int respuesta = JOptionPane.showConfirmDialog(
            null,
            "¿Estás seguro de que deseas resolver este incidente?",
            "Confirmación de resolución",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.WARNING_MESSAGE
        );
        if (respuesta == JOptionPane.YES_OPTION) {
            String[] partes = argumentos.split("\\s+");
            GestorIncidente gi = new GestorIncidente(incidenteRegistrar);
            for (String parte : partes) {
                System.out.println(parte);
            }
            gi.resolverIncidente(paquete, partes);
            JOptionPane.showMessageDialog(
                null,
                "El incidente se ha resuelto",
                "Resolución Exitosa",
                JOptionPane.INFORMATION_MESSAGE
            );
            DefaultTableModel modeloTabla = (DefaultTableModel) jTIncidente.getModel();
            modeloTabla.setRowCount(0);
        } else {
            JOptionPane.showMessageDialog(
                null,
                "La resolución del incidente se ha cancelado",
                "Resolución Cancelada",
                JOptionPane.INFORMATION_MESSAGE
            );
        }
    }//GEN-LAST:event_jBResolverIncidenteActionPerformed

    private void jTArgumentosFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTArgumentosFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jTArgumentosFocusLost

    private void jTArgumentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTArgumentosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTArgumentosActionPerformed

    private void jTArgumentosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTArgumentosKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTArgumentosKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JPIncidentes;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton jBConsultarIncidente;
    private javax.swing.JButton jBConsultarPaquete;
    private javax.swing.JButton jBRegistrarIncidente;
    private javax.swing.JButton jBResolverIncidente;
    private javax.swing.JLabel jLabel133;
    private javax.swing.JLabel jLabel134;
    private javax.swing.JLabel jLabel136;
    private javax.swing.JLabel jLabel137;
    private javax.swing.JLabel jLabel138;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JPanel jPAE1;
    private javax.swing.JPanel jPIncidentes;
    private javax.swing.JPanel jPRE1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTextField jTArgumentos;
    private javax.swing.JTextField jTCodigoResolver;
    private javax.swing.JTextField jTCodigoTracking;
    private javax.swing.JTable jTIncidente;
    private javax.swing.JTabbedPane jTPEmpleados1;
    private javax.swing.JTable jTablaPaquete;
    private javax.swing.JComboBox<String> seleccionIncidentes;
    private javax.swing.JComboBox<String> seleccionIncidentes1;
    // End of variables declaration//GEN-END:variables

    private void cargarIncidentes() {
        seleccionIncidentes.removeAllItems();
        seleccionIncidentes.addItem("Error Dirección");
        seleccionIncidentes.addItem("Paquete Estropeado");
        seleccionIncidentes.addItem("Paquete Perdido");
        seleccionIncidentes1.removeAllItems();
        seleccionIncidentes1.addItem("Error Dirección");
        seleccionIncidentes1.addItem("Paquete Estropeado");
        seleccionIncidentes1.addItem("Paquete Perdido");
    }
}
