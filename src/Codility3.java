public class Codility3 {


    public static void main(String[] args) {
        System.out.println(solution(605000));
    }


    public static String solution(int X) {
        return calcularSolucion(X);
    }


    public static String calcularSolucion(int X){
        int semanas = 0;
        int dias = 0;
        int horas = 0;
        int min =0;
        int seg =0;

        if(X>604800){ // Semanas
            semanas = X/604800;
            //int resto = X % 604800;
            X = X - (604800*semanas);
            //X = X + resto;
        }
        if(X>86400){ //Dias
            dias = X/86400;
            //int resto = X % 86400;
            X = X - (86400*dias);
            //X = X + resto;
        }
        if(X>3600){ //Horas
            horas = X/3600;
            //int resto = X % 3600;
            X = X - (3600*horas);
            //X = X + resto;
        }
        if(X>60){ //Minutos
            min = X/60;
            //int resto = X % 60;
            X = X - (60*min);
            //X = X + resto;
        }
        if(X<60){ // Segundos
            seg = X;
        }

        //formatear
        int cont =0;
        if(semanas !=0){
            cont++;
        }if(dias!=0){
            cont++;
        }
        if(horas!=0){
            if(cont >= 2){
                horas++;
                min=0;
                seg=0;
            }
            cont++;
        }if(min!=0){
            if(cont>=2){
                min++;
                seg=0;
            }
            cont++;
        }if(seg!=0){
            if(cont>=2){
                seg=0;
                min++;
            }
        }

        //Format Res
        String res = "";
        if(semanas!=0){
            res = res+semanas+"w";
        }
        if(dias!=0){
            res =res+dias+"d";
        }if(horas!=0){
            res = res +horas+"h";
        }if(min!=0){
            res = res + min+"m";
        }if(seg!=0){
            res = res + seg+"s";
        }
        return res;
    }
}

class Tiempo{
    int seg;
    int min;
    int horas;
    int dias;
    int semanas;

    public int getS() {
        return seg;
    }

    public void setS(int s) {
        this.seg = s;
    }
}
