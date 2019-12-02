package ForTest;

import Client.Client;
import ThreadDispatcher.Threaded;

public class TestClient extends Threaded {
    String Login;
    String Password;
    String File;
    public TestClient(String login, String password, String file){
        Login = login;
        Password = password;
        File = file;
    }

    @Override
    public void doRun() {
        Client cl = new Client("127.0.0.1", 8080);
        cl.login(Login, Password);
        cl.sendEmail(new String[] {"t1e1s1t123@mail.ru"}, "Test message", "Test message",
                new String[] {File}, true);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        cl.quit();
    }
}
