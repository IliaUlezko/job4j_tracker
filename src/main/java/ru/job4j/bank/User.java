package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает данные пользователя
 * @author Ilia Ulezko
 */

public class User {
    /**
     * Хранение номера паспорта в поле passport
     * Хранение имени пользователя в поле username
     */
    private String passport;
    private String username;

    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * Метод позволяет получить номер паспорта
     * @return возврщает номер паспорта
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Метод присваивает номер паспорта
     * @param passport номер паспорта, который необходимо добавить
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * Метод позволяет получить имя пользователя
     * @return возвращает имя пользователя
     */
    public String getUsername() {
        return username;
    }

    /**
     * Метод присваивает имя пользователя
     * @param username имя пользователя, которое нужно добавить
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Метод позволяет сравнить объекты класса User
     * @param o объект, который сравнивают с текущим объектом по полю passport
     * @return {@code true} , если объекты совпадают
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    /**
     *Метод получает хэш код объекта
     * @return возвращает хэш код объекта по полю passport
     */
    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}