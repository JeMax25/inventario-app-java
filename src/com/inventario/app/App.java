package com.inventario.app;

import com.inventario.modelo.Producto;
import com.inventario.dao.ProductoDAO;

import java.util.List;

public class App {
    public static void main(String[] args) {
        ProductoDAO dao = new ProductoDAO();

        //INSERTAR UN NUEVO PRODUCTO
        Producto nuevoProducto = new Producto();
        nuevoProducto.setNombre("Teclado Gamer");
        nuevoProducto.setCantidad(15);
        nuevoProducto.setPrecio(250000);

        boolean resultado = dao.insertarProducto(nuevoProducto);

        if (resultado) {
            System.out.println("✅ Producto insertado correctamente.");
        } else {
            System.out.println("❌ Error al insertar producto.");
        }

        // CONSULTAR TODOS LOS PRODUCTOS
        List<Producto> listaProductos = dao.obtenerTodos();

        System.out.println("Lista de productos:");
        for (Producto p : listaProductos) {
            System.out.println("ID: " + p.getId() +
                               " | Nombre: " + p.getNombre() +
                               " | Cantidad: " + p.getCantidad() +
                               " | Precio: $" + p.getPrecio());
        }
        
        Producto productoExistente = new Producto();
        productoExistente.setId(1); 
        productoExistente.setNombre("Teclado Mecánico RGB");
        productoExistente.setCantidad(20);
        productoExistente.setPrecio(270000);

        boolean actualizado = dao.actualizarProducto(productoExistente);

        if (actualizado) {
            System.out.println("✅ Producto actualizado correctamente.");
        } else {
            System.out.println("❌ No se pudo actualizar el producto.");
        }
        //ELIMINAR PRODUCTO POR ID
        int idAEliminar = 2; // Cambia el ID por uno que exista en tu tabla

        boolean eliminado = dao.eliminarProducto(idAEliminar);

        if (eliminado) {
            System.out.println("Producto eliminado correctamente.");
        } else {
            System.out.println("Error al eliminar el producto.");
        }

    }
}
