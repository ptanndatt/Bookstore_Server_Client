package service.serviceImpl;

import models.Merchandise;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface MerchandiseDaoService extends Remote {
    boolean addMerchandise(Merchandise merchandise) throws RemoteException;

    List<Merchandise> getAllMerchandise() throws RemoteException;

    boolean checkIdExist(String id) throws RemoteException;

    boolean updateMerchandise(Merchandise merchandise) throws RemoteException;

    boolean deleteMerchandise(String id) throws RemoteException;

    List<Merchandise> findSupplierByNameMerchandise(String name) throws RemoteException;

    List<Merchandise> findByProductTypeMerchandise(String name) throws RemoteException;

}
