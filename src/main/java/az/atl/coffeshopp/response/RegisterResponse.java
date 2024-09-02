package az.atl.coffeshopp.response;

import az.atl.coffeshopp.dao.entity.UserEntity;
import az.atl.coffeshopp.model.enums.Role;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RegisterResponse {
    String name;
    String surname;
    String phoneNumber;
    String password;
    Role role;

    public static RegisterResponse buildRegisterDto(UserEntity userEntity) {
        return RegisterResponse.builder()
                .phoneNumber(userEntity.getPhoneNumber())
                .name(userEntity.getName())
                .surname(userEntity.getSurname())
                .password(userEntity.getPassword())
                .role(userEntity.getRole())
                .build();
    }
}
