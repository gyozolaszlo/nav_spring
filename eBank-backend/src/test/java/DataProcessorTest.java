import hu.webvalto.ebank.DataProcessor;
import hu.webvalto.ebank.dao.DataStore;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DataProcessorTest {

    DataProcessor testObj;

    @BeforeEach
    void createTestObject() {
        testObj = new DataProcessor(new DataStore());
    }

    @AfterEach
    void deleteTestObject() {
        testObj = null;
    }

    @Test
    void getCustomerData() {

        List<List<String>> expectedResult = Arrays.asList(
                Arrays.asList("514", "35448669-64602172-61624015", "Johnpaul Schowalter", "72348 Tyrel Junction"),
                Arrays.asList("924", "76277549-34783185-30805374", "Johnpaul Kohler III", "3498 Douglas Passage"));

        List<List<String>> result = testObj.getCustomerData("Johnpaul");

        assertEquals(2, result.size());
        assertEquals(expectedResult, result);

    }

    @Test
    void getAccountData() {

        List<String> expectedResult = Arrays.asList("514", "35448669-64602172-61624015", "Johnpaul Schowalter", "72348 Tyrel Junction");

        List<String> result = testObj.getAccountData("35448669-64602172-61624015");

        assertEquals(expectedResult, result);
    }
}