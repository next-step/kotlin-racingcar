# 4단계 - 자동차 경주(우승자)
## 요구사항
- 각 자동차에 이름을 부여할 수 있다. 자동차 이름은 5자를 초과할 수 없다.
- 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분한다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.

**실행 결과**
```
경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).
pobi,crong,honux
시도할 횟수는 몇 회인가요?
5

실행 결과
pobi : -
crong : -
honux : -

pobi : --
crong : -
honux : --

pobi : ---
crong : --
honux : ---

pobi : ----
crong : ---
honux : ----

pobi : -----
crong : ----
honux : -----

pobi, honux가 최종 우승했습니다.
```

## TODO
- [x] Car 객체에 history를 받는 부생성자 추가
- [x] Car 객체 require 예외 메세지에 입력값 추가
- [x] Cars 에 불필요한 init 블럭 삭제
- [x] Car의 위치 출력을 위한 메서드에 템플릿 중첩 리팩토링
- [x] MoveRule mocking 대신 car.move에 람다 주입하도록 테스트 수정
- [x] RandomNumberGeneratorTest 삭제