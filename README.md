# kotlin-racingcar


## 기능 요구 사항

#### 게임 필요 정보 입력받기 : InputUtils
- 차량 이름 입력받기
- 입력받은 이름을 쉼표로 구분하기
- 게임 횟수 입력받기
- 입력받은 게임 횟수를 숫자로 변환하기


#### 게임 준비하기 : RacingCarGame.ready()
- 각 이름별로 차량 객체 생성하기 : **Car, Cars**


#### 게임 실행하기 : RacingCarGame.moveOnce()
- 0에서 9까지 랜덤한 숫자 생성하기 : **MoveStrategy, RandomMoveStrategy**
- 랜덤하게 생성된 숫자가 4이상인지 판별하기 : **RandomMoveStrategy**
- 랜덤하게 생성된 숫자가 4이상이라면 차량의 score 1만큼 증가시키기 : **Car**
- 입력받은 게임 횟수만큼 앞의 step 반복하기 : **Main**
- 각 게임 단계별로 차량의 score만큼 '-'출력하기 : **ResultView, ResultViews**


#### 게임 결과 계산하기 : RacingCarGame.finish()
- 전체 차량 중 가장 높은 스코어 알아내기 : **Cars**
- 가장 높은 스코어를 가진 차량(들)을 우승자로 선정하기 : **Cars, RacingCarGame**
- 우승자 출력하기 : **WinnerView**
