# kotlin-racingcar

## Step4 자동차 경주(우승자)

### 요구사항

- 각 자동차에 이름을 부여할 수 있다. 자동차 이름은 5자를 초과할 수 없다.
- 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분한다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한명 이상일 수 있다.

### 설계 

#### Domain

- Car
     - 움직임의 주체이나, 움직일 지 말지는 rule에 의해 결정된다. 
     - data class로 자동차의 이름과 움직인 거리 정도만 가지고 있다.
- RacingResult
    - 매 시행의 결과로써 매 시행마다의 자동차의 움직임 결과를 가지고 있다.
    - 최종적으로 이 List<RacingResult>를 가지고 게임 결과를 출력한다. 
- TurnManager
    - 게임의 핵심 기능인 최대 시행 횟수 까지 매 시행을 수행하여 자동차를 움직이게끔 한다.
    - 자동차, 움직임 조건(Rule), 시행 결과를 가지고 있다.
    - startRaceUntilFinish()로 최종 결과를 반환한다.
- CarMovementRule
    - 자동차가 움직일 지 말지에 대한 규칙을 가지고 있다.
    - interface로 따로 쪼개놨기 때문에 MockUpRule을 설정하여 테스트가 용이했다.
- WinnerChecker
    - 결과를 가지고 누가 우승자인지 찾는다.
    - 최종 결과에서 자동차를 내림차순으로 정렬하여 우승자를 가려낸다.
- ResultPrinter
    - View에서 최종 결과를 출력할 때 출력 형식을 결정한다.
    - 실제 출력하는 것은 View에서 한다. 
    
#### Controller

- RacingController
    - Domain 로직과 View를 이어주는 역할
    - 컨트롤러가 생김으로써 Domain은 View에 의존하지 않고, View는 Domain에 직접 접근하지 않는다. 

#### View

- InputView, ResultView
    - 결과적으로 화면에서 입력/출력을 담당하는 뷰에 해당한다.
    - 나머지에 의존성을 불어 넣는다. 