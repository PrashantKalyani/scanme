package com.desapex.spacemanager.resource.dto;


import com.desapex.spacemanager.domain.Checklist;
import com.desapex.spacemanager.domain.Request;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ChecklistRequestDto {
    private Checklist checklist;
    private Request request;

}
