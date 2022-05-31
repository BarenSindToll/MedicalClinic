package com.example.medicalclinic.specialty;



import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;

public class SpecialtyList {
    private static ArrayList<Specialty> specialty = new ArrayList<>();

    public static void addSpecialty(Specialty newSpecialty)  {
        specialty.add(newSpecialty);
    }

    @Override
    public String toString() {
        return specialty.toString();
    }

    public static void loadUsersFromFile() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            specialty = objectMapper.readValue(Paths.get("specialty.json").toFile(), new TypeReference<>() {
            });
        } catch (JsonParseException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Specialty> getspecialty() {
        return specialty;
    }
}
