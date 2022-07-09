package com.algorithm;

import java.util.HashSet;
import java.util.regex.Pattern;

public class 라인1 {
    public static void main(String[] args) {
        String s = "p    s   a v";
        String[] s1 = s.split(" ");

        char c = 'A';
        char c2 = 'a';
        char c3 = ' ';



        if (c > 0) {
            System.out.println((c + 0));
        }

        System.out.println(c2 + 0);
        System.out.println(c3 + 0);

        HashSet<Character> hs[] = new HashSet[4];

        for (int i = 0; i < 4; i++) {
            hs[i] = new HashSet<>();
        }
    }
}

class Solution_라인1 {
    public int solution(String[] logs) {
        int answer = 0;
        String pattern = "[a-zA-Z]+";

        for(int i=0;i<logs.length;i++){
            if(logs[i].length()>100){
                ++answer;
                continue;
            }else{
                String[] parsing = logs[i].split(" ");
                if(parsing.length!=12){
                    ++answer;
                    continue;
                }else{
                    if((!parsing[1].equals(":"))||(!parsing[4].equals(":"))||(!parsing[7].equals(":"))||(!parsing[10].equals(":"))){
                        ++answer;
                        continue;
                    }
                    else{
                        if((!parsing[0].equals("team_name"))||(!parsing[3].equals("application_name"))||(!parsing[6].equals("error_level"))||(!parsing[9].equals("message"))){
                            ++answer;
                            continue;
                        }else{
                            if((!Pattern.matches(pattern, parsing[2]))||(!Pattern.matches(pattern, parsing[5]))||(!Pattern.matches(pattern, parsing[8]))||(!Pattern.matches(pattern, parsing[11]))){
                                ++answer;
                                continue;
                            }
                        }
                    }
                }
            }
        }

        return answer;
    }
}
