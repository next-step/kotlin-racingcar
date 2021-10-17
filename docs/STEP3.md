# STEP3 

# 기능 요구 사항
> 초간단 자동차 경주 게임을 구현한다.

* 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
* 사용자는 몇 대의 자동차로 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
* 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
* 자동차의 상태를 화면에 출력한다. 어느 시점에 출력할 것인지에 대한 제약은 없다.

# todolist 

* [x] InputView
    * [x] Null 체킹을 여기서 하자 -> 도메인에서 굳이 nullable 만들필요는..
    * [x] 자동차 대수는 몇 대인가요?
        * [x] readLine() 으로 입력받기
    * [x] 시도할 횟수는 몇 회인가요?
        * [x] readLine() 으로 입력받기
* [x] ResultView
    * [x] 첫 시작은 `실행 결과`
    * [x] 현재 이동 위치는 숫자 기반 -> View 에서 변환 작업
    * [x] 루프마다 처리하는 방식으로 진행 예정 -> 배치 처리로 변경   
* [x] NumberOfCars
    * [x] value class
    * [x] 숫자로 변환 불가능한지 체크 -> 따로 로직 안 만들고 NumberFormatException 이용 
    * [x] 0미만의 숫자가 입력되면 예외처리
* [x] NumberOfAttempts
    * [x] value class
    * [x] 숫자로 변환 불가능한지 체크 -> 따로 로직 안 만들고 NumberFormatException 이용
    * [x] 0미만의 숫자가 입력되면 예외처리
* [x] RacingCarApplication
    * [x] View 로 부터 넘겨 받은 데이터를 넘겨 받는다.    
    * [x] RacingCarGame 을 실행하는 주체  
* [x] RacingCarGame
    * [x] run() 또는 execute() 또는 enter()로 게임 시작 
    * [x] 최상단이므로 디자인패턴 구현체들을 여기서 내려주는 방식으로 코드 작성 
* [x] RacingCar 
    * [x] 현재 위치를 상태로 가지고 있디. and 디폴트값 0
    * [x] 무작위 값이 4 이상일 경우 움직인다. -> 조건 변경 가능성 있음 -> 전략 패턴
    * [x] 현재 위치가 증가하면, 기존 상태값 변경이 아닌 불변 객체로 새 객체 생성 
    * [x] View 를 위해서라도 현재 위치를 반환할 수 있는 getter() 필요 
* [x] DistanceDriven
    * [x] 0미만의 숫자가 입력되면 예외처리
    * [x] 디폴트 값을 사용하기 위한 팩토리 메서드 default() 생성 -> 기본 생성자에 디폴트 프로퍼티 사용 
* [x] RacingCars
    * [x] List<RacingCar> 를 상태로 가지고 있는 일급 컬렉션  
    * [x] 현재 단계에서는 View 사용 용도로만 정의
    * [x] 숫자 입력시 해당 숫자만큼 List<RacingCars> 생성하여 객체 만듬 
* [x] MovingStrategy
    * [x] Boolean 을 반환하여 움직일 수 있는지 판단
* [x] RandomNumberMovingStrategy   
    * [x] 객체 생성시 특정 값을 입력 받는다. 
    * [x] 랜덤값을 생성한다.    
    * [x] 랜덤값이 그 값 이상이면 Boolean 을 반환하여 움직일 수 있는지 판단한다.  
  
---
추가사항)  

* [x] RacingCarGameRecord 
    * [x] 배치 처리를 위해 List<RacingCars> 를 저장하는 일급 컬렉션
    * [x] value 클래스 사용