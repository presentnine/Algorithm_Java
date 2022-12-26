package com.algorithm;

import java.util.ArrayList;

public class 카카오_2022_하반기_5 {
    public static void main(String[] args) {
        Solution_카카오_2022_하반기_5 s = new Solution_카카오_2022_하반기_5();

        String[] commands = {"UPDATE 1 1 a", "UPDATE 1 2 b", "UPDATE 2 1 c", "UPDATE 2 2 d", "MERGE 1 1 1 2", "MERGE 2 2 2 1", "MERGE 2 1 1 1", "PRINT 1 1", "UNMERGE 2 2", "PRINT 1 1"};

        s.solution(commands);
    }
}

class Solution_카카오_2022_하반기_5 {
    String[][] cell = new String[51][51];
    Infor[][] par = new Infor[51][51];

    public String[] solution(String[] commands) {
        ArrayList<String> answer = new ArrayList<>();

        for (int i = 1; i < 51; i++) {//초기화
            for (int j = 1; j < 51; j++) {
                par[i][j] = new Infor(i, j);
                cell[i][j] = "";
            }
        }

        for (int i = 0; i < commands.length; i++) {
            String[] s = commands[i].split(" ");

            if (s[0].equals("UPDATE")) {
                if (s.length == 4) {
                    update1(Integer.parseInt(s[1]), Integer.parseInt(s[2]), s[3]);
                } else {
                    update2(s[1], s[2]);
                }
            } else if (s[0].equals("MERGE")) {
                merge(Integer.parseInt(s[1]), Integer.parseInt(s[2]), Integer.parseInt(s[3]), Integer.parseInt(s[4]));
            } else if (s[0].equals("UNMERGE")) {
                unmerge(Integer.parseInt(s[1]), Integer.parseInt(s[2]));
            } else {
                Infor par = getPar(Integer.parseInt(s[1]), Integer.parseInt(s[2]));

                if (cell[par.parentR][par.parentC].equals("")) {
                    answer.add("EMPTY");
                } else {
                    answer.add(cell[par.parentR][par.parentC]);
                }
            }
        }

        return answer.toArray(new String[0]);
    }

    void update1(int r, int c, String value) {
        Infor par1 = getPar(r, c);

        for (int i = 1; i < 51; i++) {
            for (int j = 1; j < 51; j++) {
                Infor par2 = getPar(i, j);

                if (par1.parentR == par2.parentR && par1.parentC == par2.parentC) {
                    cell[i][j] = value;
                }
            }
        }
    }

    void update2(String value1, String value2) {
        for (int i = 1; i < 51; i++) {
            for (int j = 1; j < 51; j++) {
                Infor par = getPar(i, j);

                if (cell[par.parentR][par.parentC].equals(value1)) {
                    cell[i][j] = value2;
                }
            }
        }
    }

    void merge(int r1, int c1, int r2, int c2) {
        String s;
        Infor par1 = getPar(r1, c1);
        Infor par2 = getPar(r2, c2);

        if (!cell[par1.parentR][par1.parentC].equals("")) {
            s = cell[par1.parentR][par1.parentC];

            for (int i = 1; i < 51; i++) {
                for (int j = 1; j < 51; j++) {
                    Infor par3 = getPar(i, j);

                    if (par3.parentR == par2.parentR && par3.parentC == par2.parentC) {
                        cell[i][j] = s;
                        par[i][j] = par1;
                    }
                }
            }
        } else {
            s = cell[par2.parentR][par2.parentC];

            for (int i = 1; i < 51; i++) {
                for (int j = 1; j < 51; j++) {
                    Infor par3 = getPar(i, j);

                    if (par3.parentR == par1.parentR && par3.parentC == par1.parentC) {
                        cell[i][j] = s;
                        par[i][j] = par2;
                    }
                }
            }
        }
    }

    void unmerge(int r, int c) {
        Infor par1 = getPar(r, c);
        String s = cell[par1.parentR][par1.parentC];

        for (int i = 1; i < 51; i++) {
            for (int j = 1; j < 51; j++) {
                Infor par2 = getPar(i, j);

                if (par1.parentR == par2.parentR && par1.parentC == par2.parentC) {
                    cell[i][j] = "";
                    par[i][j] = new Infor(i, j);
                }
            }
        }

        cell[r][c] = s;
    }

    Infor getPar(int r, int c) {
        if (par[r][c].parentR == r && par[r][c].parentC == c) {
            return par[r][c];
        }

        return par[r][c] = getPar(par[r][c].parentR, par[r][c].parentC);
    }

    class Infor{
        int parentR, parentC;

        public Infor(int parentR, int parentC) {
            this.parentR = parentR;
            this.parentC = parentC;
        }
    }
}
