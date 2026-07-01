package org.example.internship_system.service;

import org.example.internship_system.dtos.request.InternshipOfferRequest;
import org.example.internship_system.dtos.response.InternshipOfferResponse;
import org.example.internship_system.entity.Company;
import org.example.internship_system.entity.InternshipOffer;
import org.example.internship_system.entity.enums.OfferStatus;
import org.example.internship_system.exception.ResourceNotFoundException;
import org.example.internship_system.repository.CompanyRepository;
import org.example.internship_system.repository.InternshipOfferRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InternshipOfferService {

    private final InternshipOfferRepository internshipOfferRepository;
    private final CompanyRepository companyRepository;

    public InternshipOfferService(InternshipOfferRepository internshipOfferRepository,
                                  CompanyRepository companyRepository) {
        this.internshipOfferRepository = internshipOfferRepository;
        this.companyRepository = companyRepository;
    }

    public InternshipOfferResponse create(InternshipOfferRequest request) {
        Company company = companyRepository.findById(request.getCompanyId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Company not found: " + request.getCompanyId()));

        InternshipOffer offer = new InternshipOffer();
        offer.setTitle(request.getTitle());
        offer.setDescription(request.getDescription());
        offer.setRequiredSkills(request.getRequiredSkills());
        offer.setLocation(request.getLocation());
        offer.setType(request.getType());
        offer.setDeadline(request.getDeadline());
        offer.setStatus(OfferStatus.ACTIVE);
        offer.setCompany(company);

        InternshipOffer saved = internshipOfferRepository.save(offer);
        return toResponse(saved);
    }

    public List<InternshipOfferResponse> getAll() {
        List<InternshipOfferResponse> result = new ArrayList<>();
        for (InternshipOffer offer : internshipOfferRepository.findAll()) {
            result.add(toResponse(offer));
        }
        return result;
    }

    public InternshipOfferResponse getById(Long id) {
        InternshipOffer offer = internshipOfferRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Internship offer not found: " + id));
        return toResponse(offer);
    }

    public List<InternshipOfferResponse> getByCompany(Long companyId) {
        Company company = companyRepository.findById(companyId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Company not found: " + companyId));
        List<InternshipOfferResponse> result = new ArrayList<>();
        for (InternshipOffer offer : internshipOfferRepository.findByCompany(company)) {
            result.add(toResponse(offer));
        }
        return result;
    }

    public InternshipOfferResponse update(Long id, InternshipOfferRequest request) {
        InternshipOffer offer = internshipOfferRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Internship offer not found: " + id));

        offer.setTitle(request.getTitle());
        offer.setDescription(request.getDescription());
        offer.setRequiredSkills(request.getRequiredSkills());
        offer.setLocation(request.getLocation());
        offer.setType(request.getType());
        offer.setDeadline(request.getDeadline());

        InternshipOffer saved = internshipOfferRepository.save(offer);
        return toResponse(saved);
    }

    public void delete(Long id) {
        if (!internshipOfferRepository.existsById(id)) {
            throw new ResourceNotFoundException("Internship offer not found: " + id);
        }
        internshipOfferRepository.deleteById(id);
    }

    private InternshipOfferResponse toResponse(InternshipOffer offer) {
        InternshipOfferResponse response = new InternshipOfferResponse();
        response.setId(offer.getId());
        response.setTitle(offer.getTitle());
        response.setDescription(offer.getDescription());
        response.setRequiredSkills(offer.getRequiredSkills());
        response.setLocation(offer.getLocation());
        response.setType(offer.getType());
        response.setDeadline(offer.getDeadline());
        response.setStatus(offer.getStatus());
        if (offer.getCompany() != null) {
            response.setCompanyId(offer.getCompany().getId());
            response.setCompanyName(offer.getCompany().getName());
        }
        return response;
    }
}
