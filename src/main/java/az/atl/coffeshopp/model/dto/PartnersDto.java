package az.atl.coffeshopp.model.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PartnersDto {
    Long id;
    String name;
    String phoneNumber;
    String workingHours;
    String location;
    Double latitude;
    Double longitude;
}
