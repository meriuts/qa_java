package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

@RunWith(Parameterized.class)
public class LionHasManeTest {
    private  final String sex;
    private  final String sexException;
    Feline feline = Mockito.mock(Feline.class);

    public LionHasManeTest (String sex, String sexException)  {
        this.sex = sex;
        this.sexException = sexException;
    }

    @Parameterized.Parameters
    public static Object [][] getTestLion() {
        return new Object [][] {
                {"Самец", "Женский"},
                {"Самка", "Мужской"}
        };
    }

    @Test(expected = Exception.class)
    public void generationExceptionLionTest () throws Exception {
        Lion lion = new Lion(feline, sexException);
    }

    @Test
    public void doesHaveManeResult() throws Exception {
        Lion lion = new Lion(feline, sex);
        if ("Самец".equals(sex)) {
            Assert.assertEquals(true, lion.doesHaveMane());
        } else if ("Самка".equals(sex)) {
            Assert.assertEquals(false, lion.doesHaveMane());
        }
    }

}
