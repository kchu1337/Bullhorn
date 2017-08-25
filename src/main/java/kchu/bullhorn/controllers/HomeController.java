package kchu.bullhorn.controllers;


/*import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;*/
import com.cloudinary.utils.ObjectUtils;
import kchu.bullhorn.COnfig.CloudinaryConfig;
import kchu.bullhorn.models.Message;
import kchu.bullhorn.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.io.IOException;
import java.security.Principal;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {
    @Autowired
    CloudinaryConfig cloudc;
    @Autowired
    MessageRepository messageRepository;

    @RequestMapping("/")
    public String home(Model model){
        model.addAttribute("message", new Message());
        return "index";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }
    @PostMapping("/upload")
    public String singleImageUpload(@RequestParam("file") MultipartFile file, @ModelAttribute Message message, Model model, Principal principal){
        model.addAttribute("message", message);

        if (file.isEmpty()){
            return "upload";
        }
        try {
            Map uploadResult =  cloudc.upload(file.getBytes(), ObjectUtils.asMap("resourcetype", "auto"));
            String filename = uploadResult.get("public_id").toString() + "." + uploadResult.get("format").toString();
            String url = cloudc.createUrl(filename,300,200, "pad");
            message.setImage(url);
            message.setUsername(principal.getName());
            message.setDate(new Date());
            messageRepository.save(message);

        } catch (IOException e){
            e.printStackTrace();
        }
        return "redirect:/";
    }
}
