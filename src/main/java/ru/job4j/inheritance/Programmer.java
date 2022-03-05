package ru.job4j.inheritance;

public class Programmer extends Engineer {

    private String programmingLanguage;
    private boolean writeCode;

    public Programmer(
            String name, String surname, String education, int birthday,
            String company, String programmingLanguage, boolean writeCode
    ) {
        super(name, surname, education, birthday, company);
        this.programmingLanguage = programmingLanguage;
        this.writeCode = writeCode;
    }

     public String getProgrammingLanguage() {
        return programmingLanguage;
     }

     void infoWork() {
        if (writeCode) {
            System.out.println("Programmer is working!");
        } else {
            System.out.println("Programmer is sleeping.");
        }
     }
}
