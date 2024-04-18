package service;


import dao.impl.PromotionDaoImpl;
import models.Promotion;

import java.util.List;

public class PromotionDaoImplService {
    PromotionDaoImpl promotionDao = new PromotionDaoImpl();
    public List<Promotion> getAllPromotion() {
        return promotionDao.getAllPromotion();
    }

    public boolean addPromotion(Promotion promotion) {
        return promotionDao.addPromotion(promotion);
    }

    public boolean deletePromotion(String id) {
        return promotionDao.deletePromotion(id);
    }
    public Promotion findPromotionByText(String text) {
        return promotionDao.findPromotionByText(text);
    }
    public boolean updatePromotion(Promotion promotion) {
        return promotionDao.updatePromotion(promotion);
    }
}
