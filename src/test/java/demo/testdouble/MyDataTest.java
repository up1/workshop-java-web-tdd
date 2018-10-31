package demo.testdouble;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class MyDataTest {

    @Test
    public void getNumber_5() {
        Random stubRandom = new Random5();
        MyData myData = new MyData();
        myData.setRandom(stubRandom);
        int actualResult = myData.getNumber();
        assertEquals(5, actualResult);
    }

    @Test
    public void getNumber_xxx() {
        Randomxxx stubRandom = new Randomxxx();
        MyData myData = new MyData();
        myData.setRandom(stubRandom);
        myData.getNumber();
        assertTrue(stubRandom.verify());
    }

}

class Randomxxx extends Random {
    boolean called = false;
    @Override
    public int nextInt(int bound) {
        called = true;
        return 5;
    }

    public boolean verify() {
        return called;
    }
}
class Random5 extends Random {
    @Override
    public int nextInt(int bound) {
        return 5;
    }
}