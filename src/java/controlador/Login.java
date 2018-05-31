/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Pelicula;
import org.apache.log4j.BasicConfigurator;

/**
 *
 * @author usuario
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {
    
    
    private static final Logger LOG = Logger.getLogger(Login.class);

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
        //BasicConfigurator.configure();
        response.setContentType("text/html;charset=UTF-8");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexion = DriverManager.getConnection ("jdbc:mysql://localhost/sakila?useSSL=false", "root", "admin");
            
            String usuario = request.getParameter("usuario").toUpperCase();
            String pass = request.getParameter("password").toUpperCase();
            logear("USUARIO : " + usuario + " - PASSWORD : " + pass);
            
            //ResultSet rs = conexion.prepareStatement("select * from customer where first_name = ? and last_name = ?", new String[]{usuario,pass}).executeQuery();
            PreparedStatement ps = conexion.prepareStatement("select * from customer where first_name = ? and last_name = ?");
            ps.setString(1, usuario);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            if (rs.first()) {
                ArrayList<Pelicula> peliculas = new ArrayList<Pelicula>();
                rs = conexion.createStatement().executeQuery("select film.title, film.description, film.release_year, language.name, film.length, "
                        + "film.rating from film join language on (film.language_id = language.language_id);");
                while (rs.next()) {
                    Pelicula p = new Pelicula(rs.getString(1),rs.getString(2),rs.getString(4),rs.getString(6),rs.getInt(3),rs.getInt(5));
                    peliculas.add(p);
                }
                request.setAttribute("peliculas",peliculas);
                request.setAttribute("usuario",usuario);
                request.getRequestDispatcher("/bienvenida.htm").forward(request, response);
                
                
            } else {
                request.setAttribute("error", "El usuario o contraseña no son válidos");
                request.getRequestDispatcher("/index.htm").forward(request, response);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
        
    void logear(String mensaje) {
        LOG.debug("****************************************************************");
        LOG.debug(mensaje);
        LOG.debug("****************************************************************");
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
