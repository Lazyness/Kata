package coder.codewars;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class KataTest {
    Kata kata = new Kata();
    @org.junit.jupiter.api.Test
    void sum() {
        assertEquals(14,kata.sum(5,9));
    }

    @Test
    void arrayDiff() {
        assertArrayEquals(new int[] {2,2},kata.arrayDiff( new int[] {1, 2,2,3}, new int[] {1,3}));
    }

    @Test
    void summation() {
        assertEquals(36,kata.summation(8));
    }

    @Test
    void countPassengers() {

        ArrayList<int[]> list = new ArrayList<int[]>();
        list.add(new int[] {10,0});
        list.add(new int[] {3,5});
        list.add(new int[] {2,5});
        assertEquals(5, kata.countPassengers(list));
    }
}