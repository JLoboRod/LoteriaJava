/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loteria.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author JLoboRod
 */
public class Usuarios extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        
       
        
        RequestDispatcher rd = null;
        
        Object oSession = request.getSession().getAttribute("usuario");
        String usuario_sesion = "";
        
        if(oSession != null){
            usuario_sesion = oSession.toString();
            
            String accion = request.getParameter("accion");
            if("salir".equals(accion)){
                request.getSession().removeAttribute("usuario");
            }
            rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
        }
        else{
            String usuario = request.getParameter("usuario");
            String password = request.getParameter("password");
       
            if(loginCorrecto(usuario, password)){
                //Entramos
                request.getSession().setAttribute("usuario", usuario);
            }
            else{ //Error
                request.setAttribute("error_login", "Datos incorrectos");
                request.setAttribute("usuario", usuario);
                request.setAttribute("password", password);
            }
            
            rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
        }
        
        
        
    }
    
    /**
     * 
     * @param user
     * @param pass
     * @return 
     */
    public boolean loginCorrecto(String user, String pass){
        if(user.equals("2daw") && pass.equals("2daw")){
            return true;  
        }        
        else{
            return false;
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
    /*
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    */
}
