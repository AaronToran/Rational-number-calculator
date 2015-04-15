/*
    ExtendedNumber.java
    David Klick
    CIS 260
    2014-03-11
    
    Interface for Rational number assignment.
*/

interface ExtendedNumber<T extends ExtendedNumber & Comparable<? super T>> {
    int compareTo(T obj);
    T add(T obj);
    T subtract(T obj);
    T multiply(T obj);
    T divide(T obj);
    boolean equals(Object obj);
    T increment();
    T decrement();
}
