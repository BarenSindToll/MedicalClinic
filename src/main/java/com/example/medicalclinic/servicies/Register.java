package com.example.medicalclinic.servicies;

import com.example.medicalclinic.exceptions.UsernameAlreadyExistsException;
import com.example.medicalclinic.user.Users;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.example.medicalclinic.user.UsersList;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONString;


public class Register {

    public static void addUser(String username, String password, String role) throws UsernameAlreadyExistsException {
        UsersList.addUser(new Users(username, password, role));

    }

    public static void persistUsers() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File("users.json"), UsersList.getUsers());
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
