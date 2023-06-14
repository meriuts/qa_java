package com.example;

import org.junit.Assert;
import org.junit.Test;
import java.util.List;


public class FelineTest {

    @Test
    public void eatMeatReturnListOfString() throws Exception {
        Feline feline = new Feline();
        Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), feline.eatMeat());
    }

    @Test
    public void getFamilyReturnFeline() {
        Feline feline = new Feline();
        Assert.assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void getKittens5Return5() {
        Feline feline = new Feline();
        Assert.assertEquals(5,feline.getKittens(5));
    }

    @Test
    public void getKittensNoParam() {
        Feline feline = new Feline();
        Assert.assertEquals(1,feline.getKittens());
    }

}
