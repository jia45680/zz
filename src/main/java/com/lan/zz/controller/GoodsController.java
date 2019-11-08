package com.lan.zz.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.lan.zz.entity.Customer;
import com.lan.zz.entity.Goods;
import com.lan.zz.povo.LayuiTable;
import com.lan.zz.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @GetMapping("/loadTable")
    @ResponseBody
    public LayuiTable loadTable(String ticket, Integer page, Integer limit, HttpSession session) {
        Customer cus = (Customer) session.getAttribute("customer");
        PageHelper.startPage(page, limit);
        List<Goods> goodsList = goodsService.loadGoodsByTicket(ticket.toUpperCase(), cus.getId());
        PageInfo<Goods> info = new PageInfo<>(goodsList);
        return new LayuiTable(info.getTotal(), goodsList);
    }

}
