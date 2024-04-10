package dao;

import models.Account;

public interface AccountDao {
    boolean addAccount(Account account);
    boolean deleteAccount(String accountDelete);
}
