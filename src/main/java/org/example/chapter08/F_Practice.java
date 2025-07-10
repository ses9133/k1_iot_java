package org.example.chapter08;

//  추상 클래스
// : 모바일 애플리케이션
abstract class MobileApp {
    // 추상 메서드
    // - 각 앱마다 고유한 실행을 정의(상속받은 클래스에서 구현)
    abstract void execute();

    // 일반 메서드
    void appInfo() {
        System.out.println("This is a mobile app");
    }
}

// === SNS 애플리케이션 === //
class SocialApp extends MobileApp {
    String name; // 각 객체가 가질 이름 ex. 인스타, 카카오톡,,

    SocialApp(String name) {
        this.name = name;
    }

    @Override
    void execute() {
        System.out.println(name + " app executes");
    }

    @Override
    void appInfo() {
        System.out.println(name + " app is most popular social app");
    }

    // 고유 메서드
    void shareContent(String content) {
        System.out.println(name + " shares: " + content);
    }
}

// === GAME 애플리케이션 == //
class GameApp extends MobileApp {
    @Override
    void execute() {
        System.out.println("Game app executes");
    }
}


public class F_Practice {
    public static void main(String[] args) {
        // == 다형성 적용 === //
        //: 업캐스팅
        MobileApp gameApp = new GameApp();
        MobileApp socialApp = new SocialApp("Instagram");

        // 다형성 적용에 의해 공통된 메서드 호출 가능
        gameApp.execute();
        gameApp.appInfo();
        socialApp.execute();
        socialApp.appInfo();

        //socialApp.shareContent("imaages"); -> 업캐스팅시, 하위 클래스의 고유 메서드에는 접근 불가능함

        // 형 변환
        if(socialApp instanceof GameApp) {
            System.out.println("social App 이 Game App 타입의 객체이다");
            GameApp onlyGame = (GameApp) socialApp;
        } else if (socialApp instanceof SocialApp) {
            System.out.println("social App 이 Social App 타입의 객체이다");
            SocialApp onlySocial = (SocialApp) socialApp;

            onlySocial.shareContent("images");
        }

        // == 객체 배열과 다형성 적용 == //
        MobileApp[] apps = {
                // 생성과 동시에 업캐스팅하기
                new GameApp(),
                new SocialApp("Facebook"),
                new SocialApp("kakaoTalk")
        };

        System.out.println("=====for 문 시작====");
        for(MobileApp app : apps) {
            app.execute();
            app.appInfo();

            if(app instanceof SocialApp) {
                // 다운 캐스팅
                SocialApp specificSocial = (SocialApp) app;
                specificSocial.shareContent("Files");
            }

        }

    }
}
