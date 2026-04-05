/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexion.ConexionDB;
import Modelo.Producto;
import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;

/**
 *
 * @author ACER
 */
public class ProductoDAO {
     public boolean agregarProducto(Producto p) {
         String sql = "INSERT INTO producto(nombre,categoria,precio,cantidad) VALUES(?,?,?,?)";

        try (Connection con = ConexionDB.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, p.getNombre());
            ps.setString(2, p.getCategoria());
            ps.setDouble(3, p.getPrecio());
            ps.setInt(4, p.getCantidad());

            ps.executeUpdate();
            return true;

        } catch (Exception e) {
            System.out.println("Error agregar: " + e);
            return false;
        }    
     }
}
