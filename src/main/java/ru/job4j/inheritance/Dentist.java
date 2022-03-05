package ru.job4j.inheritance;

public class Dentist extends Doctor {

    private String qualification;

    public Dentist(
            String name, String surname, String education,
            int birthday, String hospital, String qualification
    ) {
        super(name, surname, education, birthday, hospital);
        this.qualification = qualification;
    }

    public String getQualification() {
        return qualification;
    }

    void extraction() {
        System.out.println("Removal of a tooth");
    }
}
