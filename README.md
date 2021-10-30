# kotlin-racingcar
# 요구사항 정리
## 자동차 경주
* [] 이동 시도 횟수를 입력 받을 함수
* [] 자동차 대수를 입력 받을 함수
* [] 자동차는 이동 또는 멈출 수 있다.
* [] 이동 조건은 0-9까지 랜덤 값에서 4이상일 경우
* [] 자동차 이동 상태를 마지막에 출력한다

### 도메인 분리
* InputView
  * 자동차 수
  * 거리이동 도전 횟수
* ResultView
  * 이동거리 출력
* RaceController
  * 실행 및 호출 컨트롤
* Racing
  * 자동차 일급 컬렉션을 관리하는 도메인
* Cars
  * 차량 생성 및 이동 여부 판별
* Car
  * 차량 상태를 관리하는 객체
* MoveDistance
  * 차량 이동거리를 관리하는 객체
* CarMovingStrategy
  * 랜덤값 생성하여 차량이 이동할지 판별
