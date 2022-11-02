import java.util.ArrayList;
import java.util.List;

public class NonDivSubsets {

    /**
     * Esta solucion es valida cuando el array es pequeño y los enteros de dicho array tambien son pequeños,
     * en caso contrario tarda demasiado y no pasa algunos casos de prueba.
     * @param arg
     */
    public static void main(String[] arg){
        ArrayList<Integer> s = new ArrayList<>();
        s.add(19);
        s.add(10);
        s.add(12);
        s.add(10);
        s.add(24);
        s.add(25);
        s.add(22);

        System.out.println(nonDivisibleSubset(4,s));
    }

    public static int nonDivisibleSubset(int k, List<Integer> s) {
        ArrayList<ArrayList<Integer>> parejas = solucion(k,s);
        int max = 0;
        if(k==1){
            return 1;
        }


        parejas= probarParejas(k,s,parejas);
        max = getMaxArray(parejas);


        return max;
    }

    public static ArrayList<ArrayList<Integer>> solucion(int k, List<Integer> s){
        ArrayList<ArrayList<Integer>> parejas = new ArrayList<>();
        for(int i=0;i!=s.size();i++){
            for(int j=0;j!=s.size();j++){
                if(i!=j){
                    int sum = s.get(i) + s.get(j);
                    if(sum % k !=0){
                        ArrayList<Integer> temp = new ArrayList<>();
                        temp.add(s.get(i));
                        temp.add(s.get(j));
                        parejas.add(temp);
                    }
                }
            }
        }
        //System.out.println(parejas);
        return parejas;
    }

    public static ArrayList<ArrayList<Integer>> probarParejas(int k, List<Integer> listaOriginal, ArrayList<ArrayList<Integer>> parejas ){
        for(ArrayList<Integer> listaTemp : parejas){
            for(int i=0;i!=listaOriginal.size();i++){
                if(!isElementoInLista(listaOriginal.get(i), listaTemp)){
                    if(nuevoElementoValido(listaTemp, listaOriginal.get(i),k)){
                        listaTemp.add(listaOriginal.get(i));
                        parejas = probarParejas(k, listaOriginal,parejas);
                    }
                }
            }
        }
        return parejas;
    }

    public static int getMaxArray(ArrayList<ArrayList<Integer>> parejas){
        int max = 0;
        for(ArrayList<Integer> p : parejas){
            if(p.size()>max){
                max = p.size();
            }
        }
        return max;
    }


    public static boolean isElementoInLista(int elemento, ArrayList<Integer> lista){
        for(int n : lista){
            if(n == elemento){
                return true;
            }
        }
        return false;
    }

    public static boolean nuevoElementoValido(ArrayList<Integer> listaTemp , int elemento, int k){
        for(int t : listaTemp){
            if((t+elemento) % k == 0){
                return false;
            }
        }
        return true;
    }



}
