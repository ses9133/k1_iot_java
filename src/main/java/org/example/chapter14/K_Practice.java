package org.example.chapter14;

// == 직원 관리 시스템 == //

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// 직원 데이터 정의
@AllArgsConstructor
@Getter
@ToString
class Employee {
    private String department;
    private String name;
    private int salary;
}

public class K_Practice {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee("IT", "이승아", 300),
            new Employee("HR", "조승범", 500),
            new Employee("IT", "김주일", 400),
            new Employee("OP", "전예찬", 350),
            new Employee("HR", "윤대휘", 380)

        );

        // 1. 급여가 400 이상인 직원 필터링
        // : filter() - 조건 검사해서 true 인 요소만을 다시 반환
        List<Employee> filteredEmployees = employees.stream()
                .filter(employee -> employee.getSalary() >= 400)
                .toList();
        filteredEmployees.forEach(System.out::println);
        // filteredEmployees.forEach(employee -> System.out.println(employee));

        // 2. IT 부서 직원들의 이름을 추출
        List<String> names = employees.stream()
                .filter(employee -> "IT".equals(employee.getDepartment()))
                //.map(s -> s.getName())
                .map(Employee::getName)
                .toList();

        System.out.println(names);

        // 1) 부서가 IT 인 직원 필터링 - filter
        List<Employee> employeeIt = employees.stream()
                .filter(employee -> employee.getDepartment().equals("IT"))
                .toList();
        employeeIt.forEach(System.out::println);

        // 2) 부서가 IT 인 직원목록을 전체 순회하여 이름만 추출 - map
        List<String> namesIt = employeeIt.stream()
                //.map(s -> s.getName())
                .map(Employee::getName)
                .toList();
        namesIt.forEach(System.out::println);

        // 3. 특정 부서(HR) 직원 중 이름에 '조'가 포함된 직원 필터링

        List<Employee> employeesHr = employees.stream()
                .filter(employee -> employee.getDepartment().equals("HR"))
                .filter(employee -> employee.getName().contains("조"))
                .toList();
        employeesHr.forEach(System.out::println);


        // 4. 부서별 직원 그룹화
        // groupingBy 는 Map 인터페이스 반환
        // Collectors 클래스 - groupingBy
        Map<String, List<Employee>> grouped = employees.stream()
                //.collect(Collectors.groupingBy(p -> p.getDepartment()));
                 .collect(Collectors.groupingBy(Employee::getDepartment));

        System.out.println(grouped); // 한줄로 그대로 출력
//        grouped.forEach((department, group) -> {
//            System.out.println(department + ": " + group);
//        });  // 순회돌면서 한줄씩 출력

        grouped.forEach((department, employeeInDept) -> {
            String name = employeeInDept.stream()
                    .map(Employee::getName)
                    .collect(Collectors.joining(", "));

            System.out.println(department + ": " + name);
        });

        // 5. 부서별 평균 급여 계산
        // Collectors 클래스 - groupingBy
        //                  - averaging : 해당 타입의 평균을 계산 (averagingInt)
        Map<String, Double> avgSalaryByDept = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment, Collectors.averagingInt(Employee::getSalary)
                ));
        System.out.println(avgSalaryByDept);


    }
}
