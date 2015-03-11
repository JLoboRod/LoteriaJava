package loteria.joaquin;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author JLoboRod
 */
@WebServlet(urlPatterns = {"/MainServlet"})
public class MainServlet extends HttpServlet {

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

        RequestDispatcher rd = null; //Para redireccionar 
        /*/Aquí fijamos el destino de la redirección
         rd = request.getRequestDispatcher("boleto.jsp");
         rd.forward(request, response); //Redireccionamos
         */
        
        if(request.getParameter("modo")!=null){
            //request.getSession().setAttribute("modo", request.getParameter("modo")); //Guardamos el modo en sesión
            
        }
        
        if (request.getParameter("paso1")!=null) {
            request.getSession().setAttribute("num_boletos", request.getParameter("num_boletos"));
            //Aquí fijamos el destino de la redirección
            rd = request.getRequestDispatcher("form2.jsp");
            rd.forward(request, response); //Redireccionamos
            
        } else if (request.getParameter("paso2") != null) {
            
            Object oBoletos=request.getSession().getAttribute("num_boletos");
            int num_boletos = Integer.parseInt(oBoletos.toString());
            String [] num_apuestas=request.getParameterValues("num_apuestas");
            Boleto[] lista_boletos = new Boleto[num_boletos];
            
            for (int i = 0; i < num_boletos; i++) {
                lista_boletos[i] = new Boleto(Integer.parseInt(num_apuestas[i])); //Generamos los boletos
            }
            
            request.getSession().setAttribute("lista_boletos", lista_boletos); //Pasamos el array de boletos a sesión
            
            rd = request.getRequestDispatcher("texto.jsp");
            rd.forward(request, response); //Redireccionamos
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
