package com.educomser.dao;

import com.educomser.bean.Usuario;
import java.util.List;

public interface UsuarioDao {
    public void save(Usuario usuario);
    public void update(Usuario usuario);
    public void delete(int id);
    public List<Usuario> findAll();
    public Usuario findById(int id);
    public Usuario findByUsernameAndPassword(String username, String password);
}
