package com.inventario.dao;

import com.inventario.modelo.Producto;
import com.inventario.database.ConexionBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductoDAO {

    public boolean insertarProducto(Producto producto) {
        String sql = "INSERT INTO productos (nombre, cantidad, precio) VALUES (?, ?, ?)";

        try (Connection conn = ConexionBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, producto.getNombre());
            stmt.setInt(2, producto.getCantidad());
            stmt.setDouble(3, producto.getPrecio());

            int filasInsertadas = stmt.executeUpdate();

            return filasInsertadas > 0;

        } catch (SQLException e) {
            System.out.println("Error al insertar producto: " + e.getMessage());
            return false;
        }
    }
    
    public List<Producto> obtenerTodos() {
        List<Producto> lista = new ArrayList<>();

        String sql = "SELECT * FROM productos";

        try (Connection conn = ConexionBD.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Producto p = new Producto();
                p.setId(rs.getInt("id"));
                p.setNombre(rs.getString("nombre"));
                p.setCantidad(rs.getInt("cantidad"));
                p.setPrecio(rs.getDouble("precio"));
                lista.add(p);
            }

        } catch (SQLException e) {
            System.out.println("❌ Error al consultar productos: " + e.getMessage());
        }

        return lista;
    }
    
    public boolean actualizarProducto(Producto producto) {
    String sql = "UPDATE productos SET nombre = ?, cantidad = ?, precio = ? WHERE id = ?";

    try (Connection conn = ConexionBD.conectar();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, producto.getNombre());
        stmt.setInt(2, producto.getCantidad());
        stmt.setDouble(3, producto.getPrecio());
        stmt.setInt(4, producto.getId());

        int filasActualizadas = stmt.executeUpdate();
        return filasActualizadas > 0;

    } catch (SQLException e) {
        System.out.println("❌ Error al actualizar el producto");
        e.printStackTrace();
        return false;
        }
    }
    public boolean eliminarProducto(int id) {
    String sql = "DELETE FROM productos WHERE id = ?";

    try (Connection conn = ConexionBD.conectar();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setInt(1, id);
        int filasEliminadas = stmt.executeUpdate();
        return filasEliminadas > 0;

    } catch (SQLException e) {
        System.out.println("❌ Error al eliminar el producto");
        e.printStackTrace();
        return false;
        }
    }


}
