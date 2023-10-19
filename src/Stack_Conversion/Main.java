package Stack_Conversion;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Attributes
        Scanner scan = new Scanner(System.in);
        String infix,postfix;

        System.out.print("Please enter Your Infix : ");
        infix = scan.nextLine();
        postfix = InfixToPostfix.InToPost(infix);

        System.out.println("infix : " + infix);
        System.out.println("Postfix : " + postfix);
    }
}
