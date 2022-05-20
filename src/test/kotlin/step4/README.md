# 구현할 기능 목록
## 차량 객체 구현
### 차량의 이름인 name과 위치인 position 을 프로퍼티로 가짐.
### 화면에 출력하는 toString 을 함수로 가짐.
### 이동을 위한 move 를 함수로 가짐.

## MoveDecider 객체 구현
### Random 객체를 파라미터로 받아 한자리 수를 돌려주는 getRandomDigit 메서드 구현
### randomDigit을 파라미터로 받아 이동 여부를 판단하는 canMove 메서드 구현

## Race 객체 구현
### 차량수와 시도수를 프로퍼티로 가짐
### 차량과 현재 시도 횟수를 프로퍼티로 가짐
### next 함수가 호출될 때 마다 모든 차량들을 랜덤하게 이동시킴 (이동, 체류)
### isFinished 함수를 통해 레이싱이 완료되었는지 점검
### getWinner 함수를 통해 우승차량들을 반환한다.

## RaceRunner 객체 구현
### InputView 로 부터 차량 이름, 시도횟수 가져옴
### Race 수행
* 중간중간 OutputView 로 결과 출력
* 종료 후 우승자 출력