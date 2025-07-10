package org.example.chapter08;

import java.util.Arrays;

abstract class TransportApp {
    abstract void move();

    public void info() {
        System.out.println("이동 관련 애플리케이션 입니다.");
    }
}

class TaxiApp extends TransportApp {
    @Override
    void move() {
        System.out.println("택시로 이동합니다.");
    }
}

interface EcoFriendly {
    default void ecoMessage() {
        System.out.println("이동 수단은 친환경적입니다.");
    }
}

//5. `BikeApp`은 `EcoFriendly`도 구현하여 친환경 메시지를 출력할 수 있도록 구현
class BikeApp extends TransportApp implements EcoFriendly {
    @Override
    void move() {
        System.out.println("자전거로 이동합니다.");
    }
}

public class Z_Review {
    public static void main(String[] args) {

        TransportApp taxiApp = new TaxiApp();
        TransportApp bikeApp = new BikeApp();
        TransportApp[] transportApps = { taxiApp, bikeApp };

        for(TransportApp transportApp : transportApps) {
            transportApp.move();
            transportApp.info();

    //`EcoFriendly`를 구현한 객체만 `ecoMessage()`를 호출 (instanceof + 다운캐스팅)

//            if(bikeApp instanceof BikeApp) {
//                BikeApp bikeApp1 = (BikeApp) bikeApp;
//                bikeApp1.ecoMessage();
//            }

              if(bikeApp instanceof EcoFriendly) {
                  EcoFriendly bikeApp1 = (EcoFriendly) bikeApp;
                  bikeApp1.ecoMessage();
              }
        }


    }
}
