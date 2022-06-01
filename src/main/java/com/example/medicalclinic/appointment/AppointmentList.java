package com.example.medicalclinic.appointment;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;

public class AppointmentList {
    private static ArrayList<Appointment> app = new ArrayList<>();

    public static void addAppointment(Appointment newApp) {
        app.add(newApp);
    }

    @Override
    public String toString() {
        return app.toString();
    }

    public static void loadUsersFromFile() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            app = objectMapper.readValue(Paths.get("appointment.json").toFile(), new TypeReference<>() {
            });
        } catch (JsonParseException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Appointment> getAppointment() {
        return app;
    }
}
