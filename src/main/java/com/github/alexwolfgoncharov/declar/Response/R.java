package com.github.alexwolfgoncharov.declar.Response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by alexwolf on 26.02.16.
 */

@XmlRootElement(name = "r")
@XmlAccessorType(XmlAccessType.FIELD)
public class R {

    @XmlElement(name = "O")
    private  List <ODeclar> oDeclars;

    public List<ODeclar> getoDeclars() {
        return oDeclars;
    }

    public void setoDeclars(List<ODeclar> oDeclars) {
        this.oDeclars = oDeclars;
    }

    @Override
    public String toString() {
        return "R{" +
                "oDeclars=" + oDeclars +
                '}';
    }
}
