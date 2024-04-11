package dao;

import models.Account;

import java.util.List;

public interface AccountDao {
    boolean addAccount(Account account);
    boolean deleteAccount(String accountDelete);
    boolean updateAccount(Account account);
    List<Account> getAccounts();
}
