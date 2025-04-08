package com.inventario.principal;

import com.inventario.database.ConexionBD;

public class Main {
    public static void main(String[] args) {
        if (ConexionBD.conectar() != null) {
            System.out.println("✅ Conexión verificada con éxito.");
        } else {
            System.out.println("❌ No se pudo establecer conexión.");
        }
    }
}
