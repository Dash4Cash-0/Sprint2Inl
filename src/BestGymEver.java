import java.util.Scanner;

public class BestGymEver {


    public void mainProgram(){
        MemberData md = new MemberData();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter name: ");
        System.out.println(md.searchForMemberByName("Bear"));
        try{
            if(md.searchForMemberByPersonalNumber("8512021234") == null){

            }else{
                System.out.println(md.searchForMemberByPersonalNumber("8512021234"));
            }
        }catch (StringIndexOutOfBoundsException e){
            System.out.println("Not a member");
        }


    }

    public static void main(String[] args) {
        BestGymEver start = new BestGymEver();
        start.mainProgram();
    }
}
