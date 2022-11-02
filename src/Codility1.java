import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Codility1 {
    public static void main(String[] args) {
        //1, 3, 6, 4, 1, 2
        int[] intArray = new int[]{ -1, -3, -5, -4  };
        System.out.println(solution(intArray));
    }



    public static int solution(int[] A) {
        ArrayList<Integer> ar = limpiar(A);
        Collections.sort(ar);
        if(todosNegativos(ar)){
            return 1;
        }
        int i =ar.get(0);
        for(int j=0;j!=ar.size();j++){
            if(i!=ar.get(j)){
                return i;
            }
            i++;
        }
        return i;
    }
    public static ArrayList<Integer> limpiar(int[] A){
        HashMap<Integer,Integer> hs = new HashMap<>();
        ArrayList<Integer> ar = new ArrayList<>();
        for(int e : A){
            if(!hs.containsKey(e)){
                hs.put(e,0);
            }
        }
        for(int key : hs.keySet()){
           ar.add(key) ;
        }
        return ar;
    }

    public static boolean todosNegativos(ArrayList<Integer> ar){
        for(int e : ar){
            if(e>0){
                return false;
            }
        }
        return true;
    }
}
