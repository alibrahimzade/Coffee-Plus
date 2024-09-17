package az.atl.coffeshopp.mapper;

import az.atl.coffeshopp.dao.entity.Partner;
import az.atl.coffeshopp.model.dto.PartnerDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface PartnerMapper {

    PartnerDto fromEntityToDto(Partner partner);

    Partner fromDtoToEntity(PartnerDto partnerDto);

    List<PartnerDto> fromEntityListToDtoList(List<Partner> partners);
}
