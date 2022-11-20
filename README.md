# kotlin-racingcar

## How to run
```kotlin
fun main() {
    RacingGameApplication.start()
}
```

## 진행 방법
* 자동차 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

---
## Functionality Requirements
### Step 3
- [x] 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- [x] 사용자는 몇 대의 자동차로 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- [x] 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- [x] 자동차의 상태를 화면에 출력한다. 어느 시점에 출력할 것인지에 대한 제약은 없다.

### Step 4
- [x] 각 자동차에 이름을 부여할 수 있다. 자동차 이름은 5자를 초과할 수 없다.
- [x] 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- [x] 자동차 이름은 쉼표(,)를 기준으로 구분한다.
- [x] 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.

---
## Programming Requirements
1. Interface Segregation Principle (Method Separation)
    - Indent depth max: 1
    - Don't use "else" and "switch/case".
    - Method Code Line max : 10
    - Method has only one responsibility. (SRP)

2. Unit Test
    - Implement unit test for logic. (But not need for UI Layer.)
    - Logic Layer, UI Layer
    - Using JUnit5, AssertJ

3. Code Refactoring
    - Implementation by using First Class Collection
    - Wrapping all primitive and string values

---
## Project Requirements
- [https://github.com/next-step/kotlin-racingcar](https://github.com/next-step/kotlin-racingcar)
- [Commit Message Conventions](https://gist.github.com/stephenparish/9941e89d80e2bc58a153)

---
## 기능 목록
- [ ] 자동차 생성
  - [x] 자동차 이름의 길이가 5글자를 넘는 경우 예외가 발생한다
  - [x] 자동차 이름의 길이가 5글자를 넘지 않으면 정상적으로 생성된다
  - [x] 생성된 자동차는 이름과 위치를 가진다
- [ ] 자동차 이동
  - [x] 4보다 크거나 같으면 자동차는 이동한다
  - [x] 4보다 작으면 자동차는 정지한다
- [ ] 자동차 이름 변경 
  - 
- [ ] 자동차들 생성
  - [ ] 이름을 ","로 구분
  - [ ] 자동차가 2대 이상이 안 되는 경우
- [ ] 자동차들 이동
- [ ] 우승
  - [ ] 단일 우승
  - [ ] 공동 우승

## 기능 요구 사항 
- [ ] 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- [ ] 자동차 이름은 쉼표(,)를 기준으로 구분한다.
- [ ] 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.