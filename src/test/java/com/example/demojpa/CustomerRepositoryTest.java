package com.example.demojpa;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.mockito.BDDMockito.then;

@DataJpaTest
public class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    @DisplayName("findById 기본 테스트 + Spring Data JPA 동작하는지 테스트")
    void findById() {
        Customer customer = new Customer("sungbum", "park");
        customerRepository.save(customer);

        Customer foundCustomer = customerRepository.findById(1L);

        then(foundCustomer).equals(customer);
        then(foundCustomer.getFirstName()).equals("sss");
    }
}