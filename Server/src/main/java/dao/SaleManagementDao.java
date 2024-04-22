package dao;

import models.Bill;
import models.BillPending;
import models.DetailsBill;
import models.DetailsBillPending;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public interface SaleManagementDao {
    boolean deleteAllBillPending();
    boolean deleteAllDetailBillPending();
    boolean deleteBillPendingById(String id);
    boolean addBill(Bill bill);
    boolean addDetailBill(DetailsBill detailsBill);

    boolean addBillPending(BillPending billPending);
    boolean addDetailsBillPending(DetailsBillPending detailsBillPending);
    List<DetailsBillPending> findDetailsBillPendingById(String id);
    boolean deleteDetailsBillPendingById(String id);

    List<DetailsBill> findDetailsBillById(String id);

    List<BillPending> getAllBillPending();
    List<DetailsBillPending> getAllDetailsBillPending();
    Bill findBillById(String id);
    List<Object[]> getAllBill();

    List<Object[]> loadDataProduct(String id);

    int sumTotalBill();

    List<Object[]> findBillByCustomerSDT(String sdt);

    List<Object[]> findProductBestSeller(Date from, Date to);

    List<Object[]> findProductWorstSeller(Date from, Date to);

    double sumTotalAmount(Date from, Date to);

    int sumTotalBillDate(Date from, Date to);

    double sumProfit(Date from, Date to);

    double sumTotalBillValue(Date from, Date to);

    List<Object[]> sumTotalBillValueByProduct(Date from, Date to);

    List<Object[]> sumTotalBillValueDoanhThu(Date from, Date to);

    List<Object[]> sumTotalBillValueByDate(Date from, Date to);

    List<Object[]> sumTotalBillValueByDateLoiNhuan(Date from, Date to);

    List<Object[]> findEmployeeBestSeller(Date from, Date to);

    List<BillPending> findBillPendingByText(String text);

    List<Bill> findBillByEmployee(String employeeID);

//    List<Bill> findBillByDate(String dateFrom, String dateTo);


    List<Bill> findBillByDate(LocalDate dateFrom, LocalDate dateTo);
}
