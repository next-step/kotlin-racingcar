# Step2 기능 명세서

* 사칙 연산 계산기 만들기
* 우선순위가 아닌 입력 값에 따라 계산 순서가 결정
* `"2 + 3 * 4 / 2"` 문자열을 입력할 경우 `2 + 3 * 4 / 2` 실행 결과인 10을 출력

# 구현 목록

테스트할 수 있는 단위로 나누어 구현 목록을 만든다.

* 덧셈
* 뺄셈
* 곱셈
* 나눗셈
* 입력값이 null 이거나 빈 공백 문자일 경우 IllegalArgumentException throw
* 사칙연산 기호가 아닌 경우 IllegalArgumentException throw
* 사칙 연산을 모두 포함하는 기능 구현

공백 문자열을 빈 공백 문자로 분리하려면 String 클래스의 split(" ") 메소드를 활용한다. 반복적인 패턴을 찾아 반복문으로 구현한다.

# 1차 피드백

1. 상태가 없는 클래스에 대해서 object 사용 고려해볼 것
    1. object 를 사용할 경우 static 메서드를 만들 줄 알았는데 아니다.(적극 사용해볼 것)
   ```java
   public final class Calculator {
       @NotNull
       public static final Calculator INSTANCE;
       public final int calculate(@NotNull String expression) {}
   }
   ```
2. Calcuator가 문자열을 쪼개는 일을 하는 것은 어색하다고 생각, 기능 분리는 어떨까?
    1. 분리되어 만들어진 컬렉션 값을 메서드로 받고 계산만 하는 역할이 적당하다고 생각함
    2. 원본 문자열 Expression을 그대로 받는 로직 만들기 -> empty일 경우 예외처리도 가능
    3. 단, Expression 이란 네이밍을 할 경우 숫자와 연산자 어떻게 나눌지...
    4. split 과 관련되어서도 전략 패턴을 적용하면 좋을 것 같다.
3. companion object 의 위치는 최하단
    1. [코틀린 컨벤션](https://medium.com/@joongwon/kotlin-%EC%BD%94%EB%94%A9-%EC%BB%A8%EB%B2%A4%EC%85%98-%EC%A0%95%EB%A6%AC-7681cde920ce)을 찾아 보면서 진행하자
4. 생성자 테스트
    1. TDD는 클래스 정의부터 테스트해서 쌓아 올린다고 생각했으나 불필요한건 사실
    2. 실제 업무에서도 이런 불필요한 작업은 안 할 것 같으니 반영하자(다만 기존 만든것은 놔두자)

## 1차 피드백 이후 설계

1. 계산기: Calculator
    1. 컬렉션 또는 일급 컬렉션을 받아 연산만 진행하도록 하자
    2. Operator는 그대로 진행해도 될 것 같다.
2. 연산식(원본): Expression
    1. split(splittable: Splittable) 받아서 문자열 쪼개는건 어떨까?
    2. List<Words>로 만들고 -> 일급 컬렉션 Words 를 사용해도 될 것 같다.
    3. Operator implement 공통인터페이스 -> is 피연산자?
    4. Operand implement 공통인터페이스 -> is 연산자?

