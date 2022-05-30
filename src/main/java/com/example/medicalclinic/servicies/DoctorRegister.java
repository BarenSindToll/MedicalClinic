package com.example.medicalclinic.servicies;

import com.example.medicalclinic.exceptions.DoctorAlreadyExistsException;
import com.example.medicalclinic.doctors.Doctors;
import com.example.medicalclinic.doctors.DoctorsList;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;


public class DoctorRegister {

    public static void addDoctor(String name, String service) throws DoctorAlreadyExistsException {
        DoctorsList.addDoctor(new Doctors(name, service));
        persistDoctors();
    }

    private static void persistDoctors() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File("users.json"), DoctorsList.getDoctors());
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
