package ru.gb.family_tree.model.family_tree.saver;

import java.io.*;

public class FileHandler implements Writable {
    @Override
    public void save(Serializable serializable, String path) {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path));
            objectOutputStream.writeObject(serializable);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Object load(String filePath) {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath));
            return objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

}
