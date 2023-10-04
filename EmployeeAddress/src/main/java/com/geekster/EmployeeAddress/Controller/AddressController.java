package com.geekster.EmployeeAddress.Controller;

import com.geekster.EmployeeAddress.Model.Address;
import com.geekster.EmployeeAddress.Service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AddressController {
    @Autowired
    AddressService addressService;

    @PostMapping("addresses")
    public String addAddress(@RequestBody Address newAddress){
        return addressService.addAddress(newAddress);

    }

    @GetMapping("addresses")
    public List<Address> getAddress(){
        return addressService.getAddress();

    }

    @GetMapping("addresses/{id}")
    public Address getAddress(@PathVariable Long id){
        return addressService.getOneAddress(id);

    }

    @PutMapping("addresses/{id}")
    public String updateAddressById(@PathVariable Long id,@RequestBody Address address){
        return addressService.updateAddressById(id,address);
    }

    @DeleteMapping("address/{id}")
    public String deleteAddress(@PathVariable Long id){
        return addressService.deleteAddressById(id);
    }


}
