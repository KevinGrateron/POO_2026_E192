/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import DAO.ProductoDAO;
import Modelo.Producto;
import java.util.List;

/**
 *
 * @author ACER
 */
public class ProductoControlador {

    ProductoDAO dao = new ProductoDAO();
    
    public boolean guardarProducto(Producto p) {
        return dao.agregar(p);
    }

    public List<Producto> obtenerProductos() {
        return dao.listar();
    }

    public boolean actualizarProducto(Producto p) {
        return dao.actualizar(p);
    }

    public boolean eliminarProducto(int id) {
        return dao.eliminar(id);
    }
}
