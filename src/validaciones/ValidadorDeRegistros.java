/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validaciones;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author USUARIO
 */
public class ValidadorDeRegistros {

    ValidadorCedulas validarDocumentos = new ValidadorCedulas();

    public boolean camposDeRegistros(JTextField textField, JLabel label, String caso) {
        boolean valor = false;
        String texto = textField.getText();
        label.setVisible(true);

        switch (caso) {
            case "d" ->
                valor = validarDireccion(texto);
            case "b" ->
                valor = validarDocumentos.validarRUC(texto);
            case "n" ->
                valor = texto.matches("^[A-Za-záéíóúÁÉÍÓÚñÑüÜ]+( [A-Za-záéíóúÁÉÍÓÚñÑüÜ]+)*$");
            case "c" ->
                valor = validarEmail(texto);
            case "t" ->
                valor = validarTelefono(texto);
            case "telefono" ->
                valor = texto.matches("^\\d{10}$");
            case "cedula" ->
                valor = ValidadorCedulas.validarCedula(texto);
            case "precio" ->
                valor = validarMaximoDosDecimales(texto);
            case "v" ->
                valor = !texto.isEmpty();
            case "i" ->
                valor = texto.matches("^\\d+$");
        }
        if (valor) {
            textField.setBackground(new Color(255, 255, 255));
            label.setVisible(false);
        } else {
            textField.setBackground(new Color(255, 204, 204));
        }

        return valor;
    }

    public boolean camposCliente(JTextField textField, JLabel label, String caso) {
        boolean valor = false;
        switch (caso) {
            case "a" -> {
                boolean cedulaValida = ValidadorCedulas.validarCedula(textField.getText());
                if (!cedulaValida) {
                    textField.setBackground((new Color(255, 204, 204)));
                    label.setVisible(true);
                    label.setText("*CI invalida");
                    valor = false;
                } else {
                    textField.setBackground(Color.WHITE);
                    label.setVisible(false);
                    valor = true;
                }
            }
            case "b" -> {
                String telefono = textField.getText();
                valor = validarTelefono(telefono);
                if (!valor) {
                    label.setVisible(true);
                    label.setText("*Formato: +593-123456789");
                    textField.setBackground(new Color(255, 204, 204));
                } else {
                    label.setVisible(false);
                    textField.setBackground(new Color(255, 255, 255));
                }
            }
        }
        return valor;
    }

    public boolean validarMaximoDosDecimales(String valor) {
        try {
            double numero = Double.parseDouble(valor);
            int decimales = String.valueOf(numero).split("\\.")[1].length();
            return decimales <= 2;
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException ex) {
            return false;
        }
    }

    public String getClipboardContent() {
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        Transferable transferable = clipboard.getContents(null);
        try {
            if (transferable != null && transferable.isDataFlavorSupported(DataFlavor.stringFlavor)) {
                return (String) transferable.getTransferData(DataFlavor.stringFlavor);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public boolean isNumeric(String str) {
        return str.matches("\\d+");
    }

    public static boolean validarTelefono(String telefono) {
        String regexNacional = "^\\+593-\\d{9}$"; // Formato: +593-XXXXXXXXX
        boolean telefonoValido = telefono.matches(regexNacional);
        return telefonoValido;
    }
    
    public static boolean validarDireccion(String dirNegocio) {
        return dirNegocio.matches("^[A-Za-záéíóúÁÉÍÓÚñÑüÜ0-9]+([,.]?[ ]?[A-Za-záéíóúÁÉÍÓÚñÑüÜ0-9]+)*$");
    }
    
    public static boolean validarEmail(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@(gmail\\.com|outlook\\.com|yahoo\\.com|hotmail\\.com|epn\\.edu\\.ec)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}