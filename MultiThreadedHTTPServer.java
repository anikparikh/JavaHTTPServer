import java.io.*;
import java.net.*;
import java.util.Date;

public class MultiThreadedHTTPServer {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server started. Listening on port 8080...");

        while (true) {
            Socket clientSocket = serverSocket.accept();
            new Thread(new ClientHandler(clientSocket)).start();
        }
    }

    static class ClientHandler implements Runnable {
        private final Socket socket;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try (
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                OutputStream out = socket.getOutputStream()
            ) {
                String line;
                while (!(line = in.readLine()).isEmpty()) {
                    System.out.println(line);
                }

                Date now = new Date();
                String body = "<html><body><h1>Hello from Multi-threaded Java Server!</h1><p>" + now + "</p></body></html>";
                String response = "HTTP/1.1 200 OK\r\nContent-Type: text/html\r\nContent-Length: " 
                                + body.length() + "\r\n\r\n" + body;

                out.write(response.getBytes("UTF-8"));
                out.flush();

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    socket.close();
                } catch (IOException ignore) {}
            }
        }
    }
}

