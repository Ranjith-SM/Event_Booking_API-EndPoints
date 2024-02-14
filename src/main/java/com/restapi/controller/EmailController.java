package com.restapi.controller;

import com.restapi.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping(value = "/sendEmail",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String sendEmail(@RequestParam("email") String email,
//                            @RequestParam("name") String EventName,
//                            @RequestParam("date") String EventDate)
                            @RequestParam("pdfFile") MultipartFile pdf )
    {
        String toEmail = email;
        System.out.println(toEmail);
        String subject = "Event Booking Confirmed";
        String messagebody = "Event has been booked, Please Schedule other Work carefully.\n ";
//                "Event Booked :"+EventName +"\n" +
//                "Event Date :"+EventDate;

        try {
            // Attach PDF file to the email
            byte[] pdfBytes = pdf.getBytes();
            emailService.sendEmailWithAttachment(toEmail, subject, messagebody, pdfBytes, "event_receipt.pdf");
        } catch (Exception e) {
            e.printStackTrace();
            return "Error sending email with attachment";
        }

        emailService.sendEmail(toEmail, subject, messagebody);

        return "Email sent successfully!";
    }
}
