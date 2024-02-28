public class DiscountSale extends Sale{
    private double discount;

    public DiscountSale(){
        super();
        this.discount = 0;
    }

    public DiscountSale(String name, double price, double discount){
        super(name, price);
        this.discount = discount;
    }

    public DiscountSale(DiscountSale originalSale){
       /* if(originalSale == null){
            System.out.println("Error: null Sale object");
            return;
        }
        if(getClass() != originalSale.getClass()){ //Sale.class
            System.out.println("Error: can't copy a different class");
            return;
        }

        //It's safe to copy now
        this.name = originalSale.name;
        this.setPrice(originalSale.getPrice());*/

        // Needs to be tested
        super(originalSale);
        this.discount = originalSale.discount;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public static void announcement(){
        System.out.println("This is a discounted sale item");
    }

    public double bill(){
        double fraction = this.discount/100;
        return (1 - fraction) * getPrice();
    }

    public String toString(){
        return (getName() + " Price: $" + getPrice() + " Discount: " + discount
        + " Total Cost: $" + bill());
    }

    public boolean equals(Object otherObject){
        if(otherObject == null){
            System.out.println("Error: object can't be null");
            return false;
        }

        if(this.getClass() != otherObject.getClass()){
            System.out.println("Error: objects aren't of same type");
            return false;
        }

        DiscountSale s = (DiscountSale)otherObject;
        return (this.getName().equals(s.getName()) && this.getPrice() == s.getPrice() &&
                this.discount == s.discount);
    }
}
