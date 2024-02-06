package com.udayam.bablookumar.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.udayam.bablookumar.entity.Message;
import com.udayam.bablookumar.form.PaginationForm;
import com.udayam.bablookumar.repository.ContactRepository;
import com.udayam.bablookumar.util.DateFormat;

@Service
public class ContactService {
    
//    @Autowired
//    private ContactRepository contactRepository;
//    @Autowired
//    private EmailService emailService;
//
//    public void sendMessage(Message message) {
//        String name = message.getName();
//        String contactInfo = message.getContactInfo();
//        String body = message.getBody();
//        message.setDate(DateFormat.yyyyMMddHHmmss());
//        contactRepository.save(message);
//        String emailSubject = name + " sent you a message";
//        String emailBody = "Name: " + name + "\n" +
//                            "Contact Info: " + contactInfo + "\n\n" +
//                            body + "\n";
//        emailService.sendEmail(EmailService.toEmail(), emailSubject, emailBody);
//    }
//
//    public Page<Message> getMessages(PaginationForm paginationForm) {
//        Pageable pageable = PageRequest.of(paginationForm.getPageNum(), paginationForm.getPageSize());
//        Page<Message> page = contactRepository.findAllWithPaginationOrderedByDate(pageable);
//        return page;
//    }
//
//    // Returns error message if applicable, else null.
//    public String deleteMessage(Long id) {
//        Optional<Message> optional = contactRepository.findById(id);
//        if (!optional.isPresent()) {
//            return Message.MESSAGE_ID_ERROR;
//        }
//        contactRepository.delete(optional.get());
//        return null;
//    }

}
