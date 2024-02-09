import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServer {
    public static void main(String[] args) {
        try {
            // Create a UDP socket at port 9876
            DatagramSocket socket = new DatagramSocket(9876);

            // Create a buffer to receive data
            byte[] buffer = new byte[1024];

            // Create a DatagramPacket to hold received data
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

            // Receive data
            System.out.println("Server waiting for data...");

            // Block until data is received
            socket.receive(packet);

            // Convert the data to a string
            String clientMessage = new String(packet.getData(), 0, packet.getLength());
            System.out.println("Received message from client: " + clientMessage);

            // Respond with a "Hello" message
            String serverMessage = "Hello from server";
            byte[] response = serverMessage.getBytes();

            // Create a DatagramPacket to send data back to the client
            DatagramPacket responsePacket = new DatagramPacket(response, response.length, packet.getAddress(), packet.getPort());

            // Send the response packet
            socket.send(responsePacket);

            // Close the socket
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
