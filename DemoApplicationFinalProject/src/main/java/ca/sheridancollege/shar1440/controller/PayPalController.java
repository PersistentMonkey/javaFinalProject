package ca.sheridancollege.shar1440.controller;



import org.springframework.web.bind.annotation.*;

import ca.sheridancollege.shar1440.services.PayPalService;

import java.util.Map;

@RestController
@RequestMapping("/api/paypal")
@CrossOrigin(origins = "*")
public class PayPalController {

    private final PayPalService payPalService;

    public PayPalController(PayPalService payPalService) {
        this.payPalService = payPalService;
    }

    @PostMapping("/create-order")
    public Map<String, Object> createOrder() {
        return payPalService.createOrder();
    }

    @PostMapping("/capture-order/{orderId}")
    public Map<String, Object> captureOrder(@PathVariable String orderId) {
        return payPalService.captureOrder(orderId);
    }
}