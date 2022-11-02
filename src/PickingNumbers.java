import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PickingNumbers {

    public static void main(String[] args) {
        List<Integer> ar = new ArrayList<>(); //4 6 5 3 3 1
        ar.add(4);
        ar.add(6);
        ar.add(5);
        ar.add(3);
        ar.add(3);
        ar.add(1);
        System.out.println(pickingNumbers(ar));
    }

    public static int pickingNumbers(List<Integer> lista) {
        Collections.sort(lista);
        System.out.println(lista);
        ArrayList<ArrayList<Integer>> resultados = new ArrayList<>();


        for(int i=0;i!=lista.size();i++){
            ArrayList<Integer> ar= new ArrayList<>();
            ar.add(lista.get(i));
            for(int j=0;j!=lista.size();j++){
                if(i<j){
                    int a=lista.get(i);
                    int b=lista.get(j);
                    if(a==b || a+1==b){
                        ar.add(lista.get(j));
                    }

                }
            }
            resultados.add(ar);
        }
        int max=0;
        for(int i=0;i!=resultados.size();i++){
            int a=resultados.get(i).size();
            if(a>max){
                max=a;
            }
        }

        return max;
    }



}
