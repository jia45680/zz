package com.lan.zz.controller;

import com.lan.zz.entity.Customer;
import com.lan.zz.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Value("${default.password}")
    private String defultPassword;

    @PostMapping("/login")
    @ResponseBody
    public boolean login(Customer customer, HttpSession session) {
        if (defultPassword.equals(customer.getPassword())) {
            customer = customerService.loginCheck(customer);
            if (customer != null) {
                session.setAttribute("customer", customer);
                return true;
            }
        }
        return false;
    }


    @GetMapping("/exit")
    public String exit(HttpSession session) {
        session.removeAttribute("customer");
        return "redirect:/";
    }

}
