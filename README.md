# kotlin-racingcar

## [STEP 1] 코틀린 기초

코틀린 문법을 익히기 위한 학습 테스트 작성

## [STEP 2] 문자열 계산기

### 요구사항

- 사용자가 입력한 문자열 값에 따라 사칙 연산을 수행할 수 있는 계산기를 구현해야 한다.
- 문자열 계산기는 사칙 연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정된다. 즉, 수학에서는 곱셈, 나눗셈이 덧셈, 뺄셈 보다 먼저 계산해야 하지만 이를 무시한다.
- 예를 들어 "2 + 3 * 4 / 2"와 같은 문자열을 입력할 경우 2 + 3 * 4 / 2 실행 결과인 10을 출력해야 한다.

### 고민사항

- static 메서드로 구현하는게 좋을까? 객체를 생성하는게 좋을까?
    - 내부 필드를 저장해서 쓸 일이 있을까? → 없다.
    - 다른 객체와 의존성이 필요할까? -> 없다.
      -> static 으로 구현하자.
- 코틀린 문법을 거의 모르다보니, 자바 스타일로 구현하게 되었다. 코틀린만의 문법을 활용해보고 싶다...

### TODO

- [x] 덧셈 계산 테스트
    - split() 메서드에서 양쪽에 `""`이 생겨서 빈 문자는 제거해야 했음.
- [x] 입력 문자열에 빈 공백이 포함되어 있는 경우 삭제 처리
- [x] 뺄셈 계산 테스트
- [x] 곱셈 계산 테스트
- [x] 나눗셈 계산 테스트
- [x] 숫자가 2자리 이상인 경우 처리
- [x] ParameterizedTest로 여러 입력값에 대한 테스트 추가하기 (+ 3개 이상 인자 계산)
- [x] 입력값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException throw
- [x] 사칙연산 기호가 아닌 경우 IllegalArgumentException throw
- [x] 아래 구현 전에, 0으로 나눈 경우는 나누기 계산에 책임이 있으므로 계산별로 분리하는 리팩토링과 전체 코드 리팩토링
- [x] 0으로 나누기를 시도한 경우 IllegalArgumentException throw

## [STEP 3] 자동차 경주
### 기능 요구 사항
초간단 자동차 경주 게임을 구현한다.

- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다. 
- 사용자는 몇 대의 자동차로 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다. 
- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다. 
- 자동차의 상태를 화면에 출력한다. 어느 시점에 출력할 것인지에 대한 제약은 없다.

### TODO
- [x] 자동차는 현재 위치를 가지고 있어야 한다.
  - 최초는 위치가 0
- [x] 자동차는 전진이 가능하다.
- [x] 자동차 게임은 0~9 사이의 랜덤 값을 구할 수 있다.
- [x] 0~9 사이 랜덤 값으로 이동할지 말지는 게임이 아니라 게임 룰의 책임이다.
- [x] 랜덤 숫자 생성 유틸 클래스 테스트
- [x] 게임 룰에서 랜덤 숫자 생성 유틸 클래스 사용하는 것으로 변경
- [x] 자동차는 게임 룰을 통해서 앞으로 이동할지 말지 판단한다.
  - 자동차 객체를 생성할 때, 게임 룰을 주입받자.
  - 레이싱 자동차로 이름을 변경하자.
- [x] 레이싱 게임은 자동차 대수와 시도할 횟수를 갖는다.
- [x] 레이싱 게임은 게임 룰도 생성 시점에 받아서 레이싱 자동차를 생성할 때 이를 사용한다.
- [x] 생성된 레이싱 게임으로 start를 하면 각 자동차의 결과를 반환한다.
- [x] 콘솔에서 자동차 대수와 시도할 횟수를 입력받는다.
- [x] 자동차는 자신이 시도한 기록의 모든 정보를 갖고 있어야 한다.
- [x] 시도한 횟수만큼 자동차의 위치를 각각 콘솔에 출력한다.
- [x] 레이싱 게임 각 시도는 라운드로 표현하고, 이는 RacingGame에서 관리한다.

### 고민사항
- 랜덤 값을 가지고 이동할지 말지에 대한 것은 게임 룰에 책임이 있다.
  - 그러면 랜덤 값을 어떻게 테스트할까?
  - 테스트에서는 랜덤이 아닌 직접 값을 설정할 수 있도록 해보자!

## [STEP 4] 자동차 경주(우승자)
초간단 자동차 경주 게임을 구현한다.

- 각 자동차에 이름을 부여할 수 있다. 자동차 이름은 5자를 초과할 수 없다.
- 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분한다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.

### TODO
- [x] RacingCar 객체 주 생성자에 이름을 받는다.
  - 이름없는 레이싱카는 없다고 생각했음.
- [x] 이름 유효성 검사
  - 이름은 5자를 초과할 수 없다.
  - 빈값은 불가능하다.
- [x] 결과 출력에 레이싱카 이름도 같이 출력한다.
- [x] 레이싱카 게임 시작할 때, 콘솔에서 이름을 받는다. 문자열 한 줄로 받는다.
  - [x] 입력받은 이름은 공백일 수 없다 -> 테스트
- [x] 입력받은 한 줄의 레이싱카 이름들은 쉼표로 구분하여 저장한다.
- [x] 우승자 출력
  - [x] Winners 객체는 우승자들을 갖는다. (우승자 계산 담당)
  - RacingGame.start의 결과로 RacingResult를 반환하도록 변경한다.
  - RacingResult는 각 라운드의 결과들과 우승자 리스트를 갖는다.
  - RacingResult는 각 라운드의 결과로 생성을 시도하면 내부에서 우승자를 계산하여 저장한다.

## [STEP 5] 자동차 경주(리팩터링)

### 요구사항
- 핵심 비지니스 로직을 가지는 객체를 domain 패키지, UI 관련한 객체를 view 패키지에 구현한다.
- MVC 패턴 기반으로 리팩토링해 view 패키지의 객체가 domain 패키지 객체에 의존할 수 있지만, domain 패키지의 객체는 view 패키지 객체에 의존하지 않도록 구현한다.

### TODO
- [x] 4단계 피드백 반영
- [x] domain 패키지 분리
