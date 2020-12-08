package it.unipd.tos.business;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import it.unipd.tos.model.*;
import it.unipd.tos.business.exception.TakeAwayBillException;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalTime;

public class CheckTest {
    User user;
    List<MenuItem> order;
    Check check;
    @Before
    public void setup(){
    check = new Check(LocalTime.of(18,30));
    User user = new User("000","Dummy","Test",20);
    order = new ArrayList<MenuItem>();
    }
    @Test (expected = TakeAwayBillException.class)
    public void tooManyItemsTest() throws TakeAwayBillException {
        user = new User("000","Dummy","Test",20);
        int c;
        for(c=0;c<34;c++){
            order.add(new MenuItem("Juice", MenuItem.types.Bevanda,2.3));
        }
        check.getOrderPrice(order,user);
    }
    @Test
    public void getOrderPriceTest() throws TakeAwayBillException {
        user = new User("000","Dummy","Test",20);
        order.add(new MenuItem("Juice", MenuItem.types.Bevanda,2.0));
        order.add(new MenuItem("Juice", MenuItem.types.Bevanda,2.0));
        order.add(new MenuItem("Juice", MenuItem.types.Bevanda,7.0));
        Assert.assertEquals(11.0,check.getOrderPrice(order,user),0.0);
    }
    @Test
    public void orderItemsDiscount() throws TakeAwayBillException{
        user = new User("000","Dummy","Test",20);
        order.add(new MenuItem("Ice Cream", MenuItem.types.Gelato,50));
        Assert.assertEquals(45,check.getOrderPrice(order,user),0.0);
    }
    @Test
    public void commissionTest() throws TakeAwayBillException{
        user = new User("000","Dummy","Test",20);
        order.add(new MenuItem("Juice", MenuItem.types.Bevanda,4));
        Assert.assertEquals(4.5,check.getOrderPrice(order,user),0.0);
    }
    @Test
    public void numberOrderDiscount() throws TakeAwayBillException{
        user = new User("000","Dummy","Test",20);
        order.add(new MenuItem("Ice Cream", MenuItem.types.Gelato,1));
        order.add(new MenuItem("Ice Cream", MenuItem.types.Gelato,2));
        order.add(new MenuItem("Ice Cream", MenuItem.types.Gelato,4));
        order.add(new MenuItem("Ice Cream", MenuItem.types.Gelato,6));
        order.add(new MenuItem("Ice Cream", MenuItem.types.Gelato,1));
        order.add(new MenuItem("Ice Cream", MenuItem.types.Gelato,2));
        Assert.assertEquals(15.0,check.getOrderPrice(order,user),0.0);
    }
    @Test
    public void eligibleForGiftTest(){
        user = new User("001","Dummy","Test",14);
        Assert.assertTrue(check.eligibleForGift(user));
    }
    @Test
    public void notEligibleForGiftTest(){
        user = new User("001","Dummy","test",23);
        Assert.assertFalse(check.eligibleForGift(user));
    }
    @Test
    public void tooLateTest(){
        check = new Check(LocalTime.of(19,30));
        Assert.assertFalse(check.eligibleForGift(user));
    }
    @Test
    public void tooSoonTest(){
        check = new Check(LocalTime.of(17,30));
        Assert.assertFalse(check.eligibleForGift(user));
    }

}
