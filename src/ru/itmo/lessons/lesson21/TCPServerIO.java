package ru.itmo.lessons.lesson21;

import ru.itmo.lessons.lesson21.common.Connection;
import ru.itmo.lessons.lesson21.common.Message;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServerIO {
    private int port;

    private final String sender = "Server";

    private String messageText;

    public TCPServerIO(int port) {
        this.port = port;
    }

    public void run() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Сервер запущен...");
            while (true) {
                // Связь устанавливается между Socket у клиента и Socket (который создается через метод accept) у сервера
                Socket socket = serverSocket.accept(); // Пока клиент не подключится дальше инструкции не выполняются
                // взаимодействие с клиентом (получение и передача информации)
                Connection<Message> connection = new Connection<>(socket);
                Message fromClient = connection.readMessage();
                System.out.println("От клиента: " + fromClient);

                if ("/help".equalsIgnoreCase(fromClient.getText())) {
                    messageText = getHelpText();
                } else {
                    messageText = "Сообщение от сервера";
                }

                Message message = new Message(sender, messageText);
                connection.sendMessage(message);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Обработка IOException или ClassNotFoundException");
        }
    }

    private static String getHelpText() {
        String text = "\n" +
                "Команда    /help    - отобразить справку по командам" + "\n" +
                "Команда    /count   - отобразить количество сообщений, обработанное сервером" + "\n" +
                "Команда    /ping    - отобразить время, за которое сообщение доходит до сервера и возвращается обратно"
                + "\n" +
                "Команда    /exit    - закрыть клиентское приложение";
        return text;
    }

    public static void main(String[] args) {
        new TCPServerIO(TCPPropertiesIO.getTCPPortFromString(args[0])).run();
    }
}
