# [3단계] 초간단 자동차 경주 구현

# 요구사항
- [X] 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- [X] 사용자는 몇 대의 자동차로 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- [x] 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- [X] 자동차의 상태를 화면에 출력한다. 어느 시점에 출력할 것인지에 대한 제약은 없다.
- [X] 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
    - View와 Domain 패키지로 분리
    - View - InputView, ResultView와 같은 UI 클래스
    - Domain - 자동차 경주 핵심 로직
- [X] 모든 로직에 단위 테스트를 구현한다. 단, UI(System.out, System.in) 로직은 제외

# 책임
- 경주를 하라 -> CarRace.start()
- 이동 여부를 결정해라
  -> MoveStrategy: RandomBasedMoveStrategy, TimeBasedMoveStrategy
- 이동해라 -> Car.move()

# 기능 상세
  - InputView
    - [X] 이동할 자동차 대수를 입력받는다
    - [X] 시도할 경기 횟수를 입력받는다 
  - ResultView
    - [ ] 경기 횟수별 자동차 상태를 화면에 출력한다 
  - Position, Positions: 자동차 위치 
  - Car: 자동차 
    - [X] MoveStrategy 따라 이동한다
    - [X] 현재 위치를 알고 있다
  - Cars: 자동차들(일급 컬렉션)
    - [X] 자동차들을 움직이게 한다
  - CarRace: 자동차 경주
    - [X] 자동차 대수만큼 자동차를 생성한다 
    - [X] 자동차 경기를 시작한다
  - RaceRecord: 자동차 경주 결과
    - [X] 매 경기별 자동차 위치를 기억한다
  - MoveStrategy: 이동 정책
    - [X] RandomBasedMoveStrategy: 0 - 9 사이 램덤 값을 이용해 이동 여부를 결정한다
# 예시
```
자동차 대수는 몇 대인가요?
3
시도할 횟수는 몇 회인가요?
5

실행 결과
-
-
-

--
-
--

---
--
---

----
---
----

----
----
-----
```