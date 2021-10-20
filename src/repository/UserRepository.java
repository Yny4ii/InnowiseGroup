package repository;

import entity.User;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class UserRepository {
    private Map<Integer, User> userMap = new HashMap<>();

    public Map<Integer, User> getUserMap() {
        return userMap;
    }

    public void setUserMap(Map<Integer, User> userMap) {
        this.userMap = userMap;
    }

    public void addUser(User user) {
        int position = userMap.size();
        userMap.put(position, user);
    }

    public void setUser(Integer position, User user) {
        userMap.replace(position, user);
    }

    public void removeUser(Integer position) {
        if (position < userMap.size() - 1) {
            for (int i = position; i < userMap.size() - 1; i++) {
                userMap.replace(position, userMap.get(position + 1));
            }
        }
        userMap.remove(userMap.size() - 1);
    }

    public void saveRepository(String path) {
        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(path));
            objectOutputStream.writeObject(userMap);

        } catch (IOException ignored) {

        }
        try {
            objectOutputStream.writeObject(userMap);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadRepository(String path) {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path));
            setUserMap((Map<Integer, User>) objectInputStream.readObject());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
