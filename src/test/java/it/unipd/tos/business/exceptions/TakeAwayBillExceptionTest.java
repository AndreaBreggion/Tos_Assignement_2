package it.unipd.tos.business.exceptions;

import org.junit.Assert;
import org.junit.Test;

public class TakeAwayBillExceptionTest {
    @Test
    public void getMsgTest(){
        String s = "Ciccione";
        TakeAwayBillException exception = new TakeAwayBillException(s);
        Assert.assertEquals(s,exception.getMsg());
    }
}
