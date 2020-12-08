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
    check = new Check(LocalTime.of(12,30));
    User user = new User("000","Dummy","Test",20);
    order = new ArrayList<MenuItem>();
    }
    @Test (expected = TakeAwayBillException.class)
    public void tooManyItemsTest() throws TakeAwayBillException {
        int c;
        for(c=0;c<34;c++){
            order.add(new MenuItem("Juice", MenuItem.types.Bevanda,2.3));
        }
        check.getOrderPrice(order,user);
    }
    @Test
    public void getOrderPriceTest() throws TakeAwayBillException {
        order.add(new MenuItem("Juice", MenuItem.types.Bevanda,2.3));
        order.add(new MenuItem("Juice", MenuItem.types.Bevanda,7.3));
        Assert.assertEquals(9.6,check.getOrderPrice(order,user),0.0);
    }
}
