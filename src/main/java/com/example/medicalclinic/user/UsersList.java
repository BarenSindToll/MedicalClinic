package com.example.medicalclinic.user;

import com.example.medicalclinic.Main;
import com.example.medicalclinic.servicies.Register;
import com.example.medicalclinic.user.Users;
import com.example.medicalclinic.exceptions.UsernameAlreadyExistsException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Objects;

public class UsersList {

    private static ArrayList<Users> users = new ArrayList<>();
    public static String logat = "cineva";
    public static void addUser(Users newUser) throws UsernameAlreadyExistsException {
        chechkUserDoesNotAlreadyExist(newUser.getUsername());
        users.add(newUser);
        Register.persistUsers();
    }

    private static void chechkUserDoesNotAlreadyExist(String username) throws UsernameAlreadyExistsException {
        for (Users user : users) {
            if (Objects.equals(username, user.getUsername()))
                throw new UsernameAlreadyExistsException(username);
        }
    }

    public static boolean checkUserCredentials(Users user) {
        return users.contains(user);
    }

    public static void removeUser(String selectedName) {
        Users u = null;
        for (Users user : users) {
            if (Objects.equals(selectedName, user.getUsername()))
                u = user;
        }
        if(u != null)
            users.remove(u);
        Register.persistUsers();
    }

    @Override
    public String toString() {
        return users.toString();
    }

    public static void loadUsersFromFile() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            users = objectMapper.readValue(Paths.get("users.json").toFile(), new TypeReference<>() {
            });
        } catch (JsonParseException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Users> getUsers() {
        return users;
    }

    public static ArrayList<Users> getUsersWithRole(String role){
        ArrayList<Users> dl = new ArrayList<>();
        for(Users u : users)
            if(u.getRole().equals(role))
                dl.add(u);
        return dl;
    }

}