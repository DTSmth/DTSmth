package com.techelevator.model;

import java.util.Objects;

public class Client {

    private int clientId;
    private String name;
    private boolean hasPersonalCare;
    private boolean hasLifting;
    private String address1;
    private String address2;
    private String zipcode;
    private String phoneNumber;

    public Client(int clientId, String name, boolean hasPersonalCare, boolean hasLifting, String address1, String address2, String zipcode, String phoneNumber) {
        this.clientId = clientId;
        this.name = name;
        this.hasPersonalCare = hasPersonalCare;
        this.hasLifting = hasLifting;
        this.address1 = address1;
        this.address2 = address2;
        this.zipcode = zipcode;
        this.phoneNumber = phoneNumber;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isHasPersonalCare() {
        return hasPersonalCare;
    }

    public void setHasPersonalCare(boolean hasPersonalCare) {
        this.hasPersonalCare = hasPersonalCare;
    }

    public boolean isHasLifting() {
        return hasLifting;
    }

    public void setHasLifting(boolean hasLifting) {
        this.hasLifting = hasLifting;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientId=" + clientId +
                ", name='" + name + '\'' +
                ", hasPersonalCare=" + hasPersonalCare +
                ", hasLifting=" + hasLifting +
                ", address1='" + address1 + '\'' +
                ", address2='" + address2 + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return clientId == client.clientId && hasPersonalCare == client.hasPersonalCare && hasLifting == client.hasLifting && Objects.equals(name, client.name) && Objects.equals(address1, client.address1) && Objects.equals(address2, client.address2) && Objects.equals(zipcode, client.zipcode) && Objects.equals(phoneNumber, client.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientId, name, hasPersonalCare, hasLifting, address1, address2, zipcode, phoneNumber);
    }
}
