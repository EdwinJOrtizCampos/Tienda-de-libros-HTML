package Model;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;

public class Catalogo {
    private static ArrayList<Libro> catalogo;
    
    public Catalogo(String url){
        ArrayList<Libro> temp = new ArrayList<>();
        try {
            JsonReader reader;
            reader = Json.createReader(new FileReader(url));
            JsonArray arr = reader.readArray();
            for (JsonValue jsonValue : arr) {
                String titulo = ((JsonObject) jsonValue).getString("title");
                String isbn = ((JsonObject) jsonValue).getString("isbn");
                String urlLibro = ((JsonObject) jsonValue).getString("thumbnailUrl");
                int nPaginas = ((JsonObject) jsonValue).getInt("pageCount");
                temp.add(new Libro(isbn, titulo, urlLibro, nPaginas));
            }
           
        } catch (FileNotFoundException ex) {
            temp.add(new Libro("1933988673", "Unlocking Android","https://s3.amazonaws.com/AKIAJC5RLADLUMVRPFDQ.book-thumb-images/ableson.jpg", 416));
            temp.add(new Libro("1935182722", "Android in Action, Second Edition","https://s3.amazonaws.com/AKIAJC5RLADLUMVRPFDQ.book-thumb-images/ableson2.jpg", 592));
            temp.add(new Libro("1617290084", "Specification by Example","https://s3.amazonaws.com/AKIAJC5RLADLUMVRPFDQ.book-thumb-images/adzic.jpg", 0));
            temp.add(new Libro("1933988746", "Flex 3 in Action","https://s3.amazonaws.com/AKIAJC5RLADLUMVRPFDQ.book-thumb-images/ahmed.jpg", 576));
            temp.add(new Libro("1935182420", "Flex 4 in Action","https://s3.amazonaws.com/AKIAJC5RLADLUMVRPFDQ.book-thumb-images/ahmed2.jpg", 600));
            temp.add(new Libro("1933988312", "Collective Intelligence in Action","https://s3.amazonaws.com/AKIAJC5RLADLUMVRPFDQ.book-thumb-images/alag.jpg", 425));

        }
        Catalogo.catalogo = temp;
        
    }
    
    public static ArrayList<Libro> getCatalogo() {
        return catalogo;
    }
    
    public static Libro getLibro(String isbn){
        for (Libro libro : catalogo) {
            if(libro.getIsbn().equals(isbn))
                return libro;
        }
        return null;
    }
    
    public void añadirLibro(Libro lib){
        Catalogo.catalogo.add(lib);
    }    
}
