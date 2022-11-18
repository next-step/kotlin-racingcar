# kotlin-racingcar


## [step 2] 문자열 사칙 연산 계산기

### 요구 사항

- [x] 사용자가 입력한 문자열 값에 따라 사칙 연산을 수행할 수 있는 계산기를 구현해야 한다.
- [x] 문자열 계산기는 사칙 연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정된다. 즉, 수학에서는 곱셈, 나눗셈이 덧셈, 뺄셈 보다 먼저 계산해야 하지만 이를 무시한다.
- [x] 예를 들어 "2 + 3 * 4 / 2"와 같은 문자열을 입력할 경우 2 + 3 * 4 / 2 실행 결과인 10을 출력해야 한다.

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

## [step 3] 자동차 경주

### 기능 요구 사항

초간단 자동차 경주 게임을 구현한다.
- [x] 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- [x] 사용자는 몇 대의 자동차로 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- [x] 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- [x] 자동차의 상태를 화면에 출력한다. 어느 시점에 출력할 것인지에 대한 제약은 없다.

### 실행 결과
위 요구 사항에 따라 3대의 자동차가 5번 움직였을 경우 프로그램을 실행한 결과는 다음과 같다.

```
자동차 대수는 몇 대인가요?
3
시도할 횟수는 몇 회인가요?
5

실행 결과
-
-
-

--
-
--

---
--
---

----
---
----

----
----
-----
```

### 프로그래밍 요구 사항
- 모든 로직에 단위 테스트를 구현한다. 단, UI(System.out, System.in) 로직은 제외
    - 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
    - UI 로직을 InputView, ResultView와 같은 클래스를 추가해 분리한다.

### 힌트
- 값을 입력 받는 API는 kotlin.io의 readLine을 이용한다.
```kotlin
val value: String? = readLine()
val value: String = readLine()!!
val number = readLine()!!.toInt()
```