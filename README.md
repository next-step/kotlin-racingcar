# Nextstep 4기

## 1단계 - 코틀린 기초

- 패스

## 2단계 - 계산기

### 기능 요구 사항

* 사용자가 입력한 문자열 값에 따라 사칙 연산을 수행할 수 있는 계산기를 구현해야 한다.
* 문자열 계산기는 사칙 연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정된다. 즉, 수학에서는 곱셈, 나눗셈이 덧셈, 뺄셈 보다 먼저 계산해야 하지만 이를 무시한다.
* 예를 들어 "2 + 3 * 4 / 2"와 같은 문자열을 입력할 경우 2 + 3 * 4 / 2 실행 결과인 10을 출력해야 한다.

### 체크 리스트

* [x] 사칙연산 로직 단위테스트
    * [x] 더하기
    * [x] 빼기
    * [x] 곱하기
    * [x] 나누기
* [x] 사칙연산 로직 구현
    * [x] 더하기
    * [x] 빼기
    * [x] 곱하기
    * [x] 나누기
* [x] 입력 유효성 검사 로직 단위테스트
    * [x] 입력값이 null 또는 공백인 경우 
    * [x] 입력값에 유효하지 않은 사칙연산 기호가 포함된 경우
* [x] 입력 유효성 검사 로직 구현
    * [x] 입력값이 null 또는 공백인 경우 
    * [x] 입력값에 유효하지 않은 사칙연산 기호가 포함된 경우

## 3단계 - 자동차 경주

### 기능 요구 사항

* 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
* 사용자는 몇 대의 자동차로 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
* 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
* 자동차의 상태를 화면에 출력한다. 어느 시점에 출력할 것인지에 대한 제약은 없다.

### 체크 리스트
* [x] UI 레이어 단위 테스트 구현 (System 코드는 제외)
* [ ] UI 레이어 로직 구현
    * [ ] 입력 화면
    * [ ] 결과 화면
* [ ] 자동차의 상태 로직 구현
* [ ] 경기(Racing) 제어 로직 구현
