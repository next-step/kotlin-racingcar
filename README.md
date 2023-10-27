# kotlin-racingcar

---

## 기능 요구 사항
- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 사용자는 몇 대의 자동차로 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- 자동차의 상태를 화면에 출력한다. 어느 시점에 출력할 것인지에 대한 제약은 없다.

## 프로그래밍 요구 사항
- 모든 로직에 단위 테스트를 구현한다. 단, UI(System.out, System.in) 로직은 제외
  - 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
  - UI 로직을 InputView, ResultView와 같은 클래스를 추가해 분리한다.

## 기능 정리
- 입력
  - [x] 사용자에게 몇 대의 자동차를 설정할지 입력받는다.
  - [x] 사용자에게 몇 번의 이동을 할지 입력받는다.
- 기능
  - [] n대의 자동차를 생성한다.
  - [] n번의 이동을 한다.
    - [] 0 ~ 9 사이의 무작위 값을 생성한다.
    - [] 무작위 값이 4일 경우 전진한다.
    - [] 4가 아닐경우 정지한다.
- 화면
    - [] 실행 결과를 화면에 출력한다.