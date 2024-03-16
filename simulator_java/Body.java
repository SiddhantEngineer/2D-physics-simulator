/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simulator_java;

import java.awt.Color;
import java.util.Random;

/**
 *
 * @author Siddhant
 */
public class Body {
    Vec2 position;
    Vec2 prevPosition = new Vec2(0, 0);
    Vec2 velocity;
    Vec2 accel;
    Vec2 size;
    Color color;
    int cellX;
    int cellY;

    public Body(Vec2 position, Vec2 size, Color color) {
        this.position = position;
        this.prevPosition.equ(position);
        this.size = size;
        this.color = color;
        this.velocity = new Vec2(0, 0);
        this.accel = new Vec2(16000/size.x, 0);
    }
}
