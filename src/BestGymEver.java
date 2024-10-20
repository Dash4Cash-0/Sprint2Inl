import java.time.LocalDate;
import java.util.Scanner;

public class BestGymEver {


    public void mainProgram() {
        MemberData md = new MemberData();
        Scanner input = new Scanner(System.in);
        LocalDate today = LocalDate.now();

        System.out.println("Search for name or personalnumber: ");
        String search = input.nextLine();

        try {
            if (search.matches("^[0-9]+$")) {
                if (md.searchForMemberByPersonalNumber(search) != null) {
                    checkPayment(md, today, search);
                }
            }
            if (search.matches("^[a-zA-Z]+$")) {
                    if (md.searchForMemberByName(search) != null) {
                        checkPayment(md, today, search);
                    }
            }
        } catch (StringIndexOutOfBoundsException e){
            System.out.println("Not a member");
        }
    }

    private void checkPayment(MemberData md, LocalDate today, String search) {
        if(!md.checkIfMember(md.getLastPayment(search))) {
            System.out.println("It was more than a year since you payed for the membership");
        }else{
            System.out.println("Welcome!");
            System.out.println(md.searchForMemberByName(search));

            Person member = new Person(md.searchForMemberByName(search),
                    md.searchForMemberByPersonalNumber(search), today);
            md.writeToFile(member);
        }
    }

    public static void main(String[] args) {
        BestGymEver start = new BestGymEver();
        start.mainProgram();
    }
}
