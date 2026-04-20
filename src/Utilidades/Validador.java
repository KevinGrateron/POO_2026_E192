/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilidades;

/**
 *
 * @author ACER
 */
public class Validador {

    public static boolean camposVacios(String nombre, String categoria, String precio, String cantidad) {
        return nombre.isEmpty() || categoria.isEmpty() || precio.isEmpty() || cantidad.isEmpty();
    }
    
    public static boolean esNumero(String texto) {
        try{
            Double.parseDouble(texto);
            return true;
        }catch(NumberFormatException  e){
            return false;
        }
    }
    
}
