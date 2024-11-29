# kotlin-racingcar

## step-2

### 요구 사항
1. 사용자가 입력한 문자열 값에 따라 사칙 연산을 수행할 수 있는 계산기 구현(입력한 순서대로 계산)
   1. 덧셈
   2. 뺄셈
   3. 곱셈
   4. 나눗셈
   5. 입력값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException throw
   6. 사칙연산 기호가 아닌 경우 IllegalArgumentException throw
   7. 사칙 연산을 모두 포함하는 기능 구현
2. 테스트 코드 작성

### Feedback - 1
1. Calculator Class -> object class 로 변경
2. Calculator의 Double.operate() 를 Operaotr로 위임
3. Calculator require 활용
4. Calculator 0 대응
5. Operator의 String.toOperator() 를 Companion object 함수로 변경
6. Calculator 매직넘버 상수로 선언
7. Calculator validateFormula 분리

### Feedback - 2
1. calculate 메서드 파라미터 네이밍 수정
2. Operator의 from 메서드에 어떤 value가 들어왔는지 예외 메시지에 보여주기
3. Operator의 operate 메서드 수정


## step-3

### 요구사항
1. 초간단 자동차 경주 게임을 구현
2. 경주 게임 로직 클래스 구현
3. UI 로직 클래스 구현
   1. InputView
   2. ResultView
4. 테스트 코드 작성

### Feedback - 1
1. getRandomNumber 수정 혹은 삭제
2. randomNumberRange 상수 네이밍 컨벤션 적용
3. InputView.inputValues() 분리
4. RaceManager의 initCarList 분리
5. carList 네이밍 수정
6. 람다 변수 네이밍 수정
7. Car INITIAL_POSITION private 사용
8. InputView의 getNumber - requireNotNull 사용
9. RaceManager "-" 상수로 추출
10. Car의 updateCarPosition 네이밍 변경
11. CarTest - 전진하지 않는 케이스의 테스트 코드 추가
12. RaceManager 테스트하기 쉬운 코드 고민 및 수정

## Feedback - 2
1. model 패키지, core 패키지 개선
2. RANDOM_NUMBER_RANGE 접근 제한자 수정
3. isAdvancePossible 에 대한 테스트 코드 작성
4. startRacing 테스트 코드 작성
5. getMovedCars 개선 혹은 삭제
6. RaceManager 개선
   1. carCount 삭제
7. Car 의 자동자들 생성 역할 다른 객체로 위임


## step-4

### 기능 요구사항
1. 각 자동차에 이름을 부여할 수 있다.
2. 자동차 이름은 5자를 초과할 수 없다.
3. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
4. 자동차 이름은 쉼표(,)를 기준으로 구분한다.
5. 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다.
6. 우승자는 한 명 이상일 수 있다.

### 프로그래밍 요구사항
1. 모든 로직에 단위 테스트를 구현한다.
2. indent(인덴트, 들여쓰기) depth를 2를 넘지 않도록 구현한다. 1까지만 허용한다.
3. 함수(또는 메소드)의 길이가 15라인을 넘어가지 않도록 구현한다.
4. 기능을 구현하기 전에 README.md 파일에 구현할 기능 목록을 정리해 추가한다.
5. git의 commit 단위는 앞 단계에서 README.md 파일에 정리한 기능 목록 단위로 추가한다.

### Feedback - 1
1. startRacing 진행 후, 각각의 car의 position이 얼마인지를 검증하는 테스트 추가
2. RaceConditionChecker - 랜덤한 숫자를 뽑아내는 로직 포함
3. Car의 최대 이름 길이 상수명 수정
4. Car의 예외 메시지의 최대 이름 제한 길이도 상수로 주입
5. CarFactory - generateCars 개선
6. getRacingChampions 개선
   1. 객체에게 메세지 보내기
   2. 체이닝 개선
   3. getRacingChampions 네이밍 수정
   4. RaceHistory로 위임
7. startRacing의 raceHistories 개선

### Feedback - 2
1. startRacing 테스트 가능하게 리팩터링
2. 우승자 판별 로직 개선 - 우승자 판별하는 역할을 위임할 객체 추가
3. Car 클래스 - findSamePositionCar - position 관련 로직 추출

## step-5
1. 패키지명 수정
2. 의존성 체크
3. 테스트 가능한 부분과 테스트 어려운 부분을 분리

### Feedback - 1
1. RaceManager - raceConditionChecker 개선
   - startRacing 에서 주입
2. getMovedCars 네이밍 수정
3. RandomRaceConditionChecker - RANDOM_NUMBER_RANGE private 으로 수정
4. RaceManagerTest 의 startRacing - Fake 구현체 이용해서 정지하는 케이스 작성

### Feedback - 2
1. RaceManagerTest - findRacingChampions 테스트 수정