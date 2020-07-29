# Racing Car Game
### Consists of ..

### 1. Game 
* RacingGame : 게임의 Host
* RacingGameApplication : 게임의 시작을 담당한다
---
### 2. Car 
* Car : Racing Game에 참가할 자동차 객체
* CarFactory : Car를 생성하는 기능을 담당
---
### 3. Record 
* Record : 각 턴별 자동차들의 거리 기록
* RecordRepository : 모든 Record를 저장해두는 공간, *Record를 저장하고 탐색하는 기능을 담당*하며,  우승자에 대한 정보까지 확인할 수 있다
---
### 4. View 
* InputView : 자동차의 이름, 게임의 시행 횟수(턴수)을 입력 받는다
* InputInspector : 입력받은 값이 유효한지 검사한다 
* ResultView : 레이스 상황과 최종 우승자를 보여준다

---
---
## 기본 구현 기능 목록 

1. 입력 받기 : 자동차 이름과 시행횟수(턴수)를 입력받을 InputView를 만들고 입력을 받는 로직
1-1. 입력 검사 구현 : input을 검사할 InputInspector를 생성하고 검사 로직 구현
2. 자동차 구현 : 이름, run 메소드를 가진 class Car 구현
3. 자동차 생성 : CarFactory를 이용해 입력된 자동차 이름 수만큼 자동차 생성
4. Racing Game 구현 : 경주가 시작될 start 메소드 구현
5. Racing Game Application 구현 : Racing Game을 시작하고, 결과를 출력할 수 있도록 구현(ResultView 구현 이후)
6. Record 구현 : 자동차별 거리 기록을 가지도록 구현  
7. RecordRepository 구현 : 모든 Record data를 가지도록, final record에 접근 가능하도록, 우승자를 찾도록 구현
8. ResultView 구현 : 경주 상황을 출력하고 최종 우승자를 출력하도록 구현
9. CarTest 구현 : flag에 따라 distance가 증가하는지 그대로인지 확인
10. CarFactoryTest 구현 : 입력된 이름 수에 맞게 자동차가 생성되는지, 입력된 이름 순으로 생성되는지 확인
11. RecordTest 구현 : 자동차 이름별 이동거리가 제대로 mapping되어 있는지 확인
12. RecordRepositoryTest 구현 : 저장 기능(save)이 올바로 작동하는지 확인 
13. 추후 TODO LIST
