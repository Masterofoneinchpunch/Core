package com.mooip.code.util;

/**
 * A very basic pair used for testing.
 * 
 * @author masterofoneinchpunch
 */
public final class Pair {
    private final int x;
    private final int y;

    /**
     * Constructor for this int pair.
     * 
     * @param x The first int.
     * @param y The second int.
     */
    public Pair (int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Checks to see if we have an equal pair.
     * 
     * @param o The object to test.
     * @return true A true if equal, a false if not.
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Pair)) {
            return false;
        } 
        Pair pair = (Pair) o;
        return this.x == pair.x && this.y == pair.y;
    }

    /**
     * Whenever you override an equals you have to override the hashCode.
     * 
     * @return hash The has number.
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.x;
        hash = 17 * hash + this.y;
        return hash;
    }       
}
