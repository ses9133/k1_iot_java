package org.example.chapter15;

/*
    1. 불변성 데이터: Stream API 정렬 사용
     목적) 원본 리스트 변경 X, 정렬된 새로운 리스만 필요시 사용
     EX) 클라이언트 응답용 DTO 리스트 정렬시

    2. 원본 리스트 자체 정렬
    - List.sort() 또는 Collections.sort()
    목적) 원본 데이터를 직접 수정해서 정렬 순서를 유지해야하는 경우
    ex) 캐시된 리스트, 재사용 리스트, 통계 계산용 리스트 등
    >> 데이터 베이스나 외부 API 에서 자주 조회되는 데이터를 미리 리스트에 저장해두고
        , 필요시 다시 원본을 가져오지 않고 빠르게 읽어오는 용도

    3. Comparator 추출로 정렬 기준 재사용
    목적) 정렬 기준이 자주 반복되거나 복잡한 로직일 때 재사용성을 높이기 위함
 */

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

// 제품과 관련된 비즈니스 로직을 수행하는 클래스
// CRUD + 필터링 / 통게
// : 가격 기준으로 정렬 조회

@Getter
@AllArgsConstructor
class Product {
    private int price;
}

@AllArgsConstructor
class Post {
   private String title;
}

@Getter
@AllArgsConstructor
@ToString
class User {
    private String name;
    private int age;
}

class PostRepository {
    // DB SQL 을 통해 정렬된 데이터를 반환하여 가져옴
    List<Post> findTop5ByOrderByViewsDesc() {

        return new ArrayList<Post>(List.of(
                new Post("인기1"),
                new Post("인기2"),
                new Post("인기3"),
                new Post("인기4"),
                new Post("인기5")
        ));
    }
}

class ProductRepository {
    List<Product> findAll() {

        return new ArrayList<>(List.of(
                new Product(15),
                new Product(10),
                new Product(20),
                new Product(21),
                new Product(9)
        ));
    }
}

class ProductService {

    ProductRepository productRepository = new ProductRepository();

    void createProduct() {

    }
    void updateProduct() {

    }

    List<Product> getProductsSortedByPrice() {
        List<Product> products = productRepository.findAll();

        return  products.stream()
                .sorted(Comparator.comparing(Product::getPrice))
                .collect(Collectors.toList());
    }

}

class PostService {
    PostRepository postRepository = new PostRepository();
    private List<Post> cachedPopularPost;

    // List.sort()는 리스트 그 자체를 변경
    // stream() 보다 메모리 효율이 높음 (새로운 리스트 생성을 하지 않기 때문에)
    // : 캐시나 반복 사용 데이터에 적합
    public List<Post> getPopularPosts() {
        if(cachedPopularPost == null)
            // DB에서 인기 게시글 조회
            cachedPopularPost = postRepository.findTop5ByOrderByViewsDesc();

        // 한번 불러온 후 매번 DB 조회를 하지 않고 재사용
        return cachedPopularPost;
    }

    public void refreshPopularPostsCache() {
        // 필요할 때 갱신
        cachedPopularPost = postRepository.findTop5ByOrderByViewsDesc();
    }

}

// 정렬 기준을 별도의 유틸 클래스로 분리 -> 장점 : 정렬 로직을 메서드에서 분리하여 한 곳에서 관리 가능 => 테스트 용이성, 유지보수성 향상
// 사용자 데이터 정렬 로직을 정리
class UserComparators {
    // 사용자 이름 오름차순 정렬
    public static final Comparator<User> BY_NAME = Comparator.comparing(User::getName);

//    Comparator<User> BY_NAME = (o1, o2) ->
//        o1.getName().compareTo(o2.getName());

    // 사용자 나이 내림차순 정렬 (연장자 순)
    public static final Comparator<User> BY_AGE_DESC = Comparator.comparingInt(User::getAge).reversed();

//    Comparator<User> BY_AGE_DESC = (o1, o2)  -> {
//        return o1.getAge() - o2.getAge();
//    };

    // 실무 프로젝트에서는 ComparatorUtils, SortConstants 클래스에 모아서 정의
}

public class B_Sort {
    public static void main(String[] args) {

        List<User> userList = new ArrayList<>(List.of(
                new User("이승아", 25),
                new User("이도경", 20),
                new User("김명진", 30),
                new User("조승범", 23),
                new User("윤대휘", 20)
        ));

        userList.sort(UserComparators.BY_AGE_DESC);
        System.out.println(userList);

        userList.sort(UserComparators.BY_NAME);
        System.out.println(userList);
    }
}

// SQL 정렬 VS JAVA 정렬의 역할 분리
// >> 성능 최적화 및 역할 구분
// 1) 데이터가 많고 단순한 정렬: SQL - ORDER BY
// 2) 복잡한 정렬: Java - Comparator, Stream API
// 3) 정렬 조건이 요청마다 달라짐: Java 처리
// 4) 정렬된 순서를 DB  에서 보장: SQL 처리