import org.junit.Test;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import static org.junit.Assert.*;

public class MemberDataTest {

    MemberData md = new MemberData();
    Path testFile = Paths.get("test/testMembers.txt");

    @Test
    public void readFileTest(){
        String output = "";
        try(BufferedReader br = Files.newBufferedReader(testFile)){
            String line;

            while((line = br.readLine()) != null){
                if(line.contains("8204021234")){
                    output = line;
                    break;
                }
            }
        }catch (IOException e){
            System.out.println("File not found");
        }catch (Exception e){
            e.printStackTrace();
        }

        assertEquals(output, md.readFile("Bear"));
        assertNotEquals("23123123", "Bear");
    }

    @Test
    public void searchForMemberByNameTest(){
        String name1 = "Bear";
        String name2 = "John";

        assertEquals("Bear Belle", md.searchForMemberByName(name1));
        assertThrows(StringIndexOutOfBoundsException.class, () -> md.searchForMemberByName(name2));
    }

    @Test
    public void searchForMemberByPersonalNumberTest(){
        String pNumber1 = "8204021234";
        String number = "12312312313";

        assertEquals("8204021234", md.searchForMemberByPersonalNumber(pNumber1));
        assertThrows(StringIndexOutOfBoundsException.class, () -> md.searchForMemberByPersonalNumber(number));
    }

    @Test
    public void checkIfMemberTest() {
        String test1 = "2019-12-02";
        String test2 = "2023-12-02";
        LocalDate testDate1 = LocalDate.parse(test1);
        boolean year1 = ChronoUnit.YEARS.between(testDate1, LocalDate.now()) <= -1;
        LocalDate testDate2 = LocalDate.parse(test2);
        boolean year2 = ChronoUnit.YEARS.between(testDate2, LocalDate.now()) > -1;


        assertTrue(md.checkIfMember(test1) == year1);
        assertTrue(md.checkIfMember(test2) == year2);
        assertFalse(md.checkIfMember(test1) == year2);
    }
}
