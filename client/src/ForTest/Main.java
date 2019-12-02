package ForTest;
import Client.Client;
import ThreadDispatcher.ThreadDispatcher;

public class Main {
    public static void main(String[] args){
        TestClient cl1 = new TestClient("t1e1s1t123@yandex.ru", "Test123",
                new String[] {"C:\\Users\\Константин\\Desktop\\учеба\\ООП\\smtp_project\\client\\src\\ForTest\\weather-sun.jpg",
                        "C:\\Users\\Константин\\Desktop\\учеба\\ООП\\smtp_project\\client\\src\\ForTest\\weather-snow.jpg"});
        TestClient cl2 = new TestClient("t1e1s1t123@mail.ru", "Test*1!",
                new String[] {"C:\\Users\\Константин\\Desktop\\учеба\\ООП\\smtp_project\\client\\src\\ForTest\\weather-blizzard.jpg",
                        "C:\\Users\\Константин\\Desktop\\учеба\\ООП\\smtp_project\\client\\src\\ForTest\\honklhonk.jpg"});
        ThreadDispatcher dispatcher = ThreadDispatcher.getInstance();
        dispatcher.Add(cl1);
        dispatcher.Add(cl2);
//        Client cl = new Client("127.0.0.1", 8080);
//        cl.login("t1e1s1t123@mail.ru", "Test*1!");
//        cl.sendEmail(new String[] {"voice1081@gmail.com"}, "Theme", "Text");
//        cl.quit();
    }
}
