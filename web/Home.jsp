<%@page import="java.util.ArrayList"%>
<%@page import="Model.Libro"%>
<%@page import="Model.Catalogo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%! 
    Catalogo cat = new Catalogo("E:\\PWM\\WebAppTiendaLibros");
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bibliotecas Noentiendo</title>
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

        <h1 align="center">Bienvenido a Bibliotecas Noentiendo!</h1>
        <div align="center">
        <p>Pulse aquí para ir a su carrito.</p>
        <form action="FrontController">
            <input type="submit" value="Mi carrito" name="Go to cart" />
            <input type="hidden" value="VerCarrito" name="command" />
        </form>
        <p>Añada al carrito los libros que desee comprar.</p>
        <%
        int i = 1;
        for (Libro l : (ArrayList<Libro>) Catalogo.getCatalogo()) { %>
            <form action="FrontController">
            <%= new String("<img src=\""+l.getUrl()+"\"/>") %>
            <%= new String("<figcaption>Artículo " + i + ": " + l.getTitulo() +": " + (int) l.getPrecio()+" €</figcaption>") %>
            
            <%= new String("<input type=\"hidden\" value=\""+l.getIsbn()+"\" name=\"book\" />")%>
            <input type="submit" value="Añadir al carrito" />
            <input type="hidden" value="AñadirAlCarrito" name="command" />
            </form>
            <p>======================================================</p>
            <%i++;%>
        <%  } %>
        </div>
    </body>
</html>