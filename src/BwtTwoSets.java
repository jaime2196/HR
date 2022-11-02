import java.util.ArrayList;
import java.util.List;

public class BwtTwoSets {


    public static void main(String[] arg){
        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();
        a.add(100);
        a.add(99);
        a.add(98);
        a.add(97);
        a.add(96);
        a.add(95);
        a.add(94);
        a.add(93);
        a.add(92);
        a.add(91);

        b.add(1);
        b.add(2);
        b.add(3);
        b.add(4);
        b.add(5);
        b.add(6);
        b.add(7);
        b.add(8);
        b.add(9);
        b.add(10);


        getTotalX(a,b);
    }


    public static int getTotalX(List<Integer> a, List<Integer> b) {
        int res =0;
        // mcm
        int mcm = a.get(0);

        for(int n : a){
            mcm  = getMCM(mcm, n);
        }
        int mcd= b.get(0);
        for(int n : b){
            mcd = getMCD(mcd,n);
        }

        int multiple = 0;
        if(mcm==0){
            return 0;
        }
        while (multiple <= mcd) {
            multiple += mcm;
            System.out.println(multiple);
            if (multiple!=0 && mcd % multiple == 0){
                res++;
            }
        }

        return res;

    }

    public static int getMCM(int a, int b){
        ArrayList<Integer> mA = getMultiplos(a);
        ArrayList<Integer> mB = getMultiplos(b);
        for(int m : mA){
            if(isNumInLista(mB,m)){
                return m;
            }
        }
        return 0;
    }

    public static int getMCD(int a, int b){
        ArrayList<Integer> fA = getFactors(a);
        ArrayList<Integer> fB = getFactors(b);
        for(int m : fA){
            if(isNumInLista(fB,m)){
                return m;
            }
        }
        return 0;
    }


    public static boolean isNumInLista(ArrayList<Integer> lista, int num){
        for(int tem : lista){
            if(num==tem){
                return true;
            }
        }
        return false;
    }


    public static ArrayList<Integer> getMultiplos(int numero){
        ArrayList<Integer> res = new ArrayList<>();
        for(int i=1;i!=151;i++){
            res.add(numero*i);
        }
        return res;
    }


    public static ArrayList<Integer> getFactors(int numero){
        ArrayList<Integer> res = new ArrayList<>();
        for(int i=numero;i!=0;i--){
            if(numero%i == 0){
                res.add(i);
            }
        }
        return res;
    }

}

