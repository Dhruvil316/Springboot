package com.dhruvil.learnSpringbootApp;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component("razorpay")
@ConditionalOnProperty(name = "payment.provider" , havingValue = "razorpay")
public class RazorpayPaymentService  implements PayementService{
    @Override
    public String pay () {
        return "payment from Razorpay" ;
    }
}
