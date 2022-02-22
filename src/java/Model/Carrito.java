package Model;

import java.util.ArrayList;

public class Carrito {
    private ArrayList<Libro> carrito;
    
    public Carrito(){
        this.carrito = new ArrayList<>();
    }
    
    public ArrayList<Libro> getCarrito() {
        return carrito;
    }
    
    public Libro getLibro(String isbn){
        for (Libro producto : carrito) {
            if(producto.getIsbn().equals(isbn))
                return producto;
        }
        return null;
    }
    
    public void añadirAlCarrito(Libro lib){
        this.carrito.add(lib);
    }
    
    public void eliminarDelCarrito(String isbn){
        for (Libro l : carrito) {
            if(l.getIsbn().equals(isbn)){
                this.carrito.remove(l);
                return;
            }
        }
    }

    public void emptyCarrito() {
        this.carrito = new ArrayList<>();
    }

}
