package kchu.bullhorn.repositories;

import kchu.bullhorn.models.*;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User,Long> {
    public User findByUsername(String name);
    public int countByUsername(String name);

}
