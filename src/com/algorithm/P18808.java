package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/18808
public class P18808 {
    static int N, M, K;
    static int[][] panel, stickerInfor;
    static int[][][] stickers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = 0;

        //N, M, K 초기화
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        panel = new int[N][M];
        stickers = new int[K][10][10];
        stickerInfor = new int[K][2];

        for (int i = 0; i < K; i++) {//스티커 & 스티커 정보 저장
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            stickerInfor[i][0] = r;
            stickerInfor[i][1] = c;

            for (int j = 0; j < r; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < c; k++) {
                    stickers[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }

        for (int i = 0; i < K; i++) {//각 스티커 함수 호출
            answer += attach(i);
        }

        System.out.println(answer);
    }

    static int attach(int stickerNum) {//패널에 스티커 붙이기
        int[][] rotateResult = new int[10][10];
        int r = stickerInfor[stickerNum][0], c = stickerInfor[stickerNum][1]
                , rotateR, rotateC, count = 0;

        for (int i = 0; i < 4; i++) {//회전 순서 대로 진행
            if (i == 0) {//제자리
                rotateR = r;
                rotateC = c;

                for (int j = 0; j < r; j++) {
                    for (int k = 0; k < c; k++) {
                        rotateResult[j][k] = stickers[stickerNum][j][k];
                    }
                }
            } else if (i == 1) {//90도
                rotateR = c;
                rotateC = r;

                for (int j = 0; j < r; j++) {
                    for (int k = 0; k < c; k++) {
                        rotateResult[k][r - 1 - j] = stickers[stickerNum][j][k];
                    }
                }
            } else if (i == 2) {//180도
                rotateR = r;
                rotateC = c;

                for (int j = 0; j < r; j++) {
                    for (int k = 0; k < c; k++) {
                        rotateResult[r - 1 - j][c - 1 - k] = stickers[stickerNum][j][k];
                    }
                }
            } else {//270도
                rotateR = c;
                rotateC = r;

                for (int j = 0; j < r; j++) {
                    for (int k = 0; k < c; k++) {
                        rotateResult[c - 1 - k][j] = stickers[stickerNum][j][k];
                    }
                }
            }

            for (int j = 0; j <= N - rotateR; j++) {//스티커를 붙일 수 있는 지 각 위치 확인
                for (int k = 0; k <= M - rotateC; k++) {
                    boolean matchResult = true;

                    for (int l = 0; l < rotateR; l++) {
                        for (int m = 0; m < rotateC; m++) {
                            if (panel[j + l][k + m] == 1 && rotateResult[l][m] == 1) {
                                matchResult = false;
                                break;
                            }
                        }

                        if (!matchResult) {
                            break;
                        }
                    }

                    if (matchResult) {//붙일 수 있다면 패널 최신화 후 붙인 칸만큼 반환
                        for (int l = 0; l < rotateR; l++) {
                            for (int m = 0; m < rotateC; m++) {
                                if (rotateResult[l][m] == 1) {
                                    ++count;
                                    panel[j + l][k + m] = rotateResult[l][m];
                                }
                            }
                        }

                        return count;
                    }
                }
            }
        }
        return count;
    }
}
