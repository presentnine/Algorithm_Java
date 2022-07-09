package com.algorithm;

import java.util.ArrayList;

public class 카카오_여름_인턴_2022_5 {
    
}

class Solution_카카오_여름_인턴_2022_5 {
    int rowLength, colLength;
    int[][] matrix;

    public int[][] solution(int[][] rc, String[] operations) {
        rowLength = rc.length;
        colLength = rc[0].length;
        matrix = new int[rowLength][colLength];

        for (int i = 0; i < rowLength; i++) {
            System.arraycopy(rc[i], 0, matrix[i], 0, colLength);
        }

        ArrayList<Pair> newOps = new ArrayList<>();
        newOps.add(new Pair(operations[0], 1));

        for (int i = 1; i < operations.length; i++) {
            String lastOp = newOps.get(newOps.size() - 1).op;

            if (operations[i].equals(lastOp)) {
                ++newOps.get(newOps.size() - 1).time;
            } else {
                newOps.add(new Pair(operations[i], 1));
            }
        }

        for (int i = 0; i < newOps.size(); i++) {
            Pair newOp = newOps.get(i);

            if (newOp.op.equals("Rotate")) {
                for (int j = 0; j < newOp.time; j++) {
                    rotate();
                }
            } else {
                shiftRow(newOp.time);
            }
        }

        return matrix;
    }

    void rotate() {
//        time = time % (2 * (rowLength - 1) + 2 * (colLength - 1));

        int corner1 = matrix[0][0], corner2 = matrix[0][colLength - 1]
                , corner3 = matrix[rowLength - 1][colLength - 1], corner4 = matrix[rowLength - 1][0];

        for (int i = colLength - 2; i >=1; i--) {
            matrix[0][i + 1] = matrix[0][i];
        }
        matrix[0][1] = corner1;

        for (int i = rowLength - 2; i >= 1; i--) {
            matrix[i + 1][colLength - 1] = matrix[i][colLength - 1];
        }
        matrix[1][colLength - 1] = corner2;

        for (int i = 1; i < colLength - 1; i++) {
            matrix[rowLength - 1][i - 1] = matrix[rowLength - 1][i];
        }
        matrix[rowLength - 1][colLength - 2] = corner3;

        for (int i = 1; i < rowLength - 1; i++) {
            matrix[i - 1][0] = matrix[i][0];
        }
        matrix[rowLength - 2][0] = corner4;
    }

    void shiftRow(int time) {
        time = time % rowLength;
        int[][] temp = new int[rowLength][colLength];

        for (int i = 0; i < rowLength; i++) {
            System.arraycopy(matrix[i], 0, temp[(i + time) % rowLength], 0, colLength);
        }

        matrix = temp;
    }

    class Pair{
        String op;
        int time;

        public Pair(String op, int time) {
            this.op = op;
            this.time = time;
        }
    }
}
