package Control;

import Model.Carrito;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

public class EliminarDelCarrito extends FrontCommand{

    @Override
    public void process() {
        HttpSession session = request.getSession(true);

        Carrito cart = (Carrito) session.getAttribute("cart");

        if(cart == null){
            cart = new Carrito();
        }
            
        if(request.getParameter("book") != null){  
            cart.eliminarDelCarrito(request.getParameter("book"));
            session.setAttribute("cart", cart);  
        }
        
        try {
            forward("/Carrito.jsp");
        } catch (ServletException | IOException ex) {
            Logger.getLogger(EliminarDelCarrito.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}