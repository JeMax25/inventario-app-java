package com.inventario.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    private static final String URL = "jdbc:mysql://localhost:3306/inventario_DB";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection conectar() {
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión exitosa a la base de datos");
            return conn;
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos");
            e.printStackTrace();
            return null;
        }
    }
}

