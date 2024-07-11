//package com.alimentationAkonkwa.HeadFirst.controller;
//
//import com.alimentationAkonkwa.HeadFirst.models.Order;
//import com.alimentationAkonkwa.HeadFirst.service.OrderService;
//import jakarta.validation.Valid;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/order")
//public class OrderController {
//    private final OrderService orderService;
//    @Autowired
//    public OrderController(OrderService orderService) {
//        this.orderService = orderService;
//    }
//
//    @PostMapping
//    public ResponseEntity<Order> createOrder(@Valid @RequestBody Order order) {
//        return ResponseEntity.ok(orderService.createOrder(order));
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<String> updateOrder(@PathVariable Long id,@Valid @RequestBody Order order) {
//        Boolean isUpdated = orderService.updateOrder(id,order);
//        if(isUpdated){
//            return  new ResponseEntity<>("updated", HttpStatus.OK);
//        }
//       return  new ResponseEntity<>("not updated",HttpStatus.NOT_FOUND);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<String> deleteOrder(@PathVariable Long id) {
//        Boolean isDeleted = orderService.deleteOrder(id);
//        if(isDeleted){
//            return  new ResponseEntity<>("deleted", HttpStatus.OK);
//        }
//        return  new ResponseEntity<>("not deleted",HttpStatus.NOT_FOUND);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
//        return ResponseEntity.ok(orderService.getOrderById(id));
//    }
//
//    @GetMapping
//    public ResponseEntity<List<Order>> getAllOrders() {
//        return ResponseEntity.ok(orderService.getAllOrders());
//    }
//}
