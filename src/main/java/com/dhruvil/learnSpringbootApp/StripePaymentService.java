package com.dhruvil.learnSpringbootApp;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Controller;
//import org.springframework.stereotype.Repository;

//@Repository
//@Controller
@Component("stripe")
@ConditionalOnProperty(name = "payment.provider" , havingValue = "stripe")
public class StripePaymentService  implements  PayementService{
    @Override
    public String pay(){
        return "payement from stripe" ;
    }
}
