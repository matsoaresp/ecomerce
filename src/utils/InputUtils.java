package utils;

import java.util.Scanner;

public class InputUtils {

    public static double getDoubleMessage(Scanner sc, String mensagem) {
        while (true) {
            try {
                System.out.println(mensagem);
                String input = sc.nextLine().replace(",", ".");
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Entrada invalida. Por favor, insira um numero decimal.");
            }
        }
    }
    public static int getIntMessage(Scanner sc, String mensagem) {
        while (true) {
            try {
                System.out.println(mensagem);
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrada invalida. Por favor, insira um numero inteiro.");
            }
        }
    }

    public static String getMessage(Scanner sc, String mensagem) {
        System.out.println(mensagem);
        return sc.nextLine();
    }

}
