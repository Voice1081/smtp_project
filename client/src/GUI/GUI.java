package GUI;

import Client.Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI{

    private Client client;

    private JFrame mainFrame;
    private JTextField serverIdTextField;
    private JTextField portTextField;

    private JTextField loginTextField;
    private JPasswordField pwdField;

    private JTextField attachmentPaths;
    private JTextField toField;
    private JTextField themeField;
    private JTextArea textArea;


    /*
     *  запускаем
     * */
    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable(){
            public void run(){
                try{
                    GUI window = new GUI();
                    window.mainFrame.setVisible(true);
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }

    /*
     * создаем
     * */
    public GUI(){
        initialize();
    }

    /*
     * Инициализируем
     * */
    private void initialize(){
        mainFrame = new JFrame();
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension dim = new Dimension(screenSize.width / 2 + 100, screenSize.height / 2 + 100);
        mainFrame.setMinimumSize(dim);
        mainFrame.getContentPane().setLayout(new CardLayout(0, 0));
        mainFrame.setLocationRelativeTo(null);

        JPanel initializePanel = new JPanel();
        initializePanel.setBackground(Color.DARK_GRAY);
        initializePanel.setName("Инициализация");
        mainFrame.getContentPane().add(initializePanel);
        initializePanel.setVisible(true);

        JPanel authPanel = new JPanel();
        authPanel.setBackground(Color.DARK_GRAY);
        authPanel.setName("Аутентификация");
        mainFrame.getContentPane().add(authPanel);
        authPanel.setVisible(false);

        JPanel mailPanel = new JPanel();
        mailPanel.setBackground(Color.DARK_GRAY);
        mailPanel.setName("Создание письма");
        mainFrame.getContentPane().add(mailPanel);
        mailPanel.setVisible(false);
        mailPanel.setLayout(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();

        JPanel firstSupportPanel = new JPanel();
        firstSupportPanel.setLayout(new BorderLayout());
        firstSupportPanel.setBackground(Color.DARK_GRAY);

        serverIdTextField = new JTextField(20);
        JLabel serverIdLabel = new JLabel("Введите адрес сервера");
        serverIdLabel.setFont(new Font("Dialog", Font.BOLD, 14));
        serverIdLabel.setForeground(Color.WHITE);

        firstSupportPanel.add(serverIdLabel, BorderLayout.NORTH);
        firstSupportPanel.add(serverIdTextField, BorderLayout.SOUTH);

        initializePanel.add(firstSupportPanel);

        JPanel secondSupportPanel = new JPanel();
        secondSupportPanel.setBackground(Color.DARK_GRAY);
        secondSupportPanel.setLayout(new BorderLayout());

        portTextField = new JTextField(10);
        JLabel portLabel = new JLabel("Введите номер порта");
        portLabel.setFont(new Font("Dialog", Font.BOLD, 14));
        portLabel.setForeground(Color.WHITE);

        secondSupportPanel.add(portLabel, BorderLayout.NORTH);
        secondSupportPanel.add(portTextField, BorderLayout.SOUTH);

        initializePanel.add(secondSupportPanel);

        JButton buttonFirstPanel = new JButton("Продолжить");
        buttonFirstPanel.setFont(new Font("Dialog", Font.BOLD, 14));
        buttonFirstPanel.setForeground(Color.WHITE);
        buttonFirstPanel.setBackground(new Color(250, 102, 102));
        buttonFirstPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        buttonFirstPanel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                authPanel.setVisible(true);
                initializePanel.setVisible(false);
                String server = serverIdTextField.getText().trim();
                int port = Integer.parseInt(portTextField.getText().trim());
                client = new Client(server, port);
            }
        });
        initializePanel.add(buttonFirstPanel);

        JPanel authFirstSupportPanel = new JPanel();
        authFirstSupportPanel.setLayout(new BorderLayout());
        authFirstSupportPanel.setBackground(Color.DARK_GRAY);

        loginTextField = new JTextField(20);
        JLabel loginLabel = new JLabel("Введите логин");
        loginLabel.setFont(new Font("Dialog", Font.BOLD, 14));
        loginLabel.setForeground(Color.WHITE);

        authFirstSupportPanel.add(loginLabel, BorderLayout.NORTH);
        authFirstSupportPanel.add(loginTextField, BorderLayout.SOUTH);

        authPanel.add(authFirstSupportPanel);

        JPanel authSecondSupportPanel = new JPanel();
        authSecondSupportPanel.setLayout(new BorderLayout());
        authSecondSupportPanel.setBackground(Color.DARK_GRAY);

        pwdField = new JPasswordField(20);
        JLabel pwdLabel = new JLabel("Введите пароль");
        pwdLabel.setFont(new Font("Dialog", Font.BOLD, 14));
        pwdLabel.setForeground(Color.WHITE);

        authSecondSupportPanel.add(pwdLabel, BorderLayout.NORTH);
        authSecondSupportPanel.add(pwdField, BorderLayout.SOUTH);

        authPanel.add(authSecondSupportPanel);

        JButton buttonAuthPanel = new JButton("Подключиться");
        buttonAuthPanel.setFont(new Font("Dialog", Font.BOLD, 14));
        buttonAuthPanel.setForeground(Color.WHITE);
        buttonAuthPanel.setBackground(new Color(250, 102, 102));
        buttonAuthPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        buttonAuthPanel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                authPanel.setVisible(false);
                mailPanel.setVisible(true);
                String login = loginTextField.getText().trim();
                String pwd = new String(pwdField.getPassword()).trim();
                client.login(login, pwd);
            }
        });
        authPanel.add(buttonAuthPanel);

        toField = new JTextField("Кому:", 30);
        c.gridx = 0;
        c.gridy = 0;
        c.gridheight = 1;
        c.gridwidth = 1;
        mailPanel.add(toField, c);
        themeField = new JTextField("Тема:", 30);
        c.gridy = 1;
        mailPanel.add(themeField, c);
        textArea = new JTextArea(10, 30);

        JPanel panel = new JPanel();
        panel.add(new JScrollPane(textArea));
        panel.setBackground(Color.DARK_GRAY);

        JLabel areaLabel = new JLabel("Введите текст сообщения: ");
        areaLabel.setForeground(Color.WHITE);

        c.gridy = 2;
        mailPanel.add(areaLabel, c);

        c.gridy = 3;
        mailPanel.add(panel, c);

        c.gridx = 1;
        c.gridy = 0;
        JRadioButton attachmentButton = new JRadioButton("Добавить вложение", false);
        attachmentButton.setBackground(Color.DARK_GRAY);
        attachmentButton.setForeground(Color.WHITE);
        mailPanel.add(attachmentButton, c);

        c.gridy = 1;
        attachmentPaths = new JTextField("Путь к файлу:", 30);
        mailPanel.add(attachmentPaths, c);

        c.gridy = 2;
        JRadioButton archiveButton = new JRadioButton("Архивировать");
        archiveButton.setBackground(Color.DARK_GRAY);
        archiveButton.setForeground(Color.WHITE);
        mailPanel.add(archiveButton, c);

        c.gridy = 3;
        JButton sendButton = new JButton("Отправить");
        sendButton.setFont(new Font("Dialog", Font.BOLD, 14));
        sendButton.setForeground(Color.WHITE);
        sendButton.setBackground(new Color(250, 102, 102));
        sendButton.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] recipients = toField.getText().replaceAll(" ", "").split(",");
                String theme = themeField.getText();
                String text = textArea.getText();
                boolean needToArchive = archiveButton.isSelected();
                if (attachmentButton.isSelected()){
                    String[] attachments = attachmentPaths.getText().replaceAll(" ", "").split(",");
                    client.sendEmail(recipients, theme, text, attachments, needToArchive);
                }
                else{
                    System.out.println(recipients[0]);
                    client.sendEmail(recipients, theme, text);
                }
                client.quit();
                mailPanel.setVisible(false);
                initializePanel.setVisible(true);
            }
        });
        mailPanel.add(sendButton, c);
    }

}
