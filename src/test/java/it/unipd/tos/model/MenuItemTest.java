package it.unipd.tos.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MenuItemTest {
    MenuItem menuItem;
    @Before
    public void setup(){
        menuItem= new MenuItem("Sangue dei tuoi nemici", MenuItem.types.Bevanda,9.99);
    }
    @Test
    public void getNameTest(){
        Assert.assertEquals("Sangue dei tuoi nemici",menuItem.getName());
    }
    @Test
    public void getTypeTest(){
        Assert.assertEquals(MenuItem.types.Bevanda,menuItem.getType());
    }
    @Test
    public void getPriceTest(){
        Assert.assertEquals(9.99,menuItem.getPrice(),0.01);
    }
}
