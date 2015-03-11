<%-- 
    Document   : texto
    Created on : 11-mar-2015, 12:26:05
    Author     : JLoboRod
--%>

<%@page import="loteria.joaquin.Boleto"%>
<%@page import="loteria.joaquin.Apuesta"%>
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
                        <h3>Modo texto</h3>
                        <%
                            Boleto[] lista_boletos = (Boleto[])request.getAttribute("lista_boletos"); 
                        %>
                        <br/> 
                        <p>A continuación se muestran los boletos solicitados:</p>
                        
                        <!--Recorremos la lista de boletos-->
                        <% for(int i=0; i< lista_boletos.length;i++){%>
                        <br/>
                        <p>Boleto <%=i+1%>:</p>
                            <!--Recorremos apuestas de cada boleto-->
                            <% 
                            Boleto boleto = lista_boletos[i];
                            for(int j=0; j< boleto.NumApuestas();j++){ 
                            %>
                            <p>Apuesta <%=j+1%>: &nbsp;
                                <!--Recorremos los valores de cada apuesta-->
                                <%Apuesta apuesta = boleto.getApuesta(j);%>
                                <% for(int k=0;k<apuesta.NumValores();k++){%>
                                    <%=apuesta.getValor(k)%>
                                    <%if(k < apuesta.NumValores() -1 ){%>
                                        ,
                                    <%}
                                }%>
                                </p>
                                <!--Faltan reintegro e importe-->
                            <%}%>
                            
                        <%}%>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>

