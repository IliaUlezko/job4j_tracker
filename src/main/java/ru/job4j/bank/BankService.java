package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает логику работы банковского сервиса:
 * добавление пользователя и счета
 * поиск по паспорту пользователя, по номеру счета
 * перевод со счета на счет
 * @author Ilia Ulezko
 */

public class BankService {
    /**
     *Хранение осуществляется в коллекции HashMap
     * ключ - объект класса User
     * значение - счета пользователя в коллекции ArrayList
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     *Метод добавляет пользователя и пустую коллекцию счетов ArrayList,
     * если пользователь существует, то ничего не добавляет
     * @param user имя пользователя
     */
    public void addUser(User user) {
        List<Account> accounts = new ArrayList<>();
        users.putIfAbsent(user, accounts);
    }

    /**
     *Метод добавляет новый счет в коллекцию account,
     * если пользователя не существует или такой счет уже создан, ничего не добавляет
     * @param passport паспорт пользователя
     * @param account коллекция счетов пользователя
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }

    }

    /**
     *Метод позволяет найти пользователя по полю passport
     * @param passport номер паспорта
     * @return объект User или null
     */
    public User findByPassport(String passport) {
        User user = null;
        for (User user1 : users.keySet()) {
            if (user1.getPassport().equals(passport)) {
                user = user1;
                break;
            }
        }
        return user;
    }

    /**
     *Метод позволяет найти коллекцию account
     * @param passport номер паспорта
     * @param requisite номер счета
     * @return коллекцию account или null, если не существует пользователя или счета
     */
    public Account findByRequisite(String passport, String requisite) {
        Account account = null;
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            for (Account account1 : accounts) {
                if (account1.getRequisite().equals(requisite)) {
                    account = account1;
                    break;
                }
            }
        }
        return account;
    }

    /**
     *Метод позволяет перевести деньги со счета на счет
     * @param srcPassport номер паспорта пользователя, со счета которого совершается перевод
     * @param srcRequisite номер счета пользователя, с которого совершается перевод
     * @param destPassport номер паспорта пользователя, на счет которого совершается перевод
     * @param destRequisite номер счета пользователя, на счет которого совершается перевод
     * @param amount сумма перевода
     * @return {@code true} , если оба счета существуют
     * и сумма перевода не превышает величину счета srcAccount
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount != null && destAccount != null
        && srcAccount.getBalance() >= amount) {
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            destAccount.setBalance(destAccount.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}