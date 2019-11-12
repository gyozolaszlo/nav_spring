import java.util.List;

public class App {

    public static void main(String... args) {

        DataProcessor dataProcessor = new DataProcessor();

        List<List<String>> data = dataProcessor.getCustomerData("Johnpaul");

        System.out.println(data);
    }

}