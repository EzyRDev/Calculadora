import java.io.*;
import java.net.*;

public class SimpleJavaServer {

    public static void main(String[] args) {
        try {
            ServerSocket s = new ServerSocket(9999);
            System.out.println("Servidor ouvindo na porta 9999...");
            while (true) {
                Socket c = s.accept();
                System.out.println("Conexão estabelecida com " + c.getInetAddress());
                InputStream i = c.getInputStream();
                OutputStream o = c.getOutputStream();
                String str;
                byte[] buffer = new byte[1024];
                byte[] line = new byte[1024];
                i.read(line);
                str = new String(line);
                System.out.println("Comando recebido: " + str);
                if (str.trim().equalsIgnoreCase("SOMA")) {
                    int len = i.read(buffer);
                    String input = new String(buffer, 0, len);
                    String[] numbers = input.trim().split(" ");
                    int sum = Integer.parseInt(numbers[0]) + Integer.parseInt(numbers[1]);
                    o.write(("A soma é " + sum).getBytes());
                }
                if (str.trim().equalsIgnoreCase("SUB")) {
                    int len = i.read(buffer);
                    String input = new String(buffer, 0, len);
                    String[] numbers = input.trim().split(" ");
                    int sum = Integer.parseInt(numbers[0]) - Integer.parseInt(numbers[1]);
                    o.write(("O resultado da subtração é " + sum).getBytes());
                }
                if (str.trim().equalsIgnoreCase("MULT")) {
                    int len = i.read(buffer);
                    String input = new String(buffer, 0, len);
                    String[] numbers = input.trim().split(" ");
                    int sum = Integer.parseInt(numbers[0]) * Integer.parseInt(numbers[1]);
                    o.write(("O resultado da multiplição é " + sum).getBytes());
                }
                if (str.trim().equalsIgnoreCase("DIV")) {
                    int len = i.read(buffer);
                    String input = new String(buffer, 0, len);
                    String[] numbers = input.trim().split(" ");
                    int sum = Integer.parseInt(numbers[0]) / Integer.parseInt(numbers[1]);
                    o.write(("O resultado da divisão é " + sum).getBytes());
                }

            }

        } catch (Exception err) {
            System.err.println(err);
        }
    }
}
