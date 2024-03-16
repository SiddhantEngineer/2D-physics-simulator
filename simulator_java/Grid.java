/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simulator_java;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Siddhant
 */
public class Grid {
    int width;
    int height;
    int cellSize;
    int rows;
    int columns;
    ArrayList<Body> cell[][];

    public Grid(int width, int height, int cellSize) {
        setGrid(width, height, cellSize);
    }
    public void setGrid(int width, int height, int cellSize) {
        this.width = width;
        this.height = height;
        this.cellSize = cellSize;
        this.rows = width / cellSize + 1;
        this.columns = height / cellSize + 1;
        cell = new ArrayList[rows][columns];
        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                cell[i][j] = new ArrayList<>();
            }
        }
    }
    public void fillGrid(List<Body> bodies){
        int x1=0, y1=0, x2=0, y2=0;
        clearGrid();
        for (Body body : bodies) {
            
        }
    }
    public void clearGrid(){
        for (ArrayList<Body>[] arrayLists : cell) {
            for (ArrayList<Body> arrayList : arrayLists) {
                arrayList.clear();
            }
        }
    }
}
