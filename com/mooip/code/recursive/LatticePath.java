package com.mooip.code.recursive;

/**
 * Lattice Path.
 * <p>
 * Example of a Lattice Path recursion solution.  This will only solve very small problems.
 * For example a 20 by 20 took 7 minutes 46 seconds to compute on my machine.
 * 
 * @author masterofoneinchpunch
 * @see <a href="https://projecteuler.net/problem=15">Lattice paths</a>
 * @see <a href="https://bit.ly/3V7jnrC">A good example of how to code this.</a>
 */
public final class LatticePath {    
    public LatticePath() {
    }

    /**
     * Computes the lattice path using recursion.
     * 
     * @param x The first variable to compute (x-coordinate).
     * @param y The second variable to compute (y-coordinate).
     * @return paths How many paths (routes) the two variable will have.
     */
    public static long compute(int x, int y) {
        // there's only 1 way you can reach a point which is on some edge
        if (x == 0 || y == 0) {
            return 1;
        }
        
        /* 
            Otherwise apply back recursion, i.e. take the last step (when you reach x,y) :
            you can get there only by moving from x-1,y (right) or from x,y-1 (up).
            So the result would be the number of ways you can get to x-1,y plus the number 
            of ways you can get to x,y-1 
        */
        return compute(x - 1, y) + compute(x, y - 1);
    }    
}
