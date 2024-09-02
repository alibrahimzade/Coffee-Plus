package az.atl.coffeshopp.model.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FeaturesDto {
    Long id;
    String name;
    Long partnerId;
}
