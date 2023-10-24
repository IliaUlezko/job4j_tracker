package ru.job4j.inheritance;

public class Surgeon extends Doctor {

    private String speciality;

    public Surgeon(
            String name, String surname, String education,
            int birthday, String hospital, String speciality
    ) {
        super(name, surname, education, birthday, hospital);
        this.speciality = speciality;
    }

    public String getSpeciality() {
        return speciality;
    }

    void operation() {
        System.out.println("Don`t disturb a surgeon!");
    }
}
