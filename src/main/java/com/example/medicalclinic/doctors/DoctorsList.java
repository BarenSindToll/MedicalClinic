package com.example.medicalclinic.doctors;

import com.example.medicalclinic.exceptions.DoctorAlreadyExistsException;
import com.example.medicalclinic.doctors.Doctors;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Objects;

public class DoctorsList {

    private static ArrayList<Doctors> doctors = new ArrayList<>();

    public static void addDoctor(Doctors newDoctor) throws DoctorAlreadyExistsException {
        chechkUserDoesNotAlreadyExist(newDoctor.getDoctorName());
        doctors.add(newDoctor);
    }

    private static void chechkUserDoesNotAlreadyExist(String username) throws DoctorAlreadyExistsException {
        for (Doctors user : doctors) {
            if (Objects.equals(username, user.getDoctorName()))
                throw new DoctorAlreadyExistsException(username);
        }
    }

    public static boolean checkDoctorCredentials(Doctors doctor) {
        return doctors.contains(doctor);
    }

    @Override
    public String toString() {
        return doctors.toString();
    }

    public static void loadDocotrsFromFile() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            doctors = objectMapper.readValue(Paths.get("doctors.json").toFile(), new TypeReference<>() {
            });
        } catch (JsonParseException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Doctors> getDoctors() {
        return doctors;
    }

}