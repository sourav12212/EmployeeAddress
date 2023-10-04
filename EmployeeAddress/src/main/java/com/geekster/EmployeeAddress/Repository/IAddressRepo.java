package com.geekster.EmployeeAddress.Repository;

import com.geekster.EmployeeAddress.Model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAddressRepo extends JpaRepository<Address,Long> {
}
