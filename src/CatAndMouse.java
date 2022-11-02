public class CatAndMouse {


    public static void main(String[] args) {
        System.out.println(catAndMouse(2,5,4));
    }

    static String catAndMouse(int x, int y, int z) {
        int a= x-z;
        int b= y-z;

        if(a<0){
            a=a*-1;
        }
        if(b<0){
            b=b*-1;
        }
        if(a==b){
            return "Mouse C";
        }
        if(a<b){
            return "Cat A";
        }
        return "Cat B";
    }

}
