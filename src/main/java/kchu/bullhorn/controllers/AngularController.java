package kchu.bullhorn.controllers;

import kchu.bullhorn.models.*;
import kchu.bullhorn.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class AngularController {
    @Autowired
    MessageRepository messageRepository;

    @RequestMapping("/add/{message}/{user}")
    public Iterable<Message> update(@PathVariable("message") String content,@PathVariable("user") String user){
        Message message = new Message();
        message.setContent(content);
        message.setUser(user);
        message.setDate(new Date());
        messageRepository.save(message);
        return messageRepository.findAll();
    }

    @RequestMapping("/all")
    public Iterable<Message> getAll(){

        return messageRepository.findAll();
    }


}
