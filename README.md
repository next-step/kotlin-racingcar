# kotlin-racingcar

## 공통사항

- [Coding Conventions](https://kotlinlang.org/docs/coding-conventions.html)
  와 [Kotlin style guide](https://developer.android.com/kotlin/style-guide?hl=ko)를 원칙으로 한다.

## 컨벤션 설정

```shell
./gradlew ktlintApplyToIdea
mkdir .git/hooks
./gradlew addKtlintCheckGitPreCommitHook
```

- `verification/check` 하기

## 특이사항

- KoTest 알아보기

## 1단계 요구사항

- JAVA 스타일의 Person class를 코틀린으로 변환한다. (Person.java -> Person.kt)
  - [X] 이름 붙인 인자
  - [X] 널 타입
  - [X] 기본 인자
  - [X] 데이터 클래스

## 2단계 문자열 사칙 연산 계산기 구현 요구사항
### 요구사항
1. 입력 값에 따라 계산 순서가 결정된다(수학에서는 곱셈, 나눗셈이 덧셈, 뺄셈 보다 먼저 계산해야 하지만 이를 무시)
2. 예시: "2 + 3 * 4 / 2" = 10

### 프로그래밍 요구 사항
- 메서드가 너무 많은 일을 하지 않도록 분리하기 위해 노력해 본다.
- 공백 문자열을 빈 공백 문자로 분리하려면 String 클래스의 split(" ") 메소드를 활용

### 작업목록
- [X] 입력값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException throw
- [X] 사칙연산 기호가 아닌 경우 IllegalArgumentException throw
- [X] 덧셈
- [X] 뺄셈
- [X] 곱셈
- [X] 나눗셈
- [X] 객체 분리 리팩토링

### 2단계 피드백
- [X] sealed interface 사용하여 책임 분리
- [X] .fold() 를 활용
- [X] enum abstract 함수 -> override로 전환해보기
- [X] NodeTest ParameterizedTest 사용해보기
- [X] assertEquals -> assertThat
- [X] @EmptySource


## 3단계 - 자동차 경주 요구사항

### 프로그래밍 요구 사항
모든 로직에 단위 테스트를 구현한다. 단, UI(System.out, System.in) 로직은 제외
핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
UI 로직을 InputView, ResultView와 같은 클래스를 추가해 분리한다.

### 도메인
- 자동차
  - 전진 가능
    - 4 이상일 경우 전진
- 무작위 숫자 검출기
  - 0 ~ 9 사이의 무작위 숫자를 반환
- 경주
  - n대의 자동차, m번의 이동
  - n, m은 유저에게 입력을 받는다.

### 작업목록
- [X] 자동차 전진
- [X] 이동 객체 생성
- [X] 랜덤 추출기 생성
- [X] n대의 자동차 생성
- [X] ui 

## 3단계 피드백
- [X] setter는 감추고, getter만 공개
  - `private settter` 를 알아보자
- [X] error() 함수 활용 (Nodes.kt)
- [X] data class와 class의 차이점을 비교 (Car.kt)
  - data class의 equals, hashCode는 주 생성자에 선언된 프로퍼티를 모두 활용해서 수행
- [X] Cars 정적 팩토리 메소드 => 부생성자
  - 코틀린에서는 new 연산자를 사용안하니, 정적 팩토리 메소드 활용범위가 다르다.
- [X] Alist.zip(Blist) 알아보기 (Cars.kt)
- [X] RandomGenerate 인터페이스화
  - typealias로 대체
  - 인터페이스를 통해 객체까지 가야하는 이유를 찾지못함
- [X] 변수 타입이 명확하지 않은 경우 확실하게 지정하라 (RaceBoard.kt)
  - 생성자가 사라짐
  - 변수 타입을 지정하는것은 좋은 습관
- [X] CsvSource enum 적용 (NodeTest.kt)
- [X] List와 List를 직접 비교 (CarsTest.kt)

## 4단계 - 자동차 경주(우승자)
- 각 자동차에 이름을 부여할 수 있다. 자동차 이름은 5자를 초과할 수 없다.
- 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분한다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.

### 요구사항
- `Car`
  - `Name`을 가진다.
    - 5자 초과 IllegalArgumentException
- UI
  - 이동시 `Name`을 같이 출력
  - 입력은 `Name`은 쉼표(,) 구분자 문자열
  - 완료 후 우승자 함께 출력
    - 우승자는 한명 이상일 수 있다.

### 작업목록
- [X] Name 객체 만들기
  - [X] 5자 초과 경우 IllegalArgumentException
- [X] UI
  - [X] 이동시 Name 출력
  - [X] 입력은 Name은 쉼표(,) 구분자 문자열
  - [X] 완료 후 우승자 함께 출력
  - RaceResult
    - [X] 우승자는 한명 이상일 수 있다.

### 4단계 피드백 1차 피드백
- [X] MoveCondition 자체를 inferface로 활용
- [X] MoveCondition 싱글톤
- [X] winners 한번만 계산
- [X] 자바로 Decomplie 해보기
- [X] 오타 수정 
- [X] Car 를 data class -> class 로 변경 

### 4단계 피드백 2차 피드백
- [X] Cars 예외 메시지 입력과 전달
- [X] 자주사용하는 상수 이름을 지정하여 객체화
- [X] 객체간의 비교 테스트 개선 (CarsTest.kt)
