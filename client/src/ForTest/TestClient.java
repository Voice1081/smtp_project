package ForTest;

import Client.Client;
import ThreadDispatcher.Threaded;

public class TestClient extends Threaded {
    String Login;
    String Password;
    String[] Files;

    public TestClient(String login, String password, String[] files){
        Login = login;
        Password = password;
        Files = files;
    }

    @Override
    public void doRun() {
        Client cl = new Client("127.0.0.1", 8080);
        cl.login(Login, Password);
        cl.sendEmail(new String[] {"test_receive123@mail.ru", "test-receive@yandex.ru"}, "Test message", "Test message",
                Files, true);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        cl.quit();
    }
}
