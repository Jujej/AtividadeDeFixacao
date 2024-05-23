import java.util.InputMismatchException;
import java.util.Scanner;

public class Console {
    
    private static Scanner scanner = new Scanner(System.in);

    public static int lerInt(){
        int valor = 0;

        while(true){
            try {
                valor = scanner.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("O valor informado não é um inteiro. Digite novamente: ");
            } finally {
                scanner.nextLine();
            }
        }
        return valor;
    }

    public static int lerInt(String mensagem) {
        System.out.print(mensagem);
        return lerInt();
    }

    public static String lerString() {
        return scanner.nextLine();
    }

    public static String lerString(String mensagem) {
        System.out.print(mensagem);
        return lerString();
    }
}
