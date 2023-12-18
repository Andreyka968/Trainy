package com.example.computers;

import com.example.computerName.NexusWave;

public class Father extends NexusWave {
    public Father(String brand , String computerName , String computers , String system , String type , Integer hascam) {
        super(brand , computerName , computers , system , type , String.valueOf(Integer.valueOf(hascam)));
    }
}
