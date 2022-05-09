# kotlin-racingcar

## 요구 사항 정의
### Domain
- 이동 명령(MovementCommand)
  - [x] 입력 숫자가 0 ~ 3이면 대기 명령(WAIT)이다.
  - [x] 입력 숫자가 4 ~ 9면 전진 명령(FORWARD)이다.
  - [x] 입력 숫자가 범위를 벗어나면 예외를 발생시킨다.


- 자동차(Car)
  - [x] 이동 명령이 전진(Forward)이면 앞으로 전진한다.
  - [x] 이동 명령이 대기(Wait)이면 현재 위치에서 대기한다.


- 경주에 참여한 자동차들(RacingCars)
  - [x] 경주에 참여한 자동차가 없다면 예외를 발생시킨다.
  - [x] 이동 명령을 생성해 자동차에게 전달한다.
  - [x] 경주가 끝나면 경주 기록(RaceRecord)을 반환한다.


- 경주 게임(RacingGame)
  - 진행할 경주 횟수를 알고 있다.
  - 경주에 참여한 자동차를 알고 있다.
  - [x] 주어진 경주 횟수가 유효하지 않다면 예외를 발생시킨다.
  - [x] 경주를 주어진 횟수만큼 진행한다.
  - [x] 모든 경주가 끝나면 게임 기록(GameRecord)을 반환한다.
  

### Application
- 경주 게임 관리자(RacingGameManager)
  - [x] 경주에 참여할 자동차를 생성한다.
  - [x] 경주 게임을 생성하고 실행한다.
  - [x] 게임 결과(GameResult)를 반환한다.

### UI
- 입력 뷰(InputView)
    - GameInput을 입력받는다.


- 결과 뷰(ResultView)
    - GameResult를 출력한다.


- 게임 런처(GameLauncher)
  - 입력 뷰에서 입력받은 GameInput을 통해 경주 게임 관리자(RacingGameManager)를 실행한다.
  - 경주 게임 관리자가 반환한 GameResult를 결과 뷰에 전달한다
  

### 공통 모듈
- RandomCommandGenerator
  - [x] 0~9 사이의 숫자를 생성한다
