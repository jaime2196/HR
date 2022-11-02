import java.util.ArrayList;
import java.util.List;

public class SubArrayDiv{

    public static void main(String[] arg){
        ArrayList<Integer> s = new ArrayList<>();
        s.add(2);
        s.add(2);
        s.add(1);
        s.add(3);
        s.add(2);

        System.out.println(birthday(s, 4, 2));
    }

    public static int birthday(List<Integer> s, int d, int m) {
        int res =0;

        int i=0;
        boolean flag = true;
        while (flag){
            List<Integer> subLista =  s.subList(i,m);
            int sum = getSum(subLista);
            if(sum == d){
               res++;
            }

            i++;
            m++;
            if(s.size()<m){
             flag=false;
            }
        }

        return res;
    }

    public static int getSum(List<Integer> lista){
        int res =0;
        for(int i=0;i!=lista.size();i++){
            res = res +lista.get(i);
        }
        return res;
    }
}
