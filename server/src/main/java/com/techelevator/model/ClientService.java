package com.techelevator.model;

import java.util.Objects;

public class ClientService {

    private int clientId;
    private int serviceId;

    public ClientService(int clientId, int serviceId) {
        this.clientId = clientId;
        this.serviceId = serviceId;
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

    @Override
    public String toString() {
        return "ClientService{" +
                "clientId=" + clientId +
                ", serviceId=" + serviceId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientService that = (ClientService) o;
        return clientId == that.clientId && serviceId == that.serviceId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientId, serviceId);
    }
}
