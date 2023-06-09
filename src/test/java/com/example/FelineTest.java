package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @Spy
    private Feline felineSpy;

    @Test
    public void eatMeatReturnListOfString() throws Exception {
        felineSpy.eatMeat();
        Mockito.verify(felineSpy, Mockito.times(1)).getFood("Хищник");
        Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), felineSpy.eatMeat());
    }

    @Test
    public void getFamilyReturnFeline() {
        felineSpy.getFamily();
        Assert.assertEquals("Кошачьи", felineSpy.getFamily());
    }
    @Test
    public void getKittens5Return5() {
        felineSpy.getKittens(5);
        Assert.assertEquals(5,5);
    }

    @Test
    public void getKittensNoParam() {
        felineSpy.getKittens();
        Assert.assertEquals(1,1);
    }

}
