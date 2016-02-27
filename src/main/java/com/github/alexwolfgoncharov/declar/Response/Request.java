package com.github.alexwolfgoncharov.declar.Response;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by alexwolf on 26.02.16.
 */

@XmlRootElement(name="doc")
public class Request {

    private String SID;
    private String INN;
    private String DateFrom;
    private String DateTo;


    public String getSID() {
        return SID;
    }

    public void setSID(String SID) {
        this.SID = SID;
    }

    public String getINN() {
        return INN;
    }

    public void setINN(String INN) {
        this.INN = INN;
    }

    public String getDateFrom() {
        return DateFrom;
    }

    public void setDateFrom(String dateFrom) {
        DateFrom = dateFrom;
    }

    public String getDateTo() {
        return DateTo;
    }

    public void setDateTo(String dateTo) {
        DateTo = dateTo;
    }
}


