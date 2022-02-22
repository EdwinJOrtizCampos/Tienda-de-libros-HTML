package Control;

import Model.Carrito;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

public class Comprar extends FrontCommand{

    @Override
    public void process() {
        HttpSession session = request.getSession(true);
        
        Carrito c = (Carrito) session.getAttribute("cart");

        if(c == null){
            c = new Carrito();
        }
        
        if(c.getCarrito().isEmpty()){
            try {
                forward("/ErrorDePagina.jsp");
            } catch (ServletException | IOException ex) {
                Logger.getLogger(VerCarrito.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            c.emptyCarrito();
        
            session.setAttribute("cart", c);
        
            try {
                forward("/CompraRealizada.jsp");
            } catch (ServletException | IOException ex) {
                Logger.getLogger(VerCarrito.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }

    }
}