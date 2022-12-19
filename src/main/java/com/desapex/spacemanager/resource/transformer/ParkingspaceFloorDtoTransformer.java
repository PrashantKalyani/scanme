package com.desapex.spacemanager.resource.transformer;

import com.desapex.spacemanager.domain.ParkingspaceFloor;
import com.desapex.spacemanager.resource.dto.ParkingspaceFloorDto;
import org.springframework.stereotype.Component;

@Component
public class ParkingspaceFloorDtoTransformer {

    public ParkingspaceFloorDto transform(ParkingspaceFloor parkingspaceFloor) {
        ParkingspaceFloorDto dto = new ParkingspaceFloorDto();
        dto.id = parkingspaceFloor.id;
        dto.name = parkingspaceFloor.name;
        dto.officeid = parkingspaceFloor.office.id;
        return dto;
    }

}
