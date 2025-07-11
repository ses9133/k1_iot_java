package org.example.chapter10.practice01;

import java.util.ArrayList;
import java.util.List;

// 도서 관리 기능을 수행(관리할 행동을 실질적 구현)
public class LibraryManager implements Manageable {
    // 책 저장 공간 (ArrayList - 중복O, 순서 O / 조회 빠른 기능때매 Linked 안씀)
    private List<Item> items = new ArrayList<>();

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

    @Override
    public void add(Item item) {
        items.add(item);
        System.out.println("Item added: " + item.getName());
    }

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

    @Override
    public List<Item> search(String keyword) {
        return List.of();
    }

    @Override
    public List<Item> searchByCategory(String category) {
        return List.of();
    }

    @Override
    public List<Item> searchByPriceRange(int minPrice, int maxPrice) {
        return List.of();
    }
}
