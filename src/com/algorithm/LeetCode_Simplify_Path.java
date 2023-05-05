package com.algorithm;

//https://leetcode.com/problems/simplify-path/

import java.util.LinkedList;

public class LeetCode_Simplify_Path {
}

class Solution_LeetCode_Simplify_Path {
    public String simplifyPath(String path) {
        String[] dirNames = path.split("/");//path 분리
        StringBuilder canonicalPath = new StringBuilder("/");
        LinkedList<String> candidates = new LinkedList<>();

        for(int i=0;i<dirNames.length;i++){
            if(!dirNames[i].equals("")&&!dirNames[i].equals(".")){//공백이거나 "."이 아니라면
                if(dirNames[i].equals("..")){//".."인 경우
                    if(candidates.size()!=0){//앞의 경로가 있다면 해당 경로도 제거
                        candidates.removeLast();
                    }
                }else{//일반적인 경로라면 추가
                    candidates.add(dirNames[i]);
                }
            }
        }

        for(int i=0;i<candidates.size();i++){//구분자 "/"를 추가한 경로 연결
            canonicalPath.append(candidates.get(i)).append("/");
        }

        if(canonicalPath.length()!=1){//마지막 구분자 제거
            canonicalPath.deleteCharAt(canonicalPath.length() - 1);
        }

        return canonicalPath.toString();
    }
}