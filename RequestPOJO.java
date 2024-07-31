package com.bezkoder.spring.mssql.controller;

public class RequestPOJO {
	private int retryCnt;
    private int digital1;
    private int digital2;
    private int digital3;

    // getter, setter for name & number
    public int getRetryCnt() {
        return retryCnt;
      }

    public void setRetryCnt(int retryCnt) {
        this.retryCnt = retryCnt;
    }
    public int getDigital1() {
        return digital1;
      }

    public void setDigital1(int digital1) {
        this.digital1 = digital1;
    }
    
    public int getDigital2() {
        return digital2;
      }

    public void setDigital2(int digital2) {
        this.digital2 = digital2;
    }
    
    public int getDigital3() {
        return digital3;
      }

    public void setDigital3(int digital3) {
        this.digital3 = digital3;
    }
}
