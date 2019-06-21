package pizzaloop;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepositary extends CrudRepository<User, Integer> {

    List<User> findByEmail(String email);
    //List<User> findById(Integer id);


}
