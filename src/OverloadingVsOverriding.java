import java.util.ArrayList;

public class OverloadingVsOverriding {
    public static void main(String[] args) {
        // Create 2 load objects
        Loan cheaploan = Loan.createLoan("HCU");
        Loan veryCheapLoan = Loan.createLoan("BMW", 8.0);

        Loan pl = PersonalLoan.createLoan("Builder", 7.0, "residential House");
        Loan pl2 = PersonalLoan.createLoan("Builder", 7.0, "residential House");

        System.out.println(cheaploan);
        System.out.println(veryCheapLoan);
        System.out.println(pl);
        System.out.println(pl.equals(pl2));

        // Generic object
        /*ArrayList<Object> loansList = new ArrayList<>();
        loansList.add(cheaploan);
        loansList.add(veryCheapLoan);
        loansList.add(pl);*/

        // Getting the values in the array list
       /* for(int i =0; i < loansList.size(); i++){
            if(loansList.get(i).getClass() == Loan.class){
                //Treat that object as a Loan object
                // DownCasting
               System.out.println (((Loan)loansList.get(i)).getInterestRate());
            } else if (loansList.get(i).getClass() == PersonalLoan.class) {
                System.out.println(((PersonalLoan)loansList.get(i)).getCollateral());
            }
        }*/


    }
}

