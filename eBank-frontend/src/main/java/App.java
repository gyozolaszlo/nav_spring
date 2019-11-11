import java.util.List;

public class App {

    public static void main(String... args) {

        List<List<String>> data = DataSource.getData();

        System.out.println(data);
    }

}