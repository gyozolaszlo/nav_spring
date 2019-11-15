package hu.webvalto.ebank;

import hu.webvalto.ebank.DataProcessor;
import hu.webvalto.ebank.entity.Customer;
import hu.webvalto.ebank.repository.CustomerRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.powermock.api.mockito.PowerMockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class DataProcessorTest {

    DataProcessor testObj;
    CustomerRepository customerRepositoryMock;

    @BeforeEach
    void createTestObject() {
        testObj = new DataProcessor();
        customerRepositoryMock = mock(CustomerRepository.class);
        testObj.setCustomerRepository(customerRepositoryMock);
    }

    @AfterEach
    void deleteTestObject() {
        testObj = null;
    }

    @Test
    void getCustomerData() {

        List<Customer> expectedResult = Arrays.asList(
                new Customer(514, "Johnpaul Schowalter", "72348 Tyrel Junction"),
                new Customer(924, "Johnpaul Kohler III", "3498 Douglas Passage"));

        when(customerRepositoryMock.findCustomerByFullNameLike("%Johnpaul%")).thenReturn(expectedResult);

        List<Customer> result = testObj.getCustomerData("Johnpaul");

        verify(customerRepositoryMock, times(1)).findCustomerByFullNameLike("%Johnpaul%");

        assertEquals(2, result.size());
        assertEquals(expectedResult, result);

    }
}