package com.educomser.bo.impl;

import com.educomser.bean.Usuario;
import com.educomser.bo.UsuarioBo;
import com.educomser.dao.UsuarioDao;
import com.educomser.dao.impl.UsuarioDaoImpl;
import com.educomser.util.MD5;
import java.util.List;
import javax.ejb.Stateless;

@Stateless
public class UsuarioBoImpl implements UsuarioBo {

    private final UsuarioDao usuarioDao = new UsuarioDaoImpl();

    @Override
    public void guardar(Usuario usuario) {
        usuarioDao.save(usuario);
    }

    @Override
    public void actualizar(Usuario usuario) {
        usuarioDao.update(usuario);
    }

    @Override
    public void eliminar(int id) {
        usuarioDao.delete(id);
    }

    @Override
    public List<Usuario> listarUsuarios() {
        return usuarioDao.findAll();
    }

    @Override
    public Usuario buscarPorId(int id) {
        return usuarioDao.findById(id);
    }

    @Override
    public Usuario buscarUsuarioLogeado(String username, String password) {
        return usuarioDao.findByUsernameAndPassword(username.toUpperCase(), MD5.getMd5(password));
    }
}
