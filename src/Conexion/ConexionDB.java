/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException ;

/**
 *
 * @author ACER
 */
public class ConexionDB {
    public static Connection conectar() {
        Connection  con = null;
        try{
            con = DriverManager.getConnection("jdbc:sqlite:C:/Users/ACER/Documents/inventario.db");
            //System.out.println("Conexión exitosa");
        }catch (SQLException e) {
            System.out.println("Error conexión: " + e.getMessage());
            System.out.println("Texto de Prueba grateron  gaste la papa");            
        }
        return con;
    }
}
