package ru.job4j.bank;

import java.util.*;

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
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            List<Account> accounts = users.get(user.get());
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
    public Optional<User> findByPassport(String passport) {
        return users.keySet().
                stream()
                .filter(user -> user.getPassport().equals(passport))
                .findFirst();
    }

    /**
     *Метод позволяет найти коллекцию account
     * @param passport номер паспорта
     * @param requisite номер счета
     * @return коллекцию account или null, если не существует пользователя или счета
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            return users.get(user.get())
                    .stream()
                    .filter(account -> account.getRequisite().equals(requisite))
                    .findFirst();

        }
        return Optional.empty();
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
        Optional<Account> srcAccount = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount.isPresent() && destAccount.isPresent()
                && srcAccount.get().getBalance() >= amount) {
            srcAccount.get().setBalance(srcAccount.get().getBalance() - amount);
            destAccount.get().setBalance(destAccount.get().getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}