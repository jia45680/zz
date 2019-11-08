package com.lan.zz.service;

import com.lan.zz.dao.CustomerMapper;
import com.lan.zz.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    public Customer loginCheck(Customer customer) {
        List<Customer> customers = customerMapper.selectCustomerById(customer);
        if (customers.size() == 0) return null;
        return customers.get(0);
    }

}
