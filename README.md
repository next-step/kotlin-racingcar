# kotlin-racingcar

<br><br><br><br>

## step2

### 미션 체크리스트 
```
## 기능 요구사항
  - 문자열 입력에 따라 사칙연산을 수행하는 계산기를 구현한다
    - [x] 사칙연산의 연산자 우선순위를 적용하지 않고 입력받은 순서대로 계산한다.
  - 계산기 동작
    - [x] 덧셈 기능이 동작 해야 한다
    - [x] 뻴셈 기능이 동작 해야 한다
    - [x] 곱셈 기능이 동작 해야 한다
    - [x] 나눗셈 기능이 동작 해야 한다
  - 입력 유효 검사
    - [x] 입력이 null 이면 IllegalArgumentException throw
    - [x] 입력이 공백 문자열이면 IllegalArgumentException throw
    - [x] 사칙연산 기호가 아닌 경우 IllegalArgumentException throw


## 비 기능 요구사항
  - [ ] 메서드가 너무 많은 일을 하지 않도록 분리한다
```

<br><br><br><br>

## step3 

- 요구사항 체크리스트
```
## 아키텍쳐 요구사항
- [x] 로직과 UI 를 분리하기

## 기능/구현 요구사항
- [x] 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- [x] 사용자는 몇 대의 자동차로 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- [x] 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- [x] 자동차의 상태를 화면에 출력한다. 어느 시점에 출력할 것인지에 대한 제약은 없다.
```

