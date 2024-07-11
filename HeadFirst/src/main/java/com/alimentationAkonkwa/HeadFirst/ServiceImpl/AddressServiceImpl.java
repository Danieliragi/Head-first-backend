//package com.alimentationAkonkwa.HeadFirst.ServiceImpl;
//import com.alimentationAkonkwa.HeadFirst.models.Address;
//import com.alimentationAkonkwa.HeadFirst.repository.AddressRepository;
//import com.alimentationAkonkwa.HeadFirst.service.AddressService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//@Service
//public class AddressServiceImpl implements AddressService {
//
//    private final AddressRepository addressRepository;
//@Autowired
//    public AddressServiceImpl(AddressRepository addressRepository) {
//        this.addressRepository = addressRepository;
//    }
//
//    @Override
//    public Address createAddress(Address address) {
//        return addressRepository.save(address);
//    }
//
//    @Override
//    public Boolean updateAddress(Long id, Address address) {
//        return true;
//    }
//
//
//    @Override
//    public Boolean deleteAddress(Long id) {
//        addressRepository.deleteById(id);
//        return true;
//    }
//
//    @Override
//    public Address getAddressById(Long id) {
//        return addressRepository.findById(id).orElse(null);
//    }
//
//    @Override
//    public List<Address> getAllAddresses() {
//        return addressRepository.findAll();
//
//    }
//}
