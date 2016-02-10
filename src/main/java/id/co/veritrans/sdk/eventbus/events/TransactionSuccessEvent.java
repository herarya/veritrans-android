package id.co.veritrans.sdk.eventbus.events;

import id.co.veritrans.sdk.models.TransactionResponse;

/**
 * Payment Success Event.
 * @author rakawm
 */
public class TransactionSuccessEvent extends BaseSuccessEvent<TransactionResponse> {
    public TransactionSuccessEvent(TransactionResponse response) {
        super(response);
    }
}
