package com.educomser.dao.impl;

import com.educomser.bean.Usuario;
import com.educomser.dao.UsuarioDao;
import com.educomser.util.Conexion;
import com.educomser.util.MD5;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioDaoImpl implements UsuarioDao {

    private Conexion conexion;

    @Override
    public void save(Usuario usuario) {
        try {
            conexion = new Conexion();
            String sql = "INSERT INTO usuario(nombre, apellido_paterno, apellido_materno, fecha_nacimiento, username, password, email, status) VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement st = conexion.getConnection().prepareStatement(sql);
            st.setString(1, usuario.getNombre());
            st.setString(2, usuario.getApellidoPaterno());
            st.setString(3, usuario.getApellidoMaterno());
            st.setDate(4, new java.sql.Date(usuario.getFechaNacimiento().getTime()));
            st.setString(5, usuario.getUsername());
            st.setString(6, MD5.getMd5(usuario.getPassword()));
            st.setString(7, usuario.getEmail());
            st.setInt(8, usuario.getStatus());
            Logger.getLogger(getClass().getName()).log(Level.INFO, getClass().getName() + " | {0}", st.toString());
            st.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        conexion.close();
    }

    @Override
    public void update(Usuario usuario) {
        try {
            conexion = new Conexion();
            String sql = "UPDATE usuario SET nombre=?, apellido_paterno=?, apellido_materno=?, fecha_nacimiento=?, username=?, email=?, status=?, updated_at=? WHERE id=?";
            PreparedStatement st = conexion.getConnection().prepareStatement(sql);
            st.setString(1, usuario.getNombre());
            st.setString(2, usuario.getApellidoPaterno());
            st.setString(3, usuario.getApellidoMaterno());
            st.setDate(4, new java.sql.Date(usuario.getFechaNacimiento().getTime()));
            st.setString(5, usuario.getUsername());
            st.setString(6, usuario.getEmail());
            st.setInt(7, usuario.getStatus());
            st.setTimestamp(8, new java.sql.Timestamp(new Date().getTime()));
            st.setLong(9, usuario.getId());
            Logger.getLogger(getClass().getName()).log(Level.INFO, getClass().getName() + " | {0}", st.toString());
            st.executeUpdate();;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        conexion.close();       
    }

    @Override
    public void delete(int id) {
        try {
            conexion = new Conexion();
            String sql = "DELETE FROM usuario WHERE id=?";
            PreparedStatement st = conexion.getConnection().prepareStatement(sql);
            st.setInt(1, id);
            Logger.getLogger(getClass().getName()).log(Level.INFO, getClass().getName() + " | {0}", st.toString());
            st.executeUpdate();
            st.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        conexion.close();
    }

    @Override
    public List<Usuario> findAll() {
        List<Usuario> list = new ArrayList<Usuario>();
        try {
            conexion = new Conexion();
            String sql = "select id, nombre, apellido_paterno, apellido_materno, fecha_nacimiento, username, email, status, created_at from usuario;";
            Logger.getLogger(getClass().getName()).log(Level.INFO, getClass().getName() + " | {0}", sql);
            Statement st = conexion.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setApellidoPaterno(rs.getString("apellido_paterno"));
                usuario.setApellidoMaterno(rs.getString("apellido_materno"));
                usuario.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
                usuario.setUsername(rs.getString("username"));
                usuario.setEmail(rs.getString("email"));
                usuario.setStatus(rs.getInt("status"));
                usuario.setCreatedAt(rs.getDate("created_at"));
                list.add(usuario);
            }
        } catch (SQLException ex) {
             ex.printStackTrace();
        }
        conexion.close();
        return list;
    }

    @Override
    public Usuario findById(int id) {
        Usuario usuario = null;
        try {
            conexion = new Conexion();
            String sql = "select id, nombre, apellido_paterno, apellido_materno, fecha_nacimiento, username, email, status, created_at from usuario where id=?";
            PreparedStatement st = conexion.getConnection().prepareStatement(sql);
            st.setInt(1, id);
            Logger.getLogger(getClass().getName()).log(Level.INFO, getClass().getName() + " | {0}", st.toString());
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setApellidoPaterno(rs.getString("apellido_paterno"));
                usuario.setApellidoMaterno(rs.getString("apellido_materno"));
                usuario.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
                usuario.setUsername(rs.getString("username"));
                usuario.setEmail(rs.getString("email"));
                usuario.setStatus(rs.getInt("status"));
                usuario.setCreatedAt(rs.getDate("created_at"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        conexion.close();
        return usuario;
    }
}
