## 기능 요구 사항

초간단 자동차 경주 게임을 구현한다.

[X] 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
[X] 사용자는 몇 대의 자동차, 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
[X] 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
[X] 자동차의 상태를 화면에 출력한다. 어느 시점에 출력할 것인지에 대한 제약은 없다.

## 프로그래밍 요구 사항

[ ] 모든 로직에 단위 테스트를 구현한다. 단, UI(System.out, System.in) 로직은 제외
[X] 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
[X] UI 로직을 InputView 클래스로 추가해 분리한다.
[X] UI 로직을 ResultView 클래스로 추가해 분리한다.

[X] 숫자가 아닌 입력을 받으면 IllegalArgumentException을 던진다

## 힌트

값을 입력 받는 API는 kotlin.io의 readLine을 이용한다.

```
val value: String? = readLine()
val value: String = readLine()!!
val number = readLine()!!.toInt()
```

