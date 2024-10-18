import org.junit.Test;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

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
        String name2 = "Nisse";

        assertEquals("8204021234, Bear Belle", md.searchForMemberByName(name1));
        assertNotEquals("123123 Nisse", md.searchForMemberByName(name2));
    }

    @Test
    public void searchForMemberByPersonalNumberTest(){
        String pNumber1 = "8204021234";
        String number = "12312312313";

        assertEquals("8204021234, Bear Belle", md.searchForMemberByPersonalNumber(pNumber1));
        assertNotEquals("2323232", md.searchForMemberByPersonalNumber(number));
    }

    @Test
    public void checkIfMember() {

        try(BufferedReader br = Files.newBufferedReader(testFile)){
            String line;

            while((line = br.readLine()) != null){
                if(line.contains("2019-12-02")){
                    break;
                }
            }
        }catch (IOException e){
            System.out.println("File not found");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
