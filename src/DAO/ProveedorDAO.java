/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Modelo.Proveedor;
import Conexion.ConexionDB; // ¡Ajustado al nombre exacto de tu compañero!
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author enciso caleb
 */
public class ProveedorDAO {
    
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    // 1. MÉTODO PARA REGISTRAR UN PROVEEDOR
    public boolean registrarProveedor(Proveedor prov) {
        String sql = "INSERT INTO proveedor (nit, nombre, telefono, direccion, ciudad) VALUES (?,?,?,?,?)";
        try {
            con = ConexionDB.getConexion(); // Usamos tu clase ConexionDB
            ps = con.prepareStatement(sql);
            ps.setInt(1, prov.getNit());
            ps.setString(2, prov.getNombre());
            ps.setString(3, prov.getTelefono());
            ps.setString(4, prov.getDireccion());
            ps.setString(5, prov.getCiudad());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al registrar proveedor: " + e.toString());
            return false;
        } finally {
            try {
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
    }

    // 2. MÉTODO PARA LISTAR TODOS LOS PROVEEDORES
    public List<Proveedor> listarProveedores() {
        List<Proveedor> lista = new ArrayList<>();
        String sql = "SELECT * FROM proveedor";
        try {
            con = ConexionDB.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Proveedor prov = new Proveedor();
                prov.setNit(rs.getInt("nit"));
                prov.setNombre(rs.getString("nombre"));
                prov.setTelefono(rs.getString("telefono"));
                prov.setDireccion(rs.getString("direccion"));
                prov.setCiudad(rs.getString("ciudad"));
                lista.add(prov);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar proveedores: " + e.toString());
        } finally {
            try {
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
        return lista;
    }

    // 3. MÉTODO PARA MODIFICAR UN PROVEEDOR
    public boolean modificarProveedor(Proveedor prov) {
        String sql = "UPDATE proveedor SET nombre=?, telefono=?, direccion=?, ciudad=? WHERE nit=?";
        try {
            con = ConexionDB.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, prov.getNombre());
            ps.setString(2, prov.getTelefono());
            ps.setString(3, prov.getDireccion());
            ps.setString(4, prov.getCiudad());
            ps.setInt(5, prov.getNit());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al modificar proveedor: " + e.toString());
            return false;
        } finally {
            try {
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
    }

    // 4. MÉTODO PARA ELIMINAR UN PROVEEDOR
    public boolean eliminarProveedor(int nit) {
        String sql = "DELETE FROM proveedor WHERE nit=?";
        try {
            con = ConexionDB.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, nit);
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al eliminar proveedor: " + e.toString());
            return false;
        } finally {
            try {
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
    }
}