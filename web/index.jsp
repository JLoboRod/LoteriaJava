<%-- 
    Document   : index
    Created on : 10-mar-2015, 15:22:28
    Author     : 2DAWT
--%>
<%@page import="loteria.joaquin.MainServlet"%>
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
                <h1>LOTERÍA JAVA</h1>
                <p>Elija una de las dos opciones disponibles.</p>
            </div>
            </div>
        </div>
    </body>
</html>
