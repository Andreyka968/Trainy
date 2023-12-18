package com.example.computers;
import com.example.computerName.CyberNova;

public class Alla extends CyberNova {

    @Override
    public String toString() {
        return "Alla{} " + super.toString();
    }

    public Alla(String brand , String computerName , String computers , String system ,
                String type , String hascam) {
        super(brand , computerName , computers , system , type , hascam);
    }
}
