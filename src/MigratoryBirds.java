import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MigratoryBirds {

    public static void main(String[] arg){
        ArrayList<Integer> s = new ArrayList<>();
        s.add(1);
        s.add(1);
        s.add(2);
        s.add(2);
        s.add(3);
        System.out.println(migratoryBirds(s));
    }



    public static int migratoryBirds(List<Integer> arr) {
        HashMap<Integer,Integer> hs= getClaves(arr);
        hs = contar(hs,arr);
        int max = getMax(hs);
        return safeMax(hs,max);
    }

    public static HashMap<Integer,Integer> getClaves(List<Integer> arr){
        HashMap<Integer,Integer> hs = new HashMap<>();
        for(int id :arr){
            if(!hs.containsKey(id)){
                hs.put(id,0);
            }
        }
        return hs;
    }

    public static HashMap<Integer,Integer> contar(HashMap<Integer,Integer> hs, List<Integer> arr){
        for(int id: arr){
            int cont = hs.get(id);
            cont++;
            hs.put(id,cont);
        }
        return hs;
    }

    public static int getMax(HashMap<Integer,Integer> hs){
        int max =0;
        for(int id: hs.keySet()){
            if(hs.get(id)>max){
                max = hs.get(id);
            }
        }
        return max;
    }

    public static int safeMax(HashMap<Integer,Integer> hs, int max){
        ArrayList<Integer> arMax = new ArrayList<>();
        for(int id: hs.keySet()){
            if(hs.get(id)==max){
                arMax.add(id);
            }
        }
        if(arMax.size()==1){
            return arMax.get(0);
        }else{
            return getMin(arMax);
        }
    }

    public static int getMin(ArrayList<Integer> arMax){
        int min = arMax.get(0);
        for(int n : arMax){
            if(n<min){
                min = n;
            }
        }
        return min;
    }
}
