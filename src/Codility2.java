import java.util.ArrayList;

public class Codility2 {


    public static void main(String[] args) {
        int[] B = new int[]{ 10, 6, 6, 8  };
        System.out.println(solution(100, B, 2));
    }


    public static int solution(int X, int[] B, int Z) {
        int descargado = sumar(B);
        int restante = X-descargado;
        if(restante == 0){
            return 0;
        }
        ArrayList<Integer> arLast = getLastsZ(B,Z);
        int sumAvg = sumarAr(arLast);
        sumAvg = sumAvg/Z;
        return restante/sumAvg;
    }


    public static int sumar(int[] B){
        int res =0;
        for(int a : B){
            res = res +a;
        }
        return res;
    }

    public static int sumarAr(ArrayList<Integer> B){
        int res =0;
        for(int a : B){
            res = res +a;
        }
        return res;
    }

    public static ArrayList<Integer> getLastsZ(int[] B, int Z){
        ArrayList<Integer> res = new ArrayList<>();
        int j=0;
        for(int i=B.length-1;i>=0;i--){
            if(j<Z){
                res.add(B[i]);
            }
            j++;
        }
        return res;
    }


}
