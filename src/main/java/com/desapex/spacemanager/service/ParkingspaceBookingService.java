package com.desapex.spacemanager.service;

import com.desapex.spacemanager.domain.ParkingspaceBooking;
import com.desapex.spacemanager.domain.Employee;
import com.desapex.spacemanager.domain.Parkingspace;
import com.desapex.spacemanager.repository.ParkingspaceBookingRepository;
import com.desapex.spacemanager.repository.EmployeeRepository;
import com.desapex.spacemanager.repository.ParkingspaceRepository;
import jakarta.mail.MessagingException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Service
@Transactional
public class ParkingspaceBookingService implements IParkingspaceBookingService {

    @Autowired
    private ParkingspaceBookingRepository bookingRepository;

    @Autowired
    private EmailService emailService;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ParkingspaceRepository parkingspaceRepository;

    @Override
    public Long createBooking(Long employeeId, Long parkingspaceId, LocalDate date, LocalTime startTime, LocalTime endTime,String userName) {
        if (startTime.equals(endTime)) {
            throw new RuntimeException("Error while booking the parking space. Start time is equal to end time");
        }
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new RuntimeException("Invalid employee"));
        Parkingspace parkingspace = parkingspaceRepository.findById(parkingspaceId).orElseThrow(() -> new RuntimeException("Invalid parkingspace"));
        ParkingspaceBooking booking = new ParkingspaceBooking();
        booking.employee = employee;
        booking.parkingspace = parkingspace;
        booking.date = date;
        booking.startTime = startTime;
        booking.endTime = endTime.minusMinutes(1);
        ParkingspaceBooking savedBooking = bookingRepository.save(booking);

        // send email with invitation
        String subject = "Workspace Booking Confirmation";
        String message = "Thank you for booking a workspace with us!<br><br>"
                + "Booking details:<br>"
                + "Date: <b>" + date.format(DateTimeFormatter.ofPattern("dd MMM yyyy")) + "</b><br>"
                + "From: <b>" + startTime.format(DateTimeFormatter.ofPattern("hh:mm a")) + "</b><br>"
                + "To: <b>" + endTime.format(DateTimeFormatter.ofPattern("hh:mm a")) + "</b><br><br>"
                + "Regards,<br>"
                + "Desapex";
        LocalDateTime startDateTime = LocalDateTime.of(date, startTime);
        LocalDateTime endDateTime = LocalDateTime.of(date, endTime);
        try {
            System.out.println("Sending email to: " + userName);
            emailService.sendInvitation(userName, subject, message, startDateTime, endDateTime);
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return savedBooking.id;
    }

}
