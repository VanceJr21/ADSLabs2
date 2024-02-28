public class Loan {
    private  double interestRate;
    private String customer;
    private String lender;

    public Loan(){

    }

    public Loan(double interestRate, String customer, String lender){
        this.interestRate = interestRate;
        this.customer = customer;
        this.lender = lender;
    }

    public  static Loan createLoan(String lender){
        Loan loan = new Loan();
        loan.lender = lender;
        return loan;
    }

    // overloaded createLoan method
    public static  Loan createLoan(String lender, double interestRate){
        Loan loan = new Loan();
        loan.lender = lender;
        loan.interestRate = interestRate;
        return loan;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getLender() {
        return lender;
    }

    public void setLender(String lender) {
        this.lender = lender;
    }

    public String toString(){
        return "This is a loan owned by CitiBank for: " +
                this.customer + " by lender: " + this.lender +
                " the interest rate is: " + this.interestRate;
    }
}
