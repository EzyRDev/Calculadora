import java.io.*;
import java.net.*;

public class SimpleJavaServer2 {

    public static void main(String[] args) {
        try {
            ServerSocket s = new ServerSocket(8888);
            System.out.println("Servidor ouvindo na porta 8888...");
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
                if (str.trim().equalsIgnoreCase("RAIZ")) {
                    int len = i.read(buffer);
                    String input = new String(buffer, 0, len);
                    String[] numbers = input.trim().split(" ");
                    double sum = Math.sqrt(Double.parseDouble(numbers[0]));
                    o.write(("O resultado da Raiz é " + sum).getBytes());
                }
                if (str.trim().equalsIgnoreCase("POT")) {
                    int len = i.read(buffer);
                    String input = new String(buffer, 0, len);
                    String[] numbers = input.trim().split(" ");
                    double sum = Math.pow(Double.parseDouble(numbers[0]), Double.parseDouble(numbers[1]));
                    o.write(("O resultado da divisão é " + sum).getBytes());
                }
                c.close();

                if (str.trim().equalsIgnoreCase("PORC")) {
                    int len = i.read(buffer);
                    String input = new String(buffer, 0, len);
                    String[] numbers = input.trim().split(" ");
                    int sum = (Integer.parseInt(numbers[0]) * Integer.parseInt(numbers[1])/100);
                    o.write(("O resultado da porcentagem é " + sum).getBytes());

                }
            }

        } catch (Exception err) {
            System.err.println(err);
        }
    }
}


