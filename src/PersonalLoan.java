public class PersonalLoan extends Loan {
    private String collateral;

    public PersonalLoan(){

    }

    public PersonalLoan(double interestRate, String customer, String lender, String collateral){
        // Super reference from Loan
        super(interestRate, customer, lender); // Parent comes first
        this.collateral = collateral;
    }
    
    public PersonalLoan(String s){
        // Do something.
    }

    public  static Loan createLoan(String lender, double interestRate, String collateral){
        PersonalLoan pL = new PersonalLoan();
        pL.setLender(lender);
        pL.setCustomer(lender);
        pL.setInterestRate(interestRate);
        pL.collateral = collateral;
        return pL;
    }

    public String getCollateral() {
        return collateral;
    }

    public void setCollateral(String collateral) {
        this.collateral = collateral;
    }

    public boolean equals(Object otherLoan){
        if (otherLoan ==null){
            System.out.println("Error object is null");
        } else if (otherLoan.getClass() != PersonalLoan.class) {
            System.out.println("The object is not a Personal Loan object");
        }else return this.getCustomer().equals(((PersonalLoan) otherLoan).getCustomer()) &&
                this.getInterestRate() == ((PersonalLoan) otherLoan).getInterestRate() &&
                this.collateral.equals(((PersonalLoan) otherLoan).collateral);
        return false;
    }

    public String toString(){
        return "This is personal Loan owned by CitiBank with a collateral: " +
                this.collateral;
    }
}
