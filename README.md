# kotlin-racingcar

<br><br><br><br>

## step2

### 미션 체크리스트 
```markdown
## 기능 요구사항
  - 문자열 입력에 따라 사칙연산을 수행하는 계산기를 구현한다
    - [x] 사칙연산의 연산자 우선순위를 적용하지 않고 입력받은 순서대로 계산한다.
  - 계산기 동작
    - [x] 덧셈 기능이 동작 해야 한다
    - [x] 뻴셈 기능이 동작 해야 한다
    - [x] 곱셈 기능이 동작 해야 한다
    - [x] 나눗셈 기능이 동작 해야 한다
  - 입력 유효 검사
    - [x] 입력이 null 이면 IllegalArgumentException throw
    - [x] 입력이 공백 문자열이면 IllegalArgumentException throw
    - [x] 사칙연산 기호가 아닌 경우 IllegalArgumentException throw


## 비 기능 요구사항
  - [ ] 메서드가 너무 많은 일을 하지 않도록 분리한다
```

<br><br><br><br>

## step3 

- 요구사항 체크리스트
```markdown
## 아키텍쳐 요구사항
- [x] 로직과 UI 를 분리하기

## 기능/구현 요구사항
- [x] 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- [x] 사용자는 몇 대의 자동차로 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- [x] 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- [x] 자동차의 상태를 화면에 출력한다. 어느 시점에 출력할 것인지에 대한 제약은 없다.
```


<br><br><br><br>

## step4 자동차 경주(우승자)

- 요구사항 체크리스트
```markdown

- 기능 요구사항
  - [x] 각 자동차에 이름을 부여할 수 있다. 
  - [x] 자동차 이름은 5자를 초과할 수 없다.
  - [x] 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
  - [x] 자동차 이름은 쉼표(,)를 기준으로 구분한다. 
  - [x] 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다.
  - [x] 우승자는 한 명 이상일 수 있다.

- 프로그래밍 & 아키텍쳐 (비기능) 요구사항
  - [x] 모든 로직에 단위 테스트를 구현한다. 단, UI(System.out, System.in) 로직은 제외
  - [x] 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분&분리 한다.
  - [x] UI 로직을 InputView, ResultView와 같은 클래스를 추가해 분리한다.
  - [x] indent(인덴트, 들여쓰기) depth를 2를 넘지 않도록 구현한다. 1까지만 허용한다.
      - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
      - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메소드)를 분리하면 된다. 
  - [x] 함수(또는 메소드)의 길이가 15라인을 넘어가지 않도록 구현한다.
  - [x] 함수(또는 메소드)가 한 가지 일만 잘 하도록 구현한다.
  - [x] 기능을 구현하기 전에 README.md 파일에 구현할 기능 목록을 정리해 추가한다.
  - [x] git의 commit 단위는 앞 단계에서 README.md 파일에 정리한 기능 목록 단위로 추가한다.
```

<br><br><br><br>


## step5 자동차 경주(리팩터링)

## 요구사항 정리
```markdown
- 비 기능적 요구사항
    - 핵심 비지니스 로직을 가지는 객체를 domain 패키지에 구현해야한다
    - UI 관련한 객체를 view 패키지에 구현해야한다
    - (MVC 패턴 기반으로 리팩토링) view 패키지의 객체가 domain 패키지 객체에 의존할 수 있다
    - (MVC 패턴 기반으로 리팩토링) domain 패키지의 객체는 view 패키지 객체에 의존하지 않도록 해야한다
    - 테스트 가능한 부분과 테스트하기 힘든 부분을 분리해 테스트 가능한 부분에 대해서만 단위 테스트를 진행한다.

- 기능적 요구사항(추가&피드백)
    - 자동차 이름이 공백인 경우 IllegalArgumentException throw
    - 자동차 이름이 null인 경우 IllegalArgumentException throw
    - 자동차 이름은 중복되선 안된다, 중복시 IllegalArgumentException throw 

- 이외
    - kotlin의 Delegation 을 학습하고 활용하자 (RoundHistory.kt)
    - kotlin의 object 클래스를 학습하고 활용하자 (ConsoleRender.kt, CarTokenizer.kt)
```
