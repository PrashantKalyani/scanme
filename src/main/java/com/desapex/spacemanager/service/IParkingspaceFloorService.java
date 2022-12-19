package com.desapex.spacemanager.service;

import com.desapex.spacemanager.domain.ParkingspaceFloor;
import java.util.List;

public interface IParkingspaceFloorService {

    public List<ParkingspaceFloor> getFloors(Long officeId);

}
