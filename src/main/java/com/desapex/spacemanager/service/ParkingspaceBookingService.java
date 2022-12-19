package com.desapex.spacemanager.service;

import com.desapex.spacemanager.domain.ParkingspaceBooking;
import com.desapex.spacemanager.domain.Employee;
import com.desapex.spacemanager.domain.Parkingspace;
import com.desapex.spacemanager.repository.ParkingspaceBookingRepository;
import com.desapex.spacemanager.repository.EmployeeRepository;
import com.desapex.spacemanager.repository.ParkingspaceRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.LocalTime;

@Service
@Transactional
public class ParkingspaceBookingService implements IParkingspaceBookingService {

    @Autowired
    private ParkingspaceBookingRepository bookingRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ParkingspaceRepository parkingspaceRepository;

    @Override
    public Long createBooking(Long employeeId, Long parkingspaceId, LocalDate date, LocalTime startTime, LocalTime endTime) {
        LocalTime startOfDay = LocalTime.of(9, 0);
        LocalTime endOfDay = LocalTime.of(6, 0);
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new RuntimeException("Invalid employee"));
        Parkingspace parkingspace = parkingspaceRepository.findById(parkingspaceId).orElseThrow(() -> new RuntimeException("Invalid parkingspace"));
        ParkingspaceBooking booking = new ParkingspaceBooking();
        booking.employee = employee;
        booking.parkingspace = parkingspace;
        booking.date = date;
        booking.startTime = startTime == null ? startOfDay : startTime;
        booking.endTime = endTime == null ? endOfDay : endTime;
        ParkingspaceBooking savedBooking = bookingRepository.save(booking);
        return savedBooking.id;
    }

}
