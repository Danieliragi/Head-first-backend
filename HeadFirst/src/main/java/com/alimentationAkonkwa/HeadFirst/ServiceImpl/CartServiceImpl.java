//package com.alimentationAkonkwa.HeadFirst.ServiceImpl;
//
//import com.alimentationAkonkwa.HeadFirst.models.Cart;
//import com.alimentationAkonkwa.HeadFirst.repository.CartRepository;
//import com.alimentationAkonkwa.HeadFirst.service.cartService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class CartServiceImpl implements cartService {
//    @Autowired
//    private CartRepository cartRepository;
//
//    @Override
//    public Cart createCart(Cart cart) {
//        return cartRepository.save(cart);
//    }
//
//    @Override
//    public Boolean updateCart(Long id, Cart cart) {
//        return null;
//    }
//
//
//    @Override
//    public Boolean deleteCart(Long id) {
//        cartRepository.deleteById(id);
//    return true;
//    }
//
//    @Override
//    public Cart getCartById(Long id) {
//        return cartRepository.findById(id).orElse(null);
//    }
//
//    @Override
//    public List<Cart> getAllCarts() {
//        return cartRepository.findAll();
//    }
//}
