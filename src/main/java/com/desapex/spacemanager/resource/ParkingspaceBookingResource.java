package com.desapex.spacemanager.resource;

import com.desapex.spacemanager.resource.dto.CreateParkingspaceBookingDto;
import com.desapex.spacemanager.service.IParkingspaceBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("parkingspace-booking")
public class ParkingspaceBookingResource {

    @Autowired
    private IParkingspaceBookingService parkingspaceBookingService;

    @PostMapping
    public Long createBooking(@RequestBody CreateParkingspaceBookingDto dto) {
        return parkingspaceBookingService.createBooking(
                dto.employeeId,
                dto.parkingspaceId,
                dto.date,
                dto.startTime,
                dto.endTime,
                dto.userName
        );
    }

}
