# kotlin-racingcar
## 1. calculator
### 기능 요구 사항
* 더하기 기능
* 빼기 기능
* 곱하기 기능
* 나누기 기능 구현
    * 0으로 나눌 수 없다.
* 수식 검증 기능
    * 입력값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException throw
    * 입력 수식 " "로 파싱 후 사이즈가 3 미만이거나 홀수가 아닐 경우 IllegalArgumentException throw
    * 입력 수식 " "로 파싱 후 짝수 인덱스가 숫자, 홀수 인덱스가 연산자가 아닐 경우 IllegalArgumentException throw

### 기능 목록
* [CaculatorApplication] 메인 클래스
* [Operator] 사칙 연산자를 관리하는 클래스
* [ExpressionValidator] 입력된 값이 계산이 가능한지 검증하는 클래스
* [Calculator] 계산을 진행하는 클래스

---

## 2. racingcar
### 기능 요구 사항
* 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
* 사용자는 몇 대의 자동차로 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
* 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.

### 기능 목록
* [InputView] 입력을 담당하는 클래스
* [OutputView] 출력을 담당하는 클래스
* [RandomNumberGenerator] 범위에 해당하는 랜덤 값을 생성하는 클래스
* [Car] 자동차 클래스
  * 전진 가능한 상태이면 MoveStrategy에 정의된 값 만큼 이동
* [MoveStrategy] 이동 타입을 정의한 클래스
  * 타입에 따라 자동차의 이동가능 여부를 판단
  * 자동차가 이동할 수 있는 거리를 관리
* [RacingcarApplication] 레이싱 게임을 시작하는 메인 클래스
* [RacingGame] 자동차 대수, 시도할 횟수, 무브 타입을 받아서 게임을 시작하는 클래스
