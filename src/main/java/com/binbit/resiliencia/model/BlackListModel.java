package com.binbit.resiliencia.model;

import java.util.List;

public class BlackListModel {
    private List msisdn;
    private Integer mccMnc;

    public List getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(List msisdn) {
        this.msisdn = msisdn;
    }

    public Integer getMccMnc() {
        return mccMnc;
    }

    public void setMccMnc(Integer mccMnc) {
        this.mccMnc = mccMnc;
    }
}
