package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс содержит функционал простейшей вариации банковской системы
 *
 * @author Sergey Knyazev
 * @version 1.0
 */
public class BankService {
    /**
     * Хранение в Hashmap. Имеется юзер и его счета, хранящиеся
     * в коллекции типа List
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод принимает на вход нового User и добавляет в HashMap
     *
     * @param user данные, по которым производится поиск User
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод удаляет User из HashMap
     *
     * @param passport данные, по которым производится поиск User
     * @return возвращает true если User найден по полю пасспорт
     */
    public boolean deleteUser(String passport) {
        return users.remove(new User(passport, "")) != null;
    }

    /**
     * Метод добавляет User новый счет.
     * Поиск User производится по passport
     *
     * @param passport данные, по которым производится поиск User
     * @param account  данные, по которым производится внесение нового счета
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
     * Метод осуществляет поиск User по его полю Passport
     *
     * @param passport данные, по которым производится поиск User
     * @return возвращает null, если поиск не нашел введенные данные
     */
    public User findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(u -> u.getPassport().equals(passport))
                .findFirst()
                .orElse(null);
    }

    /**
     * Метод осуществляет поиск User по ревизитам его счета
     * Если юзер существует и счет не найден, возврящается null
     *
     * @param passport  данные, по которым производится поиск User
     * @param requisite данные, по которым производится поиск Account
     * @return возвращает null, если по заданным параметрам поиск не дал результатов
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            return users.get(user)
                    .stream()
                    .filter(u -> u.getRequisite().equals(requisite))
                    .findFirst()
                    .orElse(null);
        }
        return null;
    }

    /**
     * Данный метод осуществляет перевод денежных средств с одного счета
     * на другой счет.
     *
     * @param srcPassport   поиск User, со счета которого будет перевод
     * @param srcRequisite  поиск Account, с которого будет перевод
     * @param destPassport  поиск User, на счет которого будет перевод
     * @param destRequisite поиск Account, на который будет перевод
     * @param amount        сумма к переводу
     * @return возвращает false если на счете недостаточно средств
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcUser = findByRequisite(srcPassport, srcRequisite);
        Account destUser = findByRequisite(destPassport, destRequisite);
        if (srcUser != null && destUser != null && srcUser.getBalance() >= amount) {
            srcUser.setBalance(srcUser.getBalance() - amount);
            destUser.setBalance(destUser.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }

    /**
     * Метод служит выводу счетов определенного User
     *
     * @param user вывод счетов по User
     * @return возвращает коллекцию счетов User
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}
