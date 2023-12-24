package com.example.computers;
import com.example.computerName.CyberNova;

public class Alla extends CyberNova {

    @Override
    public String toString() {
        return "Alla{}" + super.toString();
    }

    public Alla(int id , String brand , String computerName , String computers , String system ,
                String type , int hascam) {
        super(id , brand , computerName , computers , system , type , hascam );
    }
}
