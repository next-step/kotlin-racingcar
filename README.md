# kotlin-racingcar

## 미션 피드백 링크

- Step 1 : [https://github.com/next-step/kotlin-racingcar/pull/1257](https://github.com/next-step/kotlin-racingcar/pull/1257)
- Step 2 : [https://github.com/next-step/kotlin-racingcar/pull/1320](https://github.com/next-step/kotlin-racingcar/pull/1320)
- Step 3 : [https://github.com/next-step/kotlin-racingcar/pull/1434](https://github.com/next-step/kotlin-racingcar/pull/1434)
- Step 4 : [https://github.com/next-step/kotlin-racingcar/pull/1504](https://github.com/next-step/kotlin-racingcar/pull/1504)

<br>

## 미션 내용

### STEP 1

<details>
<summary>접기/펼치기</summary>
<div markdown="1">

- [x] 실습 환경 구축
- [x] 코틀린 학습 테스트

</div>
</details>

<br>

### STEP 2

<details>
<summary>접기/펼치기</summary>
<div markdown="1">

> 사칙 연산의 계산 운선순위 무시 => 입력 값 순서대로 계산

- [x] 덧셈
  - [x] 테스트 코드 작성
  - [x] 기능 구현
- [x] 뺄셈
  - [x] 테스트 코드 작성
  - [x] 기능 구현
- [x] 곱셈
  - [x] 테스트 코드 작성
  - [x] 기능 구현
- [x] 나눗셈
  - [x] 테스트 코드 작성
  - [x] 기능 구현
- [x] 입력 값 순서대로 계산되는 계산기
  - [x] 테스트 코드 작성
  - [x] 기능 구현
- [x] 유효성 검증
  - [x] 입력값이 null이거나 빈 공백 문자일 경우
    - [x] 테스트 코드 작성
    - [x] 기능 구현
  - [x] 사칙연산 기호가 아닌 경우
    - [x] 테스트 코드 작성
    - [x] 기능 구현
  - [x] 첫번째 입력값이 숫자가 아닌 경우
    - [x] 테스트 코드 작성
    - [x] 기능 구현
</div>
</details>

<br>

### STEP 3

<details>
<summary>접기/펼치기</summary>
<div markdown="1">

#### [요구 사항 분석]

- 0 ~ 9 무작위 수 추출 메서드
- 4 이상인지 확인하는 메서드(전진 조건 여부)
- 각각의 자동차가 주어진 횟수만큼 시도하는 메서드(사실상 메인 함수)
- 자동차 상태 출력 메서드

#### [Todo List]

- [x] 0부터 9까지 무작위 수 추출 기능
- [x] 전진 조건 여부 확인 기능
- [x] 입력 받은대로 각각의 자동차가 주어진 횟수만큼 시도하는 기능 (InputView)
- [x] 한 턴마다 자동차의 전진 상태를 출력하는 기능 (ResultView)

</div>
</details>

<br>

### STEP 4


<details>
<summary>접기/펼치기</summary>
<div markdown="1">


#### [요구 사항 분석]

- 자동차에 이름 부여 (5글자 초과 X -> 5글자까지 가능)
- 전진 상태 출력 시 이름도 같이 출력
- 자동차 이름 입력 값은 `,`로 구분
- 마지막에 최종 우승 자동차 출력 (우승자는 여러명도 가능 -> 한명 이상 가능)
- 모든 로직 단위 테스트 구현
- indent depth 2를 넘지 않도록 제한 (뎁스 1까지만 허용)
- 함수 길이는 15라인 이하로 제한

#### [피드백]

- 린트 체크
- 누락된 중요한 도메인 관련 기능과 테스트 추가
  - 도메인은? : 자동차(Car) 객체 내부에 있는 로직(함수)인 것으로 추정
- 랜덤 수 생성 기능 리팩터링
  - 랜덤 기능은 코틀린 자체에서 지원해주는 것이 있음
  - 코틀린 자체에서 내부적으로 많이 사용하고, 많은 테스트로 기능이 검증되어 있으므로 대체하는 것이 좋을 듯함
  - `kotlin.random.*`
- 정적 메서드만 사용하는 객체는 object로 선언
  - companion object은 정적 멤버 정의할 때 유용한 기능
- 전진 상태 출력 리팩터링
  - print() 여러번 호출 -> 문자열을 만들어놓고 한번만 출력하도록 변경
- InputView 리팩터링
  - `Pair<?, ?>` 사용보다 InputView가 필요한 입력값을 명확하게 정의 (생성자)
- 프로퍼티 변경자는 접근 제어
  - private
  
#### [Todo List]

- [x] 피드백을 반영한다.
- [x] 자동차는 0부터 9까지의 임의의 수 중에 4 이상일 경우에만 전진할 수 있다.
- [x] 자동차는 위치를 가지고, 기본 값은 0이다.
- [x] 자동차는 임의의 수 4 이상일 경우 위치가 1 증가한다.
- [x] 자동차는 이름을 가지고, 5글자를 초과할 수 없다.
- [x] 자동차 이름들은 `,` 기준으로 구분한다.
- [x] 입력 받은 시도 횟수만큼 경주 게임을 시도한다.
- [x] 매 턴마다 자동차들의 전진 상태를 출력한다.
- [x] 게임 완료 후 우승자가 1명일 때 해당 이름을 출력한다.
- [x] 게임 완료 후 우승자가 여러명일 때 해당 이름들을 출력한다.
- [x] 모든 indent depth는 2를 넘지 않는다.
- [ ] 모든 함수 길이는 15라인 이하로 제한한다.
- [x] 린트를 체크한다.


</div>
</details>

## STEP 5

#### [요구 사항 분석]

- 핵심 비즈니스 로직을 가진 객체 : domain 패키지
- UI 관련 객체 : view 패키지
- view 패키지는 domain 패키지를 의존 <-> domain 패키지는 view 패키지에 의존하면 안됨 (의존 역류 주의)
- 테스트 가능한 부분은 최대한 단위 테스트 진행 (테스트 불가 영역을 잘 분리하기)

#### [Todo List]

- [ ] 피드백 반영
  - [x] 게임을 진행하는 main 함수는 별도로 분리한다.
- [ ] domain 패키지와 view 패키지로 각각 분리하고, 의존성을 제한한다.
- [ ] 테스트 불가능한 영역을 분리한다.
- [ ] 테스트 가능한 모든 영역에 단위 테스트를 진행한다.
