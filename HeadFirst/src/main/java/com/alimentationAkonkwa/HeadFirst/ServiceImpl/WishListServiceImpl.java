//package com.alimentationAkonkwa.HeadFirst.ServiceImpl;
//
//import com.alimentationAkonkwa.HeadFirst.models.WishList;
//import com.alimentationAkonkwa.HeadFirst.repository.WishListRepository;
//import com.alimentationAkonkwa.HeadFirst.service.WishlistService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//@Service
//public class WishListServiceImpl implements WishlistService {
//    private final WishListRepository wishListRepository;
//    @Autowired
//    public WishListServiceImpl(WishListRepository wishListRepository) {
//        this.wishListRepository = wishListRepository;
//    }
//    @Override
//    public WishList createWishList(WishList wishList) {
//        return  wishListRepository.save(wishList);
//    }
//
//    @Override
//    public Boolean updateWishList(Long id, WishList wishList) {
//        return null;
//    }
//
//
//    @Override
//    public Boolean deleteWishList(Long id) {
//wishListRepository.deleteById(id);
//return true;
//    }
//
//    @Override
//    public WishList getWishListById(Long id) {
//        return wishListRepository.findById(id).orElse(null);
//    }
//
//    @Override
//    public List<WishList> getAllWishList() {
//        return wishListRepository.findAll();
//    }
//}
