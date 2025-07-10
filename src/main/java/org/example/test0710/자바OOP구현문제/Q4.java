package org.example.test0710.자바OOP구현문제;

interface Playable {
    void play();
}

class Piano implements Playable {
    @Override
    public void play() {
        System.out.println("피아노 소리가 납니다.");
    }
}

class Guitar implements Playable {
    @Override
    public void play() {
        System.out.println("기타 소리가 납니다.");
    }
}

public class Q4 {
    public static void main(String[] args) {

//        Playable piano = new Piano();
//        piano.play();
//
//        Playable guitar = new Guitar();
//        guitar.play();

        Playable[] item = { new Piano(), new Guitar() };

        for(Playable items : item) {
            items.play();
        }


    }


}
