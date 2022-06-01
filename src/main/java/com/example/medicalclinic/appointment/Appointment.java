package com.example.medicalclinic.appointment;

public class Appointment {
    private String date;
    private String patient;
    private String doctor;

    public Appointment(String date, String patient, String doctor){
        this.doctor = doctor;
        this.date = date;
        this.patient = patient;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPatient() {
        return patient;
    }

    public void setPatient(String patient) {
        this.patient = patient;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }
}
