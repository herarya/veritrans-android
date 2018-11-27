package com.midtrans.sdk.corekit.core.snap.model.transaction.response.promo;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Promo implements Cloneable, Serializable {

    @SerializedName("id")
    private long id;

    @SerializedName("name")
    private String name;

    @SerializedName("bins")
    private List<String> bins;

    @SerializedName("payment_types")
    private List<String> paymentTypes;

    @SerializedName("calculated_discount_amount")
    private double calculatedDiscountAmount;

    @SerializedName("discounted_gross_amount")
    private double discountedGrossAmount;

    @SerializedName("discount_type")
    private String discountType;

    @SerializedName("start_date")
    private String startDate;

    @SerializedName("end_date")
    private String endDate;

    @SerializedName("promo_code")
    private String promoCode;

    @SerializedName("sponsor_name")
    private String sponsorName;

    @SerializedName("sponsor_message_en")
    private String sponsorMessageEn;

    @SerializedName("sponsor_message_id")
    private String sponsorMessageId;

    @SerializedName("promo_token")
    private String promoToken;
    private boolean selected;

    public long getId() {
        return id;
    }

    public List<String> getBins() {
        return bins;
    }

    public String getDiscountType() {
        return discountType;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getPromoCode() {
        return promoCode;
    }

    public String getSponsorName() {
        return sponsorName;
    }

    public String getSponsorMessageEn() {
        return sponsorMessageEn;
    }

    public String getSponsorMessageId() {
        return sponsorMessageId;
    }

    public String getPromoToken() {
        return promoToken;
    }

    public List<String> getPaymentTypes() {
        return paymentTypes;
    }

    public String getName() {
        return name;
    }

    public double getCalculatedDiscountAmount() {
        return calculatedDiscountAmount;
    }

    public double getDiscountedGrossAmount() {
        return discountedGrossAmount;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}