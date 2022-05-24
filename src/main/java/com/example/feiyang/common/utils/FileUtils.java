package com.example.feiyang.common.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.system.ApplicationHome;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author 望舒
 * @date 2022/5/20 14:19
 */

public class FileUtils {
    @Autowired
    private Integer serverPort;

    /**
     * 检查文件大小
     *
     * @param len
     * @param size
     * @param unit
     * @return
     */
    public static boolean checkFileSize(Long len, int size, String unit) {
        double fileSize = 0;

        if ("BYTE".equals(unit.toUpperCase())) {
            fileSize = (double) len;
        } else if ("KB".equals(unit.toUpperCase())) {
            fileSize = (double) len / 1024;
        } else if ("MB".equals(unit.toUpperCase())) {
            fileSize = (double) len / 1048576;
        } else if ("GB".equals(unit.toUpperCase())) {
            fileSize = (double) len / 1073741824;
        }

        if (fileSize > size) {
            return false;
        }

        return true;
    }

    /**
     * 生成唯一编码，去除"-"
     *
     * @return
     */
    public static String GetUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    /**
     * 获取文件后缀名
     *
     * @param fileName
     * @return
     */
    public static String GetSuffix(String fileName) {
        return fileName.substring(fileName.lastIndexOf("."));
    }

    /**
     * 保存文件
     *
     * @param file
     * @param savePath
     * @return
     */
    public static boolean saveFile(MultipartFile file, String savePath) {
        File dest = new File(savePath);

        // 判断文件父目录是否存在
        if (!dest.getParentFile().exists()) {
            System.out.println("创建成功！");
            dest.getParentFile().mkdir();
        }

        try {
            // 保存文件
            file.transferTo(dest);
            return true;
        } catch (IllegalStateException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }


    public JsonResponse uploadFile(MultipartFile file) throws UnknownHostException, FileNotFoundException {

        // 判断文件是否为空
        if (file == null || file.isEmpty()) {
            return JsonResponse.failure("文件不能为空！");
        }

        // 判断文件大小
        if (!FileUtils.checkFileSize(file.getSize(), 20, "MB")) {
            return JsonResponse.failure("文件超出大小限制！最大20MB");
        }

        Map<String, Object> res = new HashMap<>();

        // 判断上传文件格式
        String fileType = file.getContentType();
        System.out.println(fileType);
        if (fileType.equals("image/jpg") || fileType.equals("image/png") || fileType.equals("image/jpeg")) {
            // 设置日期格式
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            // 获取当前系统时间
            String date = df.format(new Date());
            // 获取文件名
            String fileName = file.getOriginalFilename();
            // 重新生成文件名
            fileName = GetUUID() + GetSuffix(fileName);
            // 最终保存路径
            ApplicationHome ah = new ApplicationHome(org.apache.tomcat.util.http.fileupload.FileUtils.class);
            String path = ah.getSource().getParentFile().toString();
            String savePath = path + File.separator + "uploadImg" + File.separator + fileName;
            System.out.println(savePath);
            System.out.println(serverPort);

            // 保存文件
            if (FileUtils.saveFile(file, savePath)) {
                String IP = Inet4Address.getLocalHost().getHostAddress();
                res.put("filePath", "/images/" + fileName);
                res.put("ipPath", "http://" + IP + ":" + 8080 + "/images/" + fileName);

                return JsonResponse.success(res, "图片上传成功！");
            } else {
                return JsonResponse.failure("图片上传失败");
            }
        } else {
            return JsonResponse.failure("图片格式不正确，只能生成jpg，png或jpeg格式");
        }
    }
}
