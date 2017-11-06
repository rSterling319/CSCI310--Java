/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw5;

/**
 *
 * @author rs
 */
public class Transaction {
    Integer id;
    String user;
    Double amount;
    Transaction(Integer _id, String _user, Double _amount) {
        id =_id;
        user=_user;
        amount=_amount;
    }
    @Override 
    public String toString() {
        if(amount >= 0)
            return "transaction: id: "+id+" user: " + user + " deposit= $" + amount.toString();
        else
            return "transaction: id: "+id+" user: " + user + " withdrawal= " + "($"+amount.toString()+")";
    }
}

