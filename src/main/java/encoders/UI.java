package encoders;

import java.util.Scanner;

public class UI {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        while (true) {
            printMenu();
            var str = scanner.nextLine();
            System.out.print("Enter string: ");
            switch (str) {
                case "1":
                    System.out.println(new UuEncoder().encode(scanner.nextLine()));
                    break;
                case "2":
                    System.out.println(new XxEncoder().encode(scanner.nextLine()));
                    break;
                case "3":
                    System.out.println(new Base64Encoder().encode(scanner.nextLine()));
                    break;
                default:
                    scanner.close();
                    return;
            }
        }
    }

    static void printMenu() {
        System.out.println("=============================================");
        System.out.println("1. Uuencoding");
        System.out.println("2. Xxencoding");
        System.out.println("3. Base64 encoding");
        System.out.println("=============================================");
        System.out.print("> Choose an option: ");
    }
}
