import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleJavaServer {

public static void main(String[] args) {
    try {
        ServerSocket s = new ServerSocket(9999);
        while (true) {
            Socket c = s.accept();
            DataInputStream in = new DataInputStream(c.getInputStream());
            DataOutputStream out = new DataOutputStream(c.getOutputStream());
            int sum = 0;
            int num;
            do {
                num = in.readInt();
                if (num != -1)
                sum += num;
            } while (num != -1);
            out.writeInt(sum);
            c.close();
        }
    } catch (Exception err) {
        System.err.println(err);
    }
}
}


