package com.desapex.spacemanager.resource;

import com.desapex.spacemanager.domain.WorkspaceBooking;
import com.desapex.spacemanager.resource.dto.CreateWorkspaceBookingDto;
import com.desapex.spacemanager.resource.dto.WorkspaceBookingDto;
import com.desapex.spacemanager.service.IWorkspaceBookingService;
import com.desapex.spacemanager.service.WorkspaceBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("workspace-booking")
public class WorkspaceBookingResource {

    @Autowired
    private IWorkspaceBookingService workspaceBookingService;

    @Autowired
    private WorkspaceBookingService bookingService;

    @PostMapping
    public Long createBooking(@RequestBody CreateWorkspaceBookingDto dto) {
        return workspaceBookingService.createBooking(
                dto.employeeId,
                dto.workspaceId,
                dto.startdate,
                dto.enddate,
                dto.startTime,
                dto.endTime,
                dto.userName
        );
    }

    @GetMapping
    public List<WorkspaceBookingDto> getAllBookings() {
        List<WorkspaceBooking> bookings = workspaceBookingService.getAllBookings();
        List<WorkspaceBookingDto> bookingDtos = new ArrayList<>();

        for (WorkspaceBooking booking : bookings) {
            WorkspaceBookingDto dto = new WorkspaceBookingDto();
            dto.id = booking.id;
            dto.workspace = booking.workspace.getName(); // Assuming a getName() method exists in the Workspace class
            dto.employee = booking.employee.getFirst_name();
            dto.lastemployee = booking.employee.getLast_name();
            dto.startTime = booking.startTime;
            dto.endTime = booking.endTime.plusMinutes(1); // Add one minute to the endTime
            dto.department = String.valueOf(booking.employee.getDepartment().getName());
            dto.workspaceType = String.valueOf(booking.workspace.getType());
            dto.employeeId = booking.employee.getId();
            dto.floorNumber = booking.workspace.getFloor().getId();
            dto.bookingTime = booking.bookingTime;
            bookingDtos.add(dto);
        }

        return bookingDtos;
    }

    @PostMapping("/{bookingId}/toggle")
    public ResponseEntity<String> toggleBookingType(@PathVariable Long bookingId, @RequestParam String targetType) {
        try {
            if (targetType.equalsIgnoreCase("checkin")) {
                bookingService.changeBookingTypeToCheckIn(bookingId);
                return ResponseEntity.ok("Booking type changed to Check In successfully.");
            } else if (targetType.equalsIgnoreCase("cancelled")) {
                bookingService.changeBookingTypeToCancelled(bookingId);
                return ResponseEntity.ok("Booking type changed to Cancelled successfully.");
            } else {
                return ResponseEntity.badRequest().body("Invalid target type specified.");
            }
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to toggle booking type: " + e.getMessage());
        }
    }
}