package service;

import dao.MerchandiseDao;
import dao.impl.MerchandiseDaoImpl;
import models.Merchandise;

import java.util.List;

public class MerchandiseDaoImplService {
    private MerchandiseDao merchandiseDao = new MerchandiseDaoImpl();

    public boolean addMerchandise(Merchandise merchandise) {
        return merchandiseDao.addMerchandise(merchandise);
    }

    public List<Merchandise> getAllMerchandise() {
        return merchandiseDao.getAllMerchandise();
    }

    public boolean checkIdExist(String id) {
        return merchandiseDao.checkIdExist(id);
    }

    public boolean updateMerchandise(Merchandise merchandise) {
        return merchandiseDao.updateMerchandise(merchandise);
    }

    public boolean deleteMerchandise(String id) {
        return merchandiseDao.deleteMerchandise(id);
    }

    public List<Merchandise> findSupplierByNameMerchandise(String name) {
        return merchandiseDao.findSupplierByNameMerchandise(name);
    }

    public List<Merchandise> findByProductTypeMerchandise(String name) {
        return merchandiseDao.findProductTypeMerchandise(name);
    }

    public List<Merchandise> getAllSanPhamLoadData() {
        return merchandiseDao.getAllSanPhamLoadData();
    }
}
