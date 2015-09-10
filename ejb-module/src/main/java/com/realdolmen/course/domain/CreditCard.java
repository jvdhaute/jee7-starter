package com.realdolmen.course.domain;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;



import java.io.Serializable;

/**
 * Created by JVDAX31 on 10/09/2015.
 */
@Embeddable
public class CreditCard implements Serializable{

    private String number;
    private String expiryDate;
    private Integer controlNumber;

    @Enumerated(EnumType.STRING)
    private CreditCardType creditCardType;



    public CreditCard(String number, String expiryDate, Integer controlNumber, CreditCardType creditCardType) {
        this.creditCardType = creditCardType;
        this.number = number;
        this.expiryDate = expiryDate;
        this.controlNumber = controlNumber;
    }

    protected CreditCard(){

    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public int getControlNumber() {
        return controlNumber;
    }

    public void setControlNumber(int controlNumber) {
        this.controlNumber = controlNumber;
    }

    public CreditCardType getCreditCardType() {
        return creditCardType;
    }

    public void setCreditCardType(CreditCardType creditCardType) {
        this.creditCardType = creditCardType;
    }

}
