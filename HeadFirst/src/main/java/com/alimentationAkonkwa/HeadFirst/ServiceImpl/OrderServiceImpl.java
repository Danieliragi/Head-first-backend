//package com.alimentationAkonkwa.HeadFirst.ServiceImpl;
//
//import com.alimentationAkonkwa.HeadFirst.models.Order;
//import com.alimentationAkonkwa.HeadFirst.repository.OrderRepository;
//import com.alimentationAkonkwa.HeadFirst.service.OrderService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//@Service
//public class OrderServiceImpl implements OrderService {
//    private final OrderRepository orderRepository;
//    @Autowired
//    public OrderServiceImpl(OrderRepository orderRepository) {
//        this.orderRepository = orderRepository;
//    }
//
//    @Override
//    public Order createOrder(Order order) {
//        return orderRepository.save(order);
//    }
//
//    @Override
//    public Boolean updateOrder(Long id, Order order) {
//        return false;
//    }
//
//
//    @Override
//    public Boolean deleteOrder(Long id) {
//return false;
//    }
//
//    @Override
//    public Order getOrderById(Long id) {
//        return null;
//    }
//
//    @Override
//    public List<Order> getAllOrders() {
//        return List.of();
//    }
//}
