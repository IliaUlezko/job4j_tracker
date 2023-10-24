package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает данные аккаунта
 * @author Ilia Ulezko
 */
public class Account {
    /**
     * Хранение номера счета в поле requisite
     * Хранение величины счета в поле balance
     */
    private String requisite;
    private double balance;

    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     *Метод позволяет получить номер счета
     * @return возвращает номер счета
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     *Метод присваивает номер счета
     * @param requisite номер счета, который необходимо добавить
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     *Метод позволяет получить величину счета
     * @return возвращает величину счета
     */
    public double getBalance() {
        return balance;
    }

    /**
     *Метод присваивает величину счета
     * @param balance величина счета, которую необходимо определить
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     *Метод позволяет сравнить объекты класса Account
     * @param o объект, который сравнивают с текущим объектом по полю requisite
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
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    /**
     *Метод получает хэш код объекта
     * @return возвращает хэш код объекта по полю requisite
     */
    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}