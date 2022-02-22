package Control;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;

public class VolverPagPrincipal extends FrontCommand{

    @Override
    public void process() {
        
        try {
            forward("/Home.jsp");
        } catch (ServletException | IOException ex) {
            Logger.getLogger(VerCarrito.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}