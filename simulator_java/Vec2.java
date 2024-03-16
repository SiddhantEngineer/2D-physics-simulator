/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simulator_java;

/**
 *
 * @author Siddhant
 */
public class Vec2 {
    float x;
    float y;

    public Vec2(float x, float y) {
        this.x = x;
        this.y = y;
    }
    public void set(float x, float y) {
        this.x = x;
        this.y = y;
    }
    public void add(Vec2 b){
        this.x += b.x;
        this.y += b.y;
    }
    public void sub(Vec2 b){
        this.x -= b.x;
        this.y -= b.y;
    }
    public void mul(float b){
        this.x *= b;
        this.y *= b;
    }
    public void div(float b){
        if(b == 0){
            return;
        }
        this.x /= b;
        this.y /= b;
    }
    public void equ(Vec2 b){
        this.x = b.x;
        this.y = b.y;
    }
}
