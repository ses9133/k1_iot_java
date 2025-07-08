package org.example.chapter07;

// 접근 제어자 확장 //
// : protected 접근제어자로 선언된 메서드를 자식 클래스에서 오버라이딩(재정의)
// >> 접근제어자 수정이 가능한지 여부!
// >> 접근제어자는 같거나 더 넓게만 가능!

import org.example.otherPackage.OtherClass;

class PracticeParent {
    protected void greet(){
        System.out.println("Hello Parent");
    }
}

class PracticeChild extends PracticeParent {

//    @Override
//    protected void greet() {
//        super.greet();
//    }

    // 재정의한 메서드는 부모가 가진 메서드의 범위를 축소시킬수 없음
      @Override
      public void greet() {     // protected >> public 가능
        super.greet();
    }

//    @Override
//    private void greet() {   -> 부모의 메서드 접근제어자(protected) 보다 축소될 수 없음
//        super.greet();
//    }
}


// OtherClass 내부에 protected 필드와 메서드 있음
public class C_Practice extends OtherClass {
     void exampleMethod() {
        System.out.println(otherField);
        System.out.println(this.otherField);
        otherMethod();
    }
    public static void main(String[] args) {
        OtherClass otherClass = new OtherClass();
//        otherClass.otherField;        // protected 메서드/필드는 자식클래스내에서 "직접적인" 접근만 가능함 39, 40번 처럼
//        otherClass.otherMethod();

    }
}
