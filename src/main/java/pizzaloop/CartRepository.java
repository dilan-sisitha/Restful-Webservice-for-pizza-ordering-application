package pizzaloop;

import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface CartRepository extends CrudRepository<Cart, Integer> {



}
