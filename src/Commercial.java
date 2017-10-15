import java.text.NumberFormat;

public class Commercial extends Customer {
    /**
     * declare commercial variables
     */


    public String propertyName;
    private final double COMMERCIAL_RATE = 5.0d;
    public Boolean multiProperty;

    /**
     * declaring superclass constructor
     */

    public Commercial(String customerName, String customerPhone, String customerAddress, Double squareFootage, String propertyName,
                      Boolean multiProperty) {
        super(customerName, customerPhone, customerAddress, squareFootage);
            this.propertyName = propertyName;
            this.multiProperty = multiProperty;
    }

    /**
     * set method to determine multiple properties
     */

    public void weeklyCharges() {
        System.out.println(this.customerName);
        System.out.println(this.customerAddress);
        System.out.println(this.customerPhone);
        System.out.println(this.squareFootage);
        System.out.println(this.propertyName);

        /**
         * format the cost to look pretty
         */

        NumberFormat nf = NumberFormat.getCurrencyInstance();
        nf.setGroupingUsed(true);
        nf.setMaximumFractionDigits(2);
        nf.setMinimumFractionDigits(2);
        if (multiProperty) {
           double cost =  ((this.squareFootage/1000) * COMMERCIAL_RATE) * .9;
           System.out.println("Your weekly charge with discount is: " + nf.format(cost));

        } else {
            double cost =  ((this.squareFootage/1000) * COMMERCIAL_RATE);
            System.out.println("Your weekly charge is: " + nf.format(cost));
        }

    }
}
