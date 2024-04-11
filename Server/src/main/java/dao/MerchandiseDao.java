package dao;

import models.Merchandise;

import java.util.List;

public interface MerchandiseDao {
    boolean addMerchandise(Merchandise merchandise);

    boolean updateMerchandise(Merchandise merchandise);

    boolean deleteMerchandise(String id);

    boolean checkIdExist(String id);

    List<Merchandise> getAllMerchandise();

    List<Merchandise> findSupplierByNameMerchandise(String name);

    List<Merchandise> findProductTypeMerchandise(String name);

    List<Merchandise> getAllSanPhamLoadData();
}
