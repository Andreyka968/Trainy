package com.example;

public abstract class Computer {
    private String brand;
    private  String computerName;
    private String computers;
    private String system;
    private  String type;
    private Integer hascam;

    public String getBrand() {
        return brand;
    }

    public void setBrand() {
        this.brand = brand;
    }

    public String getComputerName() {
        return computerName;
    }

    public void setComputerName(String computerName) {
        this.computerName = computerName;
    }

    public String getComputers() {
        return computers;
    }

    public void setComputers(String computers) {
        this.computers = computers;
    }

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getHascam() {
        return hascam;
    }

    public void setHascam(Integer hascam) {
        this.hascam = hascam;
    }

    @Override
    public String toString() {
        return "Computer{" +
                ", computers='" + computers + '\'' +
                ", computerName='" + computerName + '\'' +
                ", type='" + type + '\'' +
                ", system='" + system + '\'' +
                "brand='" + brand + '\'' +
                ", hascam=" + hascam +
                '}';
    }

    public Computer(String brand , String computerName , String computers , String system , String type , Integer hascam) {
        this.computers = computers;
        this.computerName = computerName;
        this.type = type;
        this.system = system;
        this.brand = brand;
        this.hascam = hascam;

    }
}
