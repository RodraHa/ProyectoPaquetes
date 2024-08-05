/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JTextField;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.TableRowSorter;
import validaciones.*;


/**
 * Panel que representa la interfaz gráfica para la gestión de envíos.
 * Contiene un panel de encabezado con un título y un botón de salida.
 * Permite arrastrar el panel y manejar el evento de clic en el botón de salida.
 *
 * @author USUARIO
 */
public class JPSalir extends javax.swing.JPanel {
    // Instancias de clases para validación de registros y componentes Swing
    private ValidadorDeRegistros validarRegistroF = new ValidadorDeRegistros();
    private ValidadorDeSwings validadorCheck = new ValidadorDeSwings();

    // Variables booleanas para validar diferentes aspectos
    private boolean anchoValidar = false;
    private boolean largoValidar = false;
    private boolean pesoValidar = false;
    private boolean remitenteValidar = false;

    // Conexión a la base de datos
    private Connection cnx;

    // Variables para manejar el movimiento del panel con el ratón
    private int xMouse, yMouse;

    /**
     * Constructor para inicializar el panel y la conexión SQL.
     *
     * @param cnx la conexión SQL que se asignará al panel
     */
    public JPSalir(Connection cnx) {
        initComponents(); // Inicializa los componentes del panel
        this.cnx = cnx;  // Asigna la conexión SQL al panel
    }

    /**
     * Método para inicializar los componentes del panel.
     * Este método es generado automáticamente por el editor de GUI.
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {

        // Inicialización de los componentes
        jPanel3 = new javax.swing.JPanel();
        jLabel69 = new javax.swing.JLabel();
        btnExit = new javax.swing.JButton();

        setLayout(new java.awt.CardLayout()); // Configura el diseño del panel

        // Configuración del panel principal
        jPanel3.setBackground(new java.awt.Color(146, 10, 48)); // Establece el color de fondo
        jPanel3.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel3MouseDragged(evt); // Llama al método cuando se arrastra el panel
            }
        });
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel3MousePressed(evt); // Llama al método cuando se presiona el botón del ratón
            }
        });

        // Configuración de la etiqueta del panel
        jLabel69.setFont(new java.awt.Font("Segoe UI", 1, 12)); // Establece la fuente y el tamaño del texto
        jLabel69.setForeground(new java.awt.Color(255, 255, 255)); // Establece el color del texto
        jLabel69.setText("Gestion de Envios"); // Establece el texto de la etiqueta

        // Configuración del botón de salida
        btnExit.setForeground(new java.awt.Color(255, 255, 255)); // Establece el color del texto del botón
        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto_encomienda/GESTION_PAQUETES/FRONTEND/imagenes/power_24dp.png"))); // Establece el icono del botón
        btnExit.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1)); // Elimina el borde del botón
        btnExit.setContentAreaFilled(false); // Hace que el área del contenido sea transparente
        btnExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR)); // Cambia el cursor al pasar sobre el botón
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt); // Llama al método cuando se hace clic en el botón
            }
        });

        // Configuración del diseño del panel principal
        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel69) // Añade la etiqueta al panel
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 616, Short.MAX_VALUE)
                                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)) // Añade el botón de salida al panel
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel69) // Añade la etiqueta al panel
                                        .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)) // Añade el botón de salida al panel
                                .addGap(0, 0, Short.MAX_VALUE))
        );

        add(jPanel3, "card2"); // Añade el panel principal al panel de tarjetas
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Maneja el evento de arrastre del panel. Permite mover el panel por la pantalla.
     *
     * @param evt el evento de arrastre del ratón
     */
    private void jPanel3MouseDragged(java.awt.event.MouseEvent evt) {
        int x = evt.getXOnScreen(); // Obtiene la posición X del ratón en la pantalla
        int y = evt.getYOnScreen(); // Obtiene la posición Y del ratón en la pantalla
        this.setLocation(x - xMouse, y - yMouse); // Establece la nueva ubicación del panel
    }

    /**
     * Maneja el evento de presión del botón del ratón en el panel. Captura la posición del ratón para el arrastre.
     *
     * @param evt el evento de presión del ratón
     */
    private void jPanel3MousePressed(java.awt.event.MouseEvent evt) {
        xMouse = evt.getX(); // Captura la posición X del ratón al presionar
        yMouse = evt.getY(); // Captura la posición Y del ratón al presionar
    }

    /**
     * Maneja el evento de clic en el botón de salida. Muestra un diálogo de confirmación para cerrar el panel.
     *
     * @param evt el evento de clic en el botón
     */
    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {
        getToolkit().beep(); // Reproduce un sonido de aviso
        int dialogButton = JOptionPane.YES_NO_OPTION; // Opciones de diálogo (Sí/No)
        int dialogResult = JOptionPane.showConfirmDialog(null, "Estas seguro de quieres cerrar la ventana?", "Warning", dialogButton); // Muestra un diálogo de confirmación
        if (dialogResult == JOptionPane.YES_OPTION) {
            //this.dispose(); // Descomentar para cerrar la ventana
        }
    }

    // Variables de instancia para los componentes del panel
    private javax.swing.JButton btnExit; // Botón de salida
    private javax.swing.JLabel jLabel69; // Etiqueta del título
    private javax.swing.JPanel jPanel3; // Panel principal
}
