package org.example.chapter07;

// == 도서 관리 시스템 == //
// : 책의 정보를 저장, 책의 상태(대여 가능 여부) 확인, 책의 정보 출력

// 1)  Book 클래스
// : 속성) title(String, 불변성), author(String, 불변성), isAvailable(boolean)
// : 메서드) borrowBook(), returnBook(), displayInfo()
// : 생성자) 매개변수 - title, author

class Book {
    private final String title;
    private final String author;
    private boolean isAvailable;

    Book(String title, String author) {
        this.title = title;
        this.author = author;
        isAvailable = true;     // 책을 생성하면 대여가능 상태로 초기화
    }

    void borrowBook() {
        if(isAvailable) {
            isAvailable = false;
            System.out.println("책 대여가 성공적으로 완료되었습니다.");
        } else {
            System.out.println("현재 대여 중입니다. (대여불가)");
        }
    }

    void returnBook() {
        if(!isAvailable) {
            isAvailable = true;
            System.out.println("책 반납이 성공적으로 완료되었습니다.");
        } else {
            System.out.println("이미 반납된 상태입니다. (반납불가)");
        }
    }

    void displayInfo() {
        System.out.println("제목: " + title + ", 저자: " + author + ", 대여가능 여부: " +
                        (isAvailable ? "대여가능" : "대여 중"));
    }

    // getter
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {      // boolean 데이터는 getter 사용시 get 키워드 작성안함.
        return isAvailable;
    }

    // EBook 클래스 - Book 클래스 상속
    // 추가속성 : fileSize(double)
    // 추가메서드: displayInfo() - 재정의, fileSize()
    // 생성자: EBook(title, author, fileSize)


}

class EBook extends Book {

    /*
        EBook() {
            super();
        }
     */
    private double fileSize;

    EBook(String title, String author, double filesize) {
        super(title, author);
        this.fileSize = filesize;
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("파일크기: " +  fileSize + "MB");
    }

    double getFileSize() {
        return fileSize;
    }

}

public class E_OOP_Practice {
    public static void main(String[] args) {

        Book book1 = new Book("자바는 재밌어","이승아");
        book1.displayInfo();
        book1.borrowBook();
        book1.displayInfo();
        book1.borrowBook();

        book1.returnBook();
        book1.returnBook();

        System.out.println("===== EBook 생성 ===== ");
        EBook eBook1 = new EBook("스프링부트", "이승아", 31.23);
        eBook1.displayInfo();
        eBook1.borrowBook();
        eBook1.returnBook();
        eBook1.displayInfo();



    }
}
