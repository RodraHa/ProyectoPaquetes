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
        jScrollPane29 = new javax.swing.JScrollPane();
        jTIncidentes1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPEE1 = new javax.swing.JPanel();
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

        jPAE1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTIncidentes1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Cod. Incidente", "Cod. Paquete", "Tipo Incidente", "Descripcion"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane29.setViewportView(jTIncidentes1);

        jPAE1.add(jScrollPane29, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 21, 666, 153));

        jButton1.setText("Editar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPAE1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(807, 38, -1, -1));

        jButton2.setText("Editar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPAE1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(807, 79, -1, -1));

        jTPEmpleados1.addTab("Actualizar", jPAE1);

        javax.swing.GroupLayout jPEE1Layout = new javax.swing.GroupLayout(jPEE1);
        jPEE1.setLayout(jPEE1Layout);
        jPEE1Layout.setHorizontalGroup(
            jPEE1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 965, Short.MAX_VALUE)
        );
        jPEE1Layout.setVerticalGroup(
            jPEE1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 566, Short.MAX_VALUE)
        );

        jTPEmpleados1.addTab("Cambiar de estado", jPEE1);

        javax.swing.GroupLayout jPIncidentesLayout = new javax.swing.GroupLayout(jPIncidentes);
        jPIncidentes.setLayout(jPIncidentesLayout);
        jPIncidentesLayout.setHorizontalGroup(
            jPIncidentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPIncidentesLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jTPEmpleados1, javax.swing.GroupLayout.PREFERRED_SIZE, 965, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(65, Short.MAX_VALUE))
        );
        jPIncidentesLayout.setVerticalGroup(
            jPIncidentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPIncidentesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTPEmpleados1, javax.swing.GroupLayout.PREFERRED_SIZE, 601, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

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

        jLabel69.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel69.setForeground(new java.awt.Color(255, 255, 255));
        jLabel69.setText("Gestion de Envios");

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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel69)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1040, Short.MAX_VALUE)
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

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
                "Eliminación Cancelada",
                JOptionPane.INFORMATION_MESSAGE
            );
        }
    }//GEN-LAST:event_jBRegistrarIncidenteActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JPIncidentes;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton jBConsultarPaquete;
    private javax.swing.JButton jBRegistrarIncidente;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel133;
    private javax.swing.JLabel jLabel134;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JPanel jPAE1;
    private javax.swing.JPanel jPEE1;
    private javax.swing.JPanel jPIncidentes;
    private javax.swing.JPanel jPRE1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane29;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTextField jTCodigoTracking;
    private javax.swing.JTable jTIncidentes1;
    private javax.swing.JTabbedPane jTPEmpleados1;
    private javax.swing.JTable jTablaPaquete;
    private javax.swing.JComboBox<String> seleccionIncidentes;
    // End of variables declaration//GEN-END:variables

    private void cargarIncidentes() {
        seleccionIncidentes.removeAllItems();
        seleccionIncidentes.addItem("Error Dirección");
        seleccionIncidentes.addItem("Paquete Estropeado");
        seleccionIncidentes.addItem("Paquete Perdido");
    }
}
