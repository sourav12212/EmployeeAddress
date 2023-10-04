package com.geekster.EmployeeAddress.Service;

import com.geekster.EmployeeAddress.Model.Address;
import com.geekster.EmployeeAddress.Repository.IAddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {
    @Autowired
    IAddressRepo addressRepo;


    public String addAddress(Address newAddress) {
        addressRepo.save(newAddress);
        return "new address added";
    }

    public List<Address> getAddress() {
        return addressRepo.findAll();
    }

    public Address getOneAddress(Long id) {
        return addressRepo.findById(id).orElseThrow();
    }

    public String deleteAddressById(Long id) {
        addressRepo.deleteById(id);
        return "deleted";
    }


    public String updateAddressById(Long id, Address updateAddress) {
        Optional<Address> presentAddress = addressRepo.findById(id);
        if(presentAddress.isPresent()){
            Address existingAddress = presentAddress.get();
            existingAddress.setStreet(updateAddress.getStreet());
            existingAddress.setCity(updateAddress.getCity());
            existingAddress.setState(updateAddress.getState());
            existingAddress.setZipcode(updateAddress.getZipcode());
            addressRepo.save(existingAddress);
            return "address is updated";
        }
        return "address id not found";
    }


}
