package az.atl.coffeshopp.dao.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Payment {
    String cardNumber;
    String expirationDate;
    String cvvCode;
    double balance;

    public boolean deductAmount(double amount){
        if (balance >= amount){
            balance = balance - amount;
            return true;
        } else {
            return false;
        }
    }
}
