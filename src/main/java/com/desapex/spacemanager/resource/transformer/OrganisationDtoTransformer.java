package com.desapex.spacemanager.resource.transformer;

import com.desapex.spacemanager.domain.Organisation;
import com.desapex.spacemanager.resource.dto.OrganisationDto;
import org.springframework.stereotype.Component;

@Component
public class OrganisationDtoTransformer {

    public OrganisationDto transform(Organisation organisation) {
        OrganisationDto dto = new OrganisationDto();
        dto.id = organisation.id;
        dto.name = organisation.name;
        return dto;
    }

}
