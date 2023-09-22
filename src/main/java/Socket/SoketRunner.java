package Socket;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class SoketRunner {
    public static void main(String[] args) throws IOException {
        try (Socket socket = new Socket("127.0.0.1", 5000);
             DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
             DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
             Scanner scanner = new Scanner(System.in)) {
            while (scanner.hasNextLine()){
                String massage = scanner.nextLine();
                dataOutputStream.writeUTF(massage);
                System.out.println(dataInputStream.readUTF());
            }
        }
    }
}
