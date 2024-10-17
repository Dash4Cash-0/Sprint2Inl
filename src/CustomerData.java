import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class CustomerData {


    Path ptFile = Paths.get("src/PTFile.txt");
    Path customerFile = Paths.get("src/customers.txt");



    public String searchForCustomerByName(String name) {

        String customerName = "";

        try (BufferedReader br = Files.newBufferedReader(customerFile)) {
            String line;

            while ((line = br.readLine()) != null) {
                if (line.contains(name)) {
                    customerName = line;
                    break;
                }
            }

        } catch (IOException e) {
            System.out.println("File not found");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return customerName;
    }
}
