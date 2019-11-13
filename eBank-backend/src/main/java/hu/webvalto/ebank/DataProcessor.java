package hu.webvalto.ebank;

import hu.webvalto.ebank.dao.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DataProcessor {

    @Autowired
    private DataSource dataSource;

    public DataProcessor(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<List<String>> getCustomerData(String namePrefix) {
        List<List<String>> result = new ArrayList<>();

        List<List<String>> data = dataSource.getData();

        for (List<String> customer: data) {
            if (customer.get(2).startsWith(namePrefix)) {
                result.add(customer);
            }
        }

        return result;
    }

    public List<String> getAccountData(String accountNumber) {

        List<List<String>> data = dataSource.getData();

        for (List<String> customer: data) {
            if (customer.get(1).equals(accountNumber)) {
                return customer;
            }
        }

        return null;

    }

}
