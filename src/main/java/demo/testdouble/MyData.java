package demo.testdouble;

import java.util.Random;

public class MyData {

    Random random;

    public int getNumber() {
        if(false) {

        }
        return random.nextInt(10);
    }

    public void setRandom(Random random) {
        this.random = random;
    }
}
