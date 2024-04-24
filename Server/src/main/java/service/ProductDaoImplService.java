package service;

import dao.ProductDao;
import dao.impl.ProductDaoImpl;
import models.Product;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public class ProductDaoImplService implements Remote {
    private final ProductDao productDao = new ProductDaoImpl();

    public ProductDaoImplService() throws RemoteException {
    }

    public Product getById(String id) throws RemoteException {
        return productDao.getProductById(id);
    }

    public List<Product> getProductByText(String text) throws RemoteException {
        return productDao.getProductByText(text);
    }

    public boolean updateProduct(String id, int quantity) throws RemoteException {
        return productDao.updateProduct(id, quantity);
    }
}
