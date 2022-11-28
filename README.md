# kotlin-racingcar

# 🚀 2단계 - 문자열 계산기

## 기능 요구사항
- [x] 사칙 연산 계산
  - [x] 연산자에 해당하는 계산기
    - [x] 덧셈
    - [x] 뺄셈
    - [x] 곱셈
    - [x] 나눗셈
      - [x] 0으로 나누려는 경우 연산하지 않는다.
      - [x] 소수점은 모두 무시한다.
- [x] 입력 순으로 계산 (연산 우선 순위 무시)

### 2단계 피드백
- [x] Application의 calculate 함수를 Calculator 클래스 내부로 이동
- [x] calculate 함수의 로컬 변수명 변경
  - inputFormula -> formula
- [x] calculateInternal 함수의 로컬 변수명 변경
  - summary -> total
- [x] Application 내부 메서드 순서 변경 (호출 순)
- [x] 불필요한 코드 제거 (map)
- [x] 연산기호 객체를 표현할 수 있는 클래스명으로 변경
  - Calculator -> Operator
- [x] Scanner 대신 readln 함수 사용
- [x] 함수에서 중괄호를 사용하는 경우 `return` 명시
- [x] scope function 대신 Elvis operator 활용!
- [x] 나누기 0 예외 처리를 operation 내부에서 수행하도록 변경
- [x] InputView를 object class로 변경
  - 자바의 private 생성자를 만들고, static 메서드로 명시하던 것과 비슷하다..

---

# 🚀 3단계 - 자동차 경주

## 기능 요구사항
- [x] 자동차의 대수와 이동 시도 횟수를 입력받는다.
- [x] 자동차
  - [x] 자동차의 위치 
  - [x] 전진 또는 멈춤
    - [x] 전진하면 위치가 1 증가
    - [x] 멈추면 위치 변경 없음
- [x] 전진 조건
  - [x] 0~9 사이의 무작위 값을 구한 후 4 이상일 경우
- [x] 입력받은 자동차의 대수만큼 자동차를 생성한다
- [x] 이동 시도 횟수만큼 전진을 시도한다.
- [x] 자동차의 위치를 화면에 출력


### 3단계 피드백
- [x] 요구사항 오타 수정
  - 이동 횟수 -> 이동 시도 횟수 
- [x] Car의 가변 프로퍼티를 Body에서 정의 후 private setter 선언
  - [x] getPosition 함수 제거. (프로퍼티 접근자 사용)
    - 코틀린에서는 프로퍼티가 getter/setter 역할을 모두 수행할 수 있다.(?)
- [x] 자동차 일급 컬렉션에서 정적 팩토리 메서드 활용
  - [x] Companion Object를 활용한 정적 팩토리 메서드
- [x] 1 ~ n 반복하는 경우 List() 사용
- [x] 람다 파라미터가 하나인 경우 it으로 변경
  - `car -> car.move()` -> `it.move()`
- [x] readLine() 대신 readln() 사용
  - 차이점
    - readLine() 은 리턴 타입이 String?. 즉 null을 허용한다.
    - readln() 은 리턴 타입이 String. null에 대한 예외 처리가 되어 있다.
- [x] 매직 리터럴 상수 치환
  - [x] "-" -> DISPLAY_MARK
  - [x] 0 -> FINISHED_COUNT_OF_TRY
- [x] interface의 move 함수명의 반환 타입을 유추할 수 있게 변경
  - `fun move()` -> `fun canMoveIt()`
- [x] 반환하지 않는 함수는 run scope 함수 사용하지 않도록 변경
  - `fun race() = run {}` -> `fun race() = {}`
- [x] 조금 더 의미 있는 변수명을 변경
  - `moveCondition` -> `movingReferencePoint`
- [x] 자동차 대수 대신 자동차들을 주입 받도록 변경

---

# 🚀 4단계 - 자동차 경주(우승자)

## 기능 요구사항
- [x] 각 자동차에 이름을 부여할 수 있다.
  - [x] 자동차 이름은 5자를 초과할 수 없다.
    - [x] 자동차 이름은 1자 이상이어야 한다.
- [x] 입력 받은 이름으로 자동차를 생성한다
  - [x] 자동차 이름은 쉼표(,)를 기준으로 구분하여 입력한다.
- [x] 자동차의 이름과 위치를 같이 출력한다.
- [x] 우승자 선별
  - [x] 우승자의 위치 구하기
  - [x] 우승자는 한 명 이상일 수 있다.
- [x] 우승자 출력
