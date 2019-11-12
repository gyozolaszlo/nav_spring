import java.util.ArrayList;
import java.util.List;

public class DataProcessor {

    public List<List<String>> getCustomerData(String namePrefix) {
        List<List<String>> result = new ArrayList<>();

        List<List<String>> data = DataSource.getData();

        for (List<String> customer: data) {
            if (customer.get(2).startsWith(namePrefix)) {
                result.add(customer);
            }
        }

        return result;
    }

    public List<String> getAccountData(String accountNumber) {

        List<List<String>> data = DataSource.getData();

        for (List<String> customer: data) {
            if (customer.get(1).equals(accountNumber)) {
                return customer;
            }
        }

        return null;

    }

}
