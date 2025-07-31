import java.util.Scanner;
public class Main {

    private static int Num;

    public static void setNum(int Num){
        Main.Num=Num;
    }
    public static int getNum(){
        return Num;
    }

    public static void factorial(){
        Scanner sc = new Scanner(System.in);
        Num=sc.nextInt();
        int i = 1;
        int multiplicador = 1;
        for (i = Num;i>=1;i--){
            System.out.print(i +"*"+multiplicador+"=");
            multiplicador = i*multiplicador;
            System.out.println(multiplicador);
        }


    }
    public static void main(String[] args) {

        factorial();
    }
}