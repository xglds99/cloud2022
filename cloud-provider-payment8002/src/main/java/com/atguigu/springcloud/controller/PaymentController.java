package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;


    @PostMapping("/insertPayment")
    public CommonResult<Integer> insertPayment(@RequestBody Payment payment){

        return new CommonResult<>(200,"ok, serverPort" + serverPort,paymentService.insertPayment(payment));
    }

    @GetMapping("/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return new CommonResult<>(200,"ok, serverPort" + serverPort,paymentService.selectPaymentById(id));
    }

}
