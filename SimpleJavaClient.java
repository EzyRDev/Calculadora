import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class SimpleJavaClient {

public static void main(String[] args) {
    try {
        Socket s = new Socket("localhost", 9999);
        DataInputStream in = new DataInputStream(s.getInputStream());
        DataOutputStream out = new DataOutputStream(s.getOutputStream());
        Scanner scanner = new Scanner(System.in);
        int num;
        do {
            System.out.print("Digite um número inteiro (-1 para sair): ");
            num = scanner.nextInt();
            out.writeInt(num);
        } while (num != -1);
        int sum = in.readInt();
        System.out.println("A soma dos números é: " + sum);
        s.close();
    } catch (Exception err) {
        System.err.println(err);
    }
}
}