package hu.webvalto.ebank.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class DataSource {

    private static List<List<String>> data = new ArrayList<>();

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    private void postConstruct() {

        List<String> allLines = null;

        ClassLoader classLoader = ClassLoader.getSystemClassLoader();

        try {
            allLines = Files.readAllLines(Paths.get(classLoader.getResource("data.txt").getPath()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String lines: allLines) {
            data.add(Arrays.asList(lines.split(",")));
        }

    }

    public List<List<String>> getData() {
        if (data.size() > 0) {
            return data;
        } else {
            postConstruct();
            return data;
        }
    }
}
