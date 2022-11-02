import java.util.ArrayList;
import java.util.Collections;

public class DrawingBook {

    public static void main(String[] args) {
        System.out.println(pageCount(83246,78132));
    }


    public static int pageCount(int n, int p) {
        if(n==p){
            return 0;
        }
        if(n%2==0){
            n++;
        }
        ArrayList<ArrayList<Integer>> libro= formarLibro(n);
        System.out.println(libro);
        int principio = contarPrincipio(libro, p);
        int fin = contarFinal(libro, p);
        if(principio<fin){
           return principio;
        }
        return fin;
    }

    private static ArrayList<ArrayList<Integer>> formarLibro(int paginas){
        ArrayList<ArrayList<Integer>> libro = new ArrayList<>();
        for(int i=0;i<paginas;i++){
            ArrayList<Integer> cara = new ArrayList<Integer>();
            cara.add(i);
            i++;
            cara.add(i);
            libro.add(cara);
        }
        return libro;
    }

    private static int contarPrincipio(ArrayList<ArrayList<Integer>> libro, int pagina){
        int cont =0;
        for(ArrayList<Integer> cara :libro){
            if(cara.contains(pagina)){
                return cont;
            }
            cont++;
        }
        return cont;
    }

    private static int contarFinal(ArrayList<ArrayList<Integer>> libro, int pagina){
        Collections.reverse(libro);
        int cont =0;
        for(ArrayList<Integer> cara :libro){
            if(cara.contains(pagina)){
                return cont;
            }
            cont++;
        }
        return cont;
    }

}
