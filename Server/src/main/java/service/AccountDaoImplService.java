package service;

import dao.impl.AccountDaoImpl;
import dao.impl.CustomerDaoImpl;
import models.Account;
import models.Customer;

import java.util.List;

public class AccountDaoImplService {
    private AccountDaoImpl accountDao = new AccountDaoImpl();

    public List<Account> getAllAccount() {
        return accountDao.getAccounts();
    }

    public boolean addAccount(Account account) {
        return accountDao.addAccount(account);
    }

    public boolean updateAccount(Account account) {
        return accountDao.updateAccount(account);
    }

    public boolean deleteAccount(String id) {
        return accountDao.deleteAccount(id);
    }

    public Account getAccountById(String id) {
        return accountDao.getAccountById(id);
    }

    public String findPasswordByEmployeeId(String employeeId) {
        return accountDao.findPasswordByEmployeeId(employeeId);
    }
}
