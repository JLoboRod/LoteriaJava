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
import loteria.clases.Boleto;

/**
 *
 * @author JLoboRod
 */
public class Principal extends HttpServlet {

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

        String modo = request.getParameter("modo");
        String paso1 = request.getParameter("paso1");
        String paso2 = request.getParameter("paso2");
        
        request.setAttribute("modo", request.getParameter("modo"));
        
        if (paso1 == null && paso2 == null) {
            
            rd = request.getRequestDispatcher("form1.jsp");
            rd.forward(request, response);
        } else if (paso1 != null && paso2 == null) {
            String num_boletos = request.getParameter("num_boletos");

            request.setAttribute("num_boletos", num_boletos);
            

            String error = "";
            error = Filtro("num_boletos", num_boletos);

            if (error != "") { //Hay errores
                //Cargamos el formulario de nuevo con los errores
                request.setAttribute("error", (String) error);
                rd = request.getRequestDispatcher("form1.jsp");
            } else { //No hay errores
                //Aquí fijamos el destino de la redirección
                rd = request.getRequestDispatcher("form2.jsp");
            }
            rd.forward(request, response); //Redireccionamos

        } else if (paso2 != null && paso1 == null) {
            boolean hayErrores = false;
            Object oBoletos = request.getParameter("num_boletos");
            int num_boletos = Integer.parseInt(oBoletos.toString());
            
            Object oNumApuestas = request.getParameterValues("num_apuestas");
            if (oNumApuestas != null) {
                String[] num_apuestas = (String[]) oNumApuestas;
                
                String[] errores = new String[num_apuestas.length];
                for (int i = 0; i < num_apuestas.length; i++) {
                    try {
                        String error = Filtro("num_apuestas", (String) num_apuestas[i]);
                        if(error != ""){
                            hayErrores = true;
                        }
                        errores[i] = error;
                    } catch (Exception e) {
                        try (PrintWriter out = response.getWriter()) {
                            out.println("Algo no va bien con num_apuestas...");
                        }
                    }
                }
                if (hayErrores) { //Hay errores
                    request.setAttribute("errores", (String[])errores);
                    
                    rd = request.getRequestDispatcher("form2.jsp");
                } else {
                    Boleto[] lista_boletos = new Boleto[num_boletos];
                    int precio_total = 0;
                    for (int i = 0; i < num_boletos; i++) {
                        lista_boletos[i] = new Boleto(Integer.parseInt(num_apuestas[i])); //Generamos los boletos
                        precio_total += lista_boletos[i].getPrecio();
                    }

                    request.setAttribute("lista_boletos", lista_boletos); //Pasamos el array de boletos a sesión
                    request.setAttribute("precio_total", precio_total);
                    
                    String destino = "";
                    destino = modo + ".jsp";

                    rd = request.getRequestDispatcher(destino);
                }

            }

            rd.forward(request, response); //Redireccionamos

        } else {
            try (PrintWriter out = response.getWriter()) {
                out.println("Algo no va bien con la redirección...");
            }
        }
    }

    /**
     * Función que filtra los valores que llegan de los formularios
     *
     * @param clave
     * @param valor
     * @return
     */
    public String Filtro(String clave, String valor) {
        String error = "";
        if (clave == "num_boletos") {
            if (valor == "") {
                error = "Debe especificarse un número de boletos";
            } else {

                try {
                    int num_boletos = Integer.parseInt(valor);
                    if (num_boletos <= 0 || num_boletos > 10) {
                        error = "El número debe estar entre 1 y 10";
                    }
                } catch (Exception e) {
                    error = "El número de boletos debe ser un número";
                }
            }
        }
        if (clave == "num_apuestas") {
            if ((String)valor == "Seleccione" || valor == "") {
                error = "Debe especificarse un número de apuestas";
            } else {
                try {
                    int num_apuestas = Integer.parseInt(valor);
                    if (num_apuestas <= 0 || num_apuestas > 8) {
                        error = "El número debe estar entre 1 y 8";
                    }
                } catch (Exception e) {
                    error = "Debe especificar un número entre 1 y 8";
                }
            }
        }
        return error;
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
