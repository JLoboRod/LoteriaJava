<%-- 
    Document   : form1
    Created on : 10-mar-2015, 13:28:44
    Author     : Joaquin
--%>

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
                        <a class="btn btn-rojo" href="form1.jsp">Modo Texto</a>
                    </div>
                    <div class="elemento">
                        <a class="btn btn-rojo" href="form1.jsp">Modo Gráfico</a>
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
                        <input type="text" name="num_boletos" value="1"/>
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
