package com.lan.zz.service;

import com.lan.zz.entity.Goods;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.zeroturnaround.zip.FileSource;
import org.zeroturnaround.zip.ZipEntrySource;
import org.zeroturnaround.zip.ZipUtil;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ImageService {

    @Value("${default.imageFolder}")
    private String imageFolder;

    public void loadImage(String path, HttpServletResponse response) {
        if (path == null) return;
        String absolutePath = imageFolder + path;
        File image = new File(absolutePath);
        if (image.exists()) {
            InputStream is = null;
            OutputStream os = null;
            try {
                is = new FileInputStream(image);
                os = response.getOutputStream();
                IOUtils.copy(is, os);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (is != null) {
                    try {
                        is.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public String downImages(String gName, List<String> imgs, HttpServletResponse response) {
        Map<String, FileSource> map = new HashMap<>();
        String imgName, fileName, filePath;
        File image;
        try {
            for (String img : imgs) {
                String[] imgInfo = img.split("--");
                //按类别 为文件设置父目录
                imgName = imgInfo[1];
                fileName = (imgInfo[0].equals("zjd") ? "质检单/" : "批件/") + imgName;
                filePath = imageFolder + imgName;
                image = new File(filePath);
                if (image.exists()) {
                    map.put(fileName, new FileSource(fileName, image));
                }
            }
            if (map.values().size() == 0) return "没有文件可以下载!";
            ZipEntrySource[] entryArray = new ZipEntrySource[map.values().size()];
            map.values().toArray(entryArray);
            //设置响应头
            response.setContentType("application/force-download");
            response.addHeader("Content-Disposition", "attachment;fileName=" + URLEncoder.encode(gName + ".zip", "UTF-8"));
            ZipUtil.pack(entryArray, response.getOutputStream());
            return "下载成功!";
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "下载失败";
    }


    public String batchDownImage(List<Goods> goodsList, HttpServletResponse response) {
        Map<String, FileSource> map = new HashMap<>();
        String fileName, filePath;
        File image;
        try {
            for (Goods goods : goodsList) {
                List<String> zjdPathList = goods.getZjdPathList();
                List<String> pjPathList = goods.getPjPathList();
                for (String s : zjdPathList) {
                    fileName = goods.getTicket() + "/" + goods.getgName() + "/质检单/" + s;
                    filePath = imageFolder + s;
                    image = new File(filePath);
                    if (image.exists()) {
                        map.put(fileName, new FileSource(fileName, image));
                    }
                }
                for (String s : pjPathList) {
                    fileName = goods.getTicket() + "/" + goods.getgName() + "/批件/" + s;
                    filePath = imageFolder + s;
                    image = new File(filePath);
                    if (image.exists()) {
                        map.put(fileName, new FileSource(fileName, image));
                    }
                }
            }
            if (map.values().size() == 0) return "没有文件可以下载!";
            ZipEntrySource[] entryArray = new ZipEntrySource[map.values().size()];
            map.values().toArray(entryArray);
            //设置响应头
            response.setContentType("application/force-download");
            response.addHeader("Content-Disposition", "attachment;fileName=" + URLEncoder.encode(goodsList.get(0).getTicket() + ".zip", "UTF-8"));
            //打包下载
            ZipUtil.pack(entryArray, response.getOutputStream());
            return "下载成功!";
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "下载失败";
    }
}
