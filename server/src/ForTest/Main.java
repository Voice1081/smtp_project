package ForTest;

import SMTPServer.Server;
import ThreadDispatcher.ThreadDispatcher;

public class Main {
    public static void main(String[] args) {
        Server server = new Server(8080);
        ThreadDispatcher dispatcher = ThreadDispatcher.getInstance();
        PrintWorker pw = new PrintWorker(server);
        dispatcher.Add(pw);
        server.run();
    }
}
