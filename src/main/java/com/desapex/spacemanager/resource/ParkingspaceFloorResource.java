package com.desapex.spacemanager.resource;

import com.desapex.spacemanager.resource.dto.ParkingspaceFloorDto;
import com.desapex.spacemanager.resource.transformer.ParkingspaceFloorDtoTransformer;
import com.desapex.spacemanager.service.IParkingspaceFloorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("parkingspace-floor")
public class ParkingspaceFloorResource {

    @Autowired
    private IParkingspaceFloorService parkingspace_floorService;

    @Autowired
    private ParkingspaceFloorDtoTransformer floorDtoTransformer;

    @GetMapping
    public List<ParkingspaceFloorDto> getParkingspaceFloors(@RequestParam(name = "officeId") Long officeId) {
        return parkingspace_floorService.getFloors(officeId)
                .stream()
                .map(floor -> floorDtoTransformer.transform(floor))
                .collect(Collectors.toList());
    }

}
