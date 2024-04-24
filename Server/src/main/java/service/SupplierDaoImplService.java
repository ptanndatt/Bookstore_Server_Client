package service;

import dao.impl.SupplierDaoImpl;
import models.Supplier;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public class SupplierDaoImplService implements Remote {
    private final SupplierDaoImpl supplierDaoImpl = new SupplierDaoImpl();

    public SupplierDaoImplService() throws RemoteException {
    }

    public List<Supplier> getAllSuppliers() throws RemoteException {
        return supplierDaoImpl.getAllSuppliers();
    }

    public boolean addSupplier(Supplier supplier) throws RemoteException {
        return supplierDaoImpl.addSupplier(supplier);
    }

    public boolean updateSupplier(Supplier supplier) throws RemoteException {
        return supplierDaoImpl.updateSupplier(supplier);
    }

    public boolean deleteSupplier(String id) throws RemoteException {
        return supplierDaoImpl.deleteSupplier(id);
    }

    public boolean checkSupplierId(String id) throws RemoteException {
        return supplierDaoImpl.checkSupplierId(id);
    }

    public List<Supplier> getLatestSupplierId() throws RemoteException {
        return supplierDaoImpl.getLatestSupplierId();
    }
}
