import java.text.DecimalFormat;

public class Codility4 {


    public static void main(String[] args) {
        String[] B = new String[]{ "300.00", "200.00", "100.00"  };
        String[] sol =solution("300.01", B);
        //String[] B = new String[]{ "1.00", "0.05", "1.00"  };
        //String[] sol =solution("300.01", B);
        for(String s : sol){
            System.out.println(s);
        }

    }



    public static String[] solution(String S, String[] B) {
        int total = B.length;
        String[] res = new String[3];
        double multi = toDouble(S);
        for(int i=0;i!=B.length;i++){

            res[i]= String.valueOf( multi *(toDouble(B[i])/getDiv(total, B))   );
            multi = multi - toDouble(res[i]);
            total--;
        }

        return res;
    }

    private static double getDiv(int total, String[] B) {
        double res =0;
        int j=1;
        for(int i=B.length-1;i>=0;i--){
            if(j<=total){
                res = res + toDouble(B[i]);
            }
            j++;
        }
        if(res == 0){
            return 1;
        }
        return res;
    }

    private static double toDouble(String a){
        return Double.parseDouble(a);
    }


}
