package com.desapex.spacemanager.service;

import com.desapex.spacemanager.domain.ParkingspaceFloor;
import com.desapex.spacemanager.repository.ParkingspaceFloorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ParkingspaceFloorService implements IParkingspaceFloorService {

    @Autowired
    private ParkingspaceFloorRepository floorRepository;

    @Override
    public List<ParkingspaceFloor> getFloors(Long officeId) {
        return floorRepository.findAll()
                .stream()
                .filter(floor -> Objects.equals(floor.office.id, officeId))
                .collect(Collectors.toList());
    }

}
