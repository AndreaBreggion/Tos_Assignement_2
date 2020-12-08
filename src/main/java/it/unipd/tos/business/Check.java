////////////////////////////////////////////////////////////////////
// Andrea Breggion 1192760
////////////////////////////////////////////////////////////////////
package it.unipd.tos.business;

import it.unipd.tos.business.exception.TakeAwayBillException;
import it.unipd.tos.model.MenuItem;

import java.time.LocalTime;
import java.util.List;
import it.unipd.tos.model.User;

public class Check implements TakeAwayBill{
    private LocalTime time;

    public Check(LocalTime t){
    time=t;
    }
    public double getOrderPrice(List<MenuItem> l,User user) throws TakeAwayBillException {
        if(l.size()>30){
            throw new TakeAwayBillException("You're getting fat!");
        }
        double total = 0;
        if(l.size()!=0) {
            for (MenuItem m : l) {
                total += m.getPrice();
            }
        }
        if(total>=50){
            total-=(total/10);
        }
        if(total<10){
            total+=0.50;
        }
        return total;
    }
}
