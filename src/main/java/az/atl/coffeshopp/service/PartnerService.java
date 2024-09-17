package az.atl.coffeshopp.service;

import az.atl.coffeshopp.dao.entity.Partner;
import az.atl.coffeshopp.dao.repository.PartnerRepository;
import az.atl.coffeshopp.exception.NoSuchPartnerException;
import az.atl.coffeshopp.exception.PartnerAlreadyExistException;
import az.atl.coffeshopp.mapper.PartnerMapper;
import az.atl.coffeshopp.model.dto.PartnerDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

import static az.atl.coffeshopp.model.constant.CoffeeShopsConstant.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class PartnerService {

    private final PartnerRepository partnerRepository;

    private final PartnerMapper partnerMapper;

    public PartnerDto findPartnerById(Long id){
        Partner partner = partnerRepository.findById(id).orElseGet(null);
        if (Objects.nonNull(partner)){
            return partnerMapper.fromEntityToDto(partner);
        }else {
            throw new NoSuchPartnerException(NO_SUCH_PARTNER.getValue());
        }
    }

    public List<PartnerDto> findAllPartners(){
        List<Partner> all = partnerRepository.findAll();
        return partnerMapper.fromEntityListToDtoList(all);
    }


    public void createPartner(PartnerDto partnerDto){
        Partner partnerName = partnerRepository.getPartnerByName(
                partnerDto.getName()).orElseGet(() -> null);

        if (Objects.isNull(partnerName)){
            Partner partner = partnerMapper.fromDtoToEntity(partnerDto);
            partnerRepository.save(partner);
            log.info("Partner created {}",partner);
        }else {
            throw new PartnerAlreadyExistException(PARTNER_ALREADY_EXIST.getValue());
        }
    }


    public void updatePartner(Long partnerId,PartnerDto partnerDto){ //TODO : Bunu mapstructer temasina baxmaq lazimdi ( update the correspondence )
        Partner partner = partnerRepository.findById(partnerId).orElse(null);
        if (Objects.nonNull(partner)){
            Partner partner1 = partnerMapper.fromDtoToEntity(partnerDto);
            partner1.setName(partner1.getName());
            partner1.setPhoneNumber(partner1.getPhoneNumber());
            partner1.setWorkingHours(partner1.getWorkingHours());
            partner1.setLocation(partner1.getLocation());
            partner1.setLatitude(partner1.getLatitude());
            partner1.setLongitude(partner1.getLongitude());
            partnerMapper.fromEntityToDto(partnerRepository.save(partner1));
            log.info("Partner info updated {}",partner1);
        } else {
            throw new NoSuchPartnerException(NO_SUCH_PARTNER.getValue());
        }
    }


    public void deletePartnerById(Long id){
        partnerRepository.findById(id).orElseThrow(
                () -> new NoSuchPartnerException(NO_SUCH_PARTNER.getValue())
        );
        partnerRepository.deleteById(id);
        log.info("Partner deleted successfully");
    }

    public void deleteAllPartners(){
        partnerRepository.deleteAll();
        log.info("All partners deleted");
    }
}
