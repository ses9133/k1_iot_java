package org.example.chapter03;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class F_Practice {
    public static void main(String[] args) {
        /*
             1. 크기 10의 ArrayList 생성
             2. 1 ~ 10 까지의 숫자를 차례로 추가
             3. 전체 리스트를 출력(원본 리스트: [1, 2, ...])
             4. 원본 리스트에서 홀수만 제거하고 결과를 출력(반복문 & 조건문 사용)
             5. 인덱스3 에 값 50을 삽입한 뒤 결과를 출력

     */

        ArrayList<Integer> list = new ArrayList<>(10);

        for(int i = 0; i < 10; i++) {      // 초기화 0 으로 하는 방법이 직관적인 반복 횟수 확인에 용이
            list.add(i + 1);
        }

        System.out.println("원본 리스트 : " + list);
      //  list.remove(1);

        for(int i = 0; i < list.size(); i++) {
            // remove 하면 리스트 크기가 변동되기 때문에 크기값을 매번 동적으로 확인해야함.
            if(list.get(i) % 2 != 0) {
                list.remove(i);

                // 요소를 삭제하고 난 후 인덱스 조정 필요(ArrayList 는 크기가 동적으로 변경되기 때문)
                i--;

                // cf) 인덱스 조정을 하지 않으면 정상 동작되지 않는 경우
                // : 연속된 요소를 제거할 때(홀수가 연속될 경우)
                // list = [1, 3, 5, 7, 9];

                // i = 0 일때 list.remove(0);
                // > [3, 5, 7, 9];
                // > 다음 인덱스인 i == 1 이 3 이 아니라 5이기 때문에 정상 동작 안됨

            }
        }
        System.out.println("짝수 리스트: " + list);

        list.add(3, 50);
        System.out.println(list);

        // cf) 존재하지 않는 인덱스에 접근하면 예외 발생(IndexOutOfBoundsException 발생)
    }
}
