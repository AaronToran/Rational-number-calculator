/*
Aaron Toran
Asignment 6
Dave Klick
Rational number calculator

*/
public class Rational implements ExtendedNumber<Rational>, Comparable<Rational> {
    // Some fields and an enum must be declared here
    public enum DisplayStyle{FRACTIONAL , FLOATING_POINT};
    private int num;
    private int den;
    private static  DisplayStyle displayStyle = DisplayStyle.FRACTIONAL;
    //basic constorctor
    public Rational(){
        num =1;
        den =1;
       simplify();
    } 
    //copy
    public  Rational( Rational r) {
        this(r.num, r.den);
        simplify();
    }
    //main consturctor
    public  Rational( int n, int d) {
        setNums( n,d);
        simplify();
    }
    void setNums( int n , int d){
	if(d == 0){
            throw new IllegalArgumentException("Try to create illegal Rational object: Error: Invalid rational number:"+n+" /"+d);
        }else if(d <0 && n != 0){
            d *= -1;
            n *= -1;
        }else if(n == 0){
            d = 0;
        }else;
            num = n;
            den =d;  
    }
    private void simplify(){
        int common = gcd(num,den);	
        num = num / common;
        den = den / common;
    }
    // implement setNums method
    // implement simplify method
    
    private static int gcd(final int a, final int b) {
        int x = a, y = b;
        if (x < y) x = -x;
        if (y > 0) y = -y;
        if (y == 0) return x;
        return gcd(y, x%y);
    }
    
    // implement the three constructors
    //     default constructor
    //     copy constructor
    //     constructor which takes two int arguments
    // implement getnum
    // implement getden
    // implement setDisplayStyle
    public static void setDisplayStyle(DisplayStyle x){
        displayStyle = x;
    }
    public Rational add(Rational r) {
	int a = num * r.den  + r.num * den;
	int b =den * r.den;
	Rational add = new Rational  (a,b);
        return add;
    }
    public Rational subtract(Rational r) {
	int a =num * r.den  - r.num * den;
	int b =den * r.den;
        Rational sub = new Rational  (a,b);
        return sub;
       
    }
    public Rational multiply(Rational r) {
	int a = num * r.num;
	int b = den *r.den;
        Rational multi =new Rational  (a,b);
        return multi;
    }
    public Rational divide(Rational r) {
	int a = num * r.den ;
	int b = r.num * den;
        Rational div = new Rational  (a,b);
        return div;
    }
    public Rational increment() {
        num = num + den;
        return this;
    }
    public Rational decrement() {
        num = num - den;
        return this;
    }
    public int compareTo(Rational r) {
        if (den + num == r.num +r.den){
            return 0;
        }else if (den + num < r.num + r.den){
	    return -1;
	}else{
            return 1;
        }
    }
    @Override public boolean equals(final Object obj) {
        boolean result = false;
        if (obj instanceof Rational) {
            Rational r = (Rational) obj;
            result = (this.num == r.num && this.den == r.den);
        }
        return result;
    }
    @Override public int hashCode() {
        return (41 * (41 + num) + den);
    }
    @Override public String toString() {
        if(displayStyle == DisplayStyle.FRACTIONAL){
            return num+"/"+den;
        }else if(displayStyle == DisplayStyle.FLOATING_POINT) {
	    double  Fp =(double) num / den;
	    String number = Fp+"";
            return number;
        }else{
            return null;
        }
        
    }
}
