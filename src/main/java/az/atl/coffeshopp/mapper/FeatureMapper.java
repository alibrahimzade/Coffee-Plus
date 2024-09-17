package az.atl.coffeshopp.mapper;

import az.atl.coffeshopp.dao.entity.Feature;
import az.atl.coffeshopp.dao.entity.Partner;
import az.atl.coffeshopp.model.dto.FeatureDto;
import az.atl.coffeshopp.model.dto.PartnerDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface FeatureMapper {
    FeatureDto fromEntityToDto(Feature feature);

    Feature fromDtoToEntity(FeatureDto featureDto);

    List<FeatureDto> fromEntityListToDtoList(List<Feature> features);
}
