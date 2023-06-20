# kotlin-racingcar

- 각 자동차에 이름을 부여할 수 있다. 자동차 이름은 5자를 초과할 수 없다.
  - [x] Test 1 : 자동차 객체에 이름을 부여할 수 있다.
    - Car 클래스에 val name 추가하고 기본값 부여하여 기존 테스트 코드 안 건드리고 테스트 성공
  - [x] Test 2 : 이름이 5자를 넘어서면 다시 입력 받는다.
    - 이름이 빈 문자열이어도 다시 입력 받는다.
    - 콘솔 테스트라 기능 구현하고 main함수 실행해 보는 것으로 대체
- 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다. 
- 자동차 이름은 쉼표(,)를 기준으로 구분한다. 
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
- 사용자가 입력한 이름의 숫자 만큼 자동차 대수를 생성한다. 
- 자동차는 자동차 이름과 위치 정보를 가지는 Car 객체를 추가해 구현한다.
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

