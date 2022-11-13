package ru.itmo.lessons.lesson21;

import ru.itmo.lessons.lesson21.common.Connection;
import ru.itmo.lessons.lesson21.common.Message;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServerIO {
    private int port;

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

                Message message = new Message("Server", "Сообщение от сервера");
                connection.sendMessage(message);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Обработка IOException или ClassNotFoundException");
        }
    }

    public static void main(String[] args) {
        new TCPServerIO(TCPPropertiesIO.getTCPPortFromString(args[0])).run();
    }
}
