import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SalesByMatch {

    public static void main(String[] args) {
        ArrayList<Integer> ar = new ArrayList<>();
        ar.add(1);
        ar.add(2);
        ar.add(1);
        ar.add(2);
        ar.add(1);
        ar.add(3);
        ar.add(2);
        System.out.println(sockMerchant(7, ar));
    }


    public static int sockMerchant(int n, List<Integer> ar) {
        HashMap<Integer,Integer> hs = getHs(ar);
        hs = contar(ar, hs);
        return contarParejas(hs);

    }

    private static int contarParejas(HashMap<Integer, Integer> hs) {
        int cont=0;
        for(int key: hs.keySet()){
            int num = hs.get(key);
            if(num % 2 == 0){
                cont = cont + (num/2);
            }else{
                num = num-1;
                cont = cont + (num/2);
            }
        }
        return cont;
    }

    private static HashMap<Integer, Integer> contar(List<Integer> ar, HashMap<Integer, Integer> hs) {
        for(int c : ar){
            int cont =hs.get(c);
            cont++;
            hs.put(c,cont);
        }
        return hs;
    }

    public static HashMap<Integer,Integer> getHs(List<Integer> ar){
        HashMap<Integer,Integer> hs = new HashMap<>();
        for(int c : ar){
            if(!hs.containsKey(c)){
                hs.put(c,0);
            }
        }
        return hs;
    }
}
