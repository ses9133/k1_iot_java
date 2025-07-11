package org.example.chapter10.practice01;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

// 도서 관리 기능을 수행(관리할 행동을 실질적 구현)
public class LibraryManager implements Manageable {
    // 책 저장 공간 (ArrayList - 중복O, 순서 O / 조회 빠른 기능때매 Linked 안씀)
    private List<Item> items = new ArrayList<>();

    // 1.
    @Override
    public void remove(String id) {
        boolean removed = false;

        // 인덱스 번호를 사용하여 요소 제거
        int size = items.size();

        for(int i = 0; i < size; i++) {
            // 각 순번의 item, id == 매개변수의 id 이면 해당 인덱스 요소 제거
            if(items.get(i).getId().equals(id)) {
                items.remove(i);
                removed = true;
                System.out.println("Item with ID: " + id + " removed");
                break;
            }
        }

        if(!removed) {
            System.out.println("No item found with ID: " + id);
        }
    }

    // 2. 책 추가
    @Override
    public void add(Item item) {
        items.add(item);
        System.out.println("Item added: " + item.getName());
    }

    // 3. 책 개수 업데이트
    @Override
    public void updateStock(String id, int quantity) {
        for(Item item : items) {

            //item.updateStock(quantity); updateStock 은 item 에 없는 메서드

            if(item.getId().equals(id) && item instanceof Book) {
               // Book selectedBook = (Book) item; -> 변수로 만들어서 활용하는 방법도 가능
                ((Book)item).updateStock(quantity); // Item 객체를 Book 객체로 다운 캐스팅
                System.out.println("Stock updated for ID: " + id + ", Stock: " + ((Book) item).getStock());
            }
        }
    }

    // 4. 책 전체 조회
    @Override
    public void listAll() {
        // 전체 조회: isEmpty() 로 요소값 존재 여부 확인후에 따라 로직 처리
        if(items.isEmpty()) {
            System.out.println("No items in the library");
        } else {
            System.out.println("=== Library Items ===");
            for (Item item : items) {
                item.display();
            }
        }
    }

    // 5. 키워드 통해 통합 조회
    @Override
    public List<Item> search(String keyword) {
        // 전체 리스트의 요소에서 키워드 검색 (통합검색)
        // : name(책 이름), author(저자명), publisher(출판사) 통합 검색

        List<Item> foundItems = new ArrayList<>(); // 검색된 도서 정보들이 저장될 배열

        for(Item item : items) {
            if(item.getName().contains(keyword)
                || (item instanceof Book && ((Book)item).getAuthor().contains(keyword)
                    || ((Book)item).getPublisher().contains(keyword))
            ) {
                foundItems.add(item);
            }
        }

        if(foundItems.isEmpty()) {
            throw new NoSuchElementException("No item found for keyword: " + keyword);
        }

        return foundItems;
    }

    // 6. 카테고리 조회
    @Override
    public List<Item> searchByCategory(String category) {
        List<Item> result = new ArrayList<>();

        for(Item item : items) {
            if(item instanceof Book && ((Book)item).getCategory().equalsIgnoreCase(category)) {
                // equalsIgnoreCase
                // : 대소문자를 구분하지 않고 데이터의 값을 비교
                // - 영어만 사용 가능
                result.add(item);
            }
        }

        if(result.isEmpty()) {
            throw new NoSuchElementException("No item found for this category: " + category);
        }
        return result;
    }

    // 7. 가격범위 조회
    @Override
    public List<Item> searchByPriceRange(int minPrice, int maxPrice) {

        List<Item> result = new ArrayList<>();

        for(Item item : items) {
            if(item instanceof Book) {
                int price = ((Book)item).getPrice();

                if(price >= minPrice && price <= maxPrice) {
                    result.add(item);
                }
            }
        }

        if(result.isEmpty()) {
            throw new NoSuchElementException("No item found for this range: " + minPrice + " ~ " + maxPrice);
        }

        return result;
    }
}
