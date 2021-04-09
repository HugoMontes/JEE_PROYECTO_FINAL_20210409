package com.educomser.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {

    private Connection connection;
    private static String DRIVER = null;
    private static String DATABASE = null;
    private static String URL = null;
    private static String USERNAME = null;
    private static String PASSWORD = null;
    static Properties prop = null;

    static {
        try(InputStream input = new FileInputStream(Util.RUTA)){
            prop = new Properties();
            prop.load(input);
            URL = prop.getProperty("URL");
            DRIVER = prop.getProperty("DRIVER");
            DATABASE = prop.getProperty("DATABASE");
            USERNAME = prop.getProperty("USERNAME");
            PASSWORD = prop.getProperty("PASSWORD");
        } catch (FileNotFoundException ex) {
            String msg = "Archivo de credenciales para la conexion a la base de datos no encontrado.";
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, msg, ex);
        } catch (IOException ex) {
            String msg = "Credenciales de conexion no encontradas.";
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, msg, ex);
        }
    }

    public Conexion() {
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL + DATABASE, USERNAME, PASSWORD);
        } catch (ClassNotFoundException ex) {
            String msg = "Error al cargar controlador de Base de Datos";
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, msg, ex);
        } catch (SQLException ex) {
            String msg = "Error en la cadena de conexion de la Base de Datos";
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, msg, ex);
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void close() {
        try {
            connection.close();
        } catch (SQLException ex) {
            String msg = "Error al cerrar conexion";
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, msg, ex);
        }
    }
}
