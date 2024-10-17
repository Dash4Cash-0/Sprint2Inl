import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

import static org.junit.Assert.*;

public class CustomerDataTest {

    CustomerData cd = new CustomerData();
    Path readFile = Paths.get("test/testCustomers.txt");

    @Test
    public void searchForCustomerByNameTest(){
        String name1 = "Bear";
        String name2 = "Nisse";

        assertEquals("8204021234, Bear Belle", cd.searchForCustomerByName(name1));
        assertNotEquals("123123 NIsse", cd.searchForCustomerByName(name2));

    }
}
