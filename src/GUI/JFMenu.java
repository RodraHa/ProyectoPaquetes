package GUI;

import proyecto_paquetes.JFIngresar;
import basededatos.DataBase;
import com.toedter.calendar.JDateChooser;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Window;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTable;
import mod_administracion.Conductor;
import mod_administracion.Recepcionista;

import mod_paquetes.Inventario;

import mod_transporte.Asignacion;

import validaciones.*;

/**
 *
 * @author Moises
 */
public class JFMenu extends javax.swing.JFrame {
//Vistas

    private JFPaquetes inventario = null;
    private JFClientes remitente = null;
    private JFIncidente incidente = null;
    private JFConductores conductor = null;
    private JFFactura factura1 = null;

//Clases   
    ValidadorDeRegistros validarRegistroF = new ValidadorDeRegistros();
    ValidadorDeSwings validadorCheck = new ValidadorDeSwings();

    //Empleados
    private boolean cedulaEmpleadoValidar = false;
    private boolean nombreEmpleadoValidar = false;
    private boolean apellidoEmpleadoValidar = false;
    private boolean cargoEmpleadoValidar = false;
    private boolean direccionEmpleadoValidar = false;
    private boolean telefonoConvenValidar = false;
    private boolean telefonoEmpleadoValiar = false;
    private boolean correoEmpleadoValidar = false;

    private boolean cargoEmpleadoValidar1 = false;
    private boolean direccionEmpleadoValidar1 = false;
    private boolean telefonoConvenValidar1 = false;
    private boolean telefonoEmpleadoValiar1 = false;
    private boolean correoEmpleadoValidar1 = false;
    //Usuarios
    private boolean claveUsuario = false;
    //Actualizar usuarios
    private boolean claveUsuario2 = false;
    public Recepcionista recepcionista;

//Mouses
    int xMouse, yMouse;

//Conexión y auditoria
    private String usuario;
    private String rol;
    Connection cnx;
    //Paneles   
    private JPanel[] clickedPanels = new JPanel[6];
    CardLayout contenido, contenido1;
    private boolean focusChanged = false;
    private String nombreUsuario;


    public void desvanecer() {
        Clicked1.setVisible(true);
        Clicked2.setVisible(false);
        Clicked3.setVisible(false);
        Clicked4.setVisible(false);
        Clicked5.setVisible(false);
        Clicked6.setVisible(false);
    }

    public JFMenu(Recepcionista recepcionista) {
        ArrayList<Conductor> conductores = DataBase.obtenerInstancia().obtenerTodosLosConductores();
        Asignacion.obtenerInstancia().agregarConductores(conductores);
        Asignacion.obtenerInstancia().cargarVehiculos();
        Asignacion.obtenerInstancia().cargarConductores();
        Asignacion.obtenerInstancia().cargarRelacionConductores();

        initComponents();
        this.recepcionista = recepcionista;

        Inventario.obtenerInstancia().cargarInventario();
        setIconImage(new ImageIcon(getClass().getResource("/iconos/AjustesBest.png")).getImage());


        setLocationRelativeTo(null);
        String fecha = "dd-MM-yyyy";
        Locale localM = null;
        String resultado;
        Date fechaYHora = new Date();

        resultado = mostrarFechaHora(fechaYHora, fecha, localM);
        //jDateChooserFecha.setText(resultado);
        txtID.setText("Usuario\t: " + "Recepcionista " + recepcionista.obtenerSucursal().name());
        txtDateLog.setText("Fecha\t: " + resultado);
        JFrame frame = new JFrame();
        frame.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        contenido = (CardLayout) (panelContent.getLayout());
        contenido.show(panelContent, "card1");
        clickedPanels[0] = Clicked1;
        clickedPanels[1] = Clicked2;
        clickedPanels[2] = Clicked3;
        clickedPanels[3] = Clicked4;
        clickedPanels[4] = Clicked5;
        clickedPanels[5] = Clicked6;
        java.util.Date fechaActual = new java.util.Date();
        // Configura el JDateChooser
        desvanecer();
        //int nuevoNumeroFactura = RegistrarDatosFactura.obtenerNuevoNumeroFactura(cnx);
        //jTFnumerofactura.setText(String.valueOf(nuevoNumeroFactura));
        jLInicio.setText("Bienvenido/a");
    }

    private void cambiarSeccionMenu(int seccionIndex) {
        for (int i = 0; i < clickedPanels.length; i++) {
            clickedPanels[i].setVisible(i == seccionIndex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Home = new javax.swing.JPanel();
        PanelHome = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel69 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        menuProveedores = new javax.swing.JLabel();
        menuEmpleados = new javax.swing.JLabel();
        menuClientes = new javax.swing.JLabel();
        menuinventario = new javax.swing.JLabel();
        menuFacturacionYVenta = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        menuLogout = new javax.swing.JLabel();
        Clicked1 = new javax.swing.JPanel();
        Clicked2 = new javax.swing.JPanel();
        Clicked3 = new javax.swing.JPanel();
        Clicked4 = new javax.swing.JPanel();
        Clicked5 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        menuIncidentes = new javax.swing.JLabel();
        Clicked6 = new javax.swing.JPanel();
        btnExit = new javax.swing.JButton();
        panelContent = new javax.swing.JPanel();
        JPGPaquetes = new javax.swing.JPanel();
        jLInicio = new javax.swing.JLabel();
        JPRemitente = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        JPConductores = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        JPFyV = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        JPRecepcionista = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        JPIncidentes = new javax.swing.JPanel();
        jLabel117 = new javax.swing.JLabel();
        txtID = new javax.swing.JLabel();
        txtDateLog = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SistemaBestColor");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setUndecorated(true);
        setResizable(false);

        Home.setLayout(new java.awt.CardLayout());

        PanelHome.setBackground(new java.awt.Color(245, 245, 245));
        PanelHome.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        PanelHome.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel69)
                .addContainerGap(1295, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel69)
                .addGap(0, 4, Short.MAX_VALUE))
        );

        PanelHome.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1400, 20));

        jPanel1.setBackground(new java.awt.Color(41, 39, 40));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        menuProveedores.setBackground(new java.awt.Color(41, 39, 40));
        menuProveedores.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 16)); // NOI18N
        menuProveedores.setForeground(new java.awt.Color(255, 255, 255));
        menuProveedores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/administracion.png"))); // NOI18N
        menuProveedores.setText("Conductores");
        menuProveedores.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        menuProveedores.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        menuProveedores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuProveedoresMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                menuProveedoresMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                menuProveedoresMouseExited(evt);
            }
        });
        jPanel1.add(menuProveedores, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 210, 50));

        menuEmpleados.setBackground(new java.awt.Color(41, 39, 40));
        menuEmpleados.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 16)); // NOI18N
        menuEmpleados.setForeground(new java.awt.Color(255, 255, 255));
        menuEmpleados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/camion.png"))); // NOI18N
        menuEmpleados.setText("Vehiculos");
        menuEmpleados.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        menuEmpleados.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        menuEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuEmpleadosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                menuEmpleadosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                menuEmpleadosMouseExited(evt);
            }
        });
        jPanel1.add(menuEmpleados, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 210, 52));

        menuClientes.setBackground(new java.awt.Color(41, 39, 40));
        menuClientes.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 16)); // NOI18N
        menuClientes.setForeground(new java.awt.Color(255, 255, 255));
        menuClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_Home_32px.png"))); // NOI18N
        menuClientes.setText("Clientes");
        menuClientes.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        menuClientes.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        menuClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuClientesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                menuClientesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                menuClientesMouseExited(evt);
            }
        });
        jPanel1.add(menuClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 210, 52));

        menuinventario.setBackground(new java.awt.Color(41, 39, 40));
        menuinventario.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 16)); // NOI18N
        menuinventario.setForeground(new java.awt.Color(255, 255, 255));
        menuinventario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/caja.png"))); // NOI18N
        menuinventario.setText("Paquetes");
        menuinventario.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        menuinventario.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        menuinventario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuinventarioMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                menuinventarioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                menuinventarioMouseExited(evt);
            }
        });
        jPanel1.add(menuinventario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 210, 52));

        menuFacturacionYVenta.setBackground(new java.awt.Color(41, 39, 40));
        menuFacturacionYVenta.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 16)); // NOI18N
        menuFacturacionYVenta.setForeground(new java.awt.Color(255, 255, 255));
        menuFacturacionYVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/factura.png"))); // NOI18N
        menuFacturacionYVenta.setText("Facturación");
        menuFacturacionYVenta.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        menuFacturacionYVenta.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        menuFacturacionYVenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuFacturacionYVentaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                menuFacturacionYVentaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                menuFacturacionYVentaMouseExited(evt);
            }
        });
        jPanel1.add(menuFacturacionYVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 210, 52));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Version 0.1");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 740, -1, -1));

        menuLogout.setBackground(new java.awt.Color(41, 39, 40));
        menuLogout.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 16)); // NOI18N
        menuLogout.setForeground(new java.awt.Color(255, 255, 255));
        menuLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_Sign_Out_32px.png"))); // NOI18N
        menuLogout.setText("     Cerrar sesión");
        menuLogout.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        menuLogout.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        menuLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuLogoutMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                menuLogoutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                menuLogoutMouseExited(evt);
            }
        });
        jPanel1.add(menuLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 210, 52));

        Clicked1.setBackground(new java.awt.Color(178, 8, 55));

        javax.swing.GroupLayout Clicked1Layout = new javax.swing.GroupLayout(Clicked1);
        Clicked1.setLayout(Clicked1Layout);
        Clicked1Layout.setHorizontalGroup(
            Clicked1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        Clicked1Layout.setVerticalGroup(
            Clicked1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 52, Short.MAX_VALUE)
        );

        jPanel1.add(Clicked1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 10, 52));

        Clicked2.setBackground(new java.awt.Color(178, 8, 55));

        javax.swing.GroupLayout Clicked2Layout = new javax.swing.GroupLayout(Clicked2);
        Clicked2.setLayout(Clicked2Layout);
        Clicked2Layout.setHorizontalGroup(
            Clicked2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        Clicked2Layout.setVerticalGroup(
            Clicked2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 52, Short.MAX_VALUE)
        );

        jPanel1.add(Clicked2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 10, 52));

        Clicked3.setBackground(new java.awt.Color(178, 8, 55));

        javax.swing.GroupLayout Clicked3Layout = new javax.swing.GroupLayout(Clicked3);
        Clicked3.setLayout(Clicked3Layout);
        Clicked3Layout.setHorizontalGroup(
            Clicked3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        Clicked3Layout.setVerticalGroup(
            Clicked3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 52, Short.MAX_VALUE)
        );

        jPanel1.add(Clicked3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 10, 52));

        Clicked4.setBackground(new java.awt.Color(178, 8, 55));

        javax.swing.GroupLayout Clicked4Layout = new javax.swing.GroupLayout(Clicked4);
        Clicked4.setLayout(Clicked4Layout);
        Clicked4Layout.setHorizontalGroup(
            Clicked4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        Clicked4Layout.setVerticalGroup(
            Clicked4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 52, Short.MAX_VALUE)
        );

        jPanel1.add(Clicked4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 10, 52));

        Clicked5.setBackground(new java.awt.Color(178, 8, 55));

        javax.swing.GroupLayout Clicked5Layout = new javax.swing.GroupLayout(Clicked5);
        Clicked5.setLayout(Clicked5Layout);
        Clicked5Layout.setHorizontalGroup(
            Clicked5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        Clicked5Layout.setVerticalGroup(
            Clicked5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 52, Short.MAX_VALUE)
        );

        jPanel1.add(Clicked5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 10, 52));

        jPanel13.setBackground(new java.awt.Color(146, 10, 48));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_Menu_32px.png"))); // NOI18N
        jButton3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton3.setContentAreaFilled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel13.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 80, 50));

        jLabel1.setBackground(new java.awt.Color(178, 8, 55));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 27)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Envios");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel13.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 130, -1));

        jLabel2.setBackground(new java.awt.Color(178, 8, 55));
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("2024");
        jPanel13.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 120, -1));

        jPanel1.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 220, 60));

        menuIncidentes.setBackground(new java.awt.Color(41, 39, 40));
        menuIncidentes.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 16)); // NOI18N
        menuIncidentes.setForeground(new java.awt.Color(255, 255, 255));
        menuIncidentes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/exclamacion.png"))); // NOI18N
        menuIncidentes.setText("Incidentes");
        menuIncidentes.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        menuIncidentes.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        menuIncidentes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuIncidentesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                menuIncidentesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                menuIncidentesMouseExited(evt);
            }
        });
        jPanel1.add(menuIncidentes, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 210, 52));

        Clicked6.setBackground(new java.awt.Color(178, 8, 55));

        javax.swing.GroupLayout Clicked6Layout = new javax.swing.GroupLayout(Clicked6);
        Clicked6.setLayout(Clicked6Layout);
        Clicked6Layout.setHorizontalGroup(
            Clicked6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        Clicked6Layout.setVerticalGroup(
            Clicked6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 52, Short.MAX_VALUE)
        );

        jPanel1.add(Clicked6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 10, 52));

        PanelHome.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 220, 770));

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
        PanelHome.add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(1360, 20, 35, 35));

        panelContent.setLayout(new java.awt.CardLayout());

        JPGPaquetes.setBackground(new java.awt.Color(245, 245, 245));
        JPGPaquetes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLInicio.setFont(new java.awt.Font("Tahoma", 0, 64)); // NOI18N
        jLInicio.setForeground(new java.awt.Color(102, 102, 102));
        jLInicio.setText("Gestión de Paquetes");
        JPGPaquetes.add(jLInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 90, 620, 250));

        panelContent.add(JPGPaquetes, "card1");

        JPRemitente.setBackground(new java.awt.Color(245, 245, 245));
        JPRemitente.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 62)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Remitente");
        JPRemitente.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 310, -1, -1));

        panelContent.add(JPRemitente, "card2");

        JPConductores.setBackground(new java.awt.Color(245, 245, 245));
        JPConductores.setMinimumSize(new java.awt.Dimension(810, 540));
        JPConductores.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 64)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("Conductores");
        JPConductores.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 270, -1, -1));

        panelContent.add(JPConductores, "card3");

        JPFyV.setBackground(new java.awt.Color(245, 245, 245));
        JPFyV.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 64)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("Facturación y Venta");
        JPFyV.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 330, -1, -1));

        panelContent.add(JPFyV, "card4");

        JPRecepcionista.setBackground(new java.awt.Color(245, 245, 245));
        JPRecepcionista.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 64)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setText("Recepcionista");
        JPRecepcionista.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 250, -1, -1));

        panelContent.add(JPRecepcionista, "card5");

        JPIncidentes.setBackground(new java.awt.Color(245, 245, 245));
        JPIncidentes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel117.setFont(new java.awt.Font("Tahoma", 0, 64)); // NOI18N
        jLabel117.setForeground(new java.awt.Color(102, 102, 102));
        jLabel117.setText("Incidentes");
        JPIncidentes.add(jLabel117, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 270, -1, -1));

        panelContent.add(JPIncidentes, "card6");

        PanelHome.add(panelContent, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, 1180, 690));

        txtID.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtID.setForeground(new java.awt.Color(51, 51, 51));
        txtID.setText("Logged  :");
        PanelHome.add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, 290, -1));

        txtDateLog.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtDateLog.setForeground(new java.awt.Color(51, 51, 51));
        txtDateLog.setText("Date      :");
        PanelHome.add(txtDateLog, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 40, 310, -1));

        Home.add(PanelHome, "home");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Home, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Home, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        getToolkit().beep();
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(null, "Estas seguro de cerrar la aplicacion?", "Warning", dialogButton);
        if (dialogResult == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_btnExitActionPerformed

    private void menuinventarioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuinventarioMouseEntered
        menuinventario.setBackground(Color.decode("#333333"));
    }//GEN-LAST:event_menuinventarioMouseEntered

    private void menuinventarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuinventarioMouseExited
        menuinventario.setBackground(Color.decode("#292728"));
        menuinventario.setOpaque(true);
    }//GEN-LAST:event_menuinventarioMouseExited

    private void menuinventarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuinventarioMouseClicked
        contenido.show(panelContent, "card1");
        cambiarSeccionMenu(0);
        menuinventario.setBackground(Color.decode("#494848"));
        //JFrame ventanaInventario = new JFGestionPaquetes(cnx);
        JFrame ventanaInventario = new JFPaquetes(this.recepcionista);
        VentanaManager.getInstance().mostrarVentana("inventario", ventanaInventario);
        jLInicio.setText("Paquetes");
    }//GEN-LAST:event_menuinventarioMouseClicked


    private void menuProveedoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuProveedoresMouseClicked
        contenido.show(panelContent, "card3");
        cambiarSeccionMenu(2);
        menuProveedores.setBackground(Color.decode("#494848"));
        JFrame ventanaConductor = new JFConductores(this.recepcionista);
        VentanaManager.getInstance().mostrarVentana("conductor", ventanaConductor);
    }//GEN-LAST:event_menuProveedoresMouseClicked

    private void menuProveedoresMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuProveedoresMouseEntered
        menuProveedores.setBackground(Color.decode("#333333"));
        menuProveedores.setOpaque(true);
    }//GEN-LAST:event_menuProveedoresMouseEntered

    private void menuProveedoresMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuProveedoresMouseExited
        menuProveedores.setBackground(Color.decode("#292728"));
        menuProveedores.setOpaque(true);
    }//GEN-LAST:event_menuProveedoresMouseExited

    private void menuEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuEmpleadosMouseClicked
        contenido.show(panelContent, "card5");
        cambiarSeccionMenu(4);
        menuEmpleados.setBackground(Color.decode("#494848"));
        JFrame ventanaRecepcionista = new JFVehiculo(cnx, recepcionista.obtenerSucursal());
        VentanaManager.getInstance().mostrarVentana("recepcionista", ventanaRecepcionista);
    }//GEN-LAST:event_menuEmpleadosMouseClicked

    private void menuEmpleadosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuEmpleadosMouseEntered
        menuEmpleados.setBackground(Color.decode("#333333"));
        menuEmpleados.setOpaque(true);
    }//GEN-LAST:event_menuEmpleadosMouseEntered

    private void menuEmpleadosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuEmpleadosMouseExited
        menuEmpleados.setBackground(Color.decode("#292728"));
        menuEmpleados.setOpaque(true);
    }//GEN-LAST:event_menuEmpleadosMouseExited

    private void menuClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuClientesMouseClicked
        contenido.show(panelContent, "card2");
        cambiarSeccionMenu(1);
        menuClientes.setBackground(Color.decode("#494848"));
        JFrame remintente = new JFClientes();
        VentanaManager.getInstance().mostrarVentana("remintente", remintente);
    }//GEN-LAST:event_menuClientesMouseClicked

    private void menuClientesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuClientesMouseEntered
        menuClientes.setBackground(Color.decode("#333333"));
        menuClientes.setOpaque(true);
    }//GEN-LAST:event_menuClientesMouseEntered

    private void menuClientesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuClientesMouseExited
        menuClientes.setBackground(Color.decode("#292728"));
        menuClientes.setOpaque(true);
    }//GEN-LAST:event_menuClientesMouseExited

    private void menuFacturacionYVentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuFacturacionYVentaMouseClicked
        contenido.show(panelContent, "card4");
        cambiarSeccionMenu(3);
        menuFacturacionYVenta.setBackground(Color.decode("#494848"));
        JFrame ventantaFactura = new JFFacturacion(cnx);
        VentanaManager.getInstance().mostrarVentana("factura1", ventantaFactura);
    }//GEN-LAST:event_menuFacturacionYVentaMouseClicked

    private void menuFacturacionYVentaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuFacturacionYVentaMouseEntered
        menuFacturacionYVenta.setBackground(Color.decode("#333333"));
        menuFacturacionYVenta.setOpaque(true);
    }//GEN-LAST:event_menuFacturacionYVentaMouseEntered

    private void menuFacturacionYVentaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuFacturacionYVentaMouseExited
        menuFacturacionYVenta.setBackground(Color.decode("#292728"));
        menuFacturacionYVenta.setOpaque(true);
    }//GEN-LAST:event_menuFacturacionYVentaMouseExited

    private void menuLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuLogoutMouseClicked
        getToolkit().beep();
        int dialogButton = JOptionPane.YES_NO_OPTION;
        if (SessionManager.getInstance().isCambiarSesion()) {  // Accede a cambiarSesion a través del Singleton
            int dialogResult = JOptionPane.showConfirmDialog(null, "¿Estás seguro/a que quieres salir de esta cuenta?", "Warning", dialogButton);
            if (dialogResult == JOptionPane.YES_OPTION) {
                // Crea una instancia del JFIngresar
                JFIngresar ingresarFrame = new JFIngresar();
                ingresarFrame.setVisible(true); // Muestra el JFIngresar

                // Cierra todas las ventanas abiertas, excepto la nueva ventana ingresarFrame
                Window[] windows = Window.getWindows(); // Obtiene todas las ventanas abiertas
                for (Window window : windows) {
                    if (window != ingresarFrame) { // Cierra todas las ventanas menos la nueva
                        window.dispose();
                    }
                }
                dispose();  // Cierra el JFrame actual si es necesario (es opcional si ya has cerrado todas las demás ventanas)
            }
        } else {
            String mensaje = "Tienes una factura pendiente.";
            String titulo = "¡Aviso Crítico!";
            JOptionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_menuLogoutMouseClicked

    private void menuLogoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuLogoutMouseEntered
        menuLogout.setBackground(Color.decode("#333333"));
        menuLogout.setOpaque(true);
    }//GEN-LAST:event_menuLogoutMouseEntered

    private void menuLogoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuLogoutMouseExited
        menuLogout.setBackground(Color.decode("#292728"));
        menuLogout.setOpaque(true);
    }//GEN-LAST:event_menuLogoutMouseExited



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


    private void jPanel3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_jPanel3MousePressed

    private void jPanel3MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_jPanel3MouseDragged

    public boolean verificarContra(String password) {
        String regex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$";
        return password.matches(regex);
    }
    public Boolean[] cambiarValoresVerdad(Boolean[] valores) {
        for (int i = 0; i < valores.length; i++) {
            valores[i] = true;
        }
        return valores;
    }


    private void menuIncidentesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuIncidentesMouseClicked
        contenido.show(panelContent, "card6");
        cambiarSeccionMenu(5);
        menuIncidentes.setBackground(Color.decode("#494848"));
        JFrame ventanaIncidentes = new JFIncidente(recepcionista);
        VentanaManager.getInstance().mostrarVentana("inventario", ventanaIncidentes);

    }//GEN-LAST:event_menuIncidentesMouseClicked

    private void menuIncidentesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuIncidentesMouseEntered
        menuIncidentes.setBackground(Color.decode("#333333"));
        menuIncidentes.setOpaque(true);
    }//GEN-LAST:event_menuIncidentesMouseEntered

    private void menuIncidentesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuIncidentesMouseExited
        menuIncidentes.setBackground(Color.decode("#292728"));
        menuIncidentes.setOpaque(true);
    }//GEN-LAST:event_menuIncidentesMouseExited

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void limpiarTabla(JTable tabla) {
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        modelo.setRowCount(0); // Establece el número de filas a cero para vaciar la tabla
    }

    private void validarClave(JTextField textField, String esClaveUsuario) {
        String password = textField.getText();
        String mensaje = verificarContrase(password);
        if (esClaveUsuario.equals("1")) {
            claveUsuario = verificarContra(password);
        } else {
            if (esClaveUsuario.equals("2")) {
                claveUsuario2 = verificarContra(password);
            }
        }
        if (!mensaje.isEmpty()) {
            textField.setToolTipText(mensaje);
            textField.setBackground(new Color(255, 204, 204));
        } else {
            textField.setToolTipText(null);
            textField.setBackground(Color.white);
        }
    }

    private String verificarContrase(String contraseña) {
        StringBuilder mensaje = new StringBuilder();
        mensaje.append("<html>La contraseña debe cumplir con lo siguiente:<br>");
        boolean cumpleRequisitos = true;
        if (!contraseña.matches(".*[A-Z].*")) {
            mensaje.append("- Debe contener al menos una letra mayúscula.<br>");
            cumpleRequisitos = false;
        }
        if (!contraseña.matches(".*[a-z].*")) {
            mensaje.append("- Debe contener al menos una letra minúscula.<br>");
            cumpleRequisitos = false;
        }
        if (!contraseña.matches(".*\\d.*")) {
            mensaje.append("- Debe contener al menos un dígito.<br>");
            cumpleRequisitos = false;
        }
        if (!contraseña.matches(".*[@#$%^&+=!].*")) {
            mensaje.append("- Debe contener al menos un carácter especial (@, #, $, %, ^, &, +, =, !).<br>");
            cumpleRequisitos = false;
        }
        if (contraseña.length() < 8) {
            mensaje.append("- Debe tener una longitud mínima de 8 caracteres.<br>");
            cumpleRequisitos = false;
        }

        if (cumpleRequisitos) {
            mensaje.setLength(0); // Si cumple todos los requisitos, vacía el mensaje
        } else {
            mensaje.append("</html>");
        }
        return mensaje.toString();
    }

    public void abrirPDFdesdeBD(int idFactura) {
        byte[] pdfBytes = obtenerPDFdesdeBD(idFactura);
        if (pdfBytes != null) {
            try {
                // Crear un archivo temporal único en la carpeta temporal del sistema
                Path tempFilePath = Files.createTempFile("temp_pdf_", ".pdf");

                // Escribir los bytes del PDF en el archivo temporal
                Files.write(tempFilePath, pdfBytes, StandardOpenOption.CREATE);

                // Abre el archivo temporal con una aplicación de visualización de PDF
                Desktop.getDesktop().open(tempFilePath.toFile());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public byte[] obtenerPDFdesdeBD(int idFactura) {
        try {
            String sql = "SELECT pdf FROM tabla_pdf WHERE idFactura = ?";
            try (PreparedStatement preparedStatement = cnx.prepareStatement(sql)) {
                preparedStatement.setInt(1, idFactura);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        return resultSet.getBytes("pdf");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String mostrarFechaHora(Date fechaYHora, String formato, Locale local) {
        String fechaString;
        SimpleDateFormat formateador;
        if (local == null) {
            formateador = new SimpleDateFormat(formato);
        } else {
            formateador = new SimpleDateFormat(formato, local);
        }

        fechaString = formateador.format(fechaYHora);
        return fechaString;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Clicked1;
    private javax.swing.JPanel Clicked2;
    private javax.swing.JPanel Clicked3;
    private javax.swing.JPanel Clicked4;
    private javax.swing.JPanel Clicked5;
    private javax.swing.JPanel Clicked6;
    private javax.swing.JPanel Home;
    private javax.swing.JPanel JPConductores;
    private javax.swing.JPanel JPFyV;
    private javax.swing.JPanel JPGPaquetes;
    private javax.swing.JPanel JPIncidentes;
    private javax.swing.JPanel JPRecepcionista;
    private javax.swing.JPanel JPRemitente;
    private javax.swing.JPanel PanelHome;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLInicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel menuClientes;
    private javax.swing.JLabel menuEmpleados;
    private javax.swing.JLabel menuFacturacionYVenta;
    private javax.swing.JLabel menuIncidentes;
    private javax.swing.JLabel menuLogout;
    private javax.swing.JLabel menuProveedores;
    private javax.swing.JLabel menuinventario;
    private javax.swing.JPanel panelContent;
    private javax.swing.JLabel txtDateLog;
    private javax.swing.JLabel txtID;
    // End of variables declaration//GEN-END:variables

}
