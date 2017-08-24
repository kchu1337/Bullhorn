package kchu.bullhorn.repositories;

import kchu.bullhorn.models.*;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User,Long> {

}
