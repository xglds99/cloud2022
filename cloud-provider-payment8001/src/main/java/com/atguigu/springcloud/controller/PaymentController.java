package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;


import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Resource
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/insertPayment")
    public CommonResult<Integer> insertPayment(@RequestBody Payment payment){

        return new CommonResult<>(200,"ok, serverPort: " + serverPort,paymentService.insertPayment(payment));
    }

    @GetMapping("/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return new CommonResult<>(200,"ok, serverPort: " + serverPort,paymentService.selectPaymentById(id));
    }


    @GetMapping("/discovery")
    public Object getInstance(){
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
                log.info("*******" + service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("cloud - payment - service");
        for (ServiceInstance instance : instances) {
            log.info("*******" + instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
        }
        return this.discoveryClient;
    }
}
