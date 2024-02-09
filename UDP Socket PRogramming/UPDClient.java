import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {
    public static void main(String[] args) {
        try {
            // Create a UDP socket
            DatagramSocket socket = new DatagramSocket();

            // Server address and port
            InetAddress serverAddress = InetAddress.getByName("localhost");
            int serverPort = 9876;

            // Message to send
            String clientMessage = "Hello from client";
            byte[] data = clientMessage.getBytes();

            // Create a DatagramPacket to send data to the server
            DatagramPacket sendPacket = new DatagramPacket(data, data.length, serverAddress, serverPort);

            // Send the packet
            socket.send(sendPacket);

            
            // Create a buffer to receive the response from the server
            byte[] Data1 = new byte[1024];

            // Create a DatagramPacket to hold the response data
            DatagramPacket receivePacket = new DatagramPacket(Data1, Data1.length);

            // Block until a response is received
            socket.receive(receivePacket);

            // Convert the response data to a string
            String serverResponse = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Received message from server: " + serverResponse);

            // Close the socket
            socket.close();
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
