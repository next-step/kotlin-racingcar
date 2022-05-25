# kotlin-racingcar

## calculator todo list
* [x] 1차 기능 구현 pr요청
* [x] todo list 작성
* [x] nullable관련 제거, 네이밍변경 등등
* [x] `require`사용해보기
* [x] 테스트코드명 변경하고, `@CsvSource` 활용해서 테스트코드추가

## 3단계 racingcar 기능요구사항
- [x] 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다. - RacingGame
- [x] 사용자는 몇 대의 자동차로 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다. - InputView
- [x] 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다. - Car
- [x] 자동차의 상태를 화면에 출력한다. 어느 시점에 출력할 것인지에 대한 제약은 없다. - ResultView

## 4단계 racingcar 기능요구사항
- [x] 자동차의 이름을 부여하고, 이름은 5자를 초과할수 없다. - Car
- [ ] 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다. - ResultView
- [x] 자동차 이름은 쉼표(,)를 기존으로 구분한다. - InputView
- [ ] 자동차 경주 게임을 완료한 후 우승자를 알려준다. 이때 우승자는 1명 이상일 수 있다. - Winner
