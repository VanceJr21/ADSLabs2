public class Sale {
    private String name;
    private double price;

    public Sale(){
        this.name = "No name yet";
        this.price = 0;


    }

    // parameterized constructor
    public Sale(String theName, double thePrice){
        this.name = theName;
        this.price = thePrice;
    }

    // copy constructor
    public Sale(Sale originalSale){
        if(originalSale == null){
            System.out.println("Error: null Sale object");
            return;
        }
        if(getClass() != originalSale.getClass()){ //Sale.class
            System.out.println("Error: can't copy a different class");
            return;
        }

        //It's safe to copy now
        this.name = originalSale.name;
        this.price = originalSale.price;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        // checking if the name is empty
        if (name == null || name.equals("")){
            System.out.println("Error: name can't be empty");
            return;
        }
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        // checking the price for negative value
        if (this.price < 0){
            System.out.println("Error: negative price");
            return;
        }
        this.price = price;
    }

    // overriding -> late binding except for static methods
    public static void announcement(){
        System.out.println("This is a Sale item");
    }

    public String toString(){
        return name + " Price and total cost = $" + price;
    }

    public double bill(){
        return price;
    }

    /*
    returns true if the sale items have the same name and same
    bill value, otherwise return false.
     */

    public boolean equalDeals(Sale otherSale){
        if(otherSale == null){
            return false;
        }
        return (this.name.equals(otherSale.name) && this.bill() == otherSale.bill());
    }

    public boolean lessThan(Sale otherSale){
        if(otherSale == null){
            return false;
        }
        return (this.name.equals(otherSale.name) && this.bill() < otherSale.bill()); // Polymorphism
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

        Sale s = (Sale)otherObject;
        return (this.name.equals(s.name) && this.price == s.getPrice());

    }

    public Sale clone(){
        return new Sale(this);
    }

}

