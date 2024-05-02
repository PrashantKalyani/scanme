package com.desapex.spacemanager.resource;

import com.desapex.spacemanager.service.ReferenceNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reference")
public class ReferenceNumberResource {

    private final ReferenceNumberService referenceNumberService;

    @Autowired
    public ReferenceNumberResource(ReferenceNumberService referenceNumberService) {
        this.referenceNumberService = referenceNumberService;
    }

    @GetMapping("/equipment/{equipmentName}")
    public Long getReferenceNumberByEquipmentName(@PathVariable String equipmentName) {
        return referenceNumberService.findReferenceNumberByEquipmentName(equipmentName);
    }
}
