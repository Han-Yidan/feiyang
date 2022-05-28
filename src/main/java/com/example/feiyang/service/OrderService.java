package com.example.feiyang.service;

import com.example.feiyang.common.utils.JsonResponse;
import com.example.feiyang.entity.Order;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Map;

/**
 * @ProjectName: feiyang
 * @Author: lyl
 * @Date: 2022-05-05 22:47
 **/

public interface OrderService {
    JsonResponse addOrder(Map<String,Object> map);
    JsonResponse cancelOrder(Map<String,Object> map);
    JsonResponse receiveOrder(Long staffId,Long orderId);
    int assignOrder(Long staffId,Long orderId);
    JsonResponse queryOrder(Long userId,int current);
    JsonResponse queryOrderForAdmin(String repairType,Integer status,String staffName,String userName,int current);
    JsonResponse finishOrder(Long orderId);
    int remindOrder(Long orderId);
    JsonResponse uploadFile(MultipartFile file) throws UnknownHostException, FileNotFoundException;
    List<Order> searchDoingOrder(Long userId);
    int getTodayOrder();
    int getThisWeek();
    int getThisMonth();
    int getTotalOrder();

}
