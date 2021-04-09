/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.educomser.controller.usuario;

import com.educomser.bean.Usuario;
import com.educomser.bo.UsuarioBo;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Hugo
 */
@WebServlet(name = "UsuarioNuevoServlet", urlPatterns = {"/UsuarioNuevoServlet"})
public class UsuarioNuevoServlet extends HttpServlet {
    
    @EJB
    private UsuarioBo usuarioBo;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // processRequest(request, response);
        // Renderizar formulario para nuevo usuario
        request.getRequestDispatcher("usuario/nuevo.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // processRequest(request, response);
        // Obtener datos del formulario en un javabean
        Usuario usuario = new Usuario();
        usuario.setNombre(request.getParameter("nombre"));
        usuario.setApellidoPaterno(request.getParameter("paterno"));
        usuario.setApellidoMaterno(request.getParameter("materno"));
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            usuario.setFechaNacimiento(sdf.parse(request.getParameter("fechaNac")));
        } catch (ParseException ex) {
            Logger.getLogger(UsuarioNuevoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        usuario.setUsername(request.getParameter("usuario"));
        usuario.setPassword(request.getParameter("password"));
        usuario.setEmail(request.getParameter("email"));
        usuario.setStatus(Integer.parseInt(request.getParameter("estado")));      
        // Guardar los datos del formulario en la base de datos
        usuarioBo.guardar(usuario);     
        // Redireccionar al formulario
        // request.getRequestDispatcher("usuario/nuevo.jsp").forward(request, response);
        response.sendRedirect(request.getContextPath()+"/UsuarioNuevoServlet");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
