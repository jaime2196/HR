import java.util.ArrayList;

public class MagSquare2 {

    public static void main(String[] args) {
        getCombinacion();
    }


    public static void getMagSquares(){
        ArrayList<ArrayList<Integer>> ms = new ArrayList<>();
        for(int i=0;i!=3;i++){
            ArrayList<Integer> fila = new ArrayList<>();
            for(int j=0;j!=3;j++){
                fila.add(1);
            }
            ms.add(fila);
        }
    }

    public static void getCombinacion(){
        int[] ar = new int[9];


    }
}
