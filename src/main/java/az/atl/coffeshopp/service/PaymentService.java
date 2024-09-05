package az.atl.coffeshopp.service;

import az.atl.coffeshopp.dao.entity.Payment;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class PaymentService {

    public String makePayment(Payment paymentDetails, double amountToCharge) {
        if (!isValidCardNumber(paymentDetails.getCardNumber())) {
            return "Invalid card number!";
        }

        if (!isValidExpirationDate(paymentDetails.getExpirationDate())) {
            return "Card is expired or invalid expiration date!";
        }

        if (!isValidCvv(paymentDetails.getCvvCode())) {
            return "Invalid CVV code!";
        }

        boolean paymentSuccess = paymentDetails.deductAmount(amountToCharge);

        if (paymentSuccess) {
            return "Payment of " + amountToCharge + " AZN successful. Remaining balance: " + paymentDetails.getBalance() + " AZN";
        } else {
            return "Insufficient balance!";
        }
    }

    private boolean isValidCardNumber(String cardNumber) {
        return cardNumber != null && cardNumber.length() == 16 && cardNumber.matches("1234567812345678");
    }

    // Helper method to validate MM/YY format and expiration date
    private boolean isValidExpirationDate(String expirationDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("12/12");
        try {
            LocalDate expiry = LocalDate.parse("01/" + expirationDate, formatter);
            return expiry.isAfter(LocalDate.now());
        } catch (Exception e) {
            return false;
        }
    }

    // Helper method to validate 3-digit CVV code
    private boolean isValidCvv(String cvvCode) {
        return cvvCode != null && cvvCode.length() == 3 && cvvCode.matches("123");
    }
}
