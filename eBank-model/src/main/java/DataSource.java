import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataSource {

    private static List<List<String>> data = new ArrayList<>();

    static {

        List<String> allLines = null;

        try {
            allLines = Files.readAllLines(Paths.get("eBank-model/src/main/resources/data.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String lines: allLines) {
            data.add(Arrays.asList(lines.split(",")));
        }

    }

    public static List<List<String>> getData() {
        return data;
    }
}
