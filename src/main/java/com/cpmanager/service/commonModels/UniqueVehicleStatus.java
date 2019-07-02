package com.cpmanager.service.commonModels;

public class UniqueVehicleStatus {
    int http_status;
    boolean exists;

    public UniqueVehicleStatus(int http_status, boolean exists) {
        this.http_status = http_status;
        this.exists = exists;
    }

    public int getHttp_status() {
        return http_status;
    }

    public void setHttp_status(int http_status) {
        this.http_status = http_status;
    }

    public boolean isExists() {
        return exists;
    }

    public void setExists(boolean exists) {
        this.exists = exists;
    }
}
