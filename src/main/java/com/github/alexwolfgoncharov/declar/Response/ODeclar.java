package com.github.alexwolfgoncharov.declar.Response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by alexwolf on 26.02.16.
 */
@XmlRootElement(name = "O")
@XmlAccessorType(XmlAccessType.FIELD)
public class ODeclar {


    @XmlAttribute(name = "CURR")
    private String CURR;

    @XmlAttribute(name = "OSTATOK")
    private String OSTATOK;

    @XmlAttribute(name = "OSTATOK_EQ")
    private String OSTATOK_EQ;

    @XmlAttribute(name = "REF")
    private String REF;

    @XmlAttribute(name = "TYPE")
    private String TYPE;

    @XmlAttribute(name = "NALOG")
    private String NALOG;

    @XmlAttribute(name = "NALOG_EQ")
    private String NALOG_EQ;

    @XmlAttribute(name = "VOEN_SBOR")
    private String VOEN_SBOR;

    @XmlAttribute(name = "VOEN_SBOR_EQ")
    private String VOEN_SBOR_EQ;

    @XmlAttribute(name = "CLIENT_MONEY")
    private String  CLIENT_MONEY;

    @XmlAttribute(name = "CLIENT_MONEY_EQ")
    private String CLIENT_MONEY_EQ;

    @XmlAttribute(name = "NACH_PROC")
    private String NACH_PROC;

    @XmlAttribute(name = "NACH_PROC_EQ")
    private String NACH_PROC_EQ;

    @XmlAttribute(name = "ZACH_PROC")
    private String  ZACH_PROC;

    @XmlAttribute(name = "ZACH_PROC_EQ")
    private String  ZACH_PROC_EQ;
    
    @XmlAttribute(name = "CRED_LIM")
    private String CRED_LIM;

    @XmlAttribute(name = "DOLG")
    private String DOLG;

    @XmlAttribute(name = "DOLG_EQ")
    private String DOLG_EQ;

    @XmlAttribute(name = "DOLG_POGASH")
    private String  DOLG_POGASH;

    @XmlAttribute(name = "DOLG_POGASH_EQ")
    private String  DOLG_POGASH_EQ;

    @XmlAttribute(name = "PROC_POGASH")
    private String  PROC_POGASH;

    @XmlAttribute(name = "PROC_POGASH_EQ")
    private String  PROC_POGASH_EQ;

    public String getCURR() {
        return CURR;
    }

    public void setCURR(String CURR) {
        this.CURR = CURR;
    }

    public String getOSTATOK() {
        return OSTATOK;
    }

    public void setOSTATOK(String OSTATOK) {
        this.OSTATOK = OSTATOK;
    }

    public String getOSTATOK_EQ() {
        return OSTATOK_EQ;
    }

    public void setOSTATOK_EQ(String OSTATOK_EQ) {
        this.OSTATOK_EQ = OSTATOK_EQ;
    }

    public String getREF() {
        return REF;
    }

    public void setREF(String REF) {
        this.REF = REF;
    }

    public String getTYPE() {
        return TYPE;
    }

    public void setTYPE(String TYPE) {
        this.TYPE = TYPE;
    }

    public String getNALOG() {
        return NALOG;
    }

    public void setNALOG(String NALOG) {
        this.NALOG = NALOG;
    }

    public String getNALOG_EQ() {
        return NALOG_EQ;
    }

    public void setNALOG_EQ(String NALOG_EQ) {
        this.NALOG_EQ = NALOG_EQ;
    }

    public String getVOEN_SBOR() {
        return VOEN_SBOR;
    }

    public void setVOEN_SBOR(String VOEN_SBOR) {
        this.VOEN_SBOR = VOEN_SBOR;
    }

    public String getVOEN_SBOR_EQ() {
        return VOEN_SBOR_EQ;
    }

    public void setVOEN_SBOR_EQ(String VOEN_SBOR_EQ) {
        this.VOEN_SBOR_EQ = VOEN_SBOR_EQ;
    }

    public String getCLIENT_MONEY() {
        return CLIENT_MONEY;
    }

    public void setCLIENT_MONEY(String CLIENT_MONEY) {
        this.CLIENT_MONEY = CLIENT_MONEY;
    }

    public String getCLIENT_MONEY_EQ() {
        return CLIENT_MONEY_EQ;
    }

    public void setCLIENT_MONEY_EQ(String CLIENT_MONEY_EQ) {
        this.CLIENT_MONEY_EQ = CLIENT_MONEY_EQ;
    }

    public String getNACH_PROC() {
        return NACH_PROC;
    }

    public void setNACH_PROC(String NACH_PROC) {
        this.NACH_PROC = NACH_PROC;
    }

    public String getNACH_PROC_EQ() {
        return NACH_PROC_EQ;
    }

    public void setNACH_PROC_EQ(String NACH_PROC_EQ) {
        this.NACH_PROC_EQ = NACH_PROC_EQ;
    }

    public String getZACH_PROC() {
        return ZACH_PROC;
    }

    public void setZACH_PROC(String ZACH_PROC) {
        this.ZACH_PROC = ZACH_PROC;
    }

    public String getZACH_PROC_EQ() {
        return ZACH_PROC_EQ;
    }

    public void setZACH_PROC_EQ(String ZACH_PROC_EQ) {
        this.ZACH_PROC_EQ = ZACH_PROC_EQ;
    }

    public String getCRED_LIM() {
        return CRED_LIM;
    }

    public void setCRED_LIM(String CRED_LIM) {
        this.CRED_LIM = CRED_LIM;
    }

    public String getDOLG() {
        return DOLG;
    }

    public void setDOLG(String DOLG) {
        this.DOLG = DOLG;
    }

    public String getDOLG_EQ() {
        return DOLG_EQ;
    }

    public void setDOLG_EQ(String DOLG_EQ) {
        this.DOLG_EQ = DOLG_EQ;
    }

    public String getDOLG_POGASH() {
        return DOLG_POGASH;
    }

    public void setDOLG_POGASH(String DOLG_POGASH) {
        this.DOLG_POGASH = DOLG_POGASH;
    }

    public String getDOLG_POGASH_EQ() {
        return DOLG_POGASH_EQ;
    }

    public void setDOLG_POGASH_EQ(String DOLG_POGASH_EQ) {
        this.DOLG_POGASH_EQ = DOLG_POGASH_EQ;
    }

    public String getPROC_POGASH() {
        return PROC_POGASH;
    }

    public void setPROC_POGASH(String PROC_POGASH) {
        this.PROC_POGASH = PROC_POGASH;
    }

    public String getPROC_POGASH_EQ() {
        return PROC_POGASH_EQ;
    }

    public void setPROC_POGASH_EQ(String PROC_POGASH_EQ) {
        this.PROC_POGASH_EQ = PROC_POGASH_EQ;
    }

    @Override
    public String toString() {
        return "ODeclar{" +
                "CURR='" + CURR + '\'' +
                ", OSTATOK='" + OSTATOK + '\'' +
                ", OSTATOK_EQ='" + OSTATOK_EQ + '\'' +
                ", REF='" + REF + '\'' +
                ", TYPE='" + TYPE + '\'' +
                ", NALOG='" + NALOG + '\'' +
                ", NALOG_EQ='" + NALOG_EQ + '\'' +
                ", VOEN_SBOR='" + VOEN_SBOR + '\'' +
                ", VOEN_SBOR_EQ='" + VOEN_SBOR_EQ + '\'' +
                ", CLIENT_MONEY='" + CLIENT_MONEY + '\'' +
                ", CLIENT_MONEY_EQ='" + CLIENT_MONEY_EQ + '\'' +
                ", NACH_PROC='" + NACH_PROC + '\'' +
                ", NACH_PROC_EQ='" + NACH_PROC_EQ + '\'' +
                ", ZACH_PROC='" + ZACH_PROC + '\'' +
                ", ZACH_PROC_EQ='" + ZACH_PROC_EQ + '\'' +
                ", CRED_LIM='" + CRED_LIM + '\'' +
                ", DOLG='" + DOLG + '\'' +
                ", DOLG_EQ='" + DOLG_EQ + '\'' +
                ", DOLG_POGASH='" + DOLG_POGASH + '\'' +
                ", DOLG_POGASH_EQ='" + DOLG_POGASH_EQ + '\'' +
                ", PROC_POGASH='" + PROC_POGASH + '\'' +
                ", PROC_POGASH_EQ='" + PROC_POGASH_EQ + '\'' +
                '}';
    }
}
