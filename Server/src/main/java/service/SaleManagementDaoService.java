package service;

import dao.SaleManagementDao;
import dao.impl.SaleManagementDaoImpl;
import models.Bill;
import models.BillPending;
import models.DetailsBill;
import models.DetailsBillPending;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class SaleManagementDaoService {
    private SaleManagementDao dao=new SaleManagementDaoImpl();
    public boolean addBillPending(BillPending billPending){
        return dao.addBillPending(billPending);
    }
    public boolean addDetailBillPending(DetailsBillPending detailsBillPending){
        return dao.addDetailsBillPending(detailsBillPending);
    }
    public List<DetailsBillPending> getDetailBillPendingByIdBill(String idBill){
        return dao.findDetailsBillPendingById(idBill);
    }
    public boolean deleteDetailsBillPendingById(String idBill){
        return dao.deleteDetailsBillPendingById(idBill);
    }
    public boolean deleteBillPendingById(String idBill){
        return dao.deleteBillPendingById(idBill);
    }
    public List<BillPending> getAllBillPending(){
        return dao.getAllBillPending();
    }
    public List<DetailsBillPending> getAllDetailBillPending(){
        return dao.getAllDetailsBillPending();
    }
    public boolean deleteAllBillPending(){
        return dao.deleteAllBillPending();
    }
    public boolean deleteAllDetailBillPending(){
        return dao.deleteAllDetailBillPending();
    }
    public boolean addBill(Bill bill){
        return dao.addBill(bill);
    }
    public Bill getBillById(String idBill){
        return dao.findBillById(idBill);
    }
    public boolean addDetailsBill(DetailsBill detailsBill){
        return dao.addDetailBill(detailsBill);
    }

    public List<Object[]> getAllBill() {
        return dao.getAllBill();
    }

    public List<Object[]> loadDataProduct(String id) {
        return dao.loadDataProduct(id);
    }

    public int sumTotalBill() {
        return dao.sumTotalBill();
    }

    public List<Object[]> findBillByCustomerSDT(String sdt) {
        return dao.findBillByCustomerSDT(sdt);
    }

    public List<Object[]> findProductBestSeller(Date from, Date to) {
        return dao.findProductBestSeller(from, to);
    }

    public double sumTotalAmount(Date from, Date to) {
        return dao.sumTotalAmount(from, to);
    }

    public int sumTotalBillDate(Date from, Date to) {
        return dao.sumTotalBillDate(from, to);
    }

    public double sumProfit(Date from, Date to) {
        return dao.sumProfit(from, to);
    }

    public double sumTotalBillValue(Date from, Date to) {
        return dao.sumTotalBillValue(from, to);
    }

    public List<Object[]> sumTotalBillValueByProduct(Date from, Date to) {
        return dao.sumTotalBillValueByProduct(from, to);
    }

    public List<Object[]> sumTotalBillValueDoanhThu(Date from, Date to) {
        return dao.sumTotalBillValueDoanhThu(from, to);
    }

    public List<Object[]> sumTotalBillValueByDate(Date from, Date to) {
        return dao.sumTotalBillValueByDate(from, to);
    }

    public List<Object[]> sumTotalBillValueByDateLoiNhuan(Date from, Date to) {
        return dao.sumTotalBillValueByDateLoiNhuan(from, to);
    }

    public List<Object[]> findProductWorstSeller(Date from, Date to) {
        return dao.findProductWorstSeller(from, to);
    }

    public List<Object[]> findEmployeeBestSeller(Date from, Date to) {
        return dao.findEmployeeBestSeller(from, to);
    }
    public List<BillPending> findBillPendingByText(String text){
        return dao.findBillPendingByText(text);
    }
    public List<DetailsBill> findDetailsBillByBillId(String id){
        return dao.findDetailsBillById(id);
    }
    public List<Bill> findBillByEmployee(String id){
        return dao.findBillByEmployee(id);
    }
    public List<Bill> findBillByDate(LocalDate from, LocalDate to){
        return dao.findBillByDate(from,to);
    }
}
