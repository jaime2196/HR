import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class FormingMagSquare {


    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static void main(String[] args) {
        List<List<Integer>> s=new ArrayList<>();
        ArrayList<Integer> a = new ArrayList<>();
        a.add(4);
        a.add(8);
        a.add(2);
        s.add(a);
        ArrayList<Integer> b = new ArrayList<>();
        b.add(4);
        b.add(5);
        b.add(7);
        s.add(b);
        ArrayList<Integer> c = new ArrayList<>();
        c.add(6);
        c.add(1);
        c.add(6);
        s.add(c);

        System.out.println(formingMagicSquare(s));
    }

    public static int formingMagicSquare(List<List<Integer>> s) {
        // Write your code here
        ArrayList<Integer> horizontal =horizontal(s);
        ArrayList<Integer> vertical =vertical(s);
        int diagonal1 =diagonal1(s);
        int diagonal2 =diagonal2(s);
        ArrayList<Integer> objetivos = findObjetivo(horizontal, vertical, diagonal1, diagonal2);
        ArrayList<ArrayList<Posicion>> ar = listToArPos(s,horizontal,vertical,diagonal1,diagonal2,objetivos.get(0));
        imprimir2(ar,  horizontal, vertical, diagonal1, diagonal2, objetivos.get(0));
        if(isMagSquare(horizontal, vertical, diagonal1,diagonal2)){
            return 0;
        }

        return recur(ar, objetivos, 0 , 0, s);
    }

    private static int recur(ArrayList<ArrayList<Posicion>> ar, ArrayList<Integer> objetivos,
                             int contObjetivo, int contador, List<List<Integer>> original){
        ArrayList<Integer> horizontal = horizontal2(ar);
        ArrayList<Integer> vertical = vertical2(ar);
        int d1 = diagonal11(ar);
        int d2 = diagonal22(ar);
        int objetivo=objetivos.get(contObjetivo);

        ar=ajustarPosicion(ar, objetivo,horizontal,vertical);
        horizontal = horizontal2(ar);
        vertical = vertical2(ar);
        d1 = diagonal11(ar);
        d2 = diagonal22(ar);
        imprimir2(ar, horizontal, vertical, d1, d2, objetivo);
        if(horizontalVerticalOK(horizontal,vertical)){
            if(isMagSquare(horizontal,vertical,d1,d2)){//Resulto
                System.out.println("RESUELTO");
                return contador;
            }else{//Sin solucion
                horizontal=horizontal(original);
                vertical=vertical(original);
                d1=diagonal1(original);
                d2=diagonal2(original);
                contObjetivo++;
                objetivo=objetivos.get(contObjetivo);
                ar = listToArPos(original,horizontal,vertical,d1,d2,objetivos.get(contObjetivo));
                imprimir2(ar, horizontal, vertical, d1, d2, objetivo);
                return recur(ar,objetivos,contObjetivo,contador, original);
            }
        }else{
            return recur(ar,objetivos,contObjetivo,contador, original);
        }

    }

    private static boolean horizontalVerticalOK(ArrayList<Integer> horizontal, ArrayList<Integer> vertical){
        int a =horizontal.get(0);
        for(int i=0;i!=horizontal.size();i++){
            if(horizontal.get(i)!=a){
                return false;
            }
        }
        for(int i=0;i!=vertical.size();i++){
            if(vertical.get(i)!=a){
                return false;
            }
        }

        return true;
    }

    private static int recur2(int contador, int contObjetivo, ArrayList<ArrayList<Posicion>> ar, ArrayList<Integer> objetivos){
        List<List<Integer>> s = arPosToList(ar);
        ArrayList<Integer> horizontal =horizontal(s);
        ArrayList<Integer> vertical =vertical(s);
        int diagonal1 =diagonal1(s);
        int diagonal2 =diagonal2(s);
        imprimir2(ar,  horizontal, vertical, diagonal1, diagonal2, objetivos.get(contObjetivo));
        if(isMagSquare(horizontal, vertical, diagonal1,diagonal2)){
            return contador;
        }
        ar = listToArPos(s,horizontal,vertical,diagonal1,diagonal2,objetivos.get(contObjetivo));
        ArrayList<ArrayList<Posicion>> arAux= ajustarPosicion(ar, objetivos.get(contObjetivo),horizontal,vertical);
        ar=ajustarPosicion(ar, objetivos.get(contObjetivo),horizontal,vertical);
        recur2(contador, contObjetivo, ar, objetivos);

        return contador;
    }

    private static ArrayList<ArrayList<Posicion>> ajustarPosicion(ArrayList<ArrayList<Posicion>> ar, int obj, ArrayList<Integer> horizontal, ArrayList<Integer> vertical){
        for(int i=0;i!= ar.size();i++){
            for(int j=0;j!=ar.get(i).size();j++){
                Posicion pos = ar.get(i).get(j);
                if(!pos.isValido()){
                    int valor = pos.getValor();
                    if(horizontal.get(i)!=obj){
                        int valorFila =horizontal.get(i);
                        int setValor=obj-valorFila;
                        setValor=valor+setValor;
                        ar.get(i).get(j).setValor(setValor);
                        ar.get(i).get(j).setValido(true);
                        return ar;
                    }else{
                        if(vertical.get(j)!=obj){
                            int valorColumna =vertical.get(j);
                            int setValor=obj-valorColumna;
                            setValor=valor+setValor;
                            ar.get(i).get(j).setValor(setValor);
                            ar.get(i).get(j).setValido(true);
                            return ar;
                        }
                    }
                }
            }
        }
        return null;
    }


    private static ArrayList<ArrayList<Posicion>> listToArPos(List<List<Integer>> s, ArrayList<Integer> horizontal, ArrayList<Integer> vertical, int d1, int d2, int obj){
        ArrayList<ArrayList<Posicion>> res = new ArrayList<>();

        for(int i=0;i!=s.size();i++){
            ArrayList<Posicion> fila = new ArrayList<>();
            for(int j=0;j!=s.get(i).size();j++){
                int a=s.get(i).get(j);
                fila.add(new Posicion(i,j, obj==horizontal.get(i) || obj==vertical.get(j),a));
            }
            res.add(fila);
        }
        return res;
    }

    private static boolean isMagSquare(ArrayList<Integer> horizontal, ArrayList<Integer> vertical, int d1, int d2){
        if(d1!=d2){
            return false;
        }
        for(int h : horizontal){
            if(d1!=h){
                return false;
            }
        }
        for(int v : vertical){
            if(d1!=v){
                return false;
            }
        }
        return true;
    }

    private static List<List<Integer>> arPosToList(ArrayList<ArrayList<Posicion>> ar){
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i!=ar.size();i++){
            ArrayList<Integer> fila = new ArrayList<>();
            for(int j=0;j!=ar.get(i).size();j++){
                int a =ar.get(i).get(j).getValor();
                fila.add(a);
            }
            res.add(fila);
        }
        return res;
    }

    private static ArrayList<Integer> horizontal(List<List<Integer>> s){
        ArrayList<Integer> res= new ArrayList<>();
        for(List<Integer> fila:s){
            int a=fila.get(0)+fila.get(1)+fila.get(2);
            res.add(a);
        }
        return res;
    }

    private static ArrayList<Integer> horizontal2(ArrayList<ArrayList<Posicion>> s){
        ArrayList<Integer> res= new ArrayList<>();
        for(List<Posicion> fila:s){
            int a=fila.get(0).getValor()+fila.get(1).getValor()+fila.get(2).getValor();
            res.add(a);
        }
        return res;
    }

    private static ArrayList<Posicion> getPosMal(ArrayList<Integer> horizontal, ArrayList<Integer> vertical, int objetivo){
        ArrayList<Posicion> posiciones = new ArrayList<>();
        for(int i=0;i!=horizontal.size();i++){
            if(horizontal.get(i)!=objetivo){
                for(int j=0;j!=vertical.size();j++){
                    if(vertical.get(j)!=objetivo && vertical.get(j)==horizontal.get(i)){
                        posiciones.add(new Posicion(i,j,false, vertical.get(j)));
                    }
                }
            }
        }
        return posiciones;
    }

    private static ArrayList<Integer> findObjetivo(ArrayList<Integer> h, ArrayList<Integer> v, int a, int b){
        HashMap<Integer,Integer> hm = new HashMap<Integer, Integer>();
        ArrayList<Integer> lista = new ArrayList<>();
        lista.add(a);
        lista.add(b);
        lista.addAll(h);
        lista.addAll(v);
        hm=sumarHM(lista, hm);

        ArrayList<ValorObj> arValorObj = new ArrayList<>();
        for(int key : hm.keySet()){
            arValorObj.add(new ValorObj(key,hm.get(key)));
        }
        Collections.sort(arValorObj);
        ArrayList<Integer> res = new ArrayList<>();
        for(ValorObj valorObj : arValorObj){
            res.add(valorObj.getNumero());
        }
        return res;
    }

    private static HashMap<Integer,Integer> sumarHM(ArrayList<Integer> h,HashMap<Integer,Integer> hm){
        for(int i=0;i!=h.size();i++){
            int n=h.get(i);
            if(hm.containsKey(n)){
                int res=hm.get(n);
                res++;
                hm.put(n,res);
            }else{
                hm.put(n,1);
            }
        }
        //System.out.println(hm);
        return hm;
    }


    private static int sumarArray(ArrayList<Integer> s){
        int res =0;
        for(int i=0;i!=s.size();i++){
            res = res + s.get(i);
        }
        return res;
    }

    private static ArrayList<Integer> vertical(List<List<Integer>> s){
        ArrayList<Integer> res= new ArrayList<>();
        for(int i=0;i!=3;i++){
            int a= s.get(0).get(i)+s.get(1).get(i)+s.get(2).get(i);
            res.add(a);
        }
        return res;
    }

    private static ArrayList<Integer> vertical2(ArrayList<ArrayList<Posicion>> s){
        ArrayList<Integer> res= new ArrayList<>();
        for(int i=0;i!=3;i++){
            int a= s.get(0).get(i).getValor()+s.get(1).get(i).getValor()+s.get(2).get(i).getValor();
            res.add(a);
        }
        return res;
    }

    private static int diagonal1(List<List<Integer>> s){
        int cont =0;
        for(int i=0;i!=3;i++){
            cont =cont+s.get(i).get(i);
        }
        return cont;
    }

    private static int diagonal11(ArrayList<ArrayList<Posicion>> s){
        int cont =0;
        for(int i=0;i!=3;i++){
            cont =cont+s.get(i).get(i).getValor();
        }
        return cont;
    }

    private static int diagonal2(List<List<Integer>> s){
        int cont=0;
        int b=2;
        for(int i=0;i!=3;i++){
            cont= cont+s.get(i).get(b);
            b--;
        }
        return cont;
    }

    private static int diagonal22(ArrayList<ArrayList<Posicion>> s){
        int cont=0;
        int b=2;
        for(int i=0;i!=3;i++){
            cont= cont+s.get(i).get(b).getValor();
            b--;
        }
        return cont;
    }

    private static void imprimir(List<List<Integer>> s, ArrayList<Integer> horizontal, ArrayList<Integer> vertical, int d1, int d2){
        int cont=0;
        for(List<Integer> fila:s){
            System.out.println("    "+fila.get(0)+" "+fila.get(1)+" "+fila.get(2)+" =>"+horizontal.get(cont));
            cont++;
        }
        System.out.println(" ↙ || || || ↘");
        System.out.println(d2+" "+vertical.get(0)+" "+vertical.get(1)+" "+vertical.get(2)+" "+d1);
    }

    private static void imprimir2(ArrayList<ArrayList<Posicion>> s, ArrayList<Integer> horizontal, ArrayList<Integer> vertical, int d1, int d2, int obj){
        int cont=0;
        for(ArrayList<Posicion> fila:s){
            System.out.println("    "+formatPos(fila.get(0))+" "+
                    formatPos(fila.get(1))+
                    " "+formatPos(fila.get(2))+" =>"+formatSum(horizontal.get(cont), obj));
            cont++;
        }
        System.out.println(" ↙ || || || ↘");
        System.out.println(formatSum(d2,obj)+" "+formatSum(vertical.get(0), obj)+" "+formatSum(vertical.get(1),obj)+" "
                +formatSum(vertical.get(2), obj)+" "+formatSum(d1, obj));
        System.out.println("________________________________________________________");
    }

    private static String formatPos(Posicion pos){
        String res ="";
        if(pos.isValido()){
            res=ANSI_GREEN+pos.getValor()+ANSI_RESET;
        }else{
            res=ANSI_RED+pos.getValor()+ANSI_RESET;
        }
        return res;
    }

    private static String formatSum(int valor, int obj){
        if(valor==obj){
            return ANSI_GREEN+valor+ANSI_RESET;
        }
        return ANSI_RED+valor+ANSI_RESET;
    }


}

class Posicion{
    private int h;
    private int v;
    private boolean valido;
    private int valor;

    public Posicion(int h, int v, boolean valido, int valor) {
        this.h = h;
        this.v = v;
        this.valido = valido;
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "("+h+","+v+")\n"+valido;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public int getV() {
        return v;
    }

    public void setV(int v) {
        this.v = v;
    }

    public boolean isValido() {
        return valido;
    }

    public void setValido(boolean valido) {
        this.valido = valido;
    }
}

class ValorObj implements Comparable<ValorObj>{
    private int numero;
    private int total;

    public ValorObj(int numero, int total) {
        this.numero = numero;
        this.total = total;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public int compareTo(ValorObj o) {
        return o.getTotal()-this.total;
    }
}
