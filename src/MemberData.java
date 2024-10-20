import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
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

    public String getLastPayment(String input){
        String date = "";

        try(BufferedReader br = Files.newBufferedReader(memberFile)){
            String line;

            while((line = br.readLine()) != null){
                if(line.contains(input)){
                    date = br.readLine();
                    break;
                }
            }
        }catch (IOException e){
            System.out.println("File not found");
        }catch (Exception e){
            e.printStackTrace();
        }
        return date;
    }


    public String searchForMemberByName(String name) {
        String memberInfo = readFile(name);

        return memberInfo.substring(12);
    }

    public String searchForMemberByPersonalNumber(String number){
        String memberInfo = readFile(number);

        return memberInfo.substring(0,10);
    }

    public Boolean checkIfMember(String lastPayment){
        return ChronoUnit.YEARS.between(LocalDate.parse(lastPayment), LocalDate.now()) < 1;
    }

    public void writeToFile(Person person){
        try(FileWriter fw = new FileWriter(String.valueOf(ptFile), true);
            BufferedWriter bw = new BufferedWriter(fw)){

                if(!Files.exists(ptFile)){
                Files.createFile(ptFile);
            }
            bw.write(person.getName() + ", ");
            bw.write(person.getPersonalNumber() + ", ");
            bw.write(person.getTrainingDate().toString());
        }catch (IOException e){
            e.printStackTrace();
        }
    }


}
