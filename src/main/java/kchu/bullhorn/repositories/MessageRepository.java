package kchu.bullhorn.repositories;

import kchu.bullhorn.models.*;
import org.springframework.data.repository.CrudRepository;


public interface MessageRepository extends CrudRepository<Message,Long> {

}
