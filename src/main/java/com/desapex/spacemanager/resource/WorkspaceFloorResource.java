package com.desapex.spacemanager.resource;

import com.desapex.spacemanager.resource.dto.WorkspaceFloorDto;
import com.desapex.spacemanager.resource.transformer.WorkspaceFloorDtoTransformer;
import com.desapex.spacemanager.service.IWorkspaceFloorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("workspace-floor")
public class WorkspaceFloorResource {

    @Autowired
    private IWorkspaceFloorService workspace_floorService;

    @Autowired
    private WorkspaceFloorDtoTransformer floorDtoTransformer;

    @GetMapping
    public List<WorkspaceFloorDto> getWorkspaceFloors(@RequestParam(name = "officeId") Long officeId) {
        return workspace_floorService.getFloors(officeId)
                .stream()
                .map(floor -> floorDtoTransformer.transform(floor))
                .collect(Collectors.toList());
    }

}
