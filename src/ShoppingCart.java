public class ShoppingCart {
    public static void main(String[] args) {
        Sale simple = new Sale("Mouse", 30.0);
        DiscountSale discount = new DiscountSale("Referbished mouse", 11.0, 10);

        System.out.println(simple);
        System.out.println(discount);


        if(simple.lessThan(discount)){
            System.out.println("Sale item is cheaper");
        }else {
            System.out.println("Discount item is cheaper");
        }

        Sale.announcement();
        DiscountSale.announcement();
    }
}
