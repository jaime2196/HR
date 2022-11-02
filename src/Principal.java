import java.util.ArrayList;
import java.util.List;

public class Principal {



    public static void main(String[] arg){
        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();
        a.add(2);
        a.add(6);
        b.add(24);
        b.add(36);
        //b.add(36);
        System.out.println(getTotalX(a,b));
    }




    public static int getTotalX(List<Integer> a, List<Integer> b) {
        ArrayList<ArrayList<Integer>> listaMultiplos = new ArrayList<>();
        for(int i=0;i!=a.size();i++){
            ArrayList<Integer> lista =getMultiplos(a.get(i));
            listaMultiplos.add(lista);
        }

        ArrayList<Integer> coincidentes = encontrarCoincidentes(listaMultiplos, getMax(b));
        //coincidentes = limpiarLista(coincidentes);
        ArrayList<ArrayList<Integer>> listaFactores = new ArrayList<>();
        int res =0;
        for(int i=0;i!=b.size();i++){
            listaFactores.add(getFactors(b.get(i)));
        }

        boolean esta=true;
        for(int n : coincidentes){
            esta = true;
            for(ArrayList<Integer> factores : listaFactores){
                if(!isNumInLista(factores, n)){
                    esta = false;
                }
            }
            if(esta){
                res++;
            }
        }

        return res;
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

    public static int getMax(List<Integer> lista){
        int max =-1;
        for(int n : lista){
            if(n>max){
                max = n;
            }
        }
        return max;
    }

    /*public static ArrayList<Integer> limpiarLista( ArrayList<Integer> lista){
        ArrayList<Integer> res = new ArrayList<>();
        for(int i=0;i!=lista.size();i++){
            if(lista.size()>i){
                int a =lista.get(i);
                int b =lista.get(i+1);
                if(a<b){
                    res.add(a);
                }else{
                    return res;
                }
            }
        }
        return res;
    }*/

    public static ArrayList<Integer> encontrarCoincidentes(ArrayList<ArrayList<Integer>> listaMultipls, int max){
        ArrayList<Integer>  res = new ArrayList<>();
        int tem;
        for(int i=0;i!= listaMultipls.size();i++){
            ArrayList<Integer> listaTem =listaMultipls.get(i);
            for(int j=0;j!=listaTem.size();j++){
                tem = listaTem.get(j);
                for(int k=0;k!=listaMultipls.size();k++){
                    if(k!=i && isNumInLista(listaMultipls.get(k), tem)){
                        if(!yaEnLista(res, tem)){
                            res.add(tem) ;
                        }
                    }
                }
            }
        }
        return res;
    }

    public static boolean yaEnLista(ArrayList<Integer> lista, int num){
        for(int n : lista){
            if(n==num){
                return true;
            }
        }
        return false;
    }

    public static boolean isNumInLista(ArrayList<Integer> lista, int num){
        for(int tem : lista){
            if(num==tem){
                return true;
            }
        }
        return false;
    }
}
