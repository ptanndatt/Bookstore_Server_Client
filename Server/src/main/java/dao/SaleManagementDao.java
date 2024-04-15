package dao;

import models.Bill;
import models.BillPending;
import models.DetailsBill;
import models.DetailsBillPending;

import java.util.ArrayList;
import java.util.List;

public interface SaleManagementDao {
    boolean deleteAllBillPending();
    boolean deleteAllDetailBillPending();
    boolean deleteBillPendingById(String id);
//    boolean deleteDetailBillPending();
    boolean addBill(Bill bill);
    boolean addDetailBill(DetailsBill detailsBill);

    boolean addBillPending(BillPending billPending);
    boolean addDetailsBillPending(DetailsBillPending detailsBillPending);
    List<DetailsBillPending> findDetailsBillPendingById(String id);
    boolean deleteDetailsBillPendingById(String id);
    List<BillPending> getAllBillPending();
    List<DetailsBillPending> getAllDetailsBillPending();

}
