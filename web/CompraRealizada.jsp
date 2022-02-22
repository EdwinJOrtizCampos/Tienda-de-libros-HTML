<%@page import="java.util.ArrayList"%>
<%@page import="Model.Libro"%>
<%@page import="Model.Carrito"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Chekout</title>
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
        <h1>Compra realizada! Gracias por desperdiciar su dinero con nosotros!<h1>
        <p>Pulse aquí para volver a la página principal:</p>
        <form action="FrontController">
            <input type="submit" value="Volver a la biblioteca" name="Go To Main Page" />
            <input type="hidden" value="VolverPagPrincipal" name="command" />
        </form>
        </div>
    </body>
</html>