/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package entities;



/**
 *
 * @author LA
 */
public enum Price {
    CAR(10000),
    MOTORBIKE(3000),
    BIKECYCLE(2000);
    
    int price;
    private Price(int price) {
        this.price = price;
    }

    

    public int getPrice() {
        return price;
    }
    
    
}
