package org.example.chapter13;
/*
    == 빌더로 게임 캐릭터 생성 ==
    1) 필수: 이름 (String), 분류 (String)
    2) 선택: 스킬(String), 아이템(String)
 */
class GameCharacter {
    // 필수
    private final String name;
    private final String sort;

    // 선택
    private final String skill;
    private final String item;

    // 빌더 클래스
    public static class Builder {
        private final String name;
        private final String sort;

        private String skill = "Basic Attack";
        private String item = "None";

        // 필수값 초기화
        public Builder(String name, String sort) {
            this.name = name;
            this.sort = sort;
        }

        // 선택 필드에 대한 할당 메서드 (필드명 그자체로 메서드명)
        public Builder skill(String skill) {
            this.skill = skill;
            return this;    // Builder 객체
        }

        public Builder item(String item) {
            this.item = item;
            return this;
        }

        public GameCharacter build() {
            return new GameCharacter(this);
        }
    }

    private GameCharacter(Builder builder) {
        this.name = builder.name;
        this.sort = builder.sort;
        this.skill = builder.skill;
        this.item =builder.item;
    }
}

public class F_Builder {
    public static void main(String[] args) {

        GameCharacter pororo = new GameCharacter.Builder("뽀로로", "펭귄")
                .skill("크롱놀리기")
                .build();

        /*
            new GameCharacter.Builder("뽀로로", "펭귄") -> 반환: Builder
            .skill() -> 반환: Builder
            .build() -> 반환: GameCharacter
         */
        GameCharacter c1 = new GameCharacter.Builder("짱구", "사람")
                .item("니알ㄴㅇㄹ")
                .build();

    }
}
