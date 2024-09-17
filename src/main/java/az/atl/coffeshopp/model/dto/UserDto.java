package az.atl.coffeshopp.model.dto;


import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserDto {

    Long id;
    String name;
    String surname;
    String phoneNumber;
    String password;
    Double balance;
    String partnership;
    LocalDateTime createdDate;

    Double latitude;
    Double longitude;
}
