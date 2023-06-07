# kotlin-racingcar

```
- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 사용자는 몇 대의 자동차로 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- 자동차의 상태를 화면에 출력한다. 어느 시점에 출력할 것인지에 대한 제약은 없다.
```

### car
- [x] 자동차는 현재 본인의 위치를 가진다.
- [ ] 새로 생성될 자동차의 최초 위치는 0이다.
- [ ] 자동차는 4 ~ 9의 값이 들어올 경우 전진한다.
- [ ] 자동차는 0 ~ 3의 값이 들어올 경우 움직이지 않는다.
- [ ] 자동차의 이동에 입력되는 값는 랜덤하게 들어온다.

### input view
- 자동차의 대수를 입력받을 수 있다.
  - [ ] 자동차의 대수는 숫자로만 입력가능하다.
  - [ ] 자동차의 대수는 1이상의 양수만 입력가능하다.
- 게임을 몇회 시도할지 입력받을 수 있다.
  - [ ] 시도 횟수는 숫자로만 입력가능하다.
  - [ ] 시도 횟수는 1이상의 양수만 입력가능하다.
```
자동차 대수는 몇 대인가요?
3
시도할 횟수는 몇 회인가요?
5
```

### output view
- [ ] 자동차의 위치를 매 시도횟수마다 출력한다.
  - 출력은 1거리당 "-"으로 출력한다.
```
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
