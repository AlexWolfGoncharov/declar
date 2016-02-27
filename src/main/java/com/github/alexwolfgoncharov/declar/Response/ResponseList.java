package com.github.alexwolfgoncharov.declar.Response;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by alexwolf on 26.02.16.
 */
@XmlRootElement( name = "doc" )
public class ResponseList {
    private R r;

    public R getR ()
    {
        return r;
    }

    public void setR (R r)
    {
        this.r = r;
    }


    @Override
    public String toString() {
        return "ResponseList{" +
                "r=" + r +
                '}';
    }
}
