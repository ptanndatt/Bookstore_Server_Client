package service;


import dao.impl.PromotionDaoImpl;
import models.Promotion;

import java.rmi.RemoteException;
import java.util.List;

public class PromotionDaoImplService {
    PromotionDaoImpl promotionDao = new PromotionDaoImpl();

    public PromotionDaoImplService() throws RemoteException {
    }

    public List<Promotion> getAllPromotion() throws RemoteException {
        return promotionDao.getAllPromotion();
    }

    public boolean addPromotion(Promotion promotion) throws RemoteException {
        return promotionDao.addPromotion(promotion);
    }

    public boolean deletePromotion(String id) throws RemoteException {
        return promotionDao.deletePromotion(id);
    }

    public boolean updatePromotion(Promotion promotion) throws RemoteException {
        return promotionDao.updatePromotion(promotion);
    }

    public List<Promotion> findPromotionByText(String text) throws RemoteException {
        return promotionDao.findPromotionByText(text);
    }
}
