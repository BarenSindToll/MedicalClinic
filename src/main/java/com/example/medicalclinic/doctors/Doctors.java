package com.example.medicalclinic.doctors;

public class Doctors {
    public String name;
    public String service;


    public Doctors()
    {

    }

    public Doctors(String name, String service)
    {
        this.name=name;
        this.service=service;

    }
    public String getDoctorName()
    {

        return name;
    }

    public void setDoctorName(String name)
    {

        this.name=name;
    }

    public String getService()
    {

        return service;
    }
    public void setPassword()
    {

        this.service=service;
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
        return doctor.equals(doctor.service);

    }
}
