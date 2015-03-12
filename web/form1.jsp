<%-- 
    Document   : form1.jsp
    Created on : 12-mar-2015, 15:59:49
    Author     : 2DAWT
--%>

<%@page import="loteria.clases.FormHelper"%>
<%
    FormHelper fh = new FormHelper();
    String num_boletos = request.getParameter("num_boletos");
    Object strError=request.getAttribute("error");
    String error="";
    if (strError!=null) {
        error = strError.toString();
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
                    <% String modo = (String)request.getAttribute("modo");%>
                    <h3>Modo <%=modo%></h3>
                    <form action="MainServlet">
                        <div class="elemento">
                        <label for="num_boletos">Nº Boletos</label>
                        <input type="text" name="num_boletos" value="<%=fh.Valor(num_boletos, (error=="")?"1":"")%>"/>
                        <%=fh.ShowIfError(error)%>
                        </div>
                        <input type="hidden" name="modo" value="<%=modo%>">
                        <div class="elemento">
                        <input class="btn btn-rojo" type="submit" name="paso1" value="Continuar"/>
                        </div>
                    </form>
                </div>
            </div>
            </div>
        </div>
    </body>
</html>
