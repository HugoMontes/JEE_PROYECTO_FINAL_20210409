/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.educomser.controller.login;

import com.educomser.bean.Usuario;
import com.educomser.bo.UsuarioBo;
import java.io.IOException;
import java.util.Date;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author hmontes
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {
    
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
        // 1. Obtener los datos del formulario
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        // 2. Verificar si es usuario valido
        Usuario usuario = usuarioBo.buscarUsuarioLogeado(username, password);
        if(usuario != null){
            // 3. Crear una variable de sesion a travez de request
            HttpSession session = request.getSession();
            // 4. Declarar una variable de sesion con el objeto usuario
            session.setAttribute("usuario", usuario);
            // 5. Declaramos una variable de sesion del ultimo acceso
            session.setAttribute("lastAccess", new Date(session.getLastAccessedTime()));
            // 6. Indicar el timpo de vida de la sesion en segundos
            session.setMaxInactiveInterval(60);
            // 7. Redireccionar a la pagina home.jsp
            // request.getRequestDispatcher("home.jsp").forward(request, response);
            response.sendRedirect(request.getContextPath()+"/HomeServlet");
        } else {
            request.setAttribute("error", "Error al logearse.");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }        
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
        processRequest(request, response);
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
        processRequest(request, response);
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
