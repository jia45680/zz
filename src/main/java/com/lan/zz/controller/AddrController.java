package com.lan.zz.controller;

import com.google.gson.Gson;
import com.lan.zz.entity.Address;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

@Controller
public class AddrController {

    @GetMapping("/")
    public String addressResolution() {
        String ip = "";
        try {
            URL url = new URL("http://pv.sohu.com/cityjson?ie=utf-8");
            String json = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8")).readLine();
            json = json.substring(json.indexOf('{'), json.indexOf('}') + 1);
            Address address = new Gson().fromJson(json, Address.class);
            ip = address.getCip();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (ip.length() == 0) return "error/404";
        return "redirect:http://" + ip + ":8082/login.html";
    }

}
