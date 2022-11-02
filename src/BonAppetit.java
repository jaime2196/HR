import java.util.ArrayList;
import java.util.List;

public class BonAppetit {

    public static void main(String[] arg){
        ArrayList<Integer> bill = new ArrayList<>();
        bill.add(2);
        bill.add(4);
        bill.add(6);
        bonAppetit(bill, 2, 3);
    }



    public static void bonAppetit(List<Integer> bill, int k, int b) {
        int sum =0;
        for(int i=0;i!=bill.size();i++){
            if(i!=k){
                sum = sum +bill.get(i);
            }
        }
        int res = b-(sum/2);
        if(res == 0){
            System.out.println("Bon Appetit");
        }else{
            System.out.println(res);
        }
    }
}
