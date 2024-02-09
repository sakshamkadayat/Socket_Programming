import java.io.PrintWriter;
import java.net.*;
import java.util.Scanner;

public class TCPClient {
    public static void main(String[] args) {
        Socket socket = new Socket("localhost", 6969);
        Scanner ins= new Scanner(socket.getInputStream());
        PrintWriter outs  =new PrintWriter(socket.getOutputStream());
        outs.println(5);
        int a = ins.nextInt();
        System.out.println("Faction of your given number is  : "+ a);
        socket.close();
        ins.close();
        outs.close();
    }
    
}
