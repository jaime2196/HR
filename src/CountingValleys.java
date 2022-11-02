public class CountingValleys {

    public static void main(String[] args){
        System.out.println(countingValleys(8, "UDDDUDUU"));
    }

    /**
     * 8
     * UDDDUDUU
     * @param steps
     * @param path
     * @return
     */
    public static int countingValleys(int steps, String path) {
        int nivel=0;
        int cont=0;
        boolean negativo = false;
        for(int i=0;i!=steps;i++){
            String paso = String.valueOf(path.charAt(i));
            if(paso.equals("U")){
                nivel++;
            }else{
                nivel--;
            }

            if(nivel<0){
                negativo=true;
            }
            if(nivel>=0 && negativo){
                cont++;
                negativo=false;
            }

        }
        return cont;
    }
}
