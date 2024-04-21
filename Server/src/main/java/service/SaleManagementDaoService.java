package service;

import dao.SaleManagementDao;
import dao.impl.SaleManagementDaoImpl;
import models.Bill;
import models.BillPending;
import models.DetailsBill;
import models.DetailsBillPending;

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
    public List<BillPending> findBillPendingByText(String text){
        return dao.findBillPendingByText(text);
    }
}
