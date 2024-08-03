/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import proyecto_paquetes.JFIngresar;
import validaciones.*;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author USUARIO
 */
public class JFRecuperar extends javax.swing.JFrame {

    int xMouse, yMouse;

    /**
     * Creates new form JFLogin
     */
    public JFRecuperar() {
        initComponents();
        setIconImage(new ImageIcon(getClass().
                getResource("/proyecto_encomienda/GESTION_PAQUETES/FRONTEND/imagenes/AjustesBest.png")).getImage());
        jCBPreguntaControl.setBackground(new Color(255,255,255));
        this.setLocationRelativeTo(null);
        setTitle("Recuperar contraseña");
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        exitP = new javax.swing.JPanel();
        exitTXT = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTFCedula = new javax.swing.JTextField();
        jBRegresar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jBIngresar = new javax.swing.JButton();
        jCBPreguntaControl = new javax.swing.JComboBox<>();
        jTFRecuperar = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Recuperación de contraseña");
        setAutoRequestFocus(false);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setForeground(new java.awt.Color(102, 102, 255));
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

        exitP.setBackground(new java.awt.Color(146, 10, 48));
        exitP.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        exitTXT.setFont(new java.awt.Font("Roboto Black", 0, 12)); // NOI18N
        exitTXT.setForeground(new java.awt.Color(255, 255, 255));
        exitTXT.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exitTXT.setText("X");
        exitTXT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitTXTMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exitTXTMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exitTXTMouseExited(evt);
            }
        });

        javax.swing.GroupLayout exitPLayout = new javax.swing.GroupLayout(exitP);
        exitP.setLayout(exitPLayout);
        exitPLayout.setHorizontalGroup(
            exitPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, exitPLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(exitTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        exitPLayout.setVerticalGroup(
            exitPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, exitPLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(exitTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Recuperar contraseña");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 283, Short.MAX_VALUE)
                .addComponent(exitP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(exitP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto_encomienda/GESTION_PAQUETES/FRONTEND/imagenes/gestionDePaquetes.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, 120));

        jTFCedula.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        jTFCedula.setForeground(new java.awt.Color(204, 204, 204));
        jTFCedula.setText("Ingrese su documento de identidad");
        jTFCedula.setBorder(null);
        jTFCedula.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTFCedulaFocusLost(evt);
            }
        });
        jTFCedula.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTFCedulaMousePressed(evt);
            }
        });
        jPanel1.add(jTFCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 160, 237, -1));

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
        jPanel1.add(jBRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 300, 101, 30));

        jLabel1.setText("Cédula:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, -1, -1));

        jBIngresar.setBackground(new java.awt.Color(255, 250, 243));
        jBIngresar.setText("Recuperar Contraseña");
        jBIngresar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jBIngresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBIngresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jBIngresarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jBIngresarMouseExited(evt);
            }
        });
        jBIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBIngresarActionPerformed(evt);
            }
        });
        jPanel1.add(jBIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 300, -1, 30));

        jCBPreguntaControl.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una opción", "¿Cuál es el nombre de tu primera mascota?", "¿En qué ciudad naciste?", "¿Cuál fue tu primer trabajo?", "¿Cuál es tu película favorita?", "¿Cuál es tu comida favorita?", "¿Cuál es tu equipo deportivo favorito?", "¿Cuál es el nombre de tu mejor amigo/a de la infancia?", "¿Cuál es el nombre de tu profesor/a favorito/a?", "¿Cuál es tu canción favorita?" }));
        jCBPreguntaControl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(jCBPreguntaControl, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, 350, -1));
        jPanel1.add(jTFRecuperar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 260, 350, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 180, 237, 10));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRegresarActionPerformed
        this.dispose();
        JFIngresar ingresar = new JFIngresar();
        ingresar.setVisible(true);
    }//GEN-LAST:event_jBRegresarActionPerformed

    private void jBIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBIngresarActionPerformed
        String pregunta = jCBPreguntaControl.getSelectedItem().toString();
        Map<String, Integer> preguntaToNumeroMap = new HashMap<>();
        preguntaToNumeroMap.put("¿Cuál es el nombre de tu primera mascota?", 1);
        preguntaToNumeroMap.put("¿En qué ciudad naciste?", 2);
        preguntaToNumeroMap.put("¿Cuál fue tu primer trabajo?", 3);
        preguntaToNumeroMap.put("¿Cuál es tu película favorita?", 4);
        preguntaToNumeroMap.put("¿Cuál es tu comida favorita?", 5);
        preguntaToNumeroMap.put("¿Cuál es tu equipo deportivo favorito?", 6);
        preguntaToNumeroMap.put("¿Cuál es el nombre de tu mejor amigo/a de la infancia?", 7);
        preguntaToNumeroMap.put("¿Cuál es el nombre de tu profesor/a favorito/a?", 9);
        preguntaToNumeroMap.put("¿Cuál es tu canción favorita?", 9);
        int numpregunta = preguntaToNumeroMap.getOrDefault(pregunta, 0);
        String respuesta = jTFRecuperar.getText();
        String CI = jTFCedula.getText();
        recuperarContrasena(CI, numpregunta, respuesta);
    }//GEN-LAST:event_jBIngresarActionPerformed

    private void jTFCedulaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTFCedulaMousePressed
        if (jTFCedula.getText().equals("Ingrese su documento de identidad")) {
            jTFCedula.setForeground(Color.black);
            jTFCedula.setText("");
        }

    }//GEN-LAST:event_jTFCedulaMousePressed

    private void jTFCedulaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTFCedulaFocusLost
        if (jTFCedula.getText().isEmpty()) {
            jTFCedula.setText("Ingrese su documento de identidad");
            jTFCedula.setForeground(new Color(204, 204, 204));
        }

    }//GEN-LAST:event_jTFCedulaFocusLost

    private void exitTXTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitTXTMouseClicked
        System.exit(0);
    }//GEN-LAST:event_exitTXTMouseClicked

    private void exitTXTMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitTXTMouseEntered
        exitP.setBackground(Color.red);
    }//GEN-LAST:event_exitTXTMouseEntered

    private void exitTXTMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitTXTMouseExited
        exitP.setBackground(new Color(146, 10, 48));
    }//GEN-LAST:event_exitTXTMouseExited

    private void jPanel2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_jPanel2MouseDragged

    private void jPanel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_jPanel2MousePressed

    private void jBIngresarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBIngresarMouseEntered
        jBIngresar.setBackground(new Color(255, 51, 133));
    }//GEN-LAST:event_jBIngresarMouseEntered

    private void jBIngresarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBIngresarMouseExited
        jBIngresar.setBackground(new Color(255, 250, 243));
    }//GEN-LAST:event_jBIngresarMouseExited

    private void jBRegresarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBRegresarMouseEntered
        jBRegresar.setBackground(new Color(255, 51, 133));
    }//GEN-LAST:event_jBRegresarMouseEntered

    private void jBRegresarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBRegresarMouseExited
        jBRegresar.setBackground(new Color(255, 250, 243));
    }//GEN-LAST:event_jBRegresarMouseExited
    private void recuperarContrasena(String CI, int numpregunta, String respuesta) {

    }

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
            java.util.logging.Logger.getLogger(JFRecuperar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFRecuperar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFRecuperar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFRecuperar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFRecuperar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel exitP;
    private javax.swing.JLabel exitTXT;
    private javax.swing.JButton jBIngresar;
    private javax.swing.JButton jBRegresar;
    private javax.swing.JComboBox<String> jCBPreguntaControl;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTFCedula;
    private javax.swing.JTextField jTFRecuperar;
    // End of variables declaration//GEN-END:variables
}
