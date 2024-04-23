package service;

import dao.impl.AccountDaoImpl;
import dao.impl.CustomerDaoImpl;
import models.Account;
import models.Customer;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public class AccountDaoImplService implements Remote {
    private AccountDaoImpl accountDao = new AccountDaoImpl();

    public AccountDaoImplService() throws RemoteException {
    }

    public List<Account> getAllAccount() throws RemoteException {
        return accountDao.getAccounts();
    }

    public boolean addAccount(Account account) throws RemoteException {
        return accountDao.addAccount(account);
    }

    public boolean updateAccount(Account account) throws RemoteException {
        return accountDao.updateAccount(account);
    }

    public boolean deleteAccount(String id) throws RemoteException {
        return accountDao.deleteAccount(id);
    }

    public Account getAccountById(String id) throws RemoteException {
        return accountDao.getAccountById(id);
    }

    public String findPasswordByEmployeeId(String employeeId) throws RemoteException {
        return accountDao.findPasswordByEmployeeId(employeeId);
    }

}
