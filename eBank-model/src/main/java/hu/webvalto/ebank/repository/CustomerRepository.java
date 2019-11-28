package hu.webvalto.ebank.repository;

import hu.webvalto.ebank.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Transactional
    List<Customer> findCustomerByFullNameLike(String fullName);

}