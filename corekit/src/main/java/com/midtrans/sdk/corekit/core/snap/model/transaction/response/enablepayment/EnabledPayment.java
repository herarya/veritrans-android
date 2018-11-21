package com.midtrans.sdk.corekit.core.snap.model.transaction.response.enablepayment;

import java.io.Serializable;

public class EnabledPayment implements Serializable {

    public static final String STATUS_UP = "up";
    public static final String STATUS_DOWN = "down";

    private String type;
    private String category;
    private String status;

    public EnabledPayment(String type, String category) {
        this.type = type;
        this.category = category;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}