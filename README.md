# kotlin-racingcar

## STEP 2
### 문자열 계산기

#### 요구사항
- 사용자가 입력한 문자열 값에 따라 사칙 연산을 수행할 수 있는 계산기를 구현해야 한다.
- 문자열 계산기는 사칙 연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정된다. 즉, 수학에서는 곱셈, 나눗셈이 덧셈, 뺄셈 보다 먼저 계산해야 하지만 이를 무시한다.
- 예를 들어 "2 + 3 * 4 / 2"와 같은 문자열을 입력할 경우 2 + 3 * 4 / 2 실행 결과인 10을 출력해야 한다.

## STEP 3
### 자동차 경주

#### 요구사항
- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 사용자는 몇 대의 자동차로 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- 자동차의 상태를 화면에 출력한다. 어느 시점에 출력할 것인지에 대한 제약은 없다.


## STEP 4 
### 자동차 경주(우승자)

#### 요구사항
- [x] 각 자동차에 이름을 부여할 수 있다. 자동차 이름은 5자를 초과할 수 없다.
    - [x] 경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분). 메시지를 출력한다.
    - [x] 문자열 길이가 5자를 초과할 경우, 자동차 이름은 5자를 초과할 수 없습니다. 에러 발생시킨다. 
- [x] 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다. 
    - [x] 이름 다음 : 특수문자를 붙인다.
    - [x] 전진하지 않더라도 이름을 출력한다.
- [x] 자동차 이름은 쉼표(,)를 기준으로 구분한다.
    - [x] 쉼표(,)가 없을 경우 한명으로 간주한다.  
    - [ ] 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
- [ ] pobi, honux가 최종 우승했습니다. 는 메시지를 출력한다. 

