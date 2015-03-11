<%-- 
    Document   : form2
    Created on : 10-mar-2015, 17:01:38
    Author     : 2DAWT
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
                    <a href="http://es.linkedin.com/in/jloborod/" target="_blanck">
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
                        <h1>LOTERÍA JAVA - MODO TEXTO</h1>
                        <%int num_boletos = Integer.parseInt((String) session.getAttribute("num_boletos"));%>
                        <p>Se juegan <%=(String) session.getAttribute("num_boletos")%> boletos.</p>
                        <form action="main">
                            <% for(int i=0; i< num_boletos;i++){%>
                            <div class="elemento">
                                <label for="boleto_<%=i+1%>">Boleto <%=i+1%> - Nº Apuestas</label>
                                <select name="apuesta">
                                    <option></option>
                                    <% for(int j=0; j< 6;j++){%>
                                    <option><%=j+1%></option>
                                    <%}%>
                                </select>
                                    
                                
                            </div>
                            <%}%>
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
