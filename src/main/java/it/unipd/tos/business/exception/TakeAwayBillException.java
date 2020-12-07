////////////////////////////////////////////////////////////////////
// Andrea Breggion 1192760
////////////////////////////////////////////////////////////////////
package it.unipd.tos.business.exception;

public class TakeAwayBillException extends Throwable {
    String msg;
    public TakeAwayBillException(String message){
        msg=message;
    }
    public String getMsg()
    {
        return msg;
    }
}
