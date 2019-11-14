package hu.webvalto.ebank.dao;

import hu.webvalto.ebank.entity.Customer;
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
public class DataStore {

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

    public void createDataTable() {

        jdbcTemplate.execute("DROP TABLE customers IF EXISTS");
        jdbcTemplate.execute("CREATE TABLE customers(" +
                "id NUMBER, account_number VARCHAR(255), full_name VARCHAR(255), address VARCHAR(255))");

        List<Object[]> insert_data = new ArrayList<>();
        data.forEach(row -> {
            Object[] new_row = new Object[row.size()];
            for (int i = 0; i < row.size(); i++) {
                new_row[i] = row.get(i);
            }
            insert_data.add(new_row);
        });

        jdbcTemplate.batchUpdate("INSERT INTO customers(id, account_number, full_name, address) VALUES (?,?,?,?)", insert_data);

        jdbcTemplate.query("SELECT id, account_number, full_name, address FROM customers WHERE full_name = ?",
                new Object[] { "Candelario Romaguera" },
                (rs, rowNum) ->
                        new Customer(
                                rs.getInt("id"),
                                rs.getString("account_number"),
                                rs.getString("full_name"),
                                rs.getString("address")
                        )
        )
                .forEach(customer ->
                        System.out.println(customer)
                );

    }
}
