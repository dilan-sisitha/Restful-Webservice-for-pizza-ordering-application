package pizzaloop;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface CardPaymentRepository extends CrudRepository<CardPayment, Integer> {


}
