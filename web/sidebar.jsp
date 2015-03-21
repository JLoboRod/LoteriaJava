<%@page import="loteria.clases.FormHelper"%>
<%FormHelper fh_login = new FormHelper();%>
<%
    String usuario = request.getParameter("usuario");
    String password = request.getParameter("password");
    Object strErrorLogin=request.getAttribute("error_login");
    String error_login="";
    if (strErrorLogin!=null) {
        error_login = strErrorLogin.toString();
    }

%>
<div id="sidebar">
    <div class="panel shadow" id="autor">
        <a href="http://es.linkedin.com/in/jloborod/" target="_blank">
            <img class="avatar" src="assets/img/autor.jpg">
            <p id="nombre">Joaquín Lobo Rodríguez</p>
            <p id="info">2ºDAW - DWEServidor</p>
        </a>
    </div>
    <% if(session.getAttribute("usuario")!= null){%>
    <div class="panel shadow" id="menu">
        <h1>Opciones</h1>
        <div class="elemento">
            <a class="btn btn-rojo" href="Principal?modo=texto">Modo Texto</a>
        </div>
        <div class="elemento">
            <a class="btn btn-rojo" href="Principal?modo=grafico">Modo Gráfico</a>
        </div>
        <div class="elemento">
            <a class="btn btn-rojo" href="Principal?modo=ultima_apuesta">Última apuesta</a>
        </div>
    </div>
    <div class="panel shadow" id="login">
        <h1>Login</h1>
        <div class="elemento">
            <p>Hola <%=session.getAttribute("usuario")%></p>
        </div>
        <div class="elemento">
            <a class="btn btn-rojo" href="Usuarios?accion=salir">Salir</a>
        </div>
    </div>
    <%}else{%>
    <div class="panel shadow" id="login">
        <h1>Login</h1>
        <form action="Usuarios" method="post">
        <div class="elemento">
            <label>Usuario</label>
            <% if(error_login != "" && usuario!=""){%>
            <input type="text" name="usuario" value="<%=fh_login.Valor(usuario)%>"/>
            <%}else{%>
            <input type="text" name="usuario" placeholder="usuario"/>
            <%}%>
            
        </div>
        <div class="elemento">
            <label>Password</label>
            <% if(error_login != "" && password!=""){%>
            <input type="text" name="password" value="<%=fh_login.Valor(password)%>"/>
            <%}else{%>
            <input type="text" name="password" placeholder="password"/>
            <%}%>
        </div>
        <div class="elemento">
            <input type="submit" class="btn btn-rojo" value="Login"/>
        </div>
        <%=fh_login.ShowIfError(error_login)%>
        </form>
    </div>
    <%}%>
</div>