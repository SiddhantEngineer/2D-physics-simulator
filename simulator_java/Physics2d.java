/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simulator_java;

import java.util.ArrayList;
import java.util.List;
import javax.swing.Action;

/**
 *
 * @author Siddhant
 */
public class Physics2d {
    Vec2 gravity = new Vec2(0, 10);
    Vec2 v = new Vec2(0, 0);
    float dist;
    float minDist;
    float dt = 0.001f;
    float dtt = 0.05f;
    int x=0;
    int y=0;
    Grid grid = new Grid(x, y, 10);
    int cellSize;
    ArrayList<Body> arrayList;
    int gridSize[] = new int[4];
    
    public void setSize(int x, int y, int bodySize){
        this.x = x;
        this.y = y-25;
        this.cellSize = bodySize * 4;
        grid.setGrid(x, y, cellSize);
    }
    public void setDt(float dt){
        this.dt = dtt;
        this.dt *= dt;
    }
    public void UpdateAll(List<Body> bodies){
        int x1,y1;
        grid.clearGrid();
        for (Body body : bodies) {
            Update(body);
//            for(int i=-1; i<2; i++){
//                for(int j=-1; j<2; j++){
                    x1 = (int)((body.position.x + body.size.x) / cellSize);
                    y1 = (int)((body.position.y + body.size.x) / cellSize);
                    if(y1>=0 && y1<grid.columns && x1>=0 && x1<grid.rows){
                        if(!grid.cell[x1][y1].contains(body)){
                            grid.cell[x1][y1].add(body);
                            body.cellX = x1;
                            body.cellY = y1;
                        }
                    }
//                }
//            }
        }
        gridCollisionByBody(bodies);
//        gridCollisionByGrid(bodies);
    }
    public void Update(Body a){
        Constrain(a);
        a.velocity.equ(VectorMath.sub(a.position, a.prevPosition));
        a.prevPosition.equ(a.position);
        a.accel.add(gravity);
        a.accel.mul(dt);
        a.velocity.add(a.accel);
        a.position.add(a.velocity);
        a.accel.set(0, 0);
    }
    public void Constrain(Body a){
        float temp = 0;
        if (a.position.y + a.size.x > y)
            {
                temp = a.position.y;
                a.position.y = a.prevPosition.y + (y - a.prevPosition.y - a.size.x) * 0.99f;
                a.prevPosition.y = temp;
            }
            if (a.position.y - a.size.x < 0)
            {
                temp = a.position.y;
                a.position.y = a.prevPosition.y - (a.prevPosition.y - a.size.x) * 0.9f;
                a.prevPosition.y = temp;
            }
            if (a.position.x + a.size.x > x)
            {
                temp = a.position.x;
                a.position.x = a.prevPosition.x - (a.prevPosition.x + a.size.x - x) * 0.9f;
                a.prevPosition.x = temp;
            }
            if (a.position.x - a.size.x < 0)
            {
                temp = a.position.x;
                a.position.x = a.prevPosition.x - (a.prevPosition.x - a.size.x) * 0.9f;
                a.prevPosition.x = temp;
            }
    }
    public void bruteForceCollision(List<Body> bodies){
        for (Body bodyA : bodies) {
            for (Body bodyB : bodies) {
                if(bodyA != bodyB){
                    checkCollisions(bodyA, bodyB);
                }
            }
        }
    }
    
    public void gridCollisionByGrid(List<Body> bodies){
        for(int i=1; i<grid.rows-1; i++){
            for(int j=1; j<grid.columns-1; j++){
                for(int a=-1; a<2; a++){
                    for(int b=-1; b<2; b++){
                        arrayList = grid.cell[i+a][j+b];
                        for(Body bodyA: arrayList){
                            for(Body bodyB: arrayList){
                                if(bodyA != bodyB){
                                    checkCollisions(bodyA, bodyB);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    
    public void gridCollisionByBody(List<Body> bodies){
        int cellX, cellY, dx, dy;
        int rows = grid.rows;
        int cols = grid.columns;
        for (Body body : bodies) {
            cellX = body.cellX;
            cellY = body.cellY;
            for(int i=-1; i<2; i++){
                for(int j=-1; j<2; j++){
                    dx = cellX+i;
                    dy = cellY+j;
                    if(dx>=0 && dx<rows && dy>=0 && dy<cols){
                        arrayList = grid.cell[dx][dy];
                        for (Body body1 : arrayList) {
                            if(body != body1){
                                checkCollisions(body, body1);
                            }
                        }
                    }
                }
            }
        }
    }
    public void checkCollisions(Body a, Body b)
        {
            v.equ(VectorMath.sub(a.position,b.position));
            dist = (v.x * v.x) + (v.y * v.y);
            minDist = a.size.x + b.size.x;
            if (dist < minDist * minDist)
            {
                dist = (float)Math.sqrt(dist);
                v.div(dist);
                dist -= minDist;
                v.mul(0.25f * (dist));
                b.position.add(v);
                a.position.sub(v);
            }
        }
}