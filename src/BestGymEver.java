public class BestGymEver {




    public void mainProgram(){
        CustomerData cd = new CustomerData();
        System.out.println(cd.searchForCustomerByName("Bear"));
    }

    public static void main(String[] args) {
        BestGymEver start = new BestGymEver();
        start.mainProgram();
    }
}
