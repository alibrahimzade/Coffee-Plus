package az.atl.coffeshopp.dao.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "partners")
public class Partner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;
    String phoneNumber;
    @OneToMany(mappedBy = "partners",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    List<Feature> features;
    String workingHours;


    String location;
    Double latitude;
    Double longitude;


}
