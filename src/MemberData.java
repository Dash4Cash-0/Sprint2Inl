import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Locale;


public class MemberData {


    Path ptFile = Paths.get("src/PTFile.txt");
    Path memberFile = Paths.get("src/members.txt");



    public String readFile(String input){
        String search = "";

        try(BufferedReader br = Files.newBufferedReader(memberFile)){
            String line;

            while((line = br.readLine()) != null){
                if(line.contains(input)){
                    search = line;
                    break;
                }
            }
        }catch (IOException e){
            System.out.println("File not found");
        }catch (Exception e){
            e.printStackTrace();
        }
        return search;
    }

    public LocalDate getLastPayment(String input){
        String date = "";

        try(BufferedReader br = Files.newBufferedReader(memberFile)){
            String line;

            while((line = br.readLine()) != null){
                if(line.contains(input)){
                    date = br.readLine();
                    break;
                } else {
                    System.out.println("Not a member");
                }
            }
        }catch (IOException e){
            System.out.println("File not found");
        }catch (Exception e){
            e.printStackTrace();
        }
        return LocalDate.parse(date);
    }


    public String searchForMemberByName(String name) {
        String memberInfo = readFile(name);

        return memberInfo.substring(12);
    }

    public String searchForMemberByPersonalNumber(String number){
        String memberInfo = readFile(number);

        return memberInfo.substring(0,10);
    }
}
