package org.example.chapter05;

class BaseBallPlayer {
    String name;
    double battingAverage;
    int homeRuns;

    static int playerCount;

    BaseBallPlayer(String name, double battingAverage, int homeRuns) {
        this.name = name;
        this.battingAverage = battingAverage;
        this.homeRuns = homeRuns;
        playerCount++;
    }

    void update(double newBattingAverage, int newHomeRuns) {
        // >> 필드값과 매개변수 명이 충돌나지 않기 때문에, this 키워드 생략가능
        battingAverage = newBattingAverage;
        homeRuns = newHomeRuns;
    }

    static String evaluate(int homeRunCount) {
        if (homeRunCount >= 20) return "홈런상 후보! 축하드립니다!";
        else  return "홈런상 후보에 등록될 수 없습니다.";
    }
}

public class E_Practice {
    public static void main(String[] args) {
        // 인스턴스 생성
        BaseBallPlayer baseBallPlayer1 = new BaseBallPlayer("정은혜", 0.3, 16);
        BaseBallPlayer baseBallPlayer2 = new BaseBallPlayer("홍길동", 0.5, 15);
        BaseBallPlayer baseBallPlayer3 = new BaseBallPlayer("홍길남", 0.325, 22);
        BaseBallPlayer baseBallPlayer4 = new BaseBallPlayer("홍길서", 0.41, 10);
        BaseBallPlayer baseBallPlayer5 = new BaseBallPlayer("홍길북", 0.54, 11);

        System.out.println("총 생성된 선수의 수 : " + BaseBallPlayer.playerCount);

        baseBallPlayer1.update(0.6, 22);
        System.out.println(baseBallPlayer1.battingAverage);
        System.out.println(baseBallPlayer1.homeRuns);

        System.out.println(BaseBallPlayer.evaluate(baseBallPlayer1.homeRuns));
        System.out.println(BaseBallPlayer.evaluate(baseBallPlayer2.homeRuns));

    }
}
