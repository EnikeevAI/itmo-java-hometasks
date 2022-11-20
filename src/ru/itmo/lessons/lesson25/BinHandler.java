package ru.itmo.lessons.lesson25;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class BinHandler<T> {

    private File file;

    public BinHandler() {setFile();}

    private void setFile() {
        file = new File("src/ru/itmo/lessons/lesson25/lesson25.bin");
    }

    public void writeToFile(T object) {
        try (FileOutputStream fileOutput = new FileOutputStream(file);
             ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput)
        ) {
            objectOutput.writeObject(object);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
