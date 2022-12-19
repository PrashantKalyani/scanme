package com.desapex.spacemanager.resource.transformer;

import com.desapex.spacemanager.domain.Office;
import com.desapex.spacemanager.resource.dto.OfficeDto;
import org.springframework.stereotype.Component;

@Component
public class OfficeDtoTransformer {

    public OfficeDto transform(Office office) {
        OfficeDto dto = new OfficeDto();
        dto.id = office.id;
        dto.name = office.name;
        return dto;
    }

}
