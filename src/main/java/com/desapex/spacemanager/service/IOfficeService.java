package com.desapex.spacemanager.service;

import com.desapex.spacemanager.domain.Office;
import java.util.List;

public interface IOfficeService {

    public List<Office> getOffices(Long organisationId);

}
