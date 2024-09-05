package az.atl.coffeshopp.controller;

import az.atl.coffeshopp.dao.entity.Payment;
import az.atl.coffeshopp.service.PaymentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {
    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/makePayment")
    public String makePayment(
            @RequestParam String cardNumber,
            @RequestParam String expirationDate,
            @RequestParam String cvvCode,
            @RequestParam double amountToCharge
    ) {

        Payment paymentDetails = new Payment(cardNumber, expirationDate, cvvCode, 1000.0);

        // Process the payment
        return paymentService.makePayment(paymentDetails, amountToCharge);
    }
}
