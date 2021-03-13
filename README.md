# 4단계
1. [x] InputView에서는 자동차 개수 대신 이름을 받아야 한다.
    1. [x] Input에서는 이름을 , 로 구분하여 리턴할 수 있어야 한다.
2. [x] Car는 이름을 받아서 객체를 생성할 수 있어야 한다.
3. [x] CarHistory는 스스로의 히스토리 내역 (toString) 을 표시할줄 알아야 한다.
4. [x] CarHistories는 최고점수를 가진 Car를 리턴할 줄 알아야 한다. 
5. [x] ResultView 에서는 이름과 같이 표출이 되어야 한다.
6. [x] ResultView 에서는 최종 히스토리에서 최고점수를 가져와 표출해줘야 한다. 

7. [X] CarMoveHistory는 Car가 아닌 name을 갖고 있어야한다. 
8. [X] CarMoveHistoryCollection 를 일급컬렉션으로 바꿔보자

9. [X] 이름을 Wrappingclass로 만들자  -> Name
   1. [X] 이름은 String만을 갖는다
   2. [X] 생성시 길이가 5가 넘으면 Exception을 발생시킨다
10. [X] 이름s을 1급컬렉션을 만들자
   1. [X] 이름s을 만들때는 String array를 받을 수 있다.
   2. [X] 이름s를 만들때는 Name List를 받을 수 있다.
11. [X] 자동차는 String의 이름이 아닌 CarName의 이름을 가져야 한다.
12. [ ] Winners가 있어야 한다.
   1. [ ] Winner는 Winner의 1급 컬렉션이다
   2. [ ] Winners는 History 기반으로 승리자를 얻어낼 수 있다.
13. [ ] Cars에서 winners를 구해올 수 있어야 한다. 