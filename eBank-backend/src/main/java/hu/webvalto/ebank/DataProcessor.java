package hu.webvalto.ebank;

import hu.webvalto.ebank.dao.DataStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DataProcessor {

    @Autowired
    private DataStore dataStore;

    public DataProcessor(DataStore dataStore) {
        this.dataStore = dataStore;
    }

    public List<List<String>> getCustomerData(String namePrefix) {
        List<List<String>> result = new ArrayList<>();

        List<List<String>> data = dataStore.getData();

        for (List<String> customer: data) {
            if (customer.get(2).startsWith(namePrefix)) {
                result.add(customer);
            }
        }

        return result;
    }

    public List<String> getAccountData(String accountNumber) {

        List<List<String>> data = dataStore.getData();

        for (List<String> customer: data) {
            if (customer.get(1).equals(accountNumber)) {
                return customer;
            }
        }

        return null;

    }

    public void createDataTable() {
        dataStore.createDataTable();
    }

}
