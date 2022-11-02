public class DayProgramer {

    public static void main(String[] arg){

    }



    //Total 1700 - 2700
    //Juliano 1700 - 1917 //Bisiestos y%4 = 0
    //Gregoriano 1919 - 2700 //Bisiestos y%400 =0 || (y%4 =0 &&y %100 !=0
    //Expecial 1918
    public static String dayOfProgrammer(int year) {
        if(year>=1700 && year<=1917){
            if(year % 4 == 0){
                return "12.09."+year;
            }else{
                return "11.09."+year;
            }
        }else if(year>=1919 && year<=2700){
            if(year % 400 == 0 || (year%4==0 && year%100!=0)){
                return "12.09."+year;
            }else{
                return "13.09."+year;
            }
        }else if(year == 1918){
            return "27.0.1918";
        }
        return "";
    }
}
