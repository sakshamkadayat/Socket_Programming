import java.io.PrintWriter;
import java.net.*;
import java.util.Scanner;
public class TCPServer {
    int static fact(int a){
        if(a===0){
            return 1;
        }
        else{
            return a* fact(a-1);
        }
    }
    public static void main(String[] args) {
        ServerSocket socket = new ServerSocket(6969);
        Socket soc = socket.accept();
        Scanner ins = new Scanner(soc.getInputStream());
        PrintWriter outs = new PrintWriter(soc.getOutputStream());
        int data = ins.nextInt();
        System.out.println("Data received from client : "+data);
        outs.println(fact(data));
        
        socket.close();
        ins.close();
        outs.close();
    }
}
