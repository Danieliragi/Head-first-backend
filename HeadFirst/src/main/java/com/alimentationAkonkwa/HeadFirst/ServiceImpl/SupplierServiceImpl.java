//package com.alimentationAkonkwa.HeadFirst.ServiceImpl;
//import com.alimentationAkonkwa.HeadFirst.models.Supplier;
//import com.alimentationAkonkwa.HeadFirst.repository.SupplierRepository;
//import com.alimentationAkonkwa.HeadFirst.service.SupplierService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import java.util.List;
//@Service
//public class SupplierServiceImpl implements SupplierService {
//
//    @Autowired
//    private SupplierRepository supplierRepository;
//    @Override
//    public Supplier createSupplier(Supplier supplier) {
//        return supplierRepository.save(supplier);
//    }
//
//    @Override
//    public Boolean updateSupplier(Long id, Supplier supplier) {
//        return null;
//    }
//
//
//    @Override
//    public Boolean deleteSupplier(Long id) {
//        supplierRepository.deleteById(id);
//        return true;
//    }
//
//    @Override
//    public Supplier getSupplierById(Long id) {
//        return supplierRepository.findById(id).orElse(null);
//    }
//
//    @Override
//    public List<Supplier> getAllSuppliers() {
//        return supplierRepository.findAll();
//    }
//}
