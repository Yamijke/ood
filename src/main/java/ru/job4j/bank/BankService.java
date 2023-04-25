package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        if (!users.containsKey(user)) {
            users.put(user, new ArrayList<Account>());
        }
    }

    public boolean deleteUser(String passport) {
        boolean result = false;
        User user = findByPassport(passport);
        if (user != null) {
            users.remove(user);
            result = true;
        }
        return result;
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            boolean accountExist = false;
            for (Account currentAcc : accounts) {
                if (currentAcc.equals(account)) {
                    accountExist = true;
                    break;
                }
            }
            if (!accountExist) {
                accounts.add(account);
            }
        }
    }

    public User findByPassport(String passport) {
        for (User foundUser : users.keySet()) {
            if (passport.equals(foundUser.getPassport())) {
                return foundUser;
            }
        }
        return null;
    }

    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            for (Account currentAcc : accounts) {
                if (currentAcc.getRequisite().equals(requisite)) {
                    return currentAcc;
                }
            }
        }
        return null;
    }

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

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}
