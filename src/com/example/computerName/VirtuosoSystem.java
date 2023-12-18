package com.example.computerName;

import com.example.Computer;

public class VirtuosoSystem extends Computer {
    @Override
    public String toString() {
        return "VirtuosoSystem{} " + super.toString();
    }

    public VirtuosoSystem(String brand , String computerName , String computers , String system , String type , String hascam) {
        super(brand , computerName , computers , system , type , Integer.valueOf(hascam));
    }

    @Override
    public String getBrand() {
        return super.getBrand();
    }

    @Override
    public void setBrand() {
        super.setBrand();
    }

    @Override
    public String getComputerName() {
        return super.getComputerName();
    }

    @Override
    public void setComputerName(String computerName) {
        super.setComputerName(computerName);
    }

    @Override
    public String getComputers() {
        return super.getComputers();
    }

    @Override
    public void setComputers(String computers) {
        super.setComputers(computers);
    }

    @Override
    public String getSystem() {
        return super.getSystem();
    }

    @Override
    public void setSystem(String system) {
        super.setSystem(system);
    }

    @Override
    public String getType() {
        return super.getType();
    }

    @Override
    public void setType(String type) {
        super.setType(type);
    }

    @Override
    public Integer getHascam() {
        return super.getHascam();
    }

    @Override
    public void setHascam(Integer hascam) {
        super.setHascam(hascam);
    }
}
