package com.desapex.spacemanager.service;

import com.desapex.spacemanager.domain.WorkspaceBooking;
import com.desapex.spacemanager.domain.Employee;
import com.desapex.spacemanager.domain.Workspace;
import com.desapex.spacemanager.repository.WorkspaceBookingRepository;
import com.desapex.spacemanager.repository.EmployeeRepository;
import com.desapex.spacemanager.repository.WorkspaceRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Service
@Transactional
public class WorkspaceBookingService implements IWorkspaceBookingService {

    @Autowired
    private WorkspaceBookingRepository bookingRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private WorkspaceRepository workspaceRepository;

    @Override
    public Long createBooking(Long employeeId, Long workspaceId, LocalDate date, LocalTime startTime, LocalTime endTime) {
        LocalDateTime start = LocalDateTime.of(date, startTime);
        LocalDateTime end = LocalDateTime.of(date, endTime);
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new RuntimeException("Invalid employee"));
        Workspace workspace = workspaceRepository.findById(workspaceId).orElseThrow(() -> new RuntimeException("Invalid workspace"));
        WorkspaceBooking booking = new WorkspaceBooking();
        booking.employee = employee;
        booking.workspace = workspace;
        booking.startTime = start;
        booking.endTime = end;
        WorkspaceBooking savedBooking = bookingRepository.save(booking);
        return savedBooking.id;
    }

}
