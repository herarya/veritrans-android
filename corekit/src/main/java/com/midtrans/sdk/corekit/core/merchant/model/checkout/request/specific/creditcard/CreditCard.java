package com.midtrans.sdk.corekit.core.merchant.model.checkout.request.specific.creditcard;

import com.google.gson.annotations.SerializedName;

import android.support.annotation.NonNull;
import android.text.TextUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CreditCard implements Serializable {

    public static final String MIGS = "migs";
    public static final String AUTHENTICATION_TYPE_RBA = "rba";
    public static final String AUTHENTICATION_TYPE_3DS = "3ds";
    public static final String AUTHENTICATION_TYPE_NONE = "none";

    @Deprecated
    public static final String RBA = "rba";

    @SerializedName("save_card")
    private boolean saveCard;
    @SerializedName("token_id")
    private String tokenId;
    private boolean secure;
    private String channel;
    private String bank;
    @SerializedName("saved_tokens")
    private List<SavedToken> savedTokens;
    @SerializedName("whitelist_bins")
    private ArrayList<String> whitelistBins;

    @SerializedName("blacklist_bins")
    private List<String> blacklistBins;

    @SerializedName("installment")
    private Installment installment;
    private String type;
    private String authentication;

    private boolean isSecureSet = false;
    private boolean isAuthenticationSet = false;

    /**
     * Credit Card payment with oneclick, user must have User ID, automatic setter method
     */
    public void setOneClick() {
        setAuthentication(AUTHENTICATION_TYPE_3DS);
    }

    /**
     * Credit Card payment with two click, automatic setter method
     *
     * @param secure default is false
     */
    public void setTwoClick(@NonNull boolean secure) {
        setSecure(secure);
    }

    /**
     * Credit Card payment with normal step, automatic setter method
     *
     * @param secure         default is false
     * @param authentication 3DS / RBA / NONE
     */
    public void setNormal(@NonNull boolean secure,
                          String authentication) {
        setSecure(secure);
        setAuthentication(authentication);
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public boolean isSaveCard() {
        return saveCard;
    }

    public void setSaveCard(boolean saveCard) {
        this.saveCard = saveCard;
    }

    public boolean isSecure() {
        return secure;
    }

    public void setSecure(boolean secure) {
        if (authentication == null ||
                !(authentication.equals(AUTHENTICATION_TYPE_RBA)
                        || authentication.equals(AUTHENTICATION_TYPE_3DS)
                        || authentication.equals(AUTHENTICATION_TYPE_NONE))) {
            if (!isSecureSet) {
                this.secure = secure;
                isSecureSet = true;
            }
        }
    }

    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }

    public List<SavedToken> getSavedTokens() {
        return savedTokens;
    }

    public void setSavedTokens(List<SavedToken> savedTokens) {
        this.savedTokens = savedTokens;
    }

    public ArrayList<String> getWhitelistBins() {
        return whitelistBins;
    }

    public Installment getInstallment() {
        return installment;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setInstallment(Installment installment) {
        this.installment = installment;
    }

    public void setWhiteListBins(ArrayList<String> whiteListBins) {
        this.whitelistBins = whiteListBins;
    }

    public String getAuthentication() {
        return authentication;
    }

    public void setAuthentication(String authentication) {
        if (!TextUtils.isEmpty(authentication)) {
            if (authentication.equals(AUTHENTICATION_TYPE_RBA)
                    || authentication.equals(AUTHENTICATION_TYPE_NONE)) {
                this.secure = false;
            } else if (authentication.equals(AUTHENTICATION_TYPE_3DS)) {
                this.secure = true;
            }
        }
        if (!isAuthenticationSet) {
            this.authentication = authentication;
            isAuthenticationSet = true;
        }
    }

    public List<String> getBlacklistBins() {
        return blacklistBins;
    }

    public void setBlacklistBins(List<String> blacklistBins) {
        this.blacklistBins = blacklistBins;
    }
}