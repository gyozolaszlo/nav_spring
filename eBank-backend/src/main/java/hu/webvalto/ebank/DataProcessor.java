package hu.webvalto.ebank;

import hu.webvalto.ebank.entity.Customer;
import hu.webvalto.ebank.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataProcessor {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getCustomerData(String namePrefix) {
        List<Customer> result = customerRepository.findCustomerByFullNameLike("%" + namePrefix + "%");
        return result;
    }

    void setCustomerRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

}
