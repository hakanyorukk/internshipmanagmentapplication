package org.example.internship_system.controller;

import org.example.internship_system.dtos.request.InternshipOfferRequest;
import org.example.internship_system.dtos.response.InternshipOfferResponse;
import org.example.internship_system.service.InternshipOfferService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/internships")
public class InternshipController {

    private final InternshipOfferService internshipOfferService;

    public InternshipController(InternshipOfferService internshipOfferService) {
        this.internshipOfferService = internshipOfferService;
    }

    @PostMapping
    public InternshipOfferResponse create(@RequestBody InternshipOfferRequest request) {
        return internshipOfferService.create(request);
    }

    @GetMapping
    public List<InternshipOfferResponse> getAll(@RequestParam(required = false) Long companyId) {
        if (companyId != null) {
            return internshipOfferService.getByCompany(companyId);
        }
        return internshipOfferService.getAll();
    }

    @GetMapping("/{id}")
    public InternshipOfferResponse getById(@PathVariable Long id) {
        return internshipOfferService.getById(id);
    }

    @PutMapping("/{id}")
    public InternshipOfferResponse update(@PathVariable Long id,
                                          @RequestBody InternshipOfferRequest request) {
        return internshipOfferService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        internshipOfferService.delete(id);
    }
}