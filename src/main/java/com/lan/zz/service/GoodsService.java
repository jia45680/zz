package com.lan.zz.service;

import com.lan.zz.dao.GoodsMapper;
import com.lan.zz.entity.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    public List<Goods> loadGoodsByTicket(String ticket, String id) {
        return goodsMapper.selectGoodsByTicketAndId(ticket, id);
    }
}
