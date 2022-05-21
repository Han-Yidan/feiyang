package com.example.feiyang.service;

import com.example.feiyang.common.utils.JsonResponse;
import com.example.feiyang.entity.Order;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.net.UnknownHostException;
import java.util.List;

/**
 * @ProjectName: feiyang
 * @Author: lyl
 * @Date: 2022-05-05 22:47
 **/

public interface OrderService {
    JsonResponse addOrder(Order order);
    JsonResponse cancelOrder(Long orderId,String cancelReason);
    JsonResponse receiveOrder(Long staffId,Long orderId);
    void assignOrder();
    int assignOrder(Long staffId,Long orderId);
    JsonResponse queryOrder(Long userId,int current);
    JsonResponse finishOrder(Long orderId);
    int remindOrder(Long orderId);
    JsonResponse uploadFile(MultipartFile file) throws UnknownHostException, FileNotFoundException;
}
