package com.babykeeper.babykeeper.model;

public class SimulationResponse {
    private boolean isThereChildrenInTheCar;
    private String picUrl;

    public SimulationResponse(boolean isThereChildrenInTheCar, String picUrl) {
        this.isThereChildrenInTheCar = isThereChildrenInTheCar;
        this.picUrl = picUrl;
    }

    public boolean isThereChildrenInTheCar() {
        return isThereChildrenInTheCar;
    }

    public void setThereChildrenInTheCar(boolean thereChildrenInTheCar) {
        isThereChildrenInTheCar = thereChildrenInTheCar;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }
}
