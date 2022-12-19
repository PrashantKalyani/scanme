package com.desapex.spacemanager.resource;


import com.desapex.spacemanager.domain.ParkingspaceType;

import com.desapex.spacemanager.resource.dto.ParkingspaceDto;
import com.desapex.spacemanager.resource.transformer.ParkingspaceDtoTransformer;
import com.desapex.spacemanager.service.IParkingspaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("parkingspace")
public class ParkingspaceResource {
    @Autowired
    private IParkingspaceService parkingspaceService;

    @Autowired
    private ParkingspaceDtoTransformer parkingspaceDtoTransformer;

    @GetMapping
    public List<ParkingspaceDto> getParkingspaces(
            @RequestParam(name = "officeId", required = false) Long officeId,
            @RequestParam(name = "parkingspaceFloorId", required = false) Long parkingspaceFloorId,
            @RequestParam(name = "parkingspaceType", required = false) ParkingspaceType parkingspaceType,
            @RequestParam(name = "date", required = false) LocalDate date,
            @RequestParam(name = "startTime", required = false) LocalTime startTime,
            @RequestParam(name = "endTime", required = false) LocalTime endTime
    ) {
        return parkingspaceService.getParkingspaces(officeId, parkingspaceFloorId, parkingspaceType, date, startTime, endTime)
                .stream()
                .map(parkingspace -> parkingspaceDtoTransformer.transform(parkingspace))
                .collect(Collectors.toList());
    }

}