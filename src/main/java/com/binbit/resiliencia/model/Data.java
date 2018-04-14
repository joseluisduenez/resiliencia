package com.binbit.resiliencia.model;

public class Data {
    private String subscription_status_name;

    public String getSubscription_status_name() {
        return subscription_status_name;
    }
    private String optin_origin_name;
    private Integer service_id;

    public String getOptin_origin_name() {
        return optin_origin_name;
    }

    public void setOptin_origin_name(String optin_origin_name) {
        this.optin_origin_name = optin_origin_name;
    }

    public Integer getService_id() {
        return service_id;
    }

    public void setService_id(Integer service_id) {
        this.service_id = service_id;
    }

    public void setSubscription_status_name(String subscription_status_name) {
        this.subscription_status_name = subscription_status_name;
    }
}
