package dao;

import models.Promotion;
import models.Role;

import java.util.List;

public interface PromotionDao {
    boolean addPromotion(Promotion promotion);
    boolean updatePromotion(Promotion promotion);
    boolean deletePromotion(String id);
    List<Promotion> getAllPromotion();
    Promotion findPromotionByText(String text);
}
