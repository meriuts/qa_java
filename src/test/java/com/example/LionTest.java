package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import java.util.List;

@RunWith(Parameterized.class)
public class LionTest  {

    private  final Feline feline;
    private  final String sex;

    public LionTest (Feline feline, String sex)  {
        this.feline = feline;
        this.sex = sex;


    }
    @Parameterized.Parameters
    public static Object [][] getTestLion() {
        return new Object [][] {
                {Mockito.mock(Feline.class), "Самец"},
                {Mockito.mock(Feline.class), "Самка"}
        };
    }

    @Test
    public void getKittensTest() throws Exception {
        Lion lion = new Lion(feline, sex);
        Lion lionSpy = Mockito.spy(lion);
        lionSpy.getKittens();
        Mockito.verify(lionSpy, Mockito.times(1)).getKittens();
    }

    @Test
    public void getKittensOfFelineClassTest() throws Exception {
        Lion lion = new Lion(feline, sex);
        Lion lionSpy = Mockito.spy(lion);
        lionSpy.feline.getKittens();
        Mockito.verify(lionSpy.feline, Mockito.times(1)).getKittens();
    }

    @Test
    public void doesHaveManeRun() throws Exception {
        Lion lion = new Lion(feline, sex);
        Lion lionSpy = Mockito.spy(lion);
        lionSpy.doesHaveMane();
        Mockito.verify(lionSpy, Mockito.times(1)).doesHaveMane();
    }

    @Test(expected = Exception.class)
    public void generationLionTest () throws Exception {
        Lion lion = new Lion(feline, "Мужчина");

    }
    @Test
    public void doesHaveManeResult() throws Exception {
        Lion lion = new Lion(feline, sex);
        Lion lionSpy = Mockito.spy(lion);
        if ("Самец".equals(sex)) {
            Assert.assertEquals(true, lionSpy.doesHaveMane());
        } else if ("Самка".equals(sex)) {
            Assert.assertEquals(false, lionSpy.doesHaveMane());
        }
    }

    @Test
    public void getFoodTest() throws Exception {
        Lion lion = new Lion(feline, sex);
        Lion lionSpy = Mockito.spy(lion);
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        lionSpy.getFood();
        Mockito.verify(lionSpy, Mockito.times(1)).getFood();
        Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"),lionSpy.getFood());
    }

}
