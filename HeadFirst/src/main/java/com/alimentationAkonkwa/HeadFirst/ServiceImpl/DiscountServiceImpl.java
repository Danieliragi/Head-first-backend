//package com.alimentationAkonkwa.HeadFirst.ServiceImpl;
//
//import com.alimentationAkonkwa.HeadFirst.models.Discount;
//import com.alimentationAkonkwa.HeadFirst.repository.DiscountRepository;
//import com.alimentationAkonkwa.HeadFirst.service.DiscountService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import java.util.List;
//
//@Service
//public class DiscountServiceImpl implements DiscountService {
//
//    @Autowired
//    private DiscountRepository discountRepository;
//    @Override
//    public Discount createDiscount(Discount discount) {
//        return discountRepository.save(discount);
//    }
//
//    @Override
//    public Boolean updateDiscount(Long id, Discount discount) {
//        return null;
//    }
//
//    @Override
//    public Boolean deleteDiscount(Long id) {
//        discountRepository.deleteById(id);
//        return false;
//    }
//
//    @Override
//    public Discount getDiscountById(Long id) {
//        return discountRepository.findById(id).orElse(null);
//    }
//
//    @Override
//    public List<Discount> getAllDiscounts() {
//        return discountRepository.findAll();
//    }
//}