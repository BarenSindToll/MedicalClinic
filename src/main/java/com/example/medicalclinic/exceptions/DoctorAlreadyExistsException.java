package com.example.medicalclinic.exceptions;

public class DoctorAlreadyExistsException extends Exception{
    private String name;

    public DoctorAlreadyExistsException(String name) {
        super(String.format("A doctor with the name '%s' already exists!", name));
        this.name = name;
    }

    public String getDoctorName() {
        return name;
    }
}