package com.desapex.spacemanager.service;

import com.desapex.spacemanager.domain.Department;
import com.desapex.spacemanager.domain.WorkspaceBooking;
import com.desapex.spacemanager.domain.Employee;
import com.desapex.spacemanager.domain.Workspace;
import com.desapex.spacemanager.repository.DepartmentRepository;
import com.desapex.spacemanager.repository.WorkspaceBookingRepository;
import com.desapex.spacemanager.repository.EmployeeRepository;
import com.desapex.spacemanager.repository.WorkspaceRepository;
import jakarta.mail.MessagingException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class WorkspaceBookingService implements IWorkspaceBookingService {

    @Autowired
    private WorkspaceBookingRepository bookingRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private WorkspaceRepository workspaceRepository;

    @Autowired
    private EmailService emailService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DepartmentRepository departmentRepository;


    @Override
    public Long createBooking(Long employeeId, Long workspaceId, LocalDate startdate, LocalDate enddate, LocalTime startTime, LocalTime endTime, String userName) {
        if (startTime.equals(endTime)) {
            throw new RuntimeException("Error while booking the parking space. Start time is equal to end time");
        }

        // Retrieve employee and department information
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Invalid employee"));
        Long departmentId = employee.getDepartment().getId();
        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new RuntimeException("Invalid department"));

        // Retrieve workspace information
        Workspace workspace = workspaceRepository.findById(workspaceId)
                .orElseThrow(() -> new RuntimeException("Invalid workspace"));
        String workspaceType = String.valueOf(workspace.getType());

        // Subtract credits from start and end time if the workspace is a meeting room
        Long creditValue = department.getCreditValue();
        if (workspaceType.equals("MEETING_ROOM")) {
            LocalDateTime start = LocalDateTime.of(startdate, startTime);
            LocalDateTime end = LocalDateTime.of(enddate, endTime).minusMinutes(1);

            Duration duration = Duration.between(start, end); // calculate duration
            long durationInMinutes = duration.toHours(); // get duration in minutes

            creditValue -= durationInMinutes; // subtract duration from credit value
        }

        // Create new booking
        WorkspaceBooking booking = new WorkspaceBooking();
        booking.employee = employee;
        booking.workspace = workspace;
        booking.startTime = LocalDateTime.of(startdate, startTime);
        booking.endTime = LocalDateTime.of(enddate, endTime).minusMinutes(1);
        booking.type = "Booked";
        WorkspaceBooking savedBooking = bookingRepository.save(booking);

        // Update department credit value in the database if the workspace is a meeting room
        if (workspaceType.equals("MEETING_ROOM")) {
            department.setCreditValue(creditValue);
            departmentRepository.save(department);
        }

        // Send booking confirmation email
        String subject = "Workspace Booking Confirmation";
        String message = "Thank you for booking a workspace with us!<br><br>"
                + "Booking details:<br>"
                + "ID: <b>" + savedBooking.id + "</b><br>"
                + "Date: <b>" + startdate.format(DateTimeFormatter.ofPattern("dd MMM yyyy")) + "</b><br>"
                + "From: <b>" + startTime.format(DateTimeFormatter.ofPattern("hh:mm a")) + "</b><br>"
                + "To: <b>" + endTime.format(DateTimeFormatter.ofPattern("hh:mm a")) + "</b><br><br>"
                + "Regards,<br>"
                + "Desapex";
        LocalDateTime startDateTime = LocalDateTime.of(startdate, startTime).minusHours(5).minusMinutes(30);
        LocalDateTime endDateTime = LocalDateTime.of(enddate, endTime).minusHours(5).minusMinutes(30);
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

    @Override
    public List<WorkspaceBooking> getAllBookings() {
        return null;
    }

}