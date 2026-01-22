package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatClient {
    public static void main(String[] args) throws IOException {
        String name = args[0];

        Socket socket = new Socket("127.0.0.1", 1234);

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

        String line = null;
        InputThread inputThread = new InputThread(in);
        inputThread.start();

        while ((line = keyboard.readLine()) != null){
            out.println(name + ": " + line);
            out.flush();
        }
    }
}

class InputThread extends Thread {
    BufferedReader in = null;
    public InputThread(BufferedReader in) {
        this.in = in;
    }

    @Override
    public void run() {
        try{
            String line = null;
            while ((line = in.readLine()) != null){
                System.out.println(line);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}