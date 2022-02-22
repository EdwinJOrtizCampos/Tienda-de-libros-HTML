package Control;

import Model.Carrito;
import Model.Catalogo;
import Model.Libro;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

public class AñadirAlCarrito extends FrontCommand{

    @Override
    public void process() {
        
        HttpSession session = request.getSession(true);

        Carrito cart = (Carrito) session.getAttribute("cart");

        if(cart == null){
            cart = new Carrito();
        }
            
        if(request.getParameter("book") != null){   
            cart.añadirAlCarrito((Libro) Catalogo.getLibro(request.getParameter("book")));
            session.setAttribute("cart", cart);  
        }
        
        try {
            request.setAttribute("added", true);
            forward("/Home.jsp");
        } catch (ServletException | IOException ex) {
            Logger.getLogger(AñadirAlCarrito.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}