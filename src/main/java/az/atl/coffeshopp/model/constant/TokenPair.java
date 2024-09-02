package az.atl.coffeshopp.model.constant;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TokenPair implements Serializable {
    public static final Long serialVersionUID = 1L;

    private String accessToken;
    private String refreshToken;

}
