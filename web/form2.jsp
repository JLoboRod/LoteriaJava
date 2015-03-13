<%-- 
    Document   : form2
    Created on : 10-mar-2015, 17:01:38
    Author     : 2DAWT
--%>
<%@page import="loteria.clases.FormHelper"%>
<%
    FormHelper fh = new FormHelper();
    String num_boletos = request.getParameter("num_boletos");
    //Object[] strErrores =request.getParameterValues("errores");
    
    String[] errores = (String[])request.getAttribute("errores");
    Object oModo = request.getAttribute("modo");
    String modo = "";
    if(oModo!=null){
        modo = (String)oModo;
    }
%>    
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lotería Java</title>
        <link rel="stylesheet" type="text/css" href="assets/css/estilos.css">
    </head>
    <body>
        <div class="contenedor">
            <div id="sidebar">
                <div class="panel shadow" id="autor">
                    <a href="http://es.linkedin.com/in/jloborod/" target="_blank">
                        <img class="avatar" src="assets/img/autor.jpg">
                        <p id="nombre">Joaquín Lobo Rodríguez</p>
                        <p id="info">2ºDAW - DWEServidor</p>
                    </a>
                </div>
                <div class="panel shadow" id="menu">
                    <h1>Opciones</h1>
                    <div class="elemento">
                        <a class="btn btn-rojo" href="MainServlet?modo=texto">Modo Texto</a>
                    </div>
                    <div class="elemento">
                        <a class="btn btn-rojo" href="MainServlet?modo=grafico">Modo Gráfico</a>
                    </div>
                </div>
            </div>
            <div id="principal">
                <div class="panel shadow">
                    <div class="contenedor">
                        <h1>LOTERÍA JAVA</h1>
                        <h3>Modo <%=modo%></h3>
                        <p>Se juegan <%=num_boletos%> boletos.</p>
                        <form action="MainServlet">
                            <% for (int i = 0; i < Integer.parseInt(num_boletos); i++) {%>
                            <div class="elemento">
                                <label for="num_apuestas>">Boleto <%=i + 1%> - Nº Apuestas</label>
                                <select name="num_apuestas">
                                    <option>Seleccione</option>
                                    <% for (int j = 0; j < 6; j++) {%>
                                    <option><%=j + 1%></option>
                                    <%}%>
                                </select>
                                <%=errores!=null?fh.ShowIfError(errores[i]):""%>
                            </div>
                            <%}%>
                            <!--inputs ocultos-->
                            <input type="hidden" name="num_boletos" value="<%=num_boletos%>"/>
                            <input type="hidden" name="modo" value="<%=modo%>"/>
                            <div class="elemento">
                                <input class="btn btn-rojo" type="submit" name="paso2" value="Continuar"/>
                            </div>  
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>

