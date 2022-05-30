package com.example.medicalclinic.services;



import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;

public class ServicesList {
    private static ArrayList<Services> services = new ArrayList<>();

    public static void addUser(Services newService)  {
        services.add(newService);
    }

    @Override
    public String toString() {
        return services.toString();
    }

    public static void loadUsersFromFile() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            services = objectMapper.readValue(Paths.get("services.json").toFile(), new TypeReference<>() {
            });
        } catch (JsonParseException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Services> getServices() {
        return services;
    }
}
