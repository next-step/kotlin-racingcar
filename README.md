# kotlin-racingcar

## Step2 문자열 계산기
### 메시지
- [x] 두 수에 대한 계산실행하라.
- [x] 입력값 유효성 검증하라.
- [x] 입력문자열을 숫자와 사칙연산으로 변경하라.
- [x] 숫자로 변환된 입력값을 계산하라.
- [x] 결과값을 출력하라.

### 리뷰반영사항 - 1
- [x] 실제 연산역할을 연산자 객체에게 위임
- [x] `Calculator`객체를 `object`로 변환
- [x] Input 객체 파일명 고려
- [x] 정규표현식의 상수화
- [x] Pattern 비용고려 후 캐싱
- [x] input 검증시 불필요한 검증 로직 제거
- [x] OCP 원칙을 고려한 연산자 여부 메서드 수정
- [x] 연산자 적절한 예외 메시지 처리
- [x] 연산자 객체의 변수명 수정
- [x] nullable 빠르게 예외 처리
- [x] readLine() -> readlnOrNull() 수정
- [x] 결과 계산 로직 가독성 증대

**추가 반영사항**
- 정규표현식을 통해 패턴을 찾을 때 연산자가 추가될수있음을 고려해 동적 패턴 생성



## Step3 자동차 경주
### 메시지

- [x] 전진하라
- [x] 랜덤한 값을 통해 전진하라
- [x] 자동차 대수를 입력받아라
- [x] 시도 횟수를 입력받아라
- [x] 자동차를 생성하라
- [x] 시도 횟수만큼 랜덤한 값을 구하라
- [x] 앞으로 전진한 횟수를 저장하라
- [x] 결과를 출력하라
- [x] 랜덤한 값을 생성하라
- [x] 자동차에게 랜덤값을 전달하라

## Step4 자동차 경주(우승자)
### Step3 리뷰 반영사항
- [x] RacingProcessor::실세계 객체로써 클래스명 고려 
- [x] RacingProcessor::cars 를 상태로서 관리
- [x] RacingProcessor::block 구문과 표현식 일관성 고려
- [x] RandomGenerator::역할을 더 명확히 드러내도록 클래스명 고려
- [x] ResultView::불필요한 메서드 추출 수정
- [x] Car::객체 행동을 통한 상수 위치 고려

### 요구사항
#### 프로그래밍 요구사항
- [x] UI 제외 모든로직 단위테스트
- [x] indent depth 1 제한
- [x] method 15 line 제한
- [x] 기능요구사항 readme 정리
- [x] 기능 단위 commit

#### 기능 요구사항
- [x] 자동차 이름 목록을 쉼표 기준으로 구분하여 입력받는다
- [x] 자동차 전진 여부 출력시 이름도 함께 출력한다
- [x] 경주 종료시 최종 우승자를 함께 출력한다
- [x] 자동차 이름은 5자를 초과할 수 없다

### 리뷰반영사항 - 1
- [x] Car::유효성 검증로직 init block 위치 수정
- [x] Car::매직넘버 수정
- [x] DefaultCarMoveConditionGenerator::최상위변수와 동반객체 상수 고민
- [x] InputView::불필요한 변수선언 수정
- [x] InputView::적절한 예외 메시지 출력
- [x] DefaultCarMoveConditionGenerator::난수생성이 아닌 명확한 메시지를 반환하도록 수정
- [x] InputView::moveTryCount 반복시키는 역할 분리
- [x] ResultView::우승자 판단로직과 출력로직 분리
- [x] CarTest::전진조건 4미만일 때에 대한 테스트 -> DefaultCarMovementDecider 테스트로 변환
- [x] CarMovementDecider::fun interface 적용

## Step5 자동차 경주(우승자)
### Step4 리뷰 반영사항

- [x] DefaultCarMovementDecider::중요하지 않는 테스트를 위한 도메인로직 변경 원복
- [x] RacingGame::race결과로 race board 반환
- [x] winner 출력시 race board를 통한 출력
- [x] RacingGame::card 가 스스로 판단하여 움직이도록 moveForward 시그니처 수정
- [x] RacingGame::CarMovementDecider를 상태로 두지않고 메서드파라미터로 전달
- [x] RacingGameTest::fun interface 파라미터 위치 수정과함께 람다식으로 수정
- [x] Winner::우승자를 찾는 역할을 다른객체에게 위임

### 요구사항
#### 프로그래밍 요구사항
- [x] 핵심 비지니스 로직을 가지는 객체를 domain 패키지, UI 관련한 객체를 view 패키지에 구현한다.
- [x] MVC 패턴 기반으로 리팩토링해 view 패키지의 객체가 domain 패키지 객체에 의존할 수 있지만, domain 패키지의 객체는 view 패키지 객체에 의존하지 않도록 구현한다.

### 리뷰반영사항 - 1
- [x] Car::에러메시지 상수적용
- [x] RaceBoard::도메인객체와 DTO 분리
- [x] ResultView::우승자 출력시 우승자를 파라미터로 추출
- [x] CarTest::네이밍 공통화
- [x] ResultView::불필요한 메서드추출 병합
- [x] InputView::input에서의 도메인객체 의존해제, car생성은 controller에서 수행
- [x] RacingGame::1줄 forEach 메서드 병합 고려
- [x] RaceBoard::data class 생성 코드 통일

### 리뷰반영사항 - 2
- [x] RacingApplication::Car 객체매핑 헬퍼함수로 수정
- [x] Car::Car name 검증 시 논리적 불필요 로직 제거
- [x] RaceBoard::carpositions를 getter로 꺼내어 처리하는 것이 아닌 RaceResultPerRound객체에게 역할위임

### 리뷰반영사항 - 3
- [x] RaceBoard::가독성을 위한 early return 제거