/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartlearner.email.analytics;

import java.awt.Point;
import java.util.HashMap;
import javax.mail.Message;

/**
 *
 * @author sony
 */
public class ArrayStructure {
private HashMap<Point, String> map = new HashMap<Point, String>();
private int maxRow = 0;
private int maxColumn = 0;

public ArrayStructure() {
    }

    public void add(int row, int column, String string) {
        map.put(new Point(row, column), string);
        maxRow = Math.max(row, maxRow);
        maxColumn = Math.max(column, maxColumn);
    }

    public String[][] toArray() {
        String[][] result = new String[maxRow + 1][maxColumn + 1];
        for (int row = 0; row <= maxRow; ++row)
            for (int column = 0; column <= maxColumn; ++column) {
                Point p = new Point(row, column);
                result[row][column] = map.containsKey(p) ? map.get(p) : "";
            }
        return result;
    }

    void add(Message[] msg, Message[] msg0, String frm) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
