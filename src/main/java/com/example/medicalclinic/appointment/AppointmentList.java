package com.example.medicalclinic.appointment;

import com.example.medicalclinic.user.UsersList;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Objects;

public class AppointmentList {
    private static ArrayList<Appointment> app = new ArrayList<>();

    public static void addAppointment(Appointment newApp) {
        app.add(newApp);
    }
    public static void persistAppointment() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File("appointment.json"), AppointmentList.getAppointment());
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
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

    public static ArrayList<Appointment> getDoctorAppointment() {
        ArrayList<Appointment> array = new ArrayList<>();
        for(Appointment a: app)
            if(Objects.equals(a.getDoctor(), UsersList.logat))
                array.add(a);
        return array;
    }

    public static ArrayList<Appointment> getPatientAppointment() {
        ArrayList<Appointment> array = new ArrayList<>();
        for(Appointment a: app)
            if(Objects.equals(a.getPatient(), UsersList.logat))
                array.add(a);
        return array;
    }
}
