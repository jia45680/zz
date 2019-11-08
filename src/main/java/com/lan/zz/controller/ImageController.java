package com.lan.zz.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lan.zz.entity.Customer;
import com.lan.zz.entity.Goods;
import com.lan.zz.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Type;
import java.util.List;

@Controller
@RequestMapping("/image")
public class ImageController {

    @Autowired
    private ImageService imageService;

    @GetMapping("/previewImage/{path}")
    @ResponseBody
    public void previewImage(@PathVariable("path") String path, HttpServletResponse response) {
        imageService.loadImage(path, response);
    }

    @PostMapping("/down")
    @ResponseBody
    public String down(String gName, @RequestParam("imgs") List<String> imgs, HttpServletResponse response) {
        String msg = imageService.downImages(gName, imgs, response);
        return msg;
    }

    @PostMapping("/batchDown")
    @ResponseBody
    public String batchDown(String goodss, HttpServletResponse response) {
        //超级强力 强无敌
        Gson gson = new Gson();
        Type type = new TypeToken<List<Goods>>() {}.getType();
        List<Goods> goodsList = gson.fromJson(goodss, type);
        String msg = imageService.batchDownImage(goodsList, response);
        return msg;
    }

}
