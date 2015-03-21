<%-- 
    Document   : ultima_apuesta
    Created on : 13-mar-2015, 14:19:42
    Author     : JLoboRod
--%>

<%@page import="loteria.clases.GraficoHelper"%>
<%@page import="loteria.clases.Apuesta"%>
<%@page import="loteria.clases.Boleto"%>
<%@page import="loteria.clases.FormHelper"%>
<%FormHelper fh = new FormHelper();
    Object oPrecio = request.getAttribute("precio_total");
    Integer precio_total = 0;
    if (oPrecio != null) {
        precio_total = Integer.parseInt(oPrecio.toString());
    }
    GraficoHelper gh = new GraficoHelper();
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
            <%@include file="sidebar.jsp" %>
            <div id="principal">
                <div class="panel shadow">
                    <div class="contenedor">
                        <h1>LOTERÍA JAVA</h1>
                        <h3>Última apuesta</h3>
                        <%
                            Apuesta apuesta = (Apuesta) session.getAttribute("apuesta");
                            int numero_apuesta = 0;
                            Object oNumAp = session.getAttribute("numero_apuesta");
                            if(oNumAp!=null){
                                numero_apuesta = Integer.parseInt(oNumAp.toString());
                            }
                        %>
                        <br/> 
                        <% if(apuesta != null){%>
                        <p>A continuación se muestra la última apuesta del usuario activo:</p>
                        <br/>
                        <%=gh.getHTMLApuesta(apuesta, numero_apuesta)%>
                        <br/>
                        <br/>
                        <%}else{%>
                            <p>No hay apuestas almacenadas</p>
                        <%}%>
                        
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>

