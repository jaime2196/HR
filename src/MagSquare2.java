import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MagSquare2 {

    public static void main(String[] args) {
        List<List<Integer>> s=new ArrayList<>();
        ArrayList<Integer> a = new ArrayList<>();
        a.add(4);
        a.add(8);
        a.add(2);
        s.add(a);
        ArrayList<Integer> b = new ArrayList<>();
        b.add(4);
        b.add(5);
        b.add(7);
        s.add(b);
        ArrayList<Integer> c = new ArrayList<>();
        c.add(6);
        c.add(1);
        c.add(6);
        s.add(c);

        formingMagicSquare(s);
    }


    public static int formingMagicSquare(List<List<Integer>> s) {
        int cost=0;
        ArrayList<ArrayList<ArrayList<Integer>>> cuadradosMagicos = getCuadradosMagicos();
        //validarMagSquares(cuadradosMagicos);
        int minCost=99999;
        for(ArrayList<ArrayList<Integer>> cuadrado: cuadradosMagicos){
            cost = getCost(cuadrado, s);
            if(cost<minCost){
                minCost=cost;
            }
        }
        System.out.println(minCost);
        return minCost;
    }

    private static ArrayList<ArrayList<Integer>> getCuadradoMagico(int a1,
                                                                                int a2,
                                                                                int a3,
                                                                                int a4,
                                                                                int a5,
                                                                                int a6,
                                                                                int a7,
                                                                                int a8,
                                                                                int a9) {
        ArrayList<ArrayList<ArrayList<Integer>>> res = new ArrayList<>();

        ArrayList<ArrayList<Integer>> cuadrado = new ArrayList<>();
        ArrayList<Integer> fila = new ArrayList<>();
        fila.add(a1);
        fila.add(a2);
        fila.add(a3);
        cuadrado.add(fila);
        fila=new ArrayList<>();
        fila.add(a4);
        fila.add(a5);
        fila.add(a6);
        cuadrado.add(fila);
        fila=new ArrayList<>();
        fila.add(a7);
        fila.add(a8);
        fila.add(a9);
        cuadrado.add(fila);
        return cuadrado;
    }

    private static ArrayList<ArrayList<ArrayList<Integer>>> getCuadradosMagicos(){
        ArrayList<ArrayList<ArrayList<Integer>>> res = new ArrayList<>();
        res.add(getCuadradoMagico(2,7,6,9,5,1,4,3,8));
        res.add(getCuadradoMagico(2,9,4,7,5,3,6,1,8));
        res.add(getCuadradoMagico(4,3,8,9,5,1,2,7,6));
        res.add(getCuadradoMagico(4,9,2,3,5,7,8,1,6));
        res.add(getCuadradoMagico(6,1,8,7,5,3,2,9,4));
        res.add(getCuadradoMagico(6,7,2,1,5,9,8,3,4));
        res.add(getCuadradoMagico(8,1,6,3,5,7,4,9,2));
        res.add(getCuadradoMagico(8,3,4,1,5,9,6,7,2));
        return res;
    }

    private static void validarMagSquares(ArrayList<ArrayList<ArrayList<Integer>>> cuadrados){
        for(ArrayList<ArrayList<Integer>> cuadrado : cuadrados){
            System.out.println("Es magico? "+isMagSquare(cuadrado));
        }
    }

    private static int getCost(ArrayList<ArrayList<Integer>> cuadradoMagico, List<List<Integer>> s){
        int cost=0;
        for(int i=0;i!=cuadradoMagico.size();i++){
            for(int j=0;j!=cuadradoMagico.size();j++){
                cost = cost + Math.abs(cuadradoMagico.get(i).get(j) -s.get(i).get(j));
            }
        }
        return cost;
    }

    private static void getCombinacion(){
        int lenTotal=9;
        ArrayList<ArrayList<Integer>> square = null;
        ArrayList<ArrayList<ArrayList<Integer>>> res = new ArrayList<>();
        for(int i=1;i!=999999999;i++){
            String cad = String.valueOf(i);
            while(cad.length()!=lenTotal){
                cad="1"+cad;
            }
            square = cadToSquare(cad);
            if(!cad.contains("0")){
                if(notRepeat(square)){
                    if(isMagSquare(square) ){
                        res.add(square);
                        imprimir2(square);
                        System.out.println("Añadido un nuevo cuadrado");
                    }
                }
            }
            /*if(i%10000000==0){
                System.out.println("Procesando numero "+i);
            }*/
        }
    }

    private static boolean notRepeat(ArrayList<ArrayList<Integer>> square) {
        ArrayList<Integer> vec = new ArrayList<>();
        vec.addAll(square.get(0));
        vec.addAll(square.get(1));
        vec.addAll(square.get(2));
        for(int i=0;i!=vec.size();i++){
            for(int j=0;j!=vec.size();j++){
                if(i!=j){
                    int a=vec.get(i);
                    int b=vec.get(j);
                    if(a==b){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private static boolean noContZero(ArrayList<ArrayList<Integer>> square) {
        for(ArrayList<Integer> fila :square){
            if(fila.get(0)==0 || fila.get(1)==0||fila.get(2)==0){
                return false;
            }
        }
        return true;
    }

    private static ArrayList<ArrayList<Integer>> cadToSquare(String cad){
        ArrayList<ArrayList<Integer>> cuadrado = new ArrayList<>();
        ArrayList<Integer> fila =new ArrayList<>();
        fila.add(Integer.parseInt(String.valueOf(cad.charAt(0))));
        fila.add(Integer.parseInt(String.valueOf(cad.charAt(1))));
        fila.add(Integer.parseInt(String.valueOf(cad.charAt(2))));
        cuadrado.add(fila);
        fila =new ArrayList<>();
        fila.add(Integer.parseInt(String.valueOf(cad.charAt(3))));
        fila.add(Integer.parseInt(String.valueOf(cad.charAt(4))));
        fila.add(Integer.parseInt(String.valueOf(cad.charAt(5))));
        cuadrado.add(fila);
        fila =new ArrayList<>();
        fila.add(Integer.parseInt(String.valueOf(cad.charAt(6))));
        fila.add(Integer.parseInt(String.valueOf(cad.charAt(7))));
        fila.add(Integer.parseInt(String.valueOf(cad.charAt(8))));
        cuadrado.add(fila);
        return cuadrado;
    }

    private static ArrayList<Integer> horizontal(ArrayList<ArrayList<Integer>> s){
        ArrayList<Integer> res= new ArrayList<>();
        for(List<Integer> fila:s){
            int a=fila.get(0)+fila.get(1)+fila.get(2);
            res.add(a);
        }
        return res;
    }

    private static ArrayList<Integer> vertical(ArrayList<ArrayList<Integer>> s){
        ArrayList<Integer> res= new ArrayList<>();
        for(int i=0;i!=3;i++){
            int a= s.get(0).get(i)+s.get(1).get(i)+s.get(2).get(i);
            res.add(a);
        }
        return res;
    }

    private static int diagonal1(ArrayList<ArrayList<Integer>> s){
        int cont =0;
        for(int i=0;i!=3;i++){
            cont =cont+s.get(i).get(i);
        }
        return cont;
    }



    private static int diagonal2(ArrayList<ArrayList<Integer>> s){
        int cont=0;
        int b=2;
        for(int i=0;i!=3;i++){
            cont= cont+s.get(i).get(b);
            b--;
        }
        return cont;
    }

    private static boolean isMagSquare(ArrayList<ArrayList<Integer>> square){
        ArrayList<Integer> horizontal = horizontal(square);
        ArrayList<Integer> vertical = vertical(square);
        int d1 = diagonal1(square);
        int d2 = diagonal2(square);
        if(d1!=d2){
            return false;
        }
        for(int h : horizontal){
            if(d1!=h){
                return false;
            }
        }
        for(int v : vertical){
            if(d1!=v){
                return false;
            }
        }
        return true;
    }

    private static void imprimir2(ArrayList<ArrayList<Integer>> s ){

        for(ArrayList<Integer> fila:s){
            System.out.println("    "+(fila.get(0))+" "+
                    (fila.get(1))+
                    " "+(fila.get(2)));

        }
        System.out.println("________________________________________________________");
    }



}
