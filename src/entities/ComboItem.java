/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author LA
 */
public class ComboItem {
    String key;
    String val;

    public ComboItem(String key, String val) {
        this.key = key;
        this.val = val;
    }

    public ComboItem() {
    }

    @Override
    public String toString() {
        return this.val;
    }
    
    
}
