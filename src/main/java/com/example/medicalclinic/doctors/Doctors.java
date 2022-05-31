package com.example.medicalclinic.doctors;

public class Doctors {
    public String name;
    public String specialty;


    public Doctors()
    {

    }

    public Doctors(String name, String specialty)
    {
        this.name=name;
        this.specialty=specialty;

    }
    public String getDoctorName()
    {

        return name;
    }

    public void setDoctorName(String name)
    {

        this.name=name;
    }

    public String getSpecialty()
    {

        return specialty;
    }
    public void setSpecialty()
    {

        this.specialty=specialty;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if(o == null || getClass() != o.getClass())
            return false;
        Doctors doctor=(Doctors) o;
        if(!name.equals(doctor.name))
            return false;
        return doctor.equals(doctor.specialty);

    }
}
