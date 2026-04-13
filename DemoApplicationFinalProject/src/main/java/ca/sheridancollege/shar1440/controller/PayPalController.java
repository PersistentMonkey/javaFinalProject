package ca.sheridancollege.shar1440.controller;

import ca.sheridancollege.shar1440.services.PayPalService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/paypal")
@CrossOrigin(origins = "*")
public class PayPalController {

    private final PayPalService payPalService;

    public PayPalController(PayPalService payPalService) {
        this.payPalService = payPalService;
    }
    
    @GetMapping("/")
    public String home() {
        return "index"; // loads templates/index.html
    }

    @PostMapping("/create-order")
    public Map<String, Object> createOrder() {
        return payPalService.createOrder();
    }

    @PostMapping("/capture-order/{orderId}")
    public Map<String, Object> captureOrder(@PathVariable String orderId) {
        return payPalService.captureOrder(orderId);
    }

    @GetMapping("/test")
    public String testPayPalController() {
        return "PayPal Controller is working.";
    }
}