# kotlin-racingcar

## presentation

### InputView

- ```parseLine()```: 입력한 이름들의 라인을 파싱해서 ```List<RacingCar>```로 변경

### ResultView

- ```showCarMove()```: 중간중간 차 하나하나의 움직임을 ```"${car.name} : $visualizedMoveCount"``` 형태로 출력
- ```showWinners(winnerList: List<RacingCar>)```: 승리자 정보들을 받아 "pobi, honux가 최종 우승했습니다." 형태로 출력
- ```visualizeMoveCount(moveCount: Int)```: moveCount를 "---" 형태로 바꿔주는 로직

## data

### RacingCar

#### 프로퍼티 - name: String / moveCount: Int

- ```tryMoving()```: TryMoving 이용해 차의 움직임 시도, 성공 시 moveCount를 늘림

### RacingCourse

#### 프로퍼티 - tryCount: Int / racingCars: List<RacingCar>

- ```run()```: 실제 프로그램 작동, tryCount에 따라 각 RacingCar를 움직이는 것을 반복한다.
- ```moveCarsInOneTry(car: RacingCar)```: car를 가지고 car.tryMoving() 실행

## domain

### TryMoving

- ```isSuccessfullyMoved(random: Int)```: 4 이상이면 성공을 가져오는 로직
- ```getRandom(): Int```: 0 ~ 10 사이의 값을 랜덤으로 꺼내오는 로직