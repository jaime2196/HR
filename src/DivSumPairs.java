import java.util.ArrayList;
import java.util.List;

public class DivSumPairs {

    public static void main(String[] arg){
        ArrayList<Integer> s = new ArrayList<>();
        s.add(1);
        s.add(2);
        s.add(3);
        s.add(4);
        s.add(5);
        s.add(6);

        System.out.println(divisibleSumPairs(s.size(), 5, s));
    }


    public static int divisibleSumPairs(int n, int k, List<Integer> ar) {
        int res =0;

        for(int i=0;i!=ar.size();i++){
            for(int j=0;j!= ar.size();j++){
                if(i!=j){
                    int sum = ar.get(i)+ ar.get(j);
                    if(sum % k ==0 && i<j){
                        res++;
                    }
                }
            }
        }

        return res;
    }



}
