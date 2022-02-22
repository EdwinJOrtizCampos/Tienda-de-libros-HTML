package Model;

public class Libro {
    private final String isbn;
    private final String titulo;
    private final String url;
    private final double precio;
    
    public Libro(String isbn, String title,
            String url, int nPaginas){
        this.isbn = isbn;
        this.titulo = title;
        this.url = url;
        this.precio = Math.floor(Math.random()*(60-30+1)+30);
    }   
    
     public String getIsbn() {
        return isbn;
    }


    public String getUrl() {
        return url;
    }

    public double getPrecio() {
        return precio;
    }
    
    public String getTitulo(){
        return this.titulo;
    }
}
