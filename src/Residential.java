import java.text.NumberFormat;

public class Residential extends Customer{
    private final double RESIDENTIAL_RATE = 6.0d;
    public Boolean seniorProperty;


    /**
     * declaring superclass constructor
     */

    public Residential(String customerName, String customerPhone, String customerAddress, Double squareFootage, Boolean seniorProperty) {
        super(customerName, customerPhone, customerAddress, squareFootage);
        this.seniorProperty = seniorProperty;
    }

    /**
     * set method to determine senior properties
     */

    public void weeklyCharges() {
        System.out.println(this.customerName);
        System.out.println(this.customerAddress);
        System.out.println(this.customerPhone);
        System.out.println(this.squareFootage);

        /**
         * format the cost to look pretty
         */

        NumberFormat nf = NumberFormat.getCurrencyInstance();
        nf.setGroupingUsed(true);
        nf.setMaximumFractionDigits(2);
        nf.setMinimumFractionDigits(2);
        if (seniorProperty) {
            double cost =  ((this.squareFootage/1000) * RESIDENTIAL_RATE) * .85;
            System.out.println("Your weekly charge with discount is: " + nf.format(cost));

        } else {
            double cost =  ((this.squareFootage/1000) * RESIDENTIAL_RATE);
            System.out.println("Your weekly charge is: " + nf.format(cost));
        }

    }
}
