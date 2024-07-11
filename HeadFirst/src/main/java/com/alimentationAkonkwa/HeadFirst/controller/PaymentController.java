//package com.alimentationAkonkwa.HeadFirst.controller;
//
//
//import com.alimentationAkonkwa.HeadFirst.models.Payment;
//import com.alimentationAkonkwa.HeadFirst.service.PaymentService;
//import jakarta.validation.Valid;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/payment")
//public class PaymentController {
//
//    private final PaymentService paymentService;
//    @Autowired
//    public PaymentController(PaymentService paymentService) {
//        this.paymentService = paymentService;
//    }
//
//    @PostMapping
//    public ResponseEntity<Payment> createPayment(@Valid @RequestBody Payment payment) {
//        return ResponseEntity.ok(paymentService.createPayment(payment));
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<String> updatePayment(@PathVariable Long id,@Valid @RequestBody Payment payment) {
//        Boolean isUpdated = paymentService.updatePayment(id,payment);
//        if(isUpdated) {
//            return new ResponseEntity<>("updated suc", HttpStatus.OK);
//        }
//        return new ResponseEntity<>("not updated", HttpStatus.NOT_FOUND);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deletePayment(@PathVariable Long id) {
//        paymentService.deletePayment(id);
//        return ResponseEntity.ok().build();
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Payment> getPaymentById(@PathVariable Long id) {
//        return ResponseEntity.ok(paymentService.getPaymentById(id));
//    }
//
//    @GetMapping
//    public ResponseEntity<List<Payment>> getAllPayments() {
//        return ResponseEntity.ok(paymentService.getAllPayments());
//    }
//}
