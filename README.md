# kotlin-racingcar


# 자동차경주 (우승자)
- [X] 각 자동차에 이름을 부여할 수 있다. 
    - [X] car 객체는 이동한 경로외에 이름도 가질 수 있다.
- [X] 자동차 이름은 5자를 초과할 수 없다.
- [X] 자동차 경주에 참가하는 자동차는 움직이는 횟수를 정할 수 있다.
- [X] 0~9사이의 랜덤값을 뽑아 4이상인 경우만 자동차는 움직인다.
- [X] 자동차 경주 게임이 완료되면, 최종 우승자를 출력한다. 
  - [X] 제일 이동거리가 큰 자동차가 우승자이고 한명 이상이 될 수 있다.

# 자동차경주 (리팩토링)
- [X] MVC 패턴 기반으로 리팩토링한다.
  - view 패키지의 객체가 domain 패키지 객체에 의존할 수 있다.
  - domain 패키지의 객체는 view 패키지 객체에 의존하지 않는다.
