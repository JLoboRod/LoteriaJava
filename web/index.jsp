<%-- 
    Document   : index
    Created on : 10-mar-2015, 15:22:28
    Author     : 2DAWT
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Lotería Java</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="assets/css/estilos.css">
    </head>
    <body>
        <div class="contenedor">
            <%@include file="sidebar.jsp" %>
            <div id="principal">
            <div class="panel shadow">
                <h1>LOTERÍA JAVA</h1>
                
                <p>
                    <%=(session.getAttribute("usuario")!=null)?"Elija una de las dos opciones disponibles.":
                            "Debe loguear para poder utilizar la aplicación."%>
                </p>
            </div>
            </div>
        </div>
    </body>
</html>
