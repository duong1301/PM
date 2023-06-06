/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

/**
 *
 * @author LA
 */
public class testSet implements Comparable<testSet>{
    String data;

    public testSet() {
    }

    public testSet(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "testSet{" + "data=" + data + '}';
    }

   

    @Override
    public int compareTo(testSet o) {
        return this.data.compareTo(o.data);
    }
    
    
}
