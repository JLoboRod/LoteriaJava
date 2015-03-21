<%-- 
    Document   : texto
    Created on : 11-mar-2015, 12:26:05
    Author     : JLoboRod
--%>

<%@page import="loteria.clases.Apuesta"%>
<%@page import="loteria.clases.Boleto"%>
<%@page import="loteria.clases.FormHelper"%>
<%
    FormHelper fh = new FormHelper();
    Object oPrecio = request.getAttribute("precio_total");
    Integer precio_total = 0;
    if (oPrecio != null) {
        precio_total = Integer.parseInt(oPrecio.toString());
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
            <%@include file="sidebar.jsp" %>
            <div id="principal">
                <div class="panel shadow">
                    <div class="contenedor">
                        <h1>LOTERÍA JAVA</h1>
                        <h3>Modo texto</h3>
                        <%
                            Boleto[] lista_boletos = (Boleto[]) request.getAttribute("lista_boletos");
                        %>
                        <br/> 
                        <p>A continuación se muestran los boletos solicitados:</p>

                        <!--Recorremos la lista de boletos-->
                        <% for (int i = 0; i < lista_boletos.length; i++) {%>
                        <br/>
                        <p>Boleto <%=i + 1%>:</p>
                        <!--Recorremos apuestas de cada boleto-->
                        <%
                            Boleto boleto = lista_boletos[i];
                            for (int j = 0; j < boleto.NumApuestas(); j++) {
                        %>
                        <p>Apuesta <%=j + 1%>: &nbsp;
                            <!--Recorremos los valores de cada apuesta-->
                            <%Apuesta apuesta = boleto.getApuesta(j);%>
                            <% for (int k = 0; k < apuesta.NumValores(); k++) {%>
                                <%=apuesta.getValor(k)%>
                                <%if (k < apuesta.NumValores() - 1) {%>
                                ,
                                <%}
                            }%>
                        </p>
                        <%}%>   
                        <p>Reintegro: <%=boleto.getReintegro()%></p>
                        <p>Importe Boleto: <%=boleto.getPrecio()%> €</p>
                        <%}%>
                        <br/>
                        <p>El importe total a abonar son: <%=precio_total%> €</p>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>

