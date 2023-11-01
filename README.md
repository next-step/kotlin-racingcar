# kotlin-racingcar
## Step 2
- 23.10.27 피드백 적용 방안
  - StringExpression 클래스 별도 파일 분리
  - StringCalculator 클래스 내 문자열 식 토큰화 로직 책임 분리
  - 문자열 식 내 토큰 Operator, Operand 분리 및 계산 로직 책임 분리
  - main 함수 생성 및 StringCalculator를 객체로 사용할 수 있도록 변경
## Step 3
- 23.10.29 
  - Car 클래스 구현
  - RacingcarGame 클래스 구현
  - InputView, ResultView 클래스 구현
  - RacingcarGameApplication 클래스 구현
- 23.10.31 피드백 적용 방안
  - RacingcarGameContext 및 CarMovementManager 클래스 구조 리팩토링 및 오류 수정
  - RacingcarGameContext 내 출력 기능 ResultView으로 이동
  - RacingcarGameContext 클래스 RacingcarGameManager로 이름 변경
  - View 클래스 object 선언으로 변경
  - currentDistance 함수 이름 동사로 변경 
  - RacingcarGameApplication -> RacingcarGame 명칭 변경 및 main 함수와 분리 
  - 테스트 이름 한글화 및 기능 명세 단위 분리
