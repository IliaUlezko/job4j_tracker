package ru.job4j.inheritance;

public class Builder extends Engineer {

    private int experience;

    public Builder(
            String name, String surname, String education,
            int birthday, String company, int experience
    ) {
        super(name, surname, education, birthday, company);
        this.experience = experience;
    }

    public int getExperience() {
        return experience;
    }

    void showInfo() {
        if (experience <= 2) {
            System.out.println("Builder has a little experience.");
        } else {
            System.out.println("Experienced Builder!");
        }
    }

}