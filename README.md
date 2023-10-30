# kotlin-racingcar

## 초간단 자동차 경주 게임

1. 각 자동차에 이름을 부여합니다. 자동차 이름은 5자를 초과할 수 없습니다.

2. 전진하는 자동차를 출력할 때에는 이름을 같이 출력합니다.

3. 자동차 이름은 쉼표(,)를 기준으로 구분합니다.

4. 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려줍니다. 우승자는 한 명 이상일 수 있습니다.

```
경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).
pobi,crong,honux
시도할 횟수는 몇 회인가요?
5

실행 결과
pobi : -
crong : -
honux : -

pobi : --
crong : -
honux : --

pobi : ---
crong : --
honux : ---

pobi : ----
crong : ---
honux : ----

pobi : -----
crong : ----
honux : -----

pobi, honux가 최종 우승했습니다.
```

## 사전 구현 계획

### 위치

- `class Position`
    - 프로퍼티: `xPos`,

### 자동차

- `class Car`
    - 프로퍼티: `Name`, `Position`,

### Winner

- `sealed interface RacingCarWinner`
    - `data class SingleWinner`
    - `data class MultipleWinner`

### Policy

#### 이동

- `sealed interface MovementPolicy`
    - `interface RandomMovement`
        - `class RandomMovementImpl`

#### 순위

- `sealed interface RankingPolicy`
    - `interface MultipleWinnersAllowed`
        - `class MultipleWinnersAllowedImpl`
    - `interface SingleWinnerOnly`
        - `class SingleWinnerOnlyImpl`

### RacingCarRoad

- `data class RacingCarRoad`: 자동차들 위치를 알고 순위를 관리
    - 프로퍼티: `Cars`, `RankingPolicy` 구현체


- UI 로직 구현
    - `InputView class`, `ResultView class`

