package com.algorithm;

public class 카카오모빌리티_2022_2차_1 {
}

class Solution_카카오모빌리티_2022_2차_1 {
    int carTotalTime = 0, walkTotalTime = 0;
    int[][] bikeDP, publicDP;

    public int solution(int[][] infos, int m) {
        for (int i = 0; i < infos.length; i++) {//총 자동차 시간, 도보 시간 계산 
            carTotalTime += infos[i][0];
            walkTotalTime += infos[i][3];
        }

        if (walkTotalTime > m) {//도보 시간 가능 여부 확인
            walkTotalTime = 987654321;
        }

        bikeDP = new int[infos.length][m + 1];
        publicDP = new int[infos.length][m + 1];
        bikeCal(0, 0, infos, 0, m);
        publicCal(0, 0, infos, 0, m);

        return Math.min(
                Math.min(carTotalTime, walkTotalTime), Math.min(bikeDP[0][0], publicDP[0][0])
        );
    }

    int bikeCal(int sectionNum, int accWalk, int[][] infos, int accTime, int m) {
        int result = 987654321;

        if (bikeDP[sectionNum][accWalk] != 0) {
            return bikeDP[sectionNum][accWalk];
        }

        if (sectionNum == infos.length - 1) {//기저조건
            if ((infos[sectionNum][1] > infos[sectionNum][3]) && (accWalk + infos[sectionNum][3] <= m)) {//도보가 더 이득인 경우 + 사용 가능
                result = Math.min(result, accTime + infos[sectionNum][3]);
            }

            result = Math.min(result, accTime + infos[sectionNum][1]);

            return bikeDP[sectionNum][accWalk] = result;
        }

        if ((infos[sectionNum][1] > infos[sectionNum][3]) && (accWalk + infos[sectionNum][3] <= m)) {//도보가 더 이득인 경우 + 사용 가능
            result = Math.min(result, bikeCal(sectionNum + 1
                    , accWalk + infos[sectionNum][3]
                    , infos
                    , accTime + infos[sectionNum][3]
                    , m));
        }

        result = Math.min(result, bikeCal(sectionNum + 1
                , 0
                , infos
                , accTime + infos[sectionNum][1]
                , m));

        return bikeDP[sectionNum][accWalk] = result;
    }

    int publicCal(int sectionNum, int accWalk, int[][] infos, int accTime, int m) {
        int result = 987654321;

        if (publicDP[sectionNum][accWalk] != 0) {
            return publicDP[sectionNum][accWalk];
        }

        if (sectionNum == infos.length - 1) {//기저조건
            if (infos[sectionNum][2] == -1) {//대중교통 사용 불가
                if (accWalk + infos[sectionNum][3] <= m) {//도보 사용 가능
                    result = Math.min(result, accTime + infos[sectionNum][3]);
                }
            } else {//대중교통 사용 가능
                if ((infos[sectionNum][2] > infos[sectionNum][3])
                        && (accWalk + infos[sectionNum][3] <= m)) {//도보 이득 + 사용 가능
                    result = Math.min(result, accTime + infos[sectionNum][3]);
                }

                result = Math.min(result, accTime + infos[sectionNum][2]);//대중교통 사용
            }

            return publicDP[sectionNum][accWalk] = result;
        }

        if (infos[sectionNum][2] == -1) {//대중교통 사용 불가
            if (accWalk + infos[sectionNum][3] <= m) {//도보 사용 가능
                result = Math.min(result, publicCal(sectionNum + 1
                        , accWalk + infos[sectionNum][3]
                        , infos
                        , accTime + infos[sectionNum][3]
                        , m));
            }
        } else {//대중교통 사용 가능
            if ((infos[sectionNum][2] > infos[sectionNum][3])
                    && (accWalk + infos[sectionNum][3] <= m)) {//도보 이득 + 사용 가능
                result = Math.min(result, publicCal(sectionNum + 1
                        , accWalk + infos[sectionNum][3]
                        , infos
                        , accTime + infos[sectionNum][3]
                        , m));
            }

            result = Math.min(result, publicCal(sectionNum + 1//대중교통 사용
                    , 0
                    , infos
                    , accTime + infos[sectionNum][2]
                    , m));
        }
        
        return publicDP[sectionNum][accWalk] = result;
    }
}
