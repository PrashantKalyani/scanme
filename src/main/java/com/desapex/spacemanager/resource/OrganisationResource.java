package com.desapex.spacemanager.resource;

import com.desapex.spacemanager.resource.dto.OrganisationDto;
import com.desapex.spacemanager.resource.transformer.OrganisationDtoTransformer;
import com.desapex.spacemanager.service.IOrganisationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("organisation")
public class OrganisationResource {

    @Autowired
    private IOrganisationService organisationService;

    @Autowired
    private OrganisationDtoTransformer organisationDtoTransformer;

    @GetMapping
    public List<OrganisationDto> getOrganisations() {
        return organisationService.getOrganisations()
                .stream()
                .map(organisation -> organisationDtoTransformer.transform(organisation))
                .collect(Collectors.toList());
    }

}
