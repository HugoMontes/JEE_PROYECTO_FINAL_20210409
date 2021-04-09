
package com.educomser.bo;

import com.educomser.bean.Usuario;
import java.util.List;
import javax.ejb.Local;

@Local
public interface UsuarioBo {
    public void guardar(Usuario usuario);
    public void actualizar(Usuario usuario);
    public void eliminar(int id);
    public List<Usuario> listarUsuarios();
    public Usuario buscarPorId(int id);
}
