import java.io.*;
import java.net.*;


public class SimpleJavaClient {
    public static void main(String[] args) {
        try {

            System.out.print("Digite qual sua operação:\nSOMA = Soma\nSUB = Subtração\nMULT = Multiplicação\nDIV = Divisão\nPOT = POTENCIA\nRAIZ = RAIZ\nPORC = PORCENTAGEM\n");
            byte[] line = new byte[100];
            System.in.read(line);
            String input1 = new String(line).trim();
            if (input1.equalsIgnoreCase("SOMA")||input1.equalsIgnoreCase("DIV")||input1.equalsIgnoreCase("SUB")||input1.equalsIgnoreCase("MULT")) {
                Socket s = new Socket("localhost", 9999);
                InputStream i = s.getInputStream();
                OutputStream o = s.getOutputStream();
                o.write(input1.getBytes());


                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


                System.out.print("Digite dois números separados por espaço: ");
                String input = reader.readLine();

                o.write(input.getBytes());

                byte[] buffer = new byte[1024];
                int len = i.read(buffer);
                String result = new String(buffer, 0, len);
                System.out.println(result);

                s.close();
            }
            if (input1.equalsIgnoreCase("POT")){
                Socket s = new Socket("localhost", 8888);
                InputStream i = s.getInputStream();
                OutputStream o = s.getOutputStream();
                o.write(input1.getBytes());


                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


                System.out.print("Digite dois números separados por espaço:(Base) (Expoente)");
                String input = reader.readLine();

                o.write(input.getBytes());

                byte[] buffer = new byte[1024];
                int len = i.read(buffer);
                String result = new String(buffer, 0, len);
                System.out.println(result);

                s.close();
            }
            if (input1.equalsIgnoreCase("RAIZ")) {
                Socket s = new Socket("localhost", 8888);
                InputStream i = s.getInputStream();
                OutputStream o = s.getOutputStream();
                o.write(input1.getBytes());


                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


                System.out.print("Digite o numero da raiz: ");
                String input = reader.readLine();

                o.write(input.getBytes());

                byte[] buffer = new byte[1024];
                int len = i.read(buffer);
                String result = new String(buffer, 0, len);
                System.out.println(result);

                s.close();
            }

            if (input1.equalsIgnoreCase("PORC")){
                Socket s = new Socket("localhost", 8888);
                InputStream i = s.getInputStream();
                OutputStream o = s.getOutputStream();
                o.write(input1.getBytes());


                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


                System.out.print("Digite dois números separados por espaço:(Numero) (Porcentagem)");
                String input = reader.readLine();

                o.write(input.getBytes());

                byte[] buffer = new byte[1024];
                int len = i.read(buffer);
                String result = new String(buffer, 0, len);
                System.out.println(result);

                s.close();
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
