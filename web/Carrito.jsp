<%@page import="Model.Carrito"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.Libro"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bienvenido a su carrito</title>
    </head>
    <style>
        body {
            background-image: url('https://images.hdqwalls.com/wallpapers/cold-snow-trees-4k-bg.jpg');
            background-repeat: no-repeat;
            background-attachment: fixed;
            background-size: cover;
        }
    </style>
    <body>
        <div align="center">
        <p>Pulse aquí para proceder a comprar los libros de su carrito.</p>
        <form action="FrontController">
            <input type="submit" value="Pasar a la compra" name="Go To Checkout" />
            <input type="hidden" value="Comprar" name="command" />
        </form>
        <p>Pulse aquí para volver al catalogo.</p>
        <form action="FrontController">
            <input type="submit" value="Volver a la biblioteca" name="Go To Main Page" />
            <input type="hidden" value="VolverPagPrincipal" name="command" />
        </form>
        <%
            ArrayList<Libro> carrito = ((Carrito)request.getSession(true).getAttribute("cart")).getCarrito();
            if(!carrito.isEmpty()){%>
                <p>Este es el contenido de su carrito:</p>
                <%int i = 1;
                for (Libro l : carrito) { %>
                    <form action="FrontController">
                    <%= new String("<img src=\""+l.getUrl()+"\"/>") %>
                    <%= new String("<figcaption>Artículo " + i + ": " + l.getTitulo()+ " Precio: " + (int) l.getPrecio()+" €</figcaption>") %>

                    <%= new String("<input type=\"hidden\" value=\""+l.getIsbn()+"\" name=\"book\" />")%>
                    <input type="submit" value="Ya no lo quiero" name="Delete From Cart" />
                    <input type="hidden" value="EliminarDelCarrito" name="command" />
                    <p>--------------------------------------------------------</p>
                    </form>
                    <%i++;%>
                <%}%> 
            
            <%}else{%>
                <p>Parece que su carrito está vacío.</p>
            <%}%>
        </div>
    </body>
</html>