/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author isard
 */
public class MySQLProyecto {
    /**
     * Ejecuta una acción en la base de datos: registrar, ingresar o eliminar.
     * @param nombre Nombre del usuario
     * @param apellidos Apellidos del usuario (solo para registrar)
     * @param contraseña Contraseña del usuario
     * @param tipoConsulta Tipo de acción: registrar, ingresar, eliminar
     */

    private boolean accesoCorrecto = false;
    private boolean registroCorrecto = false;
    private boolean eliminacionCorrecta = false;

    public MySQLProyecto(String nombre, String apellidos, String contraseña, String tipoConsulta) {
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/clientes", "root", "");
            Statement s = conexion.createStatement();

            switch (tipoConsulta) {
                case "registrar":
                    String insert = "INSERT INTO usuario (Nombre, Apellidos, Contraseña) " +
                                    "VALUES ('" + nombre + "', '" + apellidos + "', '" + contraseña + "')";
                    s.executeUpdate(insert);
                    registroCorrecto = true;
                    JOptionPane.showMessageDialog(null, "Usuario registrado con éxito.");
                    break;

                case "ingresar":
                    String query = "SELECT * FROM usuario WHERE Nombre='" + nombre + "' AND Contraseña='" + contraseña + "'";
                    ResultSet rs = s.executeQuery(query);
                    if (rs.next()) {
                        accesoCorrecto = true;
                    } else {
                        JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos.");
                    }
                    break;

                case "eliminar":
                    String delete = "DELETE FROM usuario WHERE Nombre='" + nombre + "' AND Contraseña='" + contraseña + "'";
                    int filas = s.executeUpdate(delete);
                    if (filas > 0) {
                        JOptionPane.showMessageDialog(null, "Usuario eliminado correctamente.");
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontró el usuario.");
                    }
                    break;
            }

            conexion.close();
        } catch (SQLIntegrityConstraintViolationException e) {
            JOptionPane.showMessageDialog(null, "La contraseña ya existe (clave primaria).");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean accesoPermitido() {
        return accesoCorrecto;
    }

    public boolean registroExitoso() {
        return registroCorrecto;
    }
    
    public boolean eliminacionExitosa() {
        return eliminacionCorrecta;
    }
}
