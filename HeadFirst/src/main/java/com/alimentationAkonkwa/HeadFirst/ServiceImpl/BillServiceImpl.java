//package com.alimentationAkonkwa.HeadFirst.ServiceImpl;
//
//
//import com.alimentationAkonkwa.HeadFirst.models.Bill;
//import com.alimentationAkonkwa.HeadFirst.repository.BillRepository;
//import com.alimentationAkonkwa.HeadFirst.service.BillService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class BillServiceImpl implements BillService {
//
//    @Autowired
//    private BillRepository billRepository;
//
//    @Override
//    public Bill createBill(Bill bill) {
//        return billRepository.save(bill);
//    }
//
//    @Override
//    public Boolean updateBill(Long id, Bill bill) {
//        return null;
//    }
//
//
//    @Override
//    public Boolean deleteBill(Long id) {
//        billRepository.deleteById(id);
//        return false;
//    }
//
//    @Override
//    public Bill getBillById(Long id) {
//        return billRepository.findById(id).orElse(null);
//    }
//
//    @Override
//    public List<Bill> getAllBills() {
//        return billRepository.findAll();
//    }
//}