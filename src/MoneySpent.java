public class MoneySpent {

    public static void main(String[] args){
        int[] a ={40,50,60};
        int[] b ={5,8,12};
        System.out.println(getMoneySpent(a, b,60));
    }


    static int getMoneySpent(int[] keyboards, int[] drives, int b) {
        int max=-1;
        for(int i=0;i!=keyboards.length;i++){
            int keyPrice=keyboards[i];
            for(int j=0;j!=drives.length;j++){
                int drivePrice=drives[j];
                int suma=keyPrice+drivePrice;
                if(suma<=b && suma>max){
                    max=suma;
                }
            }
        }

        return max;
    }

}
