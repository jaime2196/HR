import java.util.ArrayList;
import java.util.List;

public class BrkTheRecords {


    public static void main(String[] arg){
        List<Integer> scores = new ArrayList<>();
        scores.add(10);
        scores.add(5);
        scores.add(20);
        scores.add(20);
        scores.add(4);
        scores.add(5);
        scores.add(2);
        scores.add(25);
        scores.add(1);

        System.out.println(breakingRecords(scores));
    }

    public static List<Integer> breakingRecords(List<Integer> scores) {
        ArrayList<Integer> res = new ArrayList<>();
        int max = scores.get(0);
        int contMax =0;
        int contMin =0;
        int min = scores.get(0);
        for(int score : scores){
            if(score>max){
                max=score;
                contMax++;
            }
            if(score<min){
                min=score;
                contMin++;
            }
        }

        res.add(contMax);
        res.add(contMin);
        return res;
    }

}
