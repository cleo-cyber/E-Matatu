package com.emat;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class UserRVmodel implements Parcelable {
    private String name;
    private String email;
    private int PhoneNumber;
    private String Destination;
    private String PickUpPoint;


    public UserRVmodel(String name, String email, int phoneNumber, String destination, String pickUpPoint) {
        this.name = name;
        this.email = email;
        this.PhoneNumber = phoneNumber;
        this.Destination = destination;
        this.PickUpPoint = pickUpPoint;
    }

    protected UserRVmodel(Parcel in) {
        name = in.readString();
        email = in.readString();
        PhoneNumber = in.readInt();
        Destination = in.readString();
        PickUpPoint = in.readString();
    }

    public static final Creator<UserRVmodel> CREATOR = new Creator<UserRVmodel>() {
        @Override
        public UserRVmodel createFromParcel(Parcel in) {
            return new UserRVmodel(in);
        }

        @Override
        public UserRVmodel[] newArray(int size) {
            return new UserRVmodel[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getDestination() {
        return Destination;
    }

    public void setDestination(String destination) {
        Destination = destination;
    }

    public String getPickUpPoint() {
        return PickUpPoint;
    }

    public void setPickUpPoint(String pickUpPoint) {
        PickUpPoint = pickUpPoint;
    }

    public UserRVmodel(){

    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(email);
        dest.writeInt(PhoneNumber);
        dest.writeString(Destination);
        dest.writeString(PickUpPoint);
    }
}
