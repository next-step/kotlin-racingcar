# kotlin-racingcar
# 요구사항 정리

## 문자열 계산기
* [X] 덧셈
* [X] 뺄셈
* [X] 곱셈
* [X] 나눗셈
* [X] 예외
  * [X] 입력값이 null이거나 빈 공백 문자일 경우 부적절 인수 예외
  * [X] 사칙연산 기호가 아닌 경우 부적절 인수 예외

### 도메인 분리
* Input Domain
  * null 및 empty 예외 처리
  * 숫자와 사칙연산으로만 이루어져 있는지 확인
* 사칙연산 interface
* Input Domain 및 사칙연산 interface를 활용해서 결과값을 받는 Service Layer

## 자동차 경주
* [x] 이동 시도 횟수를 입력 받을 함수
* [x] 자동차 대수를 입력 받을 함수
* [x] 자동차는 이동 또는 멈출 수 있다.
* [x] 이동 조건은 0-9까지 랜덤 값에서 4이상일 경우
* [x] 자동차 이동 상태를 마지막에 출력한다
* [X] 이름을 입력 받고 이름은 5글자를 초과할 수 없다
* [x] 출력할 때 자동차 이름도 같이 출력한다
* [x] 게임 종료 후 우승자를 구한다 우승자는 복수일 수 있다.

### 도메인 분리
* InputView
  * 자동차 수
  * 거리이동 도전 횟수
* ResultView
  * 이동거리 출력
* RaceController
  * 실행 및 호출 컨트롤
* Racing
  * 자동차 일급 컬렉션을 관리하는 도메인
* Cars
  * 차량 생성 및 이동 여부 판별
* Car
  * 차량 상태를 관리하는 객체
* MoveDistance
  * 차량 이동거리를 관리하는 객체
* CarMovingStrategy
  * 랜덤값 생성하여 차량이 이동할지 판별
* CarName
  * Type 체크 및 5글자 이상인지 판별
* RaceWinner
  * Cars 객체를 받아서 우승자 체크
* Winners
  * 우승자를 구하는 도메인
