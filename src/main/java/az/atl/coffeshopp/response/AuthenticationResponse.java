package az.atl.coffeshopp.response;

import az.atl.coffeshopp.model.constant.TokenPair;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthenticationResponse {
    Long userId;
    TokenPair tokenPair;

}
