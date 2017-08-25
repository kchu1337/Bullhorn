package kchu.bullhorn.COnfig;


import kchu.bullhorn.models.User;
import kchu.bullhorn.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    UserRepository userRepository;

    @Override
    public void run(String... strings) throws Exception {
        if (userRepository.countByUsername("user") < 1) {
            System.out.println("Loading Data");
            User user = new User("User 1", "password", "user@suser.com", "user");
            user.setAuthority("USER");
            userRepository.save(user);
        }
    }
}
