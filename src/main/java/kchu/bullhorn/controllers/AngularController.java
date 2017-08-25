package kchu.bullhorn.controllers;

import kchu.bullhorn.models.*;
import kchu.bullhorn.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Date;
import java.util.List;

@RestController
public class AngularController {
    @Autowired
    MessageRepository messageRepository;
    @Autowired
    UserRepository userRepository;

    @RequestMapping("/add/{message}")
    public Iterable<Message> update(@PathVariable("message") String content, Principal principal){
        Message message = new Message();
        message.setContent(content);
        message.setUsername(principal.getName());
        message.setDate(new Date());
        messageRepository.save(message);
        return messageRepository.findAll();
    }

    @RequestMapping("/all")
    public Iterable<Message> getAll(){

        return messageRepository.findAll();
    }


}
