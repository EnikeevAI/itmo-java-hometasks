package ru.itmo.lessons.lesson14.message;

import java.util.*;

public class MessageTask {
    public static void countEachPriority(List<Message> messageList) {
        int counter;
        System.out.println();
        System.out.println("=====Количество сообщений для каждого приоритета=====");
        for (MessagePriority mp: MessagePriority.values()) {
            counter = 0;
            for (Message message : messageList) {
                if (mp.equals(message.getPriority())) {
                    counter++;
                }
            }
            System.out.println("Приоритет: " + mp + "; Количество сообщений: " + counter);
        }
    }

    public static void countEachCode(List<Message> messageList) {
        System.out.println();
        System.out.println("===Количество сообщений для каждого кода сообщений===");
        HashSet<Integer> messageSet = new HashSet<>();
        int counter;

        for (Message message : messageList) {
            messageSet.add(message.getCode());
        }

        for (Integer code : messageSet) {
            counter = 0;
            for (Message message : messageList) {
                if(code.equals(message.getCode())){
                    counter++;
                }
            }
            System.out.println("Код сообщения: " + code + "; количество сообщений: " + counter);
        }
    }

    public static void uniqueMessageCount(List<Message> messageList) {
        System.out.println();
        System.out.println("===========Количество уникальных сообщений===========");
        System.out.println(new HashSet<>(messageList).size());
    }

    public static List<Message> uniqueMessagesInOriginalOrder(List<Message> messageList) {
        System.out.println();
        System.out.println("=Неповторяющиеся сообщения в порядке, в котором они встретились в первоначальном списке=");
        return new ArrayList<>(new LinkedHashSet<>(messageList));
    }

    public static void removeEach(List<Message> messageList, MessagePriority priority) {
        System.out.println();
        System.out.println("===Удалить из коллекции каждое сообщение с заданным приоритетом===");
        System.out.println("Коллекция до удаления сообщений с приоритетом - " + priority);
        System.out.println(messageList);
        Iterator<Message> iterator = messageList.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getPriority().equals(priority)) {
                iterator.remove();
            }
        }
        System.out.println("Коллекция после удаления сообщений с приоритетом - " + priority);
        System.out.println(messageList);
    }

    public static void removeOther(List<Message> messageList, MessagePriority priority) {
        System.out.println();
        System.out.println("===Удалить из коллекции все сообщения, кроме тех, которые имеют заданный приоритет===");
        System.out.println("Коллекция до удаления сообщений с приоритетом отличающимся от - " + priority);
        System.out.println(messageList);
        Iterator<Message> iterator = messageList.iterator();
        while (iterator.hasNext()) {
            if (!iterator.next().getPriority().equals(priority)) {
                iterator.remove();
            }
        }
        System.out.println("Коллекция после удаления сообщений с приоритетом отличающимся от " + priority);
        System.out.println(messageList);
    }

    public static void main(String[] args) {
        List<Message> messages = Message.generate(34);
        System.out.println(messages);
        MessageTask.countEachPriority(messages);
        MessageTask.countEachCode(messages);
        MessageTask.uniqueMessageCount(messages);
        System.out.println(MessageTask.uniqueMessagesInOriginalOrder(messages));
        MessageTask.removeEach(messages, MessagePriority.HIGH);
        MessageTask.removeOther(messages, MessagePriority.LOW);
    }
}
