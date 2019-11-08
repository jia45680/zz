package com.lan.zz.dao;


import com.lan.zz.entity.Customer;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CustomerMapper {


    @Select("select kh_id id, kh_name username from kh where kh_id = #{id}")
    List<Customer> selectCustomerById(Customer customer);
}
