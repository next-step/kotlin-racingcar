# kotlin-racingcar

## 🚀 4단계 - 자동차 경주(우승자)
### 기능 요구 사항
+ 초간단 자동차 경주 게임을 구현한다.
  + 각 자동차에 이름을 부여할 수 있다. 자동차 이름은 5자를 초과할 수 없다.
  + 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
  + 자동차 이름은 쉼표(,)를 기준으로 구분한다.
  + 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.

### 프로그래밍 요구 사항
+ 모든 로직에 단위 테스트를 구현한다. 단, UI(System.out, System.in) 로직은 제외
  + 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
  + UI 로직을 InputView, ResultView와 같은 클래스를 추가해 분리한다.
+ indent(인덴트, 들여쓰기) depth를 2를 넘지 않도록 구현한다. 1까지만 허용한다.
  + 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
  + 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메소드)를 분리하면 된다.
+ 함수(또는 메소드)의 길이가 15라인을 넘어가지 않도록 구현한다.
  + 함수(또는 메소드)가 한 가지 일만 잘 하도록 구현한다.
+ 기능을 구현하기 전에 README.md 파일에 구현할 기능 목록을 정리해 추가한다.
+ git의 commit 단위는 앞 단계에서 README.md 파일에 정리한 기능 목록 단위로 추가한다.

### 힌트
+ 사용자가 입력한 이름의 숫자 만큼 자동차 대수를 생성한다.
+ 자동차는 자동차 이름과 위치 정보를 가지는 Car 객체를 추가해 구현한다.

### 구현 사항
- [x] 자동차 수 대신 자동차 이름을 입력 받는다.
  - [x] 자동차 이름은 5자를 초과할 수 없다.
  - [x] 자동차 이름은 쉼표(,)를 기준 으로 구분 한다.
- [x] 실행 결과 출력 시 자동차 이름도 함께 출력 한다.
- [x] 최종 우승 결과를 출력 한다.

---
## 🚀 3단계 - 자동차 경주
### 기능 요구 사항
+ 초간단 자동차 경주 게임을 구현한다.
  + 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
  + 사용자는 몇 대의 자동차로 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
  + 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
  + 자동차의 상태를 화면에 출력한다. 어느 시점에 출력할 것인지에 대한 제약은 없다.

### 프로그래밍 요구 사항
+ 모든 로직에 단위 테스트를 구현한다. 단, UI(System.out, System.in) 로직은 제외
+ 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
+ UI 로직을 InputView, ResultView와 같은 클래스를 추가해 분리한다.

### 구현 사항
- [x] 사용자에게 입력 받은 수 만큼 자동차 생성
- [x] 사용자에게 입력 받은 수 만큼 이동 횟수 생성
- [x] 자동차 수 * 이동 횟수 만큼 게임 진행
  - [x] 0에서 9 사이의 값을 랜덤하게 구함
  - [x] 4 이상인 경우 이동 했다는 정보 저장
- [x] 결과 출력

---
## 🚀 2단계 - 문자열 계산기
## 문자열 사칙 연산 계산기 구현
### 기능 요구 사항
+ 사용자가 입력한 문자열 값에 따라 사칙 연산을 수행할 수 있는 계산기를 구현해야 한다.
+ 문자열 계산기는 사칙 연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정된다. 즉, 수학에서는 곱셈, 나눗셈이 덧셈, 뺄셈 보다 먼저 계산해야 하지만 이를 무시한다.
+ 예를 들어 "2 + 3 * 4 / 2"와 같은 문자열을 입력할 경우 2 + 3 * 4 / 2 실행 결과인 10을 출력해야 한다.

### 프로그래밍 요구 사항
메서드가 너무 많은 일을 하지 않도록 분리하기 위해 노력해 본다.

### 구현 사항
- [x] 덧셈
- [x] 뺄셈
- [x] 곱셈
- [x] 나눗셈
- [x] 입력값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException throw
- [x] 사칙연산 기호가 아닌 경우 IllegalArgumentException throw
- [x] 사칙 연산을 모두 포함하는 기능 구현