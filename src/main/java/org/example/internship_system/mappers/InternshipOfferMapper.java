package org.example.internship_system.mappers;

import org.example.internship_system.dtos.request.InternshipOfferRequest;
import org.example.internship_system.dtos.response.InternshipOfferResponse;
import org.example.internship_system.entity.InternshipOffer;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class InternshipOfferMapper {

    private ModelMapper modelMapper;

    public InternshipOfferMapper(ModelMapper modelMapper){
        this.modelMapper =modelMapper;
    }
    public InternshipOffer toEntity(InternshipOfferRequest request){
        return modelMapper.map(request, InternshipOffer.class);
    }
    public InternshipOfferResponse toDto(InternshipOffer internshipOffer){
        return  modelMapper.map(internshipOffer, InternshipOfferResponse.class);
    }
}
