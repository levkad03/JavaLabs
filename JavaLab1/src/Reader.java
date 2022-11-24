import java.util.Scanner;

public class Reader {
    int i;
    int k;
    public void Scan(){
        System.out.println("Enter first digit");
        Scanner scn1 = new Scanner(System.in);
        i = scn1.nextInt();
        System.out.println("Enter second digit");
        Scanner scn2 = new Scanner(System.in);
        k = scn2.nextInt();
    }
}
