package ForTest;

import Client.Client;

public class Main {
    public static void main(String[] args){
        Client client = new Client("127.0.0.1", 8080);
        client.login("t1e1s1t123@yandex.ru", "Test123");
        client.sendEmail(new String[] {"voice1081@gmail.com", "t1e1s1t123@mail.ru"}, "Костян", "Принимай гавно", new String[] {"C:\\Users\\Константин\\Desktop\\учеба\\Web\\web 2\\honklhonk.jpg"}, true);
        client.quit();
    }
}
