package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import org.springframework.web.bind.annotation.*;


import javax.annotation.Resource;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @PostMapping("/insertPayment")
    public CommonResult<Integer> insertPayment(@RequestBody Payment payment){

        return new CommonResult<>(200,"ok",paymentService.insertPayment(payment));
    }

    @GetMapping("/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return new CommonResult<>(200,"ok",paymentService.selectPaymentById(id));
    }

}
