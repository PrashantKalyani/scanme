package com.desapex.spacemanager.resource;

import com.desapex.spacemanager.resource.dto.OfficeDto;
import com.desapex.spacemanager.resource.transformer.OfficeDtoTransformer;
import com.desapex.spacemanager.service.IOfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("office")
public class OfficeResource {

    @Autowired
    private IOfficeService officeService;

    @Autowired
    private OfficeDtoTransformer officeDtoTransformer;

    @GetMapping
    public List<OfficeDto> getOffices(@RequestParam(name = "organisationId",  required = false) Long organisationId) {
        return officeService.getOffices(organisationId)
                .stream()
                .map(office -> officeDtoTransformer.transform(office))
                .collect(Collectors.toList());
    }

}
