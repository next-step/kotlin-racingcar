# kotlin-racingcar


## [step 2] 문자열 사칙 연산 계산기

### 요구 사항

- 사용자가 입력한 문자열 값에 따라 사칙 연산을 수행할 수 있는 계산기를 구현해야 한다.
- 문자열 계산기는 사칙 연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정된다. 즉, 수학에서는 곱셈, 나눗셈이 덧셈, 뺄셈 보다 먼저 계산해야 하지만 이를 무시한다.
- 예를 들어 "2 + 3 * 4 / 2"와 같은 문자열을 입력할 경우 2 + 3 * 4 / 2 실행 결과인 10을 출력해야 한다.

### 프로그래밍 요구 사항

- 메서드가 너무 많은 일을 하지 않도록 분리하기 위해 노력해 본다.

### 힌트

테스트할 수 있는 단위로 나누어 구현 목록을 만든다.
- 덧셈
- 뺄셈
- 곱셈
- 나눗셈
- 입력값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException throw
- 사칙연산 기호가 아닌 경우 IllegalArgumentException throw
- 사칙 연산을 모두 포함하는 기능 구현

공백 문자열을 빈 공백 문자로 분리하려면 String 클래스의 split(" ") 메소드를 활용한다. 반복적인 패턴을 찾아 반복문으로 구현한다.
- [AssertJ Exception Assertions](https://www.baeldung.com/assertj-exception-assertion) 를 참고한다.

```kotlin
assertThatThrownBy(() -> {
    List<String> list = Arrays.asList("String one", "String two"));
    list(2);
}).isInstanceOf(IndexOutOfBoundsException.class)
    .hasMessageContaining("Index: 2, Size: 2");
```

```kotlin
assertThatExceptionOfType(IndexOutOfBoundsException.class)
  .isThrownBy(() -> {
      // ...
}).hasMessageMatching("Index: \\d+, Size: \\d+");
```

```kotlin
assertThatIOException().isThrownBy(() -> {
    // ...
});
```

- AssertJ의 Assertions

```kotlin
import static org.assertj.core.api.Assertions.assertThat;
```

- 테스트 데이터 전달
- [Guide to JUnit 5 Parameterized Tests](https://www.baeldung.com/parameterized-tests-junit-5)

```kotlin
@ParameterizedTest
@ValueSource(strings = {"", "  "})
void isBlank_ShouldReturnTrueForNullOrBlankStrings(String input) {
    assertTrue(Strings.isBlank(input));
}
```

### EP'S 학습 목표

- TDD를 적용해보자.
    - TDD 법칙
        1. 실패하는 단위 테스트를 작성할 때까지 실제 코드를 작성하지 않는다.
        2. 컴파일은 실패하지 않으면서 실행시 실패하는 정도로만 단위 테스트를 작성한다.
        3. 현재 실패하는 테스트를 통과할 정도로만 실제 코드를 작성한다.
    - DSL 사용
    - 테스트당 assert 하나
    - F.I.R.S.T 개념 적용
- 디자인 패턴을 적용해본다.
    - SOLID 원칙에 얼마나 적합했는지 판단해본다.
- 클린 코드를 적용해본다.
    - 르블랑의 법칙
    - "논리가 간단해야 버그가 숨어들지 못한다. 깨끗한 코드는 한 가지를 제대로 한다." - Bjarne Strostrup
    - "깨끗한 코드란 다른 사람이 고치기 쉬운 코드" - Dave Thomas
    - "코드를 주의 깊게 짜는 것이 깨끗한 코드이다" - Michael Feathers
    - 의미있는 이름
        - 의도가 명확한 코드를 짜야한다.(변수(함수, 클래스)의 존재 이유는? 수행 기능은? 사용 방법은?)
        - 주석을 사용해야한다면 의도를 분명히 드러내지 못했다는 뜻이다.
        - 클래스와 함수는 접두어가 필요 없을 정도로 작아야 마땅하다.
        - 클래스 이름과 객체 명사나 명사구가 적합하다.
        - 메서드 이름은 동사나 동사구가 적합하다.
        - 한 개념에 한 단어를 사용하지 말아라.
            - 추상적인 개념 하나에 단어 하나를 선택해 이를 고수해야 한다.
    - 함수
        - 함수는 한가지만 해라
        - "코드를 읽으면서 짐작했던 기능을 각 루틴이 그대로 수행한다면 깨끗한 코드라고 불러도 된다."
        - 함수가 하는 일을 좀 더 잘표현해야 좋은 이름이다.
        - 이름이 길어도 괜찮다.
        - 일관성이 있어야 한다.
        - 인자의 개수
            - 0개가 가장 이상적이다.
            - 1개도 좋다. 2개는 조금 복잡하다.
            - 3개가 넘어가면 테스트하기 부담스럽다.
            - 4개 이상은 특별한 이유가 필요하다.
        - 플래그 인자는 추하다.
        - 인수가 2-3개 필요하다면 클래스로 만들어주자
        - 가변 인수는 사실상 하나의 인자로 취급할 수 있다.
        - 많은 경우 시간적인 결합(temporal coupling)이나 순서 종속성(order dependency)을 초래한다.
            - 시간적인 결합: 동시성(같은 시각에 일어나는 일들)과 순서(시간 속에서 일들의 상대적인 위치)
        - 명령과 조회를 분리해라
            - Query(ASK)
                - 객체의 상태에 대한 정보를 제공
                - 상태 변경 x
                - free of side effects
            - Command(Tell)
                - 객체의 내부 상태를 변경
                - 편의를 위해 어떤 결과를 반환할 수 있다.
        - 오류 처리도 한 가지 작업이다.
        - 반복하지 마라
    - 객체와 자료구조
      - 자료 추상화
      - 잡종 구조 지양
      - DTO 사용
      - 디미터의 법칙
      - Tell, Dont' Ask
    - 오류 처리
        - 예외에 의미 제공
            - 오류를 정의할 때 오류를 잡아내는 방법을 가장 중요한 관심사로
        - unchecked exception 사용
        - 정상 흐름을 정의하고 적합하지 않는 에러인 경우 특수 사례 패턴을 사용하자
        - null 반환 금지
        - null 전달 금지
    - 외부 코드 사용하기
        - 외부 코드사용할 때 경계 설정(일급 컬렉션)
        - 학습테스트 사용
        - 어댑터 패턴 사용
- 이펙티브 코틀린의 내용을 참고한다.
- 최대한 쪼개고 쪼개고 쪼개보자
- 객체지향 체조 원칙

### EP'S Blue Print

- UI랑 어플리케이션을 분리해야한다.
- UI는 Query 요청이 대다수일 것이다.
- 문자열 계산기는 사칙 연산의 계산 우선순위가 아닌 입력값에 따라 계산 순서가 결정된다.
    - 물론 처음에는 그렇지만 나중에는 사친연산의 우선순위로 변경될 가능성이 있다. 전략패턴으로 빼자
- 파싱을 수행하는 객체가 있어야 할 것 같다.
- 사칙 연산 문자열을 담는 enum이 있어야할 것 같다.
- 연산의 Command를 4개로 분리할 수 있을 것 같다.
- 하나의 연산으로 2개의 항을 계산하는 과정을 이항연산(binary operation)이라고 한다.
    - 이항 연산은 순서가 있다.
- 원소와 원소의 