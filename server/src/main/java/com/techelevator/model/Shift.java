package com.techelevator.model;

import java.util.Objects;

public class Shift {

    private int shiftId;
    private int clientId;
    private int serviceId;
    private int totalHours;
    private String zipcode;
    private boolean isAvailable;
    private String firstName;
    private String lastName;
    private String serviceName;


    public Shift(int shiftId, int clientId, int serviceId, int totalHours, String zipcode, boolean isAvailable, String firstName, String lastName, String serviceName) {
        this.shiftId = shiftId;
        this.clientId = clientId;
        this.serviceId = serviceId;
        this.totalHours = totalHours;
        this.zipcode = zipcode;
        this.isAvailable = isAvailable;
        this.firstName = firstName;
        this.lastName = lastName;
        this.serviceName = serviceName;
    }

    public int getShiftId() {
        return shiftId;
    }

    public void setShiftId(int shiftId) {
        this.shiftId = shiftId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public int getTotalHours() {
        return totalHours;
    }

    public void setTotalHours(int totalHours) {
        this.totalHours = totalHours;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    @Override
    public String toString() {
        return "Shift{" +
                "shiftId=" + shiftId +
                ", clientId=" + clientId +
                ", serviceId=" + serviceId +
                ", totalHours=" + totalHours +
                ", zipcode='" + zipcode + '\'' +
                ", isAvailable=" + isAvailable +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", serviceName='" + serviceName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shift shift = (Shift) o;
        return shiftId == shift.shiftId && clientId == shift.clientId && serviceId == shift.serviceId && totalHours == shift.totalHours && isAvailable == shift.isAvailable && Objects.equals(zipcode, shift.zipcode) && Objects.equals(firstName, shift.firstName) && Objects.equals(lastName, shift.lastName) && Objects.equals(serviceName, shift.serviceName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shiftId, clientId, serviceId, totalHours, zipcode, isAvailable, firstName, lastName, serviceName);
    }
}
