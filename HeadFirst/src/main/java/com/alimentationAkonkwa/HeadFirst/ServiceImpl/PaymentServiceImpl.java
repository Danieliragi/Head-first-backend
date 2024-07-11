//package com.alimentationAkonkwa.HeadFirst.ServiceImpl;
//
//import com.alimentationAkonkwa.HeadFirst.models.Payment;
//import com.alimentationAkonkwa.HeadFirst.repository.PaymentRepository;
//import com.alimentationAkonkwa.HeadFirst.service.PaymentService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import java.util.List;
//@Service
//public class PaymentServiceImpl implements PaymentService {
//    private final PaymentRepository paymentRepository;
//@Autowired
//    public PaymentServiceImpl(PaymentRepository paymentRepository) {
//        this.paymentRepository = paymentRepository;
//    }
//
//    @Override
//    public Payment createPayment(Payment payment) {
//        return paymentRepository.save(payment);
//    }
//
//    @Override
//    public Boolean updatePayment(Long id, Payment payment) {
//        return null;
//    }
//
//
//
//    @Override
//    public Boolean deletePayment(Long id) {
//    paymentRepository.deleteById(id);
//    return false;
//    }
//
//    @Override
//    public Payment getPaymentById(Long id) {
//        return paymentRepository.findById(id).orElse(null);
//    }
//
//    @Override
//    public List<Payment> getAllPayments() {
//        return paymentRepository.findAll();
//    }
//}
