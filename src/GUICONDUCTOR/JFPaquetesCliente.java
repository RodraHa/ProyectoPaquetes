/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUICONDUCTOR;

import basededatos.DataBase;
import proyecto_paquetes.JFIngresar;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import mod_administracion.Cliente;
import mod_administracion.ReporteNoPermitido;
import mod_incidentes.DevolucionPaquete;
import mod_incidentes.ErrorDireccion;
import mod_incidentes.GestorIncidente;
import mod_incidentes.Incidente;
import mod_incidentes.PaqueteEstropeado;
import mod_incidentes.PaquetePerdido;
import mod_incidentes.PaqueteYaTieneIncidente;
import mod_paquetes.Entregado;
import mod_paquetes.Inventario;
import mod_paquetes.Paquete;

/**
 *
 * @author USUARIO
 */
public class JFPaquetesCliente extends javax.swing.JFrame {

    int xMouse, yMouse;
    Cliente cliente;

    /**
     * Creates new form JFLogin
     */
    public JFPaquetesCliente() {
        Inventario.obtenerInstancia().cargarInventario();
        setIconImage(new ImageIcon(getClass().getResource("/iconos/AjustesBest.png")).getImage());
        initComponents();
        this.setLocationRelativeTo(null);
        seleccionIncidentes.setVisible(false);
        jLabel133.setVisible(false);
        jTablaPaquete.setVisible(false);
        jBRegistrarIncidente.setVisible(false);
        setTitle("Recuperar contraseña");
        // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jColorChooser1 = new javax.swing.JColorChooser();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jTCodigo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jBInsertar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jTCedula = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        seleccionIncidentes = new javax.swing.JComboBox<>();
        jLabel133 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTablaPaquete = new javax.swing.JTable();
        jBRegistrarIncidente = new javax.swing.JButton();
        jBRegresar = new javax.swing.JButton();
        jBRegistrarIncidente1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Recuperación de contraseña");
        setAutoRequestFocus(false);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setForeground(new java.awt.Color(102, 102, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(1180, 540));
        jPanel1.setPreferredSize(new java.awt.Dimension(1180, 540));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(146, 10, 48));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(460, 24));
        jPanel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel2MouseDragged(evt);
            }
        });
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel2MousePressed(evt);
            }
        });
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1270, -1));

        jTCodigo.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        jTCodigo.setBorder(null);
        jTCodigo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTCodigoFocusLost(evt);
            }
        });
        jTCodigo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTCodigoMousePressed(evt);
            }
        });
        jPanel1.add(jTCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, 237, -1));

        jLabel1.setText("CodigoPaquete:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, -1, -1));

        jBInsertar.setBackground(new java.awt.Color(255, 250, 243));
        jBInsertar.setText("Ingresar");
        jBInsertar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jBInsertar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBInsertar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jBInsertarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jBInsertarMouseExited(evt);
            }
        });
        jBInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBInsertarActionPerformed(evt);
            }
        });
        jPanel1.add(jBInsertar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 140, 80, 30));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 20, 10, 520));

        jTCedula.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        jTCedula.setBorder(null);
        jTCedula.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTCedulaFocusLost(evt);
            }
        });
        jTCedula.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTCedulaMousePressed(evt);
            }
        });
        jTCedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTCedulaActionPerformed(evt);
            }
        });
        jPanel1.add(jTCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 50, 237, -1));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 70, 237, 10));

        seleccionIncidentes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Paquete estropeado", "Devolución paquete" }));
        seleccionIncidentes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seleccionIncidentesActionPerformed(evt);
            }
        });
        jPanel1.add(seleccionIncidentes, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, -1, -1));

        jLabel133.setText("Tipo de incidente:");
        jPanel1.add(jLabel133, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, -1));

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

        jPanel1.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 540, 120));

        jBRegistrarIncidente.setText("Registrar");
        jBRegistrarIncidente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBRegistrarIncidenteActionPerformed(evt);
            }
        });
        jPanel1.add(jBRegistrarIncidente, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 390, -1, -1));

        jBRegresar.setBackground(new java.awt.Color(255, 250, 243));
        jBRegresar.setText("Regresar");
        jBRegresar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jBRegresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBRegresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jBRegresarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jBRegresarMouseExited(evt);
            }
        });
        jBRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBRegresarActionPerformed(evt);
            }
        });
        jPanel1.add(jBRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 470, 101, 30));

        jBRegistrarIncidente1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jBRegistrarIncidente1.setText("CONTACTANOS!");
        jBRegistrarIncidente1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBRegistrarIncidente1ActionPerformed(evt);
            }
        });
        jPanel1.add(jBRegistrarIncidente1, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 130, 220, 60));

        jLabel6.setText("Cédula:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel7.setText("¿Necesitas ayuda o tienes alguna duda?");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 70, 470, -1));

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 20, 30, 520));
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 120, 237, 10));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBInsertarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jBInsertarActionPerformed
        Cliente cliente = DataBase.obtenerInstancia().obtenerclientePorCedula(jTCedula.getText());
        if (cliente == null) {
            JOptionPane.showMessageDialog(null, "No Existen datos", "Alguno de los datos no se encontraron",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        Paquete paquete = cliente.obtenerPaquete(jTCodigo.getText());
        if (paquete == null) {
            JOptionPane.showMessageDialog(null, "No Existen datos", "Alguno de los datos no se encontraron",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (cliente.consultarPaquete(paquete)) {
            seleccionIncidentes.setVisible(true);
            jLabel133.setVisible(true);
            jTablaPaquete.setVisible(true);
            jBRegistrarIncidente.setVisible(true);
            DefaultTableModel model = new DefaultTableModel();
            jTablaPaquete.setModel(model);
            String[] columnNames = {
                    "Código de Tracking", "Volumen", "Peso", "Contenido",
                    "Remitente", "Estado", "Provincia Destino"
            };
            model.setColumnIdentifiers(columnNames);
            model.addRow(new Object[] {
                    paquete.obtenerCodigo(),
                    paquete.getVolumen(),
                    paquete.getPeso(),
                    paquete.getContenido(),
                    paquete.getRemitente().toString(),
                    paquete.obtenerEstado().toString(),
                    paquete.getProvinciaDestino().name()
            });
            this.cliente = cliente;
            return;
        }
        JOptionPane.showMessageDialog(null, "No Coinciden los datos", "Error", JOptionPane.ERROR_MESSAGE);

    }// GEN-LAST:event_jBInsertarActionPerformed

    private void jTCodigoMousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jTCodigoMousePressed
        if (jTCodigo.getText().equals("Ingrese su documento de identidad")) {
            jTCodigo.setForeground(Color.black);
            jTCodigo.setText("");
        }

    }// GEN-LAST:event_jTCodigoMousePressed

    private void jTCodigoFocusLost(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_jTCodigoFocusLost
        if (jTCodigo.getText().isEmpty()) {
            jTCodigo.setText("Ingrese su documento de identidad");
            jTCodigo.setForeground(new Color(204, 204, 204));
        }

    }// GEN-LAST:event_jTCodigoFocusLost

    private void exitTXTMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_exitTXTMouseClicked
        System.exit(0);
    }// GEN-LAST:event_exitTXTMouseClicked



    private void jPanel2MouseDragged(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jPanel2MouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }// GEN-LAST:event_jPanel2MouseDragged

    private void jPanel2MousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jPanel2MousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }// GEN-LAST:event_jPanel2MousePressed

    private void jBInsertarMouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jBInsertarMouseEntered
        jBInsertar.setBackground(new Color(255, 51, 133));
    }// GEN-LAST:event_jBInsertarMouseEntered

    private void jBInsertarMouseExited(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jBInsertarMouseExited
        jBInsertar.setBackground(new Color(255, 250, 243));
    }// GEN-LAST:event_jBInsertarMouseExited

    private void jTCedulaFocusLost(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_jTCedulaFocusLost
        // TODO add your handling code here:
    }// GEN-LAST:event_jTCedulaFocusLost

    private void jTCedulaMousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jTCedulaMousePressed
        // TODO add your handling code here:
    }// GEN-LAST:event_jTCedulaMousePressed

    private void jTCedulaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jTCedulaActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_jTCedulaActionPerformed

    private void seleccionIncidentesActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_seleccionIncidentesActionPerformed

    }// GEN-LAST:event_seleccionIncidentesActionPerformed

    private void jBRegistrarIncidenteActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jBRegistrarIncidenteActionPerformed
        String incidente = (String) seleccionIncidentes.getSelectedItem();
        Paquete paquete = Inventario.obtenerInstancia().obtenerPaquete(jTCodigo.getText());
        Incidente incidenteRegistrar = new ErrorDireccion();
        if (incidente.equals("Paquete estropeado")) {
            incidenteRegistrar = new PaqueteEstropeado();
        } else if (incidente.equals("Devolución paquete")) {
            incidenteRegistrar = new DevolucionPaquete();
        }
        int respuesta = JOptionPane.showConfirmDialog(
            null,
            "¿Estás seguro de que deseas registrar este incidente?",
            "Confirmación de registro",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.WARNING_MESSAGE);
        if (respuesta == JOptionPane.YES_OPTION) {
            cliente.setIncidenteAManejar(incidenteRegistrar);
            try {
                cliente.reportarIncidente(paquete);
            } catch (ReporteNoPermitido ex) {
                JOptionPane.showMessageDialog(
                    null,
                    "El paquete se encuentra fuera de su jurisdicción",
                    "Registro falló",
                    JOptionPane.INFORMATION_MESSAGE);
                return;
            } catch (PaqueteYaTieneIncidente ex) {
                JOptionPane.showMessageDialog(
                    null,
                    "El paquete ya cuenta con un incidente registrado",
                    "Registro falló",
                    JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            JOptionPane.showMessageDialog(
                    null,
                    "El incidente se ha registrado",
                    "Registro Exitoso",
                    JOptionPane.INFORMATION_MESSAGE);
            Inventario.obtenerInstancia().guardarInventario();
            DefaultTableModel modeloTabla = (DefaultTableModel) jTablaPaquete.getModel();
            modeloTabla.setRowCount(0);
        } else {
            JOptionPane.showMessageDialog(
                null,
                "El registro del incidente se ha cancelado",
                "Registro Cancelado",
                JOptionPane.INFORMATION_MESSAGE);
        }
    }// GEN-LAST:event_jBRegistrarIncidenteActionPerformed

    private void jBRegresarMouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jBRegresarMouseEntered
        jBRegresar.setBackground(new Color(255, 51, 133));
    }// GEN-LAST:event_jBRegresarMouseEntered

    private void jBRegresarMouseExited(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jBRegresarMouseExited
        jBRegresar.setBackground(new Color(255, 250, 243));
    }// GEN-LAST:event_jBRegresarMouseExited

    private void jBRegresarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jBRegresarActionPerformed
        this.dispose();
        JFIngresar ingresar = new JFIngresar();
        ingresar.setVisible(true);
    }// GEN-LAST:event_jBRegresarActionPerformed

    private void jBRegistrarIncidente1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jBRegistrarIncidente1ActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_jBRegistrarIncidente1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBInsertar;
    private javax.swing.JButton jBRegistrarIncidente;
    private javax.swing.JButton jBRegistrarIncidente1;
    private javax.swing.JButton jBRegresar;
    private javax.swing.JColorChooser jColorChooser1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel133;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTextField jTCedula;
    private javax.swing.JTextField jTCodigo;
    private javax.swing.JTable jTablaPaquete;
    private javax.swing.JComboBox<String> seleccionIncidentes;
    // End of variables declaration//GEN-END:variables
}
