package com.algorithm;

import java.util.HashMap;

public class 카카오모빌리티_2022_2 {
}

class Solution_카카오모빌리티_2022_2 {
    public int solution(String[] id_list, int k) {
        int answer = 0;
        HashMap<String, History> couponCountsForCustomer = new HashMap<>();

        for (int i = 0; i < id_list.length; i++) {//각 날짜별
            String[] ids = id_list[i].split(" ");//id 분할

            for (int j = 0; j < ids.length; j++) {//각 id들에 대한 작업
                String id = ids[j];

                if (couponCountsForCustomer.containsKey(id)) {//기존 쿠폰 받은 이력 존재
                    History history = couponCountsForCustomer.get(id);

                    if (history.lastDate != i) {//동일한 날짜가 아니고
                        if (history.totalCount < k) {//쿠폰을 더 받을 수 있다면
                            ++answer;
                        }
                        //정보 최신화
                        ++history.totalCount;
                        history.lastDate = i;
                    }

                    couponCountsForCustomer.replace(id, history);//객체 교체
                } else {//쿠폰 받은 이력 X
                    couponCountsForCustomer.put(id, new History(1, i));
                    ++answer;
                }
            }
        }

        return answer;
    }

    class History{
        int totalCount, lastDate;

        public History(int totalCount, int lastDate) {
            this.totalCount = totalCount;
            this.lastDate = lastDate;
        }
    }
}
