/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simulator_java;

/**
 *
 * @author Siddhant
 */
public class VectorMath {
    public static Vec2 add(Vec2 a, Vec2 b){
        return new Vec2(a.x + b.x, a.y + b.y);
    }
    public static Vec2 sub(Vec2 a, Vec2 b){
        return new Vec2(a.x - b.x, a.y - b.y);
    }
}
