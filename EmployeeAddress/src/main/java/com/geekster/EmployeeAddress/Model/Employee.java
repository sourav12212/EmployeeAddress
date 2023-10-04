package com.geekster.EmployeeAddress.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Employee {

    @Id
    private Integer employeeId;
    @NotBlank(message = "you must enter first name")
    private String firstName;
    private String lastName;
    @OneToOne
    @JoinColumn(name = "fk_addressId")
    private Address address;
}
