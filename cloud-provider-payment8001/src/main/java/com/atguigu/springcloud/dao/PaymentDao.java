package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentDao {

    public int insertPayment(Payment payment);
    public int updatePayment(Payment payment);
    public int deletePayment(Long paymentId);
    public Payment getPaymentById(@Param("id") Long paymentId);

}
