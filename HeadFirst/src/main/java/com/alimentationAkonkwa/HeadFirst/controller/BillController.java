//package com.alimentationAkonkwa.HeadFirst.controller;
//
//import com.alimentationAkonkwa.HeadFirst.models.Bill;
//import com.alimentationAkonkwa.HeadFirst.service.BillService;
//import jakarta.validation.Valid;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/bill")
//public class BillController {
//    private final BillService billService;
//  @Autowired
//    public BillController(BillService billService) {
//        this.billService = billService;
//    }
//    @PostMapping
//    public ResponseEntity<Bill> createBill(@Valid @RequestBody Bill bill){
//     return ResponseEntity.ok( billService.createBill(bill));
//    }
//    @GetMapping("/{id}")
//    public ResponseEntity<Bill> getBillById(@PathVariable("id") Long id){
//       return new ResponseEntity<>(billService.getBillById(id), HttpStatus.OK);
//    }
//    @GetMapping
//    public ResponseEntity<Bill> getAllBill(@Valid @RequestBody Bill bill){
//        return ResponseEntity.ok( billService.createBill(bill));
//    }
//    @GetMapping
//    public ResponseEntity<List<Bill>> getAllBill(){
//        return new ResponseEntity<>(billService.getAllBills(), HttpStatus.OK);
//    }
//
//}
