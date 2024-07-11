//package com.alimentationAkonkwa.HeadFirst.controller;
//
//import com.alimentationAkonkwa.HeadFirst.models.Address;
//import com.alimentationAkonkwa.HeadFirst.service.AddressService;
//import jakarta.validation.Valid;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/adresse")
//public class AddressController {
//    @Autowired
//    private AddressService addressService;
//
//    @PostMapping
//    public ResponseEntity<Address> createAddress(@Valid @RequestBody Address address) {
//        return ResponseEntity.ok(addressService.createAddress(address));
//    }
//    @PutMapping("/{id}")
//    public ResponseEntity<String> updateAddress(@PathVariable Long id,@Valid @RequestBody Address address) {
//        Boolean isUpdated = addressService.updateAddress(id, address);
//        if(isUpdated){
//            return  new ResponseEntity<>("updated", HttpStatus.OK);
//        }
//        return  new ResponseEntity<>("not updated",HttpStatus.NOT_FOUND);
//    }
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteAddress(@PathVariable Long id) {
//        addressService.deleteAddress(id);
//        return ResponseEntity.ok().build();
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Address> getAddressById(@PathVariable Long id) {
//        return ResponseEntity.ok(addressService.getAddressById(id));
//    }
//
//    @GetMapping
//    public ResponseEntity<List<Address>> getAllAddresses() {
//        return ResponseEntity.ok(addressService.getAllAddresses());
//    }
//}
