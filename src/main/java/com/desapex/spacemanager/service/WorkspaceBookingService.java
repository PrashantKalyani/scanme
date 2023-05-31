//package com.desapex.spacemanager.service;
//
//import com.desapex.spacemanager.domain.Department;
//import com.desapex.spacemanager.domain.WorkspaceBooking;
//import com.desapex.spacemanager.domain.Employee;
//import com.desapex.spacemanager.domain.Workspace;
//import com.desapex.spacemanager.repository.DepartmentRepository;
//import com.desapex.spacemanager.repository.WorkspaceBookingRepository;
//import com.desapex.spacemanager.repository.EmployeeRepository;
//import com.desapex.spacemanager.repository.WorkspaceRepository;
//import jakarta.mail.MessagingException;
//import jakarta.transaction.Transactional;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Service;
//
//import java.time.Duration;
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.time.LocalTime;
//import java.time.format.DateTimeFormatter;
//import java.time.temporal.ChronoUnit;
//import java.util.List;
//import java.util.Map;
//
//@Service
//@Transactional
//public class WorkspaceBookingService implements IWorkspaceBookingService {
//
//    @Autowired
//    private WorkspaceBookingRepository bookingRepository;
//
//    @Autowired
//    private EmployeeRepository employeeRepository;
//
//    @Autowired
//    private WorkspaceRepository workspaceRepository;
//
//    @Autowired
//    private EmailService emailService;
//
//    @Autowired
//    private EmployeeService employeeService;
//
//    @Autowired
//    private DepartmentRepository departmentRepository;
//
//
//    @Override
//    public Long createBooking(Long employeeId, Long workspaceId, LocalDate startdate, LocalDate enddate, LocalTime startTime, LocalTime endTime, String userName) {
//        if (startTime.equals(endTime)) {
//            throw new RuntimeException("Error while booking the parking space. Start time is equal to end time");
//        }
//
//        // Retrieve employee and department information
//        Employee employee = employeeRepository.findById(employeeId)
//                .orElseThrow(() -> new RuntimeException("Invalid employee"));
//        Long departmentId = employee.getDepartment().getId();
//        Department department = departmentRepository.findById(departmentId)
//                .orElseThrow(() -> new RuntimeException("Invalid department"));
//
//        // Retrieve workspace information
//        Workspace workspace = workspaceRepository.findById(workspaceId)
//                .orElseThrow(() -> new RuntimeException("Invalid workspace"));
//        String workspaceType = String.valueOf(workspace.getType());
//
//        // Subtract credits from start and end time if the workspace is a meeting room
//        Long creditValue = department.getCreditValue();
//        if (workspaceType.equals("MEETING_ROOM")) {
//            LocalDateTime start = LocalDateTime.of(startdate, startTime);
//            LocalDateTime end = LocalDateTime.of(enddate, endTime).minusMinutes(1);
//
//            Duration duration = Duration.between(start, end); // calculate duration
//            long durationInMinutes = duration.toHours(); // get duration in minutes
//
//            creditValue -= durationInMinutes; // subtract duration from credit value
//        }
//
//        // Create new booking
//        WorkspaceBooking booking = new WorkspaceBooking();
//        booking.employee = employee;
//        booking.workspace = workspace;
//        booking.bookingTime = LocalDateTime.now(); // Set the current booking time
//        booking.startTime = LocalDateTime.of(startdate, startTime);
//        booking.endTime = LocalDateTime.of(enddate, endTime).minusMinutes(1);
//        booking.type = "Booked";
//        WorkspaceBooking savedBooking = bookingRepository.save(booking);
//
//        // Update department credit value in the database if the workspace is a meeting room
//        if (workspaceType.equals("MEETING_ROOM")) {
//            department.setCreditValue(creditValue);
//            departmentRepository.save(department);
//        }
//
//        // Send booking confirmation email
//        String subject = "Workspace Booking Confirmation";
//        String message = "Thank you for booking a workspace with us!<br><br>"
//                + "Booking details:<br>"
//                + "ID: <b>" + savedBooking.id + "</b><br>"
//                + "Date: <b>" + startdate.format(DateTimeFormatter.ofPattern("dd MMM yyyy")) + "</b><br>"
//                + "From: <b>" + startTime.format(DateTimeFormatter.ofPattern("hh:mm a")) + "</b><br>"
//                + "To: <b>" + endTime.format(DateTimeFormatter.ofPattern("hh:mm a")) + "</b><br><br>"
//                + "Regards,<br>"
//                + "Desapex";
//        LocalDateTime startDateTime = LocalDateTime.of(startdate, startTime).minusHours(5).minusMinutes(30);
//        LocalDateTime endDateTime = LocalDateTime.of(enddate, endTime).minusHours(5).minusMinutes(30);
//        try {
//            System.out.println("Sending email to: " + userName);
//            emailService.sendInvitation(userName, subject, message, startDateTime, endDateTime);
//        } catch (MessagingException e) {
//            e.printStackTrace();
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//
//        return savedBooking.id;
//    }
//
//    @Override
//    public List<WorkspaceBooking> getAllBookings() {
//        return bookingRepository.findAll();
//    }
//
//    public void changeBookingTypeToCheckIn(Long bookingId) {
//        WorkspaceBooking booking = bookingRepository.findById(bookingId)
//                .orElseThrow(() -> new RuntimeException("Invalid booking"));
//
//        if (!booking.getType().equalsIgnoreCase("Booked")) {
//            throw new RuntimeException("Invalid booking type. Cannot change to Check In.");
//        }
//
//        booking.setType("Check In");
//        bookingRepository.save(booking);
//    }
//
//    public void changeBookingTypeToCancelled(Long bookingId) {
//        WorkspaceBooking booking = bookingRepository.findById(bookingId)
//                .orElseThrow(() -> new RuntimeException("Invalid booking"));
//
//        if (!booking.getType().equalsIgnoreCase("Booked")) {
//            throw new RuntimeException("Invalid booking type. Cannot change to Cancelled.");
//        }
//
//        booking.setType("Cancelled");
//        bookingRepository.save(booking);
//    }
//}

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
        import org.springframework.scheduling.annotation.Scheduled;
        import org.springframework.stereotype.Service;

        import java.time.Duration;
        import java.time.LocalDate;
        import java.time.LocalDateTime;
        import java.time.LocalTime;
        import java.time.format.DateTimeFormatter;
        import java.time.temporal.ChronoUnit;
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
            long durationInMinutes = duration.toMinutes(); // get duration in minutes

            creditValue -= durationInMinutes; // subtract duration from credit value
        }

        LocalDateTime currentDateTime = LocalDateTime.of(startdate, startTime);
        LocalDateTime endDateTime = LocalDateTime.of(enddate, endTime).minusMinutes(1);

        long numberOfDays = ChronoUnit.DAYS.between(startdate, enddate) + 1;

        WorkspaceBooking savedBooking = null;
        LocalDateTime consolidatedStartDateTime = null;
        LocalDateTime consolidatedEndDateTime = null;
        StringBuilder consolidatedMessage = new StringBuilder();
        int consecutiveDaysCount = 0;

        for (int i = 0; i < numberOfDays; i++) {
            LocalDateTime currentStartTime = currentDateTime;
            LocalDateTime currentEndTime = currentDateTime.withHour(endTime.getHour()).withMinute(endTime.getMinute()).withSecond(endTime.getSecond());

            // Create new booking for the current day
            WorkspaceBooking booking = new WorkspaceBooking();
            booking.setEmployee(employee);
            booking.setWorkspace(workspace);
            booking.bookingTime = LocalDateTime.now();
            booking.setStartTime(currentStartTime);
            booking.setEndTime(currentEndTime);
            booking.setType("Booked");
            savedBooking = bookingRepository.save(booking);

            // Update department credit value in the database if the workspace is a meeting room
            if (workspaceType.equals("MEETING_ROOM")) {
                department.setCreditValue(creditValue);
                departmentRepository.save(department);
            }

            // Track consecutive days and build consolidated message
            if (consolidatedStartDateTime == null) {
                // Start of consecutive days
                consolidatedStartDateTime = currentStartTime;
                consolidatedEndDateTime = currentEndTime;
            } else {
                // Check if the current day is consecutive
                LocalDateTime expectedNextDay = consolidatedEndDateTime.plusDays(1);
                if (currentStartTime.toLocalDate().equals(expectedNextDay.toLocalDate())) {
                    consolidatedEndDateTime = currentEndTime;
                } else {
                    // Non-consecutive day found, send the consolidated email
                    sendConsolidatedEmail(userName, consolidatedStartDateTime, consolidatedEndDateTime, consolidatedMessage.toString());

                    // Reset consolidated data for the next consecutive days
                    consolidatedStartDateTime = currentStartTime;
                    consolidatedEndDateTime = currentEndTime;
                    consolidatedMessage = new StringBuilder();
                    consecutiveDaysCount = 0;
                }
            }

            // Append booking details to the consolidated message
            String bookingDetails = getBookingDetails(savedBooking.getId(), currentStartTime, currentEndTime);
            consolidatedMessage.append(bookingDetails);

            // Send booking confirmation email for the last day if it's consecutive
            if (i == numberOfDays - 1 && consecutiveDaysCount > -1) {
                sendConsolidatedEmail(userName, consolidatedStartDateTime, consolidatedEndDateTime, consolidatedMessage.toString());
            }

            currentDateTime = currentDateTime.plusDays(1); // Move to the next day
            consecutiveDaysCount++;
        }

        return savedBooking.getId();
    }

    private String getBookingDetails(Long bookingId, LocalDateTime startDateTime, LocalDateTime endDateTime) {
        String details = "Booking details:<br>"
                + "ID: <b>" + bookingId + "</b><br>"
                + "Date: <b>" + startDateTime.toLocalDate().format(DateTimeFormatter.ofPattern("dd MMM yyyy")) + "</b><br>"
                + "From: <b>" + startDateTime.toLocalTime().format(DateTimeFormatter.ofPattern("hh:mm a")) + "</b><br>"
                + "To: <b>" + endDateTime.toLocalTime().format(DateTimeFormatter.ofPattern("hh:mm a")) + "</b><br><br>";
        return details;
    }

    private void sendConsolidatedEmail(String userName, LocalDateTime startDateTime, LocalDateTime endDateTime, String message) {
        String subject = "Workspace Booking Confirmation";
        LocalDateTime adjustedStartDateTime = startDateTime.minusHours(5).minusMinutes(30);
        LocalDateTime adjustedEndDateTime = endDateTime.minusHours(5).minusMinutes(30);
        try {
            System.out.println("Sending email to: " + userName);
            emailService.sendInvitation(userName, subject, message, adjustedStartDateTime, adjustedEndDateTime);
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<WorkspaceBooking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public void changeBookingTypeToCheckIn(Long bookingId) {
        WorkspaceBooking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Invalid booking"));

        if (!booking.getType().equalsIgnoreCase("Booked")) {
            throw new RuntimeException("Invalid booking type. Cannot change to Check In.");
        }

        booking.setType("Check In");
        bookingRepository.save(booking);
    }

    public void changeBookingTypeToCancelled(Long bookingId) {
        WorkspaceBooking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Invalid booking"));

        if (!booking.getType().equalsIgnoreCase("Booked")) {
            throw new RuntimeException("Invalid booking type. Cannot change to Cancelled.");
        }

        booking.setType("Cancelled");
        bookingRepository.save(booking);
    }

    @Scheduled(fixedRate = 15000) // 15 seconds
    public void monitorBookingStatus() {
        System.out.println("Running monitorBookingStatus...");
        List<WorkspaceBooking> bookings = bookingRepository.findAll();

        for (WorkspaceBooking booking : bookings) {
            if (booking.getType().equalsIgnoreCase("Check In")) {
                continue; // Skip already checked-in bookings
            }

            LocalDateTime currentDateTime = LocalDateTime.now();
            LocalDateTime bookingDateTime = booking.getStartTime();

            long minutesElapsed = Duration.between(bookingDateTime, currentDateTime).toMinutes();

            if (minutesElapsed >= 4) {
                booking.setType("Cancelled");
                bookingRepository.save(booking);
            }
        }
    }

    public boolean toggleBookingStatus(Long bookingId) {
        WorkspaceBooking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Invalid booking"));

        LocalDateTime currentDateTime = LocalDateTime.now();
        LocalDateTime bookingDateTime = booking.getStartTime();
        long minutesElapsed = Duration.between(bookingDateTime, currentDateTime).toMinutes();

        if (booking.getType().equalsIgnoreCase("Booked") && (minutesElapsed >= 4 || bookingDateTime.isAfter(currentDateTime))) {
            booking.setType("Cancelled");
            bookingRepository.save(booking);
            return true; // Booking status changed to Cancelled
        }

        return false; // Cannot change the booking status to Cancelled
    }
}