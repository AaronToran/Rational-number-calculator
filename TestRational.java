/*
    TestRational.java
    David Klick
    CIS 260
    2014-03-11
    
    Test program for Rational number assignment.
*/

public class TestRational {
    public static void main(String[] args) {
        Rational[] r = { new Rational(),
            new Rational(2,3),
            new Rational(12,15),
            new Rational(-15,-12),
            new Rational(4,3),
            new Rational(3,2) };
        int i;

        // display rational numbers created
        for (i=0; i<6; i++) System.out.println("r[" + i + "] = " + r[i]);

        System.out.println("Testing methods:");
        System.out.println("r[1].add(r[4]) = " + r[1].add(r[4]));
        System.out.println("r[1].subtract(r[4]) = " + r[1].subtract(r[4]));
        System.out.println("r[1].divide(r[4]) = " + r[1].divide(r[4]));
        System.out.println("r[1].multiply(r[4]) = " + r[1].multiply(r[4]));
        System.out.println("r[1].multiply(r[5]) = " + r[1].multiply(r[5]));
        System.out.println("r[1].increment() = " + r[1].increment());
        System.out.println("r[1].decrement() = " + r[1].decrement());

        System.out.println("Testing equality and comparison methods:");
        r[2] = r[0];
        System.out.println("r[2] set to r[0]");
        System.out.println("r[0].compareTo(r[1]) = " + r[0].compareTo(r[1]));
        System.out.println("r[0].compareTo(r[2]) = " + r[0].compareTo(r[2]));
        System.out.println("r[0].compareTo(r[3]) = " + r[0].compareTo(r[3]));
        System.out.println("r[0].equals(r[1]) = " + r[0].equals(r[1]));
        System.out.println("r[0].equals(r[2]) = " + r[0].equals(r[2]));
        System.out.println("r[0].equals(r[3]) = " + r[0].equals(r[3]));

        System.out.println("Testing display style setting:");
        for (i=0; i<6; i++) {
            Rational.setDisplayStyle(Rational.DisplayStyle.FRACTIONAL);
            System.out.print("r[" + i + "] = " + r[i] + " = ");
            Rational.setDisplayStyle(Rational.DisplayStyle.FLOATING_POINT);
            System.out.println(r[i]);
        }
        Rational.setDisplayStyle(Rational.DisplayStyle.FRACTIONAL);

        System.out.println("Try to create illegal Rational object:");
        try {
            Rational badrat = new Rational(2,0);
            System.out.println("Error: Program failed to throw exception");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("*** End of test");
    }
}
