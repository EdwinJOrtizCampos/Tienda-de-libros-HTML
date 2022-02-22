package Control;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;

public class ErrorDesconocido extends FrontCommand{

    @Override
    public void process() {
        try {
            forward("/ErrorDePagina.jsp");
        } catch (ServletException | IOException ex) {
            Logger.getLogger(ErrorDesconocido.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
}