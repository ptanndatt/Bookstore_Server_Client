package service;

import dao.impl.SupplierDaoImpl;
import models.Supplier;

import java.util.List;

public class SupplierDaoImplService {
    private SupplierDaoImpl supplierDaoImpl = new SupplierDaoImpl();

    public List<Supplier> getAllSuppliers() {
        return supplierDaoImpl.getAllSuppliers();
    }

    public boolean addSupplier(Supplier supplier) {
        return supplierDaoImpl.addSupplier(supplier);
    }

    public boolean updateSupplier(Supplier supplier) {
        return supplierDaoImpl.updateSupplier(supplier);
    }

    public boolean deleteSupplier(String id) {
        return supplierDaoImpl.deleteSupplier(id);
    }

    public boolean checkSupplierId(String id) {
        return supplierDaoImpl.checkSupplierId(id);
    }

    public List<Supplier> getLatestSupplierId() {
        return supplierDaoImpl.getLatestSupplierId();
    }
}
