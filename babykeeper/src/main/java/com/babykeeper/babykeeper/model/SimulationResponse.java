package com.babykeeper.babykeeper.model;

public class SimulationResponse {
    private boolean isThereChildrenInTheCar;

    public SimulationResponse(boolean isThereChildrenInTheCar) {
        this.isThereChildrenInTheCar = isThereChildrenInTheCar;
    }

    public boolean isThereChildrenInTheCar() {
        return isThereChildrenInTheCar;
    }

    public void setThereChildrenInTheCar(boolean thereChildrenInTheCar) {
        isThereChildrenInTheCar = thereChildrenInTheCar;
    }
}
