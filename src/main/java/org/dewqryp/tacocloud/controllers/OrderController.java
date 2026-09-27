package org.dewqryp.tacocloud.controllers;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.dewqryp.tacocloud.data.TacoOrder;
import org.dewqryp.tacocloud.data.User;
import org.dewqryp.tacocloud.messaging.OrderMessagingService;
import org.dewqryp.tacocloud.repositories.OrderRepository;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import java.util.Locale;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("tacoOrder")
public class OrderController {

    private OrderRepository orderRepository;
    private OrderMessagingService orderMessagingService;

    public OrderController(OrderRepository orderRepository, OrderMessagingService orderMessagingService) {
        this.orderRepository = orderRepository;
        this.orderMessagingService = orderMessagingService;
    }



    @GetMapping("/current")
    public String orderForm(){
        return "orderForm";
    }

    @PostMapping
    public String  processOrder(@Valid TacoOrder tacoOrder, Errors errors, SessionStatus sessionStatus, @AuthenticationPrincipal User user){
        if(errors.hasErrors()){
            return "orderForm";
        }
        tacoOrder.setUser(user);
        orderRepository.save(tacoOrder);
        orderMessagingService.sendOrder(tacoOrder);
        sessionStatus.setComplete();
        return "redirect:/";
    }


}
