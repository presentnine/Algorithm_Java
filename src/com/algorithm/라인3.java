package com.algorithm;

import java.util.*;
import java.io.*;

public class 라인3 {
    public static void main(String[] args) {

    }
}

class Solution_라인3 {
    public int[] solution(int num_teams, String[] remote_tasks, String[] office_tasks, String[] employees) {
        int[] answer;
        ArrayList<Integer> answerList = new ArrayList<>();
        int employeesCount = employees.length;
        PriorityQueue<Integer>[] teamMembers = new PriorityQueue[num_teams+1];
        HashSet<String> officeTasks = new HashSet<>();
        boolean[] isAllMembersRemoteTask = new boolean[num_teams+1], isRemoteTask = new boolean[employeesCount+1];
        int[] teamBelongingTo = new int[employeesCount+1];

        for(int i=1;i<=num_teams;i++){
            teamMembers[i] = new PriorityQueue<>();
            isAllMembersRemoteTask[i] = true;
        }

        for(int i=1;i<=employeesCount;i++){
            isRemoteTask[i] = true;
        }

        for(int i=0;i<office_tasks.length;i++){
            officeTasks.add(office_tasks[i]);
        }

        for(int i=0;i<employeesCount;i++){
            String[] s = employees[i].split(" ");
            boolean result = true;
            int team = Integer.parseInt(s[0]);
            teamBelongingTo[i+1] = team;

            for(int j = 1;j<s.length;j++){
                if(officeTasks.contains(s[j])){
                    result = false;
                    break;
                }
            }

            if(result){
                teamMembers[team].add(i+1);
            }else{
                isAllMembersRemoteTask[team] = false;
                isRemoteTask[i+1] = false;
            }
        }

        for(int i=1;i<=num_teams;i++){
            if(isAllMembersRemoteTask[i]){
                isRemoteTask[teamMembers[i].peek()] = false;
            }
        }

        for(int i=1;i<=employeesCount;i++){
            if(isRemoteTask[i]){
                answerList.add(i);
            }
        }

        answer = new int[answerList.size()];

        for(int i=0;i<answerList.size();i++){
            answer[i] = answerList.get(i);
        }

        return answer;
    }
}
