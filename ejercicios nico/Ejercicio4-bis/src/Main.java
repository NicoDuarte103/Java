import java.util.Scanner;
public class Main {

    private static int Num;

    public static void setNum(int num){
        Main.Num = num;
    }
    public static int getNum(){
        return Num;
    }
    public static void hasta100(int Num){

        for (int i = Num;i<=100;i++){
            System.out.println("Num comun: "+i);}


    }

    public static void hasta100condivisores(int Num){

        for (int i = Num;i<=100;i++){
            if (i%2 == 0 && i%3 == 0){
            System.out.println("Num divisor: "+i);}}


    }

    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Num = sc.nextInt();
    hasta100condivisores(Num);


    }
}