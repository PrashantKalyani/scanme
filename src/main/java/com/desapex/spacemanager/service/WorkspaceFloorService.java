package com.desapex.spacemanager.service;

import com.desapex.spacemanager.domain.WorkspaceFloor;
import com.desapex.spacemanager.repository.WorkspaceFloorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class WorkspaceFloorService implements IWorkspaceFloorService {

    @Autowired
    private WorkspaceFloorRepository floorRepository;

    @Override
    public List<WorkspaceFloor> getFloors(Long officeId) {
        return floorRepository.findAll()
                .stream()
                .filter(floor -> Objects.equals(floor.office.id, officeId))
                .collect(Collectors.toList());
    }

}
