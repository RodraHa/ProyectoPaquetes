/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.text.SimpleDateFormat;
import javax.swing.JFrame;
import javax.swing.JRootPane;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import com.toedter.calendar.JTextFieldDateEditor;
import java.util.List;
import javax.swing.JLabel;
import validaciones.*;

/**
 *
 * @author USUARIO
 */
public class JFFacturacion extends javax.swing.JFrame {
//Validadores

    ValidadorDeRegistros validarRegistroF = new ValidadorDeRegistros();
    ValidadorDeSwings validadorCheck = new ValidadorDeSwings();
//Factura
  private boolean nombreNegocioValido = false;
    private boolean estadoPagoP = false;
    private boolean rucV = false;
    private boolean dirNeg = false;
    private boolean telefonoNeg = false;
    private boolean rucCliente = false;
    private boolean nombreCFactura = false;
    private boolean apellidoCFactura = false;
    private boolean telfCliente = false;
    private boolean dirCliente = false;
    private boolean correoElectronico = false;
    private  boolean cambiarSesion = true;

    private boolean nombreItemValidar1 = false;
    private boolean stockValidar1 = false;
    private boolean precioUValidar1 = false;
    
//Mouse
    int xMouse, yMouse;
    private VisibilidadManager visibilidadManager;
    Connection cnx;
    
    public JFFacturacion(Connection cnx) {
        initComponents();
        this.cnx=cnx;
        setIconImage(new ImageIcon(getClass().getResource("/proyecto_encomienda/GESTION_PAQUETES/FRONTEND/imagenes/factura.png")).getImage());
        this.visibilidadManager = new VisibilidadManager();
        JFrame frame = new JFrame();
        frame.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        java.util.Date fechaActual = new java.util.Date();
        JTextFieldDateEditor editor = (JTextFieldDateEditor) jDateChooserFecha.getDateEditor();
        editor.setEditable(false);
        jDateChooserFecha.setMaxSelectableDate(fechaActual); // Fecha máxima permitida
        jDateChooserFecha.setMinSelectableDate(null);
        setLocationRelativeTo(null);

    }
    
    public JFFacturacion() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/iconos/factura.png")).getImage());
        // Inicializa el campo IDIncidentesTF con el siguiente ID
        this.visibilidadManager = new VisibilidadManager();
        JFrame frame = new JFrame();
        frame.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
    }

    public boolean isCambiarSesion() {
        return cambiarSesion;
    }

    public void setCambiarSesion(boolean cambiarSesion) {
        this.cambiarSesion = cambiarSesion;
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
     
      public void cambiarValoresFalsosF() {
        nombreNegocioValido = false;
        estadoPagoP = false;
        rucV = false;
        dirNeg = false;
        telefonoNeg = false;
        rucCliente = false;
        nombreCFactura = false;
        apellidoCFactura = false;
        telfCliente = false;
        dirCliente = false;
        correoElectronico = false;
    }
      
        public void cambiarValoresNego() {
        nombreNegocioValido = true;
        estadoPagoP = true;
        rucV = true;
        dirNeg = true;
        telefonoNeg = true;
    }
        
        
      
      private void deshabilitarCampos() {
        // Deshabilitar los componentes

        jTFnumerofactura.setEnabled(false);
        jDateChooserFecha.setEnabled(false);

        jTCIDelCliente.setEnabled(false);
        jTFApeliidosCliente.setEnabled(false);
        jTTelefonoCliente.setEnabled(false);
        jTDireccionCliente.setEnabled(false);
        correoCli.setEnabled(false);
        jTNombreCliente.setEnabled(false);
        // Habilitar los componentes
        jTCodigoPaquete.setEnabled(true);

        btnBuscarPaquete.setEnabled(true);

        jBGenerarFactura.setEnabled(true);

    }

    private void limpiarYCambiarCampos() {
        jDateChooserFecha.setEnabled(true);
        jTCIDelCliente.setEnabled(true);
        jTNombreCliente.setEnabled(true);
        jTFApeliidosCliente.setEnabled(true);
        jTTelefonoCliente.setEnabled(true);
        jTDireccionCliente.setEnabled(true);
        correoCli.setEnabled(true);

        jTCodigoPaquete.setEnabled(false);

        btnBuscarPaquete.setEnabled(false);

        jBGenerarFactura.setEnabled(false);

 
        jTCIDelCliente.setText("");
        jTNombreCliente.setText("");
        jTFApeliidosCliente.setText("");
        jTTelefonoCliente.setText("");
        jTDireccionCliente.setText("");
        correoCli.setText("");
        jTPrecioPaquete.setText("");
        jTTotal.setText("");
        jTCodigoPaquete.setText("");
        jTCodigoPaquete.setText("");

        jDateChooserFecha.setDate(null);

    }
    

    private void fillClientFields(String id, String nombre, String apellido, String telefono, String direccion, String esExtranjero, String tipo, String correo) {


        jTCIDelCliente.setText(id);
        jTNombreCliente.setText(nombre);
        jTFApeliidosCliente.setText(apellido);
        jTTelefonoCliente.setText(telefono);
        jTDireccionCliente.setText(direccion);
        correoCli.setText(correo);
    }
  
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JPFyV = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPConsultarFactura = new javax.swing.JPanel();
        jScrollPane26 = new javax.swing.JScrollPane();
        jTablaRegistrarFactura = new javax.swing.JTable();
        btnAbrirFactura = new javax.swing.JButton();
        jTCodigoFactura = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnBuscarFactura = new javax.swing.JButton();
        jPRegistrarFactura = new javax.swing.JPanel();
        jPDatosCliente = new javax.swing.JPanel();
        jTNombreCliente = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jTTelefonoCliente = new javax.swing.JTextField();
        jLCITipoCliente = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jTDireccionCliente = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        jTFApeliidosCliente = new javax.swing.JTextField();
        jLabel85 = new javax.swing.JLabel();
        correoCli = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jTCIDelCliente1 = new javax.swing.JTextField();
        jPDatosFactura = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        jTFnumerofactura = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        jDateChooserFecha = new com.toedter.calendar.JDateChooser();
        jError6 = new javax.swing.JLabel();
        jLPrecioPaquete = new javax.swing.JLabel();
        jLPrecioImpuesto = new javax.swing.JLabel();
        jTPrecioPaquete = new javax.swing.JTextField();
        jTPrecioImpuesto = new javax.swing.JTextField();
        jLTotal = new javax.swing.JLabel();
        jTTotal = new javax.swing.JTextField();
        jPPaquete = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jTCodigoPaquete = new javax.swing.JTextField();
        btnBuscarPaquete = new javax.swing.JButton();
        jLabel64 = new javax.swing.JLabel();
        jTContenidoPaquete = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jTCIDelCliente = new javax.swing.JTextField();
        jBGenerarFactura = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jLPrecioDistancia = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jTPrecioDistancia = new javax.swing.JTextField();
        jLabel71 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel69 = new javax.swing.JLabel();
        btnExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Facturación");
        setUndecorated(true);
        getContentPane().setLayout(new java.awt.CardLayout());

        JPFyV.setBackground(new java.awt.Color(245, 245, 245));
        JPFyV.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPConsultarFactura.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTablaRegistrarFactura.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Código", "Remitente", "Destinario", "Dirección Origen", "Dirección Destino", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTablaRegistrarFactura.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablaRegistrarFacturaMouseClicked(evt);
            }
        });
        jScrollPane26.setViewportView(jTablaRegistrarFactura);

        jPConsultarFactura.add(jScrollPane26, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 1050, 390));

        btnAbrirFactura.setText("Abrir");
        jPConsultarFactura.add(btnAbrirFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 530, 90, 30));
        jPConsultarFactura.add(jTCodigoFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 160, -1));

        jLabel1.setText("Código Factura");
        jPConsultarFactura.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, -1, -1));

        btnBuscarFactura.setText("Buscar");
        jPConsultarFactura.add(btnBuscarFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 70, -1, -1));

        jTabbedPane1.addTab("Consultar facturas", jPConsultarFactura);

        jPRegistrarFactura.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPDatosCliente.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del cliente"));
        jPDatosCliente.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTNombreCliente.setEditable(false);
        jPDatosCliente.add(jTNombreCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 250, -1));

        jLabel30.setText("Teléfono móvil:");
        jPDatosCliente.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        jTTelefonoCliente.setEditable(false);
        jPDatosCliente.add(jTTelefonoCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, 250, -1));

        jLCITipoCliente.setText("CI:");
        jPDatosCliente.add(jLCITipoCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        jLabel33.setText("Dirección:");
        jPDatosCliente.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        jTDireccionCliente.setEditable(false);
        jPDatosCliente.add(jTDireccionCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, 250, -1));

        jLabel45.setText("Apellidos:");
        jPDatosCliente.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        jTFApeliidosCliente.setEditable(false);
        jPDatosCliente.add(jTFApeliidosCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, 250, -1));

        jLabel85.setText("Correo:");
        jPDatosCliente.add(jLabel85, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 43, -1));

        correoCli.setEditable(false);
        jPDatosCliente.add(correoCli, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, 250, -1));

        jLabel31.setText("Nombres:");
        jPDatosCliente.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        jTCIDelCliente1.setEditable(false);
        jPDatosCliente.add(jTCIDelCliente1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 250, -1));

        jPRegistrarFactura.add(jPDatosCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 20, 450, 270));

        jPDatosFactura.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos de la Factura"));
        jPDatosFactura.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel34.setText("Número de factura");
        jPDatosFactura.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 35, -1, -1));

        jTFnumerofactura.setEditable(false);
        jPDatosFactura.add(jTFnumerofactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 57, 112, -1));

        jLabel38.setText("Fecha de emisión");
        jPDatosFactura.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 91, -1, -1));

        jDateChooserFecha.setBackground(new java.awt.Color(255, 255, 255));
        jDateChooserFecha.setDateFormatString("dd-MM-yyyy");
        jDateChooserFecha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jDateChooserFechaMouseClicked(evt);
            }
        });
        jPDatosFactura.add(jDateChooserFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 119, 112, -1));

        jError6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jError6.setForeground(new java.awt.Color(204, 0, 51));
        jError6.setText("*Vacio");
        jPDatosFactura.add(jError6, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 147, -1, -1));

        jPRegistrarFactura.add(jPDatosFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, 190, 180));

        jLPrecioPaquete.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLPrecioPaquete.setText("Precio Paquete");
        jPRegistrarFactura.add(jLPrecioPaquete, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 440, 120, -1));

        jLPrecioImpuesto.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLPrecioImpuesto.setText("IVA (%)");
        jPRegistrarFactura.add(jLPrecioImpuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 470, -1, -1));

        jTPrecioPaquete.setEditable(false);
        jPRegistrarFactura.add(jTPrecioPaquete, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 440, 151, -1));

        jTPrecioImpuesto.setEditable(false);
        jTPrecioImpuesto.setText("15");
        jTPrecioImpuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTPrecioImpuestoActionPerformed(evt);
            }
        });
        jPRegistrarFactura.add(jTPrecioImpuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 470, 151, -1));

        jLTotal.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLTotal.setText("Total");
        jPRegistrarFactura.add(jLTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 500, -1, -1));

        jTTotal.setEditable(false);
        jTTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTTotalActionPerformed(evt);
            }
        });
        jPRegistrarFactura.add(jTTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 500, 151, -1));

        jPPaquete.setBorder(javax.swing.BorderFactory.createTitledBorder("Paquete"));
        jPPaquete.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel37.setText("Código paquete");
        jPPaquete.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jTCodigoPaquete.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTCodigoPaqueteKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTCodigoPaqueteKeyTyped(evt);
            }
        });
        jPPaquete.add(jTCodigoPaquete, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 142, -1));

        btnBuscarPaquete.setText("Buscar");
        btnBuscarPaquete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscarPaquete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarPaqueteActionPerformed(evt);
            }
        });
        jPPaquete.add(btnBuscarPaquete, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        jLabel64.setText("Contenido");
        jPPaquete.add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        jTContenidoPaquete.setEditable(false);
        jTContenidoPaquete.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTContenidoPaqueteKeyReleased(evt);
            }
        });
        jPPaquete.add(jTContenidoPaquete, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 200, 30));

        jLabel29.setText("Nombre Destinatario");
        jPPaquete.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        jTCIDelCliente.setEditable(false);
        jPPaquete.add(jTCIDelCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 200, 30));

        jPRegistrarFactura.add(jPPaquete, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 250, 230));
        jPPaquete.getAccessibleContext().setAccessibleName("Paquete");

        jBGenerarFactura.setText("Generar Factura");
        jBGenerarFactura.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBGenerarFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBGenerarFacturaActionPerformed(evt);
            }
        });
        jPRegistrarFactura.add(jBGenerarFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 550, -1, -1));
        jPRegistrarFactura.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 360, 1190, 10));

        jLabel67.setText("$");
        jPRegistrarFactura.add(jLabel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 500, -1, -1));

        jLabel68.setText("$");
        jPRegistrarFactura.add(jLabel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 470, -1, -1));

        jLPrecioDistancia.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLPrecioDistancia.setText("Precio Distancia");
        jPRegistrarFactura.add(jLPrecioDistancia, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 410, 120, -1));

        jLabel70.setText("$");
        jPRegistrarFactura.add(jLabel70, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 410, 10, -1));

        jTPrecioDistancia.setEditable(false);
        jTPrecioDistancia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTPrecioDistanciaActionPerformed(evt);
            }
        });
        jPRegistrarFactura.add(jTPrecioDistancia, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 410, 151, -1));

        jLabel71.setText("$");
        jPRegistrarFactura.add(jLabel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 440, 10, -1));

        jTabbedPane1.addTab("Registrar factura", jPRegistrarFactura);

        JPFyV.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 1150, 630));

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

        JPFyV.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1180, -1));

        getContentPane().add(JPFyV, "card4");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jDateChooserFechaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDateChooserFechaMouseClicked
        jDateChooserFecha.setBackground(new Color(255, 204, 204)); // Color blanco
    }//GEN-LAST:event_jDateChooserFechaMouseClicked

    private void jTCodigoPaqueteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTCodigoPaqueteKeyReleased

    }//GEN-LAST:event_jTCodigoPaqueteKeyReleased

    private void jTCodigoPaqueteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTCodigoPaqueteKeyTyped
        char variable = evt.getKeyChar();
        if (Character.isLetter(variable)) {
            getToolkit().beep();
            evt.consume();
            jTCodigoPaquete.requestFocus();
            JOptionPane.showMessageDialog(null, "Ingrese solo números");
        }
    }//GEN-LAST:event_jTCodigoPaqueteKeyTyped

    private void btnBuscarPaqueteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarPaqueteActionPerformed
        
    }//GEN-LAST:event_btnBuscarPaqueteActionPerformed

    private void jTContenidoPaqueteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTContenidoPaqueteKeyReleased

    }//GEN-LAST:event_jTContenidoPaqueteKeyReleased

    private void jBGenerarFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBGenerarFacturaActionPerformed

    }//GEN-LAST:event_jBGenerarFacturaActionPerformed

    private void jTablaRegistrarFacturaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablaRegistrarFacturaMouseClicked

       

    }//GEN-LAST:event_jTablaRegistrarFacturaMouseClicked

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
          getToolkit().beep();
        int dialogButton = JOptionPane.YES_NO_OPTION;
        if (cambiarSesion) {
            int dialogResult = JOptionPane.showConfirmDialog(null, "Estas seguro/a que quieres salir de esta ventana", "Warning", dialogButton);
            if (dialogResult == JOptionPane.YES_OPTION) { 
                this.dispose();
            }
        } else {
            String mensaje = "Tienes una factura pendiente.";
            String titulo = "¡Aviso Crítico!";
            JOptionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.ERROR_MESSAGE);
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

    private void jTTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTTotalActionPerformed

    private void jTPrecioDistanciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTPrecioDistanciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTPrecioDistanciaActionPerformed

    private void jTPrecioImpuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTPrecioImpuestoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTPrecioImpuestoActionPerformed

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
            java.util.logging.Logger.getLogger(JFFacturacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFFacturacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFFacturacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFFacturacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFFacturacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JPFyV;
    private javax.swing.JButton btnAbrirFactura;
    private javax.swing.JButton btnBuscarFactura;
    private javax.swing.JButton btnBuscarPaquete;
    private javax.swing.JButton btnExit;
    private javax.swing.JTextField correoCli;
    private javax.swing.JButton jBGenerarFactura;
    private com.toedter.calendar.JDateChooser jDateChooserFecha;
    private javax.swing.JLabel jError6;
    private javax.swing.JLabel jLCITipoCliente;
    private javax.swing.JLabel jLPrecioDistancia;
    private javax.swing.JLabel jLPrecioImpuesto;
    private javax.swing.JLabel jLPrecioPaquete;
    private javax.swing.JLabel jLTotal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JPanel jPConsultarFactura;
    private javax.swing.JPanel jPDatosCliente;
    private javax.swing.JPanel jPDatosFactura;
    private javax.swing.JPanel jPPaquete;
    private javax.swing.JPanel jPRegistrarFactura;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane26;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTCIDelCliente;
    private javax.swing.JTextField jTCIDelCliente1;
    private javax.swing.JTextField jTCodigoFactura;
    private javax.swing.JTextField jTCodigoPaquete;
    private javax.swing.JTextField jTContenidoPaquete;
    private javax.swing.JTextField jTDireccionCliente;
    private javax.swing.JTextField jTFApeliidosCliente;
    private javax.swing.JTextField jTFnumerofactura;
    private javax.swing.JTextField jTNombreCliente;
    private javax.swing.JTextField jTPrecioDistancia;
    private javax.swing.JTextField jTPrecioImpuesto;
    private javax.swing.JTextField jTPrecioPaquete;
    private javax.swing.JTextField jTTelefonoCliente;
    private javax.swing.JTextField jTTotal;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTablaRegistrarFactura;
    // End of variables declaration//GEN-END:variables
}
