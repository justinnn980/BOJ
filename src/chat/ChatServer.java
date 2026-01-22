package chat;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ChatServer {

    public static void main(String[] args) throws IOException {

        // 클라이언트와 통신하는 소켓
        ServerSocket serverSocket = new ServerSocket(1234);
        // 공유객체에서 쓰레드에 안전한 리스트를 만든다.
        List<PrintWriter> outList = Collections.synchronizedList(new ArrayList<>());
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("접속 :" + socket);

            ChatThread chatThread = new ChatThread(socket, outList);
            chatThread.start();
        }
    }

}

class ChatThread extends Thread {

    private Socket socket;
    private List<PrintWriter> outList;
    private BufferedReader in;
    private PrintWriter out;

    //현재 연결된 클라이언트와만 소통
    public ChatThread(Socket socket, List<PrintWriter> outList) throws IOException {
        this.socket = socket;
        this.outList = outList;

        //1. socket으로 부터 읽을 수 있는 객체 얻기
        //2. socket에 쓰기 위한 객체를 얻는다(현재 연결된 클라이언트에게 쓰는 객체)
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
            outList.add(out);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        String line = null;
        try {
            while ((line = in.readLine()) != null){
                for(PrintWriter out : outList){
                    out.println(line);
                    out.flush();
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            outList.remove(out);

            for (PrintWriter pw : outList) {
                pw.println("[SYSTEM] 어떤 클라이언트가 접속 종료");
                pw.flush();
            }

            try { socket.close(); } catch (IOException ignored) {}
        }

        //3. 클라이언트가 보낸 메세지 읽기
        //4. 접속된 모든 클라이언트에 메세지 보내기(현재 접속된 모든 클라이언트에게 쓸수 있는 객체가 필요)

    }
}