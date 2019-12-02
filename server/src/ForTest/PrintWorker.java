package ForTest;

import SMTPServer.Server;
import ThreadDispatcher.Threaded;

public class PrintWorker extends Threaded {

    private final Server server;
    public PrintWorker(Server server){
        this.server = server;
    }
    @Override
    public void doRun() {
        while (true){
            System.out.println(server.dispatcher.monitor.getThreads());
            try {
                Thread.sleep(700);
            } catch (InterruptedException e) {
                Thread.interrupted();
            }
        }
    }
}
