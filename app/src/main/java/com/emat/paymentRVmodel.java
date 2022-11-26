package com.emat;

import android.os.Parcel;
import android.os.Parcelable;

public class paymentRVmodel implements Parcelable {
    private int Amount;
    public paymentRVmodel(){

    }

    public paymentRVmodel(int amount) {
        Amount = amount;
    }

    protected paymentRVmodel(Parcel in) {
        Amount = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(Amount);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<paymentRVmodel> CREATOR = new Creator<paymentRVmodel>() {
        @Override
        public paymentRVmodel createFromParcel(Parcel in) {
            return new paymentRVmodel(in);
        }

        @Override
        public paymentRVmodel[] newArray(int size) {
            return new paymentRVmodel[size];
        }
    };

    public int getAmount() {
        return Amount;
    }

    public void setAmount(int amount) {
        Amount = amount;
    }
}
