package az.atl.coffeshopp.service;

import az.atl.coffeshopp.dao.entity.Feature;
import az.atl.coffeshopp.dao.entity.Partner;
import az.atl.coffeshopp.dao.repository.FeatureRepository;
import az.atl.coffeshopp.dao.repository.PartnerRepository;
import az.atl.coffeshopp.exception.FeatureAlreadyExist;
import az.atl.coffeshopp.exception.NoSuchFeatureException;
import az.atl.coffeshopp.exception.NoSuchPartnerException;
import az.atl.coffeshopp.mapper.FeatureMapper;
import az.atl.coffeshopp.model.dto.FeatureDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

import static az.atl.coffeshopp.model.constant.CoffeeShopsConstant.*;
@Service
@RequiredArgsConstructor
@Slf4j
public class FeatureService {
    private final FeatureRepository featureRepository;
    private final FeatureMapper featureMapper;
    private final PartnerRepository partnerRepository;

    public FeatureDto findFeatureById(Long id){
        Feature feature = featureRepository.findById(id).orElseGet(null);
        if (Objects.nonNull(feature)){
            return featureMapper.fromEntityToDto(feature);
        }else {
            throw new NoSuchFeatureException(NO_SUCH_FEATURE.getValue());
        }
    }

    public List<FeatureDto> findAllFeatures(){
        List<Feature> all = featureRepository.findAll();
        return featureMapper.fromEntityListToDtoList(all);
    }

    public void createFeature(FeatureDto featureDto){
        Feature featureName = featureRepository.getFeatureByName(
                featureDto.getName()).orElseGet(() -> null);
        if (Objects.isNull(featureName)){
            Partner partner = partnerRepository.findById(featureDto.getPartnerId()).orElseGet(() -> null);
            if (Objects.nonNull(partner)){
                Feature feature = featureMapper.fromDtoToEntity(featureDto);
                featureRepository.save(feature);
            }else {
                throw new NoSuchPartnerException(NO_SUCH_PARTNER.getValue());
            }
        } else {
            throw new FeatureAlreadyExist(FEATURE_ALREADY_EXIST.getValue());
        }
    }

    public void updateFeature(Long featureId,FeatureDto featureDto){
        Feature feature = featureRepository.findById(featureId).orElseGet(null);
        if (Objects.nonNull(feature)){
            Partner partner = partnerRepository.findById(featureDto.getPartnerId()).orElseGet(() -> null);
            if (Objects.nonNull(partner)){
                Feature feature1 = featureMapper.fromDtoToEntity(featureDto);
                feature1.setName(feature1.getName());
                featureMapper.fromEntityToDto(featureRepository.save(feature1));
                log.info("Feature info updated {}",feature1);
            }else throw new NoSuchPartnerException(NO_SUCH_PARTNER.getValue());
        }else throw new NoSuchFeatureException(NO_SUCH_FEATURE.getValue());
    }

    public void deleteFeatureById(Long id){
        featureRepository.findById(id).orElseThrow(
                ()-> new NoSuchFeatureException(NO_SUCH_FEATURE.getValue()));
        featureRepository.deleteById(id);
        log.info("Feature deleted successfully");
    }

    public void deleteAllFeatures(){
        featureRepository.deleteAll();
        log.info("All features deleted");
    }
}
